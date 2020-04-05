package be.pvgroup.tpetool.pdf.pages.intro.blocks.tussenpersoon;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

public interface TussenpersoonBlock {
    void createTussenpersoonBlock(Document document, ProposalPdfData proposalPdfData);
}
