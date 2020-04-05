package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface AccidentsIntroHeader {

    void createIntroHeader(Table table, ProposalPdfData proposalPdfData);
}
