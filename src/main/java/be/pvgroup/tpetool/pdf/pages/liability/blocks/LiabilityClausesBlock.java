package be.pvgroup.tpetool.pdf.pages.liability.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface LiabilityClausesBlock {

    void createClauses(Table table, ProposalPdfData proposalPdfData);
}
