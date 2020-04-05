package be.pvgroup.tpetool.pdf.pages.property.blocks.values;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface ValuesBlock {

    void createValuesBlock(Table table, ProposalPdfData proposalPdfData);
}
