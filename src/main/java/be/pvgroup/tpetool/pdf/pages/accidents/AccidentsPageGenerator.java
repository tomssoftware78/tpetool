package be.pvgroup.tpetool.pdf.pages.accidents;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;

public interface AccidentsPageGenerator {

    void createAccidentsPage(Document document, ProposalPdfData proposalPdfData);
}
