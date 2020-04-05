package be.pvgroup.tpetool.pdf.pages.intro.blocks.tussenpersoon;

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
public class TussenpersoonBlockImpl implements TussenpersoonBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createTussenpersoonBlock(Document document, ProposalPdfData proposalPdfData) {
        Table table = new Table(7);
        //--------------------------------------------------
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("tussenpersoon"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("producentNr"));
        table.addCell(cell);

        cell = cellNoBorder(1, 3)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getIntermediary().getProducerNr());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("fsmaNr"));
        table.addCell(cell);

        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getIntermediary().getFsmaNr());
        table.addCell(cell);
        //---------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("naam"));
        table.addCell(cell);

        cell = cellNoBorder(1, 3)
                .setTextAlignment(TextAlignment.LEFT)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getIntermediary().getName());
        table.addCell(cell);

        cell = cellNoBorder(1,1).add(languageLabel.getLabel("voornaam"));
        table.addCell(cell);
        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getIntermediary().getFirstName());
        table.addCell(cell);
        //---------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("telefoon"));
        table.addCell(cell);

        cell = cellNoBorder(1, 3)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getIntermediary().getPhone());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("gsm"));
        table.addCell(cell);

        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getIntermediary().getCell());
        table.addCell(cell);
        //---------------------------------------------
        document.add(table);
    }
}
