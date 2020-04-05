package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.proposal.ProposalInput;
import org.springframework.core.io.InputStreamSource;

import javax.mail.MessagingException;

public interface MailService {

    void sendMailWithAttachment(ProposalInput proposalInput, InputStreamSource pdf) throws MessagingException;
}
