package be.pvgroup.tpetool.pdf.pages.summary.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

import java.math.BigDecimal;

@Component
public class SummaryPremiumsBlockImpl extends AbstractBlock implements SummaryPremiumsBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createSummaryPremiumsBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        // --------------------------------------------------
        Cell cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.LEFT).setBackgroundColor(viviumOrgange())
                .setBold().setFontColor(Color.WHITE).add(languageLabel.getLabel("proposal.summary.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);
        // --------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add("   ");
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.premieMetTaks")).setBold();
        ;
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.premieNetto")).setBold();
        ;
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);
        // -------------------------------------------------
        createPropertySummaryBlock(table);
        createLiabilitySummaryBlock(table);
        createAccidentsSummaryBlock(table);
        cell = cellNoBorder(1, 3).add("   ");
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.totaal")).setBold();
        table.addCell(cell);
        cell = cellBorderTop(1, 1, Color.BLACK).add(totalAllProductsWithTax.toString()).setBold();
        table.addCell(cell);
        cell = cellBorderTop(1, 1, Color.BLACK).add(totalAllProductsNoTax.toString()).setBold();
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("  ");
        table.addCell(cell);
        // --------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        // -------------------------------------------------
    }

    private void createAccidentsSummaryBlock(Table table) {
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents() != null) {
            Cell cell;// -------------------------------------------------
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.accidents.title")).setBold();
            table.addCell(cell);
            cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.accidents.wettelijkewaarborg"));
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(totaalWettelijkeWaarborgWithTax.toString());
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(totaalWettelijkeWaarborgNoTax.toString());
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            // -------------------------------------------------
            cell = cellNoBorder(1, 2).add("   ");
            table.addCell(cell);
            cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.accidents.2424"));
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(sumFeeWithTaxBeneficiaries.toString());
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(sumFeeNoTaxBeneficiaries.toString());
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            // -------------------------------------------------
        }
    }

    private void createLiabilitySummaryBlock(Table table) {
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability() != null) {
            Cell cell;
            // Begin liability
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.liability.title")).setBold();
            table.addCell(cell);
            cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.liability.ba"));
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(sumLiabilityBA_WithTax.toString());
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(sumLiabilityBA_NoTax.toString());
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            // -------------------------------------------------
            cell = cellNoBorder(1, 2).add("   ");
            table.addCell(cell);
            cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.liability.rechtsbijstand"));
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(
                    liabilityPremiumLegalProtection != null ? liabilityPremiumLegalProtection.getFeeWithTax().toString()
                            : "");
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(
                    liabilityPremiumLegalProtection != null ? liabilityPremiumLegalProtection.getFeeNoTax().toString()
                            : "");
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            // -------------------------------------------------
            cell = cellNoBorder(1, 2).add("   ");
            table.addCell(cell);
            cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.liability.oa"));
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(liabilityPremiumObjectiveLiability != null
                    ? liabilityPremiumObjectiveLiability.getFeeWithTax().toString()
                    : "");
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(liabilityPremiumObjectiveLiability != null
                    ? liabilityPremiumObjectiveLiability.getFeeNoTax().toString()
                    : "");
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            // --------------------------------------------------
            cell = cellNoBorder(1, 7).setHeight(20).add("   ");
            table.addCell(cell);
        }
    }

    private void createPropertySummaryBlock(Table table) {
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null) {
            Cell cell;
            cell = cellNoBorder(1, 1).add("   ");
            table.addCell(cell);
            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.property.title")).setBold();
            table.addCell(cell);
            if (sumPremiumsNoTax.compareTo(BigDecimal.ZERO) > 0) {
                cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.property.property"));
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add(sumPremiumsWithTax.toString());
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add(sumPremiumsNoTax.toString());
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add("   ");
                table.addCell(cell);
            }
            // -------------------------------------------------
            cell = cellNoBorder(1, 2).add("   ");
            table.addCell(cell);
            if (sumValuesNoTax.compareTo(BigDecimal.ZERO) > 0) {
                cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.property.waarden"));
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add(this.sumValuesWithTax.toString());
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add(this.sumValuesNoTax.toString());
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add("   ");
                table.addCell(cell);
            }
            // -------------------------------------------------
            if (sumComUnemploNoTax.compareTo(BigDecimal.ZERO) > 0) {
                cell = cellNoBorder(1, 2).add("   ");
                table.addCell(cell);
                cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.summary.property.bedrijfsschade"));
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add(this.sumComUnemploWithTax.toString());
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add(this.sumComUnemploNoTax.toString());
                table.addCell(cell);
                cell = cellNoBorder(1, 1).add("   ");
                table.addCell(cell);
            }
            // --------------------------------------------------
            cell = cellNoBorder(1, 7).setHeight(20).add("   ");
            table.addCell(cell);
        }
    }
}
