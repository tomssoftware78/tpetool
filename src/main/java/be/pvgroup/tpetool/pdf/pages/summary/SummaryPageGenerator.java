package be.pvgroup.tpetool.pdf.pages.summary;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;

public interface SummaryPageGenerator {
    void createSummaryPage(Document document, ProposalPdfData proposalPdfData);
}
