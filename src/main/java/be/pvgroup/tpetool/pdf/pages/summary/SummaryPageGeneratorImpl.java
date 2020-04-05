package be.pvgroup.tpetool.pdf.pages.summary;

import be.pvgroup.tpetool.model.User;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.summary.blocks.SummaryPremiumsBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.DottedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component
public class SummaryPageGeneratorImpl implements SummaryPageGenerator {

    @Autowired
    private LanguageLabel languageLabel;

    @Autowired
    private SummaryPremiumsBlock summaryPremiumsBlock;

    @Override
    public void createSummaryPage(Document document, ProposalPdfData proposalPdfData) {
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));


        Table table = new Table(7);

        summaryPremiumsBlock.createSummaryPremiumsBlock(table, proposalPdfData);

        Cell cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.footer")).setItalic();
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.package.horeca.title")).setUnderline();
        table.addCell(cell);
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.package.horeca.1"));
        table.addCell(cell);
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.package.horeca.1.1"));
        table.addCell(cell);
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.package.horeca.1.2"));
        table.addCell(cell);
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.package.horeca.1.3"));
        table.addCell(cell);
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.package.horeca.1.4"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //--------------------------------------------------



        //--------------------------------------------------
        cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("proposal.summary.schadeverleden.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellNoBorder(1, 5).add("");
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.schadeverleden.question2"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.schadeverleden.question.property"));
        table.addCell(cell);
        cell = cellNoBorder(1, 5).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.schadeverleden.question.liability"));
        table.addCell(cell);
        cell = cellNoBorder(1, 5).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.schadeverleden.question.accident"));
        table.addCell(cell);
        cell = cellNoBorder(1, 5).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.schadeverleden.question"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.schadeverleden.question.property"));
        table.addCell(cell);
        cell = cellNoBorder(1, 5).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.schadeverleden.question.liability"));
        table.addCell(cell);
        cell = cellNoBorder(1, 5).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.summary.schadeverleden.question.accident"));
        table.addCell(cell);
        cell = cellNoBorder(1, 5).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        document.add(table);




        table = new Table(7);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.indicatieftarief.title")).setBold();
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.indicatieftarief.1"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.indicatieftarief.2"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.waarschuwing.title")).setBold();
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.waarschuwing.1"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(10).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.waarschuwing.2"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(10).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.waarschuwing.3"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.datassur.title")).setBold();
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.datassur.1"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.klachten.title")).setBold();
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.klachten.1"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.klachten.2"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.klachten.3"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(10).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.klachten.4"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.algemeen.title")).setBold();
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.algemeen.1"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(10).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.algemeen.2"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(10).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.summary.algemeen.3"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        document.add(table);

        table = new Table(7);
        table.setBorder(Border.NO_BORDER);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.sumary.opgemaakt.1"));
        table.addCell(cell);
        cell = cellNoBorder(1, 2).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(1, 2).add("   ");
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.sumary.opgemaakt.2"));
        table.addCell(cell);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = format.format(new Date());
        cell = cellNoBorder(1, 1).add(dateString);
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.sumary.opgemaakt.verklaring.1")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.sumary.opgemaakt.verklaring.2")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.sumary.opgemaakt.verklaring.3")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.sumary.opgemaakt.verklaring.4")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 2).add(languageLabel.getLabel("proposal.sumary.opgemaakt.3"));
        table.addCell(cell);
        cell = cellNoBorder(3, 3).add("   ").setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell);
        cell = cellNoBorder(1, 2).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(2, 2).setHeight(30).add(" ");
        table.addCell(cell);
        cell = cellNoBorder(2, 2).add(" ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("proposal.sumary.opgemaakt.4"));
        table.addCell(cell);
        cell = cellNoBorder(1, 1).add("   ").setBackgroundColor(Color.LIGHT_GRAY).setBorderBottom(new DottedBorder(1));
        table.addCell(cell);
        cell = cellNoBorder(2, 5).add(" ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        
        
        if (User.COMPANY_VIVIUM.equals(proposalPdfData.getCompany())) {
        	cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.footer.vivium.0"));
            table.addCell(cell);
        }
        
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.footer.1"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.footer.2"));               
        table.addCell(cell);
        
        if (User.COMPANY_VIVIUM.equals(proposalPdfData.getCompany())) {
        	cell = cellNoBorder(1, 7).add(languageLabel.getLabel("proposal.footer.vivium.3"));
            table.addCell(cell);
        }

        document.add(table);

    }
}
