package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.proposal.ProposalInput;
import be.pvgroup.tpetool.service.liability.LiabilityServiceImpl;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.google.common.io.ByteStreams;
import com.sendgrid.*;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
@Profile("default")
public class MailServiceSendGrid implements MailService {

	Logger logger = LoggerFactory.getLogger(MailServiceSendGrid.class);

	@Autowired
	private final SendGrid sendGrid;

	@Autowired
	private LanguageLabel languageLabel;

	@Value("${pdf.bcc.email}")
	private String bccAddress;

	public MailServiceSendGrid(SendGrid sendGrid) {
		this.sendGrid = sendGrid;
	}

	@Override
	public void sendMailWithAttachment(ProposalInput proposalInput, InputStreamSource pdf) throws MessagingException {
		// Email from = new Email("tpe_tool@penv.com");
		String fromAddress = languageLabel.getLabel("mail.proposal.from.address");
		String toAddress = proposalInput.getData().getCommonAnswers().getIntermediary().getEmail();
		String subject = languageLabel.getLabel("mail.proposal.subject");
		String body = languageLabel.getLabel("mail.proposal.content");
		String fileName = languageLabel.getLabel("mail.proposal.file.name");

		logger.debug("fromAddress: " + fromAddress);
		logger.debug("toAddress: " + toAddress);
		logger.debug("subject: " + subject);
		logger.debug("fileName: " + fileName);
		logger.debug("body: " + body);

		Email from = new Email(fromAddress);
		Email to = new Email(toAddress);
		Email bcc = new Email(bccAddress);
		Content content = new Content("text/plain", body);
		Mail mail = new Mail(from, subject, to, content);
		if (!(bccAddress.toUpperCase().equals(toAddress.toUpperCase()))) {
			mail.getPersonalization().get(0).addBcc(bcc);
		}

		try {
			byte[] fileData = ByteStreams.toByteArray(pdf.getInputStream());

			Base64 x = new Base64();
			String imageDataString = x.encodeAsString(fileData);

			Attachments attachments3 = new Attachments();
			attachments3.setContent(imageDataString);

			attachments3.setType("application/pdf");
			attachments3.setFilename(fileName);
			attachments3.setDisposition("attachment");
			mail.addAttachments(attachments3);

			MailSettings mailSettings = new MailSettings();
			Setting sandBoxMode = new Setting();
			sandBoxMode.setEnable(true);
			mailSettings.setSandboxMode(sandBoxMode);

			Request request = new Request();
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());

			Response response = this.sendGrid.api(request);

			logger.debug("Sent via sendgrid");
			logger.debug("response.getStatusCode(): " + response.getStatusCode());
			logger.debug("response.getBody(): " + response.getBody());
			logger.debug("response.getHeaders(): " + response.getHeaders());
		} catch (IOException ex) {
			logger.error("Sent via sendgrid with exception");
			logger.error("" + ex);
		}
	}
}
