package be.pvgroup.tpetool.pdf.pages.accidents;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.accidents.blocks.*;
import be.pvgroup.tpetool.util.LanguageLabel;
import be.pvgroup.tpetool.util.arbeidsongevallen.AccidentsPremiumType;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TextAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.pdf.PdfUtil.*;

@Component
public class AccidentsPageGeneratorImpl implements AccidentsPageGenerator {

    private static Logger logger = LoggerFactory.getLogger(AccidentsPageGeneratorImpl.class);

    @Autowired
    private LanguageLabel languageLabel;

    @Autowired
    private AccidentsClausesBlock accidentsClausesBlock;

    @Autowired
    private AccidentsIntroHeader accidentsIntroHeader;

    @Autowired
    private WettelijkeWaarborgBlock wettelijkeWaarborgBlock;

    @Autowired
    private ManueleArbeid2424Block manueleArbeid2424Block;

    @Autowired
    private FooterBlock footerBlock;

    @Autowired
    private AccidentsTotalBlock accidentsTotalBlock;

    public void createAccidentsPage(Document document, ProposalPdfData proposalPdfData) {
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents() !=null) {

            logger.debug("start creation accidents page");

            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

            Table table = new Table(7);

            accidentsIntroHeader.createIntroHeader(table, proposalPdfData);
            wettelijkeWaarborgBlock.createWettelijkeWaarborgBlock(table, proposalPdfData);
            manueleArbeid2424Block.createManueleArbeid2424Block(table, proposalPdfData);
            footerBlock.createFooterBlock(table, proposalPdfData);
            accidentsTotalBlock.createAccidentsTotalBlock(table, proposalPdfData);
            accidentsClausesBlock.createClauses(table, proposalPdfData);

            document.add(table);
        }
    }
}
