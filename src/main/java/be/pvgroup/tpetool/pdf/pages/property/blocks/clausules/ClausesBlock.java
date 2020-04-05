package be.pvgroup.tpetool.pdf.pages.property.blocks.clausules;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface ClausesBlock {

    void createClauses(Table table, ProposalPdfData proposalPdfData);
}
