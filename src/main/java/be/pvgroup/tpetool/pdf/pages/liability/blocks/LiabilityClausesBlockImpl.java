package be.pvgroup.tpetool.pdf.pages.liability.blocks;

import be.pvgroup.tpetool.model.liability.LiabilityData;
import be.pvgroup.tpetool.model.liability.LiabilityInput;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.service.liability.LiabilityService;
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
public class LiabilityClausesBlockImpl implements LiabilityClausesBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Autowired
    private LiabilityService liabilityService;

    @Override
    public void createClauses(Table table, ProposalPdfData proposalPdfData) {
        //-------------------------------------------------
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(viviumOrgange())
                .setBold()
                .setFontColor(Color.WHITE)
                .add(languageLabel.getLabel("liability.clausules.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellBorderTop(1, 5).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.verklaring.kandidaat.title")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.verklaring.kandidaat.1"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.verklaring.kandidaat.2"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.verklaring.kandidaat.3"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);
        cell = cellNoBorder(1, 6).add(languageLabel.getLabel("liability.clausules.verklaring.kandidaat.3.1"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);
        cell = cellNoBorder(1, 6).add(languageLabel.getLabel("liability.clausules.verklaring.kandidaat.3.2"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);
        cell = cellNoBorder(1, 6).add(languageLabel.getLabel("liability.clausules.verklaring.kandidaat.3.3"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.voorwaarden.title")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.voorwaarden"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.premieberekening.title")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.premieberekening.1"));
        table.addCell(cell);
        //-------------------------------------------------
        LiabilityData.LiabilityDataBuilder liabilityDataBuilder = LiabilityData.LiabilityDataBuilder.aLiabilityData();
        LiabilityData liabilityData = liabilityDataBuilder.withAnswers(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()).build();

        LiabilityInput.LiabilityInputBuilder liabilityInputBuilder = LiabilityInput.LiabilityInputBuilder.aLiabilityInput();
        LiabilityInput liabilityInput = liabilityInputBuilder.withData(liabilityData).build();

        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.clausules.premieberekening.2") + ": " + liabilityService.calculateTotalNumbersOfEmployees(liabilityInput).toString());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------

    }
}