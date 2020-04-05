package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface AccidentsTotalBlock {

    void createAccidentsTotalBlock(Table table, ProposalPdfData proposalPdfData);
}
