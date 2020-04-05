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

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component
public class LiabilityIntroHeaderImpl implements LiabilityIntroHeader {

    @Autowired
    private LanguageLabel languageLabel;

    private LiabilityService liabilityService;

    public LiabilityIntroHeaderImpl(LiabilityService liabilityService) {
        this.liabilityService = liabilityService;
    }

    @Override
    public void createIntroHeader(Table table, ProposalPdfData proposalPdfData) {
        Cell cell = cellNoBorder(1, 2)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold()
                .setFontColor(viviumOrgange())
                .setFontSize(15)
                .add(languageLabel.getLabel("liability.title"));
            table.addCell(cell);

        cell = cellNoBorder(1, 5).add("");
            table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 2)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBackgroundColor(viviumOrgange())
                .setBold()
                    .setFontColor(Color.WHITE)
                    .add(languageLabel.getLabel("liability.generalTitle"));
            table.addCell(cell);
            table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellNoBorder(1, 5).add("");
            table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.aantalwerknemers")).setBold();
            table.addCell(cell);

        cell = cellNoBorder(1, 7).add("");
            table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.aantalowners"));
            table.addCell(cell);

        cell = cellNoBorder(1, 1)
                    .add("1")
                    .setTextAlignment(TextAlignment.RIGHT);
            table.addCell(cell);

        cell = cellNoBorder(1, 2).add(languageLabel.getLabel("liability.persoon"));
            table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.aantalcoowners"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability().getNumberOfCoowners().toString())
                .setTextAlignment(TextAlignment.RIGHT);
        table.addCell(cell);

        cell = cellNoBorder(1, 2).add(languageLabel.getLabel("liability.personen"));
        table.addCell(cell);
        //--------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
            table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.aantalfulltime_medewerkerss"));
            table.addCell(cell);

        cell = cellNoBorder(1, 1)
                    .add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability().getNumberOfFullTimeEmployees().toString())
                    .setTextAlignment(TextAlignment.RIGHT);
            table.addCell(cell);

        cell = cellNoBorder(1, 2).add(languageLabel.getLabel("liability.personen"));
            table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
            table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.aantalparttime_medewerkers"));
            table.addCell(cell);

        cell = cellNoBorder(1, 1)
                    .add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability().getNumberOfPartTimeEmployees().toString())
                    .setTextAlignment(TextAlignment.RIGHT);
            table.addCell(cell);

        cell = cellNoBorder(1, 2).add(languageLabel.getLabel("liability.personen"));
            table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.aantaltoevallige_medewerkers"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1)
                .add(languageLabel.getLabel("liability.gratis"))
                .setTextAlignment(TextAlignment.RIGHT);
        table.addCell(cell);

        cell = cellNoBorder(1, 2).add("");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.totaal_medewerkers")).setBold();
        table.addCell(cell);

        LiabilityData.LiabilityDataBuilder liabilityDataBuilder = LiabilityData.LiabilityDataBuilder.aLiabilityData();
        LiabilityData liabilityData = liabilityDataBuilder.withAnswers(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()).build();

        LiabilityInput.LiabilityInputBuilder liabilityInputBuilder = LiabilityInput.LiabilityInputBuilder.aLiabilityInput();
        LiabilityInput liabilityInput = liabilityInputBuilder.withData(liabilityData).build();


        cell = cellNoBorder(1, 1)
                .add(liabilityService.calculateTotalNumbersOfEmployees(liabilityInput).toString())
                .setTextAlignment(TextAlignment.RIGHT);
        table.addCell(cell);

        cell = cellNoBorder(1, 2)
                .add("");

        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("");
        table.addCell(cell);

        cell = cellNoBorder(1, 6).add(languageLabel.getLabel("liability.rounding.tekst"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
    }
}
