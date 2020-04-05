package be.pvgroup.tpetool.pdf.pages.property.blocks.commercialunemployment;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface CommercialUnemploymentHeader {

    void createCommercialUnemploymentHeader(Table table, ProposalPdfData proposalPdfData);
}
