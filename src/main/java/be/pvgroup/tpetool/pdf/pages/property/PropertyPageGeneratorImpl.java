package be.pvgroup.tpetool.pdf.pages.property;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.clausules.ClausesBlock;
import be.pvgroup.tpetool.pdf.pages.property.blocks.commercialunemployment.CommercialUnemploymentBlock;
import be.pvgroup.tpetool.pdf.pages.property.blocks.commercialunemployment.CommercialUnemploymentHeader;
import be.pvgroup.tpetool.pdf.pages.property.blocks.header.Header;
import be.pvgroup.tpetool.pdf.pages.property.blocks.property.*;
import be.pvgroup.tpetool.pdf.pages.property.blocks.totaal.TotaalBlock;
import be.pvgroup.tpetool.pdf.pages.property.blocks.values.ValuesBlock;
import be.pvgroup.tpetool.pdf.pages.property.blocks.values.ValuesHeader;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyPageGeneratorImpl implements PropertyPageGenerator {

    @Autowired
    private Header generalHeader;

    @Autowired
    private PropertyHeaderBlock propertyHeaderBlock;

    @Autowired
    private BuildingBlock buildingBlock;

    @Autowired
    private ContentBlock contentBlock;

    @Autowired
    private MerchandisingBlock merchandisingBlock;

    @Autowired
    private PropertyTotalBlock propertyTotalBlock;

    @Autowired
    private ValuesHeader valuesHeader;
    @Autowired
    private ValuesBlock valuesBlock;
    @Autowired
    private CommercialUnemploymentHeader commercialUnemploymentHeader;
    @Autowired
    private CommercialUnemploymentBlock commercialUnemploymentBlock;

    @Autowired
    private ClausesBlock clausesBlock;

    @Autowired
    private TotaalBlock totaalBlock;

    @Override
    public void createPropertyPage(Document document, ProposalPdfData proposalPdfData) {

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null) {
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

            Table table = new Table(7);

            generalHeader.createHeader(table, proposalPdfData);
            propertyHeaderBlock.createPropertyHeader(table, proposalPdfData);
            buildingBlock.createBuildingBlock(table, proposalPdfData);
            contentBlock.createContentBlock(table, proposalPdfData);
            merchandisingBlock.createMerchandisingBlock(table, proposalPdfData);
            propertyTotalBlock.createGrandTotalBlock(table, proposalPdfData);

            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
                    .getValues()) {
                valuesHeader.createValuesHeader(table, proposalPdfData);
                valuesBlock.createValuesBlock(table, proposalPdfData);
            }

            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
                    .getCommercialUnemployment()) {
                commercialUnemploymentHeader.createCommercialUnemploymentHeader(table, proposalPdfData);
                commercialUnemploymentBlock.createCommercialUnemploymentBlock(table, proposalPdfData);
            }
            totaalBlock.createTotaalBlock(table, proposalPdfData);
            clausesBlock.createClauses(table, proposalPdfData);

            document.add(table);
        }
    }
}
