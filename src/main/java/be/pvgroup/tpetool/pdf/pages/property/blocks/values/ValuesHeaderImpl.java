package be.pvgroup.tpetool.pdf.pages.property.blocks.values;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
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

@Component
public class ValuesHeaderImpl implements ValuesHeader {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createValuesHeader(Table table, ProposalPdfData proposalPdfData) {
        //-------------------------------------------------
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("property.values.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellBorderTop(1, 1).add("   ");
        table.addCell(cell);

        cell = cellBorderTop(1, 1).add(languageLabel.getLabel("property.values.startdatum"));
        table.addCell(cell);

        cell = cellBorderTop(1, 3).add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getStartDates().getPropertyAsString().toString());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
    }
}
