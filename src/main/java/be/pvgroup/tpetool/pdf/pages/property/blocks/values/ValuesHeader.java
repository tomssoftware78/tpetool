package be.pvgroup.tpetool.pdf.pages.property.blocks.values;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface ValuesHeader {

    void createValuesHeader(Table table, ProposalPdfData proposalPdfData);
}
