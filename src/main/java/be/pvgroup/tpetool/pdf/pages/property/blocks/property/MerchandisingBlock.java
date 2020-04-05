package be.pvgroup.tpetool.pdf.pages.property.blocks.property;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface MerchandisingBlock {

    void createMerchandisingBlock(Table table, ProposalPdfData proposalPdfData);
}
