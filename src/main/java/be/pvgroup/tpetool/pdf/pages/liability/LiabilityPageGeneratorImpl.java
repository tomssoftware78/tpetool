package be.pvgroup.tpetool.pdf.pages.liability;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.liability.blocks.LiabilityClausesBlock;
import be.pvgroup.tpetool.pdf.pages.liability.blocks.LiabilityHeader;
import be.pvgroup.tpetool.pdf.pages.liability.blocks.LiabilityIntroHeader;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import org.springframework.stereotype.Component;

@Component
public class LiabilityPageGeneratorImpl implements LiabilityPageGenerator {


    private LiabilityIntroHeader introHeader;

    private LiabilityHeader header;

    private LiabilityClausesBlock clausesBlock;

    public LiabilityPageGeneratorImpl(LiabilityIntroHeader introHeader,
                                      LiabilityHeader header,
                                      LiabilityClausesBlock clausesBlock) {
        this.introHeader = introHeader;
        this.header = header;
        this.clausesBlock = clausesBlock;
    }

    @Override
    public void createLiabilityPage(Document document, ProposalPdfData proposalPdfData) {
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability() !=null) {

            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

            Table table = new Table(7);

            introHeader.createIntroHeader(table, proposalPdfData);
            header.createLiabilityHeader(table, proposalPdfData);
            clausesBlock.createClauses(table, proposalPdfData);

            document.add(table);
        }

    }
}
