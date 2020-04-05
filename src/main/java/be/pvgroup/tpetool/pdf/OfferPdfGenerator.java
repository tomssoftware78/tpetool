package be.pvgroup.tpetool.pdf;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public interface OfferPdfGenerator {
    ByteArrayInputStream createPdf(ProposalPdfData proposalPdfData);

    ByteArrayOutputStream createPdfStream(ProposalPdfData proposalPdfData);
}
