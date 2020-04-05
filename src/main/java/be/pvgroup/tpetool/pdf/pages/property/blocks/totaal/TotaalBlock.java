package be.pvgroup.tpetool.pdf.pages.property.blocks.totaal;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface TotaalBlock {

    void createTotaalBlock(Table table, ProposalPdfData proposalPdfData);
}
