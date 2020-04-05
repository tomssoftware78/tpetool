package be.pvgroup.tpetool.pdf.pages.property.blocks.values;

import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import be.pvgroup.tpetool.util.property.PropertyPremiumType;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

@Component
public class ValuesBlockImpl extends AbstractBlock implements ValuesBlock {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createValuesBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        //-------------------------------------------------
        Cell cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .add(languageLabel.getLabel("property.values.totaalMetTaks"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .add(languageLabel.getLabel("property.values.totaalNetto"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getValues().getCapital() != null) {

            String label = languageLabel.getLabel(
                    proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getValues().getCapital().getValue());
            cell = cellNoBorder(1, 4)
                    .setTextAlignment(TextAlignment.LEFT)
                    .add(label);
        } else {
            cell = cellNoBorder(1, 4)
                    .setTextAlignment(TextAlignment.LEFT)
                    .add("   ");
        }
        table.addCell(cell);

        PropertyPremium propertyPremiumValuesCov = proposalPdfData.getPropertyPremiumByType(PropertyPremiumType.VALUES_COVERAGE);

        cell = cellNoBorder(1, 1)
                .add(propertyPremiumValuesCov.getFeeWithTax().toString());
        table.addCell(cell);
        cell = cellNoBorder(1, 1)
                .add(propertyPremiumValuesCov.getFeeNoTax().toString());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 4).add("");
        table.addCell(cell);


        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .add(languageLabel.getLabel("property.values.totaal")).setBold();
        table.addCell(cell);


        cell = cellNoBorder(1, 1).add(this.sumValuesWithTax.toString()).setBold().setBorderTop(new SolidBorder(1));
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(this.sumValuesNoTax.toString()).setBold().setBorderTop(new SolidBorder(1));
        table.addCell(cell);
        //-------------------------------------------------
    }
}
