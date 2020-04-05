package be.pvgroup.tpetool.service.proposal;

import be.pvgroup.tpetool.model.proposal.ProposalInput;

import javax.mail.MessagingException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public interface ProposalService {

    ByteArrayInputStream makeProposal(ProposalInput proposalInput, String language);

    ByteArrayOutputStream makeProposalStream(ProposalInput proposalInput, String language);

    void handleProposal(ProposalInput proposalInput, String language) throws MessagingException;
}
