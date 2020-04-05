package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.proposal.ProposalInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;

@Component
@Profile("gmail")
public class MailServiceImpl implements MailService {

    //@Autowired
    //private JavaMailSender javaMailSender;

    @Override
    public void sendMailWithAttachment(ProposalInput proposalInput, InputStreamSource pdf) throws MessagingException {
        /*MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("tom.vandeneynde@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // true = text/html
        helper.setText("<h1>Check attachment for pdf!</h1>", true);

        helper.addAttachment("proposal.pdf", pdf);
        javaMailSender.send(msg);
        */
    }
}
