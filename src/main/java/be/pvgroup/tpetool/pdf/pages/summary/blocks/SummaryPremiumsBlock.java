package be.pvgroup.tpetool.pdf.pages.summary.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface SummaryPremiumsBlock {

    void createSummaryPremiumsBlock(Table table, ProposalPdfData proposalPdfData);
}
