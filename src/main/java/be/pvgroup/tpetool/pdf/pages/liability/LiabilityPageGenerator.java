package be.pvgroup.tpetool.pdf.pages.liability;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;

public interface LiabilityPageGenerator {

    void createLiabilityPage(Document document, ProposalPdfData proposalPdfData);
}
