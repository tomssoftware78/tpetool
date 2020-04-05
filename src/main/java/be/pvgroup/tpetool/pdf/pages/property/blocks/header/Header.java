package be.pvgroup.tpetool.pdf.pages.property.blocks.header;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

public interface Header {

    void createHeader(Table table, ProposalPdfData proposalPdfData);
}
