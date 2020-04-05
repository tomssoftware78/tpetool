package be.pvgroup.tpetool.controllers;

import java.io.IOException;
import java.math.BigDecimal;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.pvgroup.tpetool.model.proposal.ProposalInput;
import be.pvgroup.tpetool.service.MailService;
import be.pvgroup.tpetool.service.proposal.ProposalService;

@RestController
@RequestMapping("/api/premium")
public class ProposalController {

	Logger logger = LoggerFactory.getLogger(ProposalController.class);

	@Autowired
	private ProposalService proposalService;

	@Autowired
	private MailService mailService;

	public ProposalController(ProposalService proposalService) {
		this.proposalService = proposalService;
	}

	@PostMapping(value = "/proposal", produces = MediaType.APPLICATION_PDF_VALUE)
	@CrossOrigin
	public void proposal(@RequestBody ProposalInput proposalInput, @RequestHeader("Accept-Language") String language)
			throws MessagingException, IOException {
		logger.debug("Incoming request to make a proposal");
		logger.debug("with input: " + proposalInput);
		logger.debug("");

		LocaleContext localeContext = LocaleContextHolder.getLocaleContext();
		logger.debug("language: + localeContext.getLocale().getLanguage()");

		if (proposalInput.getData() != null && proposalInput.getData().getInsuranceAnswers() != null
				&& proposalInput.getData().getInsuranceAnswers().getProperty() != null) {
			if (proposalInput.getData().getInsuranceAnswers().getProperty().getMandatoryCoverage()
					.getContents() == null) {

				logger.debug("MandatoryCoverage.Contents is NULL");
				logger.debug("\tSet MandatoryCoverage.Contents to ZERO manually");

				proposalInput.getData().getInsuranceAnswers().getProperty().getMandatoryCoverage()
						.setContents(BigDecimal.ZERO);
			}
		}

		proposalService.handleProposal(proposalInput, language);
	}
}
