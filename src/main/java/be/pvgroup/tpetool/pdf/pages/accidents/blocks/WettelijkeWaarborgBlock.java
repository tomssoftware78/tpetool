package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface WettelijkeWaarborgBlock {
    void createWettelijkeWaarborgBlock(Table table, ProposalPdfData proposalPdfData);
}