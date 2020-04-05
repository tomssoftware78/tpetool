package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component
public class AccidentsClausesBlockImpl implements AccidentsClausesBlock {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createClauses(Table table, ProposalPdfData proposalPdfData) {
        // -------------------------------------------------
        Cell cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.LEFT).setBackgroundColor(viviumOrgange())
                .setBold().setFontColor(Color.WHITE).add(languageLabel.getLabel("accidents.clausules.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellBorderTop(1, 5).add("   ");
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.clausules.verklaring.kandidaat.title"))
                .setBold();
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.clausules.verklaring.kandidaat.1"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.clausules.verklaring.kandidaat.2"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.clausules.verklaring.kandidaat.3"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 1).add("  ");
        table.addCell(cell);
        cell = cellNoBorder(1, 6).add(languageLabel.getLabel("accidents.clausules.verklaring.kandidaat.3.1"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 1).add("  ");
        table.addCell(cell);
        cell = cellNoBorder(1, 6).add(languageLabel.getLabel("accidents.clausules.verklaring.kandidaat.3.2"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 1).add("  ");
        table.addCell(cell);
        cell = cellNoBorder(1, 6).add(languageLabel.getLabel("accidents.clausules.verklaring.kandidaat.3.3"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        // -------------------------------------------------

        boolean atLeastOneBeneficiary = (proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                .getAccidents().getBeneficiary().getName().trim().length() > 0)
                || (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getBeneficiary2()
                        .getName().trim().length() > 0);
                        
        if (atLeastOneBeneficiary) {
            cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.clausules.berekening.title")).setBold();
            table.addCell(cell);

            // -------------------------------------------------
            cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.clausules.berekening.1"));
            table.addCell(cell);
            // -------------------------------------------------
            cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.clausules.berekening.2"));
            table.addCell(cell);
        }
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
    }
}
