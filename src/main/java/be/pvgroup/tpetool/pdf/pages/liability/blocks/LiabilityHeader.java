package be.pvgroup.tpetool.pdf.pages.liability.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.element.Table;

public interface LiabilityHeader {

    void createLiabilityHeader(Table table, ProposalPdfData proposalPdfData);
}
