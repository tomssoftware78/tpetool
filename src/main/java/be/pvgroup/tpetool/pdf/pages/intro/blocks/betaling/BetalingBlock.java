package be.pvgroup.tpetool.pdf.pages.intro.blocks.betaling;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;

public interface BetalingBlock {
    void createBetalingBlock(Document document, ProposalPdfData proposalPdfData);
}
