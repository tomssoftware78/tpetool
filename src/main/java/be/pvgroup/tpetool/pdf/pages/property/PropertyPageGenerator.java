package be.pvgroup.tpetool.pdf.pages.property;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;

public interface PropertyPageGenerator {

    void createPropertyPage(Document document, ProposalPdfData proposalPdfData);
}
