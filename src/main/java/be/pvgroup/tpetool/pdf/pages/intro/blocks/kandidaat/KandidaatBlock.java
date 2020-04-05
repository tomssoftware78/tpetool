package be.pvgroup.tpetool.pdf.pages.intro.blocks.kandidaat;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;

public interface KandidaatBlock {
    void createKandidaatBlock(Document document, ProposalPdfData proposalPdfData);
}
