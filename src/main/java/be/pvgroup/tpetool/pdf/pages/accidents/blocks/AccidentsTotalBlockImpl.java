package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

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

import java.math.BigDecimal;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component
public class AccidentsTotalBlockImpl extends AbstractBlock implements AccidentsTotalBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createAccidentsTotalBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("accidents.totaal.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellBorderTop(1, 5).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 5).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.totaal.premieMetTaks")).setBold();
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.totaal.premieNetto")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 4).add("   ");
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.totaal.totaal")).setBold();
        table.addCell(cell);

        cell = cellBorderTop(1, 1, Color.BLACK).add(accidentsTotaalWithTax.toString()).setBold();
        table.addCell(cell);

        cell = cellBorderTop(1, 1, Color.BLACK).add(accidentsTotaalNoTax.toString()).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------

    }
}
