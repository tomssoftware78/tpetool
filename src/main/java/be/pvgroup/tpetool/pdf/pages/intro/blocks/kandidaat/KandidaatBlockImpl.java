package be.pvgroup.tpetool.pdf.pages.intro.blocks.kandidaat;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component
public class KandidaatBlockImpl implements KandidaatBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createKandidaatBlock(Document document, ProposalPdfData proposalPdfData) {
        Table table = new Table(7);
        //--------------------------------------------------
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("kandidaat"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("bdpNr"));
        table.addCell(cell);

        cell = cellNoBorder(1, 3)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getBdpNr());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("ondernemingsNr"));
        table.addCell(cell);
        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getCompanyNr());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 4).add("");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("rechtsvorm"));
        table.addCell(cell);

        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getLegalForm());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.naam"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getName());
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.voornaam"));
        table.addCell(cell);
        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getFirstName());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.straat"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getStreet());
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.nr"));
        table.addCell(cell);
        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getNumber());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.postcode"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getZip());
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.plaats"));
        table.addCell(cell);
        cell = cellNoBorder(1, 2)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getCity ());
        table.addCell(cell);

        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.telefoon"));
        table.addCell(cell);
        cell = cellNoBorder(1, 6)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getPhone());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("kandidaat.email"));
        table.addCell(cell);
        cell = cellNoBorder(1, 6)
                .add(proposalPdfData.getProposalInput().getData().getCommonAnswers().getProspect().getEmail());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("nacecode"));
        table.addCell(cell);
        cell = cellNoBorder(1, 6)
                .add(proposalPdfData.getProposalInput().getData().getNacebel());
        table.addCell(cell);
        //-------------------------------------------------
        Text text1 = new Text(languageLabel.getLabel("omschrijvingActiviteit"));
        text1.setUnderline(1.5f, -2);
        cell = cellNoBorder(1, 7).add(new Paragraph(text1));
        table.addCell(cell);
        //-------------------------------------------------
        String nacecodeDescriptionLabel = "nacecode." + proposalPdfData.getProposalInput().getData().getNacebel() + ".description";
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel(nacecodeDescriptionLabel));
        table.addCell(cell);

        document.add(table);
    }
}
