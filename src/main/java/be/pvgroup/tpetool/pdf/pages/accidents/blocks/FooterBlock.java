package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface FooterBlock {

    void createFooterBlock(Table table, ProposalPdfData proposalPdfData);
}
