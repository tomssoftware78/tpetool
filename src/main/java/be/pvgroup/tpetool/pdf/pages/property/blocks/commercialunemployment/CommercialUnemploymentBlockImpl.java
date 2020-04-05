package be.pvgroup.tpetool.pdf.pages.property.blocks.commercialunemployment;

import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.model.property.CommercialUnemploymentFormula;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import be.pvgroup.tpetool.util.property.PropertyPremiumType;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

@Component
public class CommercialUnemploymentBlockImpl extends AbstractBlock implements CommercialUnemploymentBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createCommercialUnemploymentBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        //-------------------------------------------------
        Cell cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.comm.unemployment.formule"));
        table.addCell(cell);


        String formuleString = languageLabel.getLabel("property.comm.unemployment.formule.daily");

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.REVENUE)) {
             formuleString = languageLabel.getLabel("property.comm.unemployment.formule.revenue");
        }
        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .add(formuleString);
        table.addCell(cell);

        cell = cellNoBorder(1, 2)
                .add("  ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.premievoet")).setBold();
        table.addCell(cell);


        cell = cellNoBorder(1, 1)
                .add(languageLabel.getLabel("property.comm.unemployment.totaalMetTaks")).setBold();
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .add(languageLabel.getLabel("property.comm.unemployment.totaalNetto")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        String s = languageLabel.getLabel("property.comm.unemployment.bedrag.daily");
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.REVENUE)) {
            s = languageLabel.getLabel("property.comm.unemployment.bedrag.revenue");
        }
        cell = cellNoBorder(1, 1)
                .add(s).setItalic();
        table.addCell(cell);

        String vergoeding = "";

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.REVENUE)) {
            vergoeding = proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getRevenue().toString();
        } else if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.DAILY)) {
            vergoeding = proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getDaily().toString();
        }
        cell = cellNoBorder(1, 1)
                .add(vergoeding)
                .setTextAlignment(TextAlignment.RIGHT);
        table.addCell(cell);

        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);

        //-------------------------------------------------
        cell = cellNoBorder(1, 1)
                .add(languageLabel.getLabel("property.comm.unemployment.vergoedingstermijn"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.comm.unemployment.vergoedingstermijn.value"));
        table.addCell(cell);

        cell = cellNoBorder(1, 2)
                .add("");
        table.addCell(cell);

        PropertyPremium propertyPremiumValuesCovDaily = proposalPdfData.getPropertyPremiumByType(PropertyPremiumType.COMMERCIAL_UNEMPLOYMENT_COVERAGE_DAILY);
        PropertyPremium propertyPremiumValuesCovRevenue = proposalPdfData.getPropertyPremiumByType(PropertyPremiumType.COMMERCIAL_UNEMPLOYMENT_COVERAGE_REVENUE);

        BigDecimal rate = null;
        BigDecimal feeNoTax = null;
        BigDecimal feeWithTax = null;


        if (propertyPremiumValuesCovDaily != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.DAILY)) {
            rate = propertyPremiumValuesCovDaily.getPremiumRate();
            feeNoTax = propertyPremiumValuesCovDaily.getFeeNoTax();
            feeWithTax = propertyPremiumValuesCovDaily.getFeeWithTax();
        } else if (propertyPremiumValuesCovRevenue != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.REVENUE)) {
            rate = propertyPremiumValuesCovRevenue.getPremiumRate();
            feeNoTax = propertyPremiumValuesCovRevenue.getFeeNoTax();
            feeWithTax = propertyPremiumValuesCovRevenue.getFeeWithTax();
        }

        cell = cellNoBorder(1, 1).add(rate.toString());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(feeWithTax.toString());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(feeNoTax.toString());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .setItalic()
                .add(languageLabel.getLabel("property.comm.unemployment.gedektegevaren"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .add(languageLabel.getLabel("property.comm.unemployment.gedektegevaren.value"));
        table.addCell(cell);

        cell = cellNoBorder(1, 5).add("  ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 4)
                .add("    ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.comm.unemployment.totaal")).setBold();
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(this.sumComUnemploWithTax.toString()).setBorderTop(new SolidBorder(1)).setBold();
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(this.sumComUnemploNoTax.toString()).setBorderTop(new SolidBorder(1)).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);



    }
}
