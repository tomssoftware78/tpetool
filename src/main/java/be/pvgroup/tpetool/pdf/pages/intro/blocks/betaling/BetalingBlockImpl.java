package be.pvgroup.tpetool.pdf.pages.intro.blocks.betaling;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component
public class BetalingBlockImpl implements BetalingBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createBetalingBlock(Document document, ProposalPdfData proposalPdfData) {
        Table table = new Table(7);
        //--------------------------------------------------
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("betaling"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 2).add(languageLabel.getLabel("betalingPremie"));
        table.addCell(cell);

        cell = cellNoBorder(1, 5).add(languageLabel.getLabel("betalingPeriode"));
        table.addCell(cell);
        //-------------------------------------------------
        document.add(table);

    }
}
