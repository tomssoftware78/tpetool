package be.pvgroup.tpetool.pdf.pages.intro;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import com.itextpdf.layout.Document;

public interface IntroPageGenerator {

    void createIntroPage(Document document, ProposalPdfData proposalPdfData);
}
