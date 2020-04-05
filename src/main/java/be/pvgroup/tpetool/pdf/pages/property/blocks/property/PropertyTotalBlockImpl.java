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

@Component
public class PropertyTotalBlockImpl extends AbstractBlock implements PropertyTotalBlock {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createGrandTotalBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        Cell cell = cellNoBorder(1, 4).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.totaal")).setBold();
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(sumPremiumsWithTax.toString()).setBold().setBorderTop(new SolidBorder(1));
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(sumPremiumsNoTax.toString()).setBold().setBorderTop(new SolidBorder(1));
        table.addCell(cell);

        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
    }
}
