package be.pvgroup.tpetool.pdf.pages.property.blocks.totaal;

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

import static be.pvgroup.tpetool.pdf.PdfUtil.*;

@Component
public class TotaalBlockImpl extends AbstractBlock implements TotaalBlock {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createTotaalBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        //-------------------------------------------------
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("property.totaal.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellBorderTop(1, 5).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 5).setHeight(20).add(" ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .add(languageLabel.getLabel("property.totaal.totaalMetTaks"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .add(languageLabel.getLabel("property.totaal.totaalNetto"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 4).setHeight(20).add(" ");
        table.addCell(cell);
        cell = cellNoBorder(1, 1)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .add(languageLabel.getLabel("property.totaal.totaal"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .setBold()
                .add(this.getTotalWithTax().toString())
                .setBorderTop(new SolidBorder(1));
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .setBold()
                .add(this.getTotalNoTax().toString());
                //.setBorderTop(new SolidBorder(1));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
    }
}
