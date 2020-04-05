package be.pvgroup.tpetool.pdf.pages.property.blocks.property;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

@Component("merchandisingBlock")
public class MerchandisingBlockImpl extends AbstractBlock implements MerchandisingBlock {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createMerchandisingBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums().getAccidentalDamage()) {
            //-------------------------------------------------
            Cell cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.merchandising.title"));
            table.addCell(cell);

            cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.merchandising.description"));
            table.addCell(cell);


            cell = cellNoBorder(1, 1).add(propertyPremiumMerchDamageCov.getPremiumRate().toString());
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(propertyPremiumMerchDamageCov.getFeeWithTax().toString());
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(propertyPremiumMerchDamageCov.getFeeNoTax().toString());
            table.addCell(cell);
            //-------------------------------------------------
            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.merchandising.bedrag")).setItalic();
            table.addCell(cell);

            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getAccidentalDamage().getCapital() != null) {
                cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getAccidentalDamage().getCapital().toString());
            } else {
                cell = cellNoBorder(1, 1).add("   ");
            }
            table.addCell(cell);

            cell = cellNoBorder(1, 2).add("   ");
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.merchandising.totaal"));
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(propertyPremiumMerchDamageCov.getFeeWithTax().toString()).setBorderTop(new SolidBorder(1));
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(propertyPremiumMerchDamageCov.getFeeNoTax().toString()).setBorderTop(new SolidBorder(1));
            table.addCell(cell);
            //-------------------------------------------------
            cell = cellNoBorder(1, 7).setHeight(20).add("   ");
            table.addCell(cell);
            //-------------------------------------------------
        }
    }
}
