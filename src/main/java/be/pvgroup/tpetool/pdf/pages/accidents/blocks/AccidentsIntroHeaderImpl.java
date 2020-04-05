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

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component("accidentsIntroHeaderImpl")
public class AccidentsIntroHeaderImpl implements AccidentsIntroHeader {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createIntroHeader(Table table, ProposalPdfData proposalPdfData) {
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .setFontColor(viviumOrgange())
                .setFontSize(15)
                .add(languageLabel.getLabel("accidents.title"));
        table.addCell(cell);

        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("accidents.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.ingangsdatum"));
        table.addCell(cell);

        cell = cellNoBorder(1, 3).add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getStartDates().getAccidentsAsString().toString());
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
    }
}
