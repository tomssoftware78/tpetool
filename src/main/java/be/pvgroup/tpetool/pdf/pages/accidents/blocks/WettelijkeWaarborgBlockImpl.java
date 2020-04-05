package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import be.pvgroup.tpetool.util.arbeidsongevallen.AccidentsPremiumType;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

@Component
public class WettelijkeWaarborgBlockImpl extends AbstractBlock implements  WettelijkeWaarborgBlock {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createWettelijkeWaarborgBlock(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        Cell cell = cellNoBorder(1, 7).setBold().add(languageLabel.getLabel("accidents.wettelijkewaarborg.title"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.wettelijkewaarborg.description"));
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.CENTER).add(languageLabel.getLabel("accidents.wettelijkewaarborg.loonmassa"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.premievoet")).setBold();
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.premieMetTaks")).setBold();
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.premieNetto")).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.wettelijkewaarborg.loonmassa.others"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.wettelijkewaarborg.loonmassa.students"));
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.wettelijkewaarborg.arbeidsweg.incl"));
        table.addCell(cell);

        cell = cellNoBorder(1, 2).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.bedienden"));
        table.addCell(cell);

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getEmployeeWage() != null) {

            cell = cellNoBorder(1, 1)
                    .add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getEmployeeWage().toString());
        } else {
            cell = cellNoBorder(1, 1).add("");

        }
        table.addCell(cell);


        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getEmployeeWageStudent() != null) {
            cell = cellNoBorder(1, 1)
                    .add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getEmployeeWageStudent().toString());
        } else {
            cell = cellNoBorder(1, 1).add("");
        }
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(premiumEmployeeOther.getPremiumRate().toString());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(totalFeeWithTaxEmployee.toString());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(totalFeeNoTaxEmployee.toString());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.arbeiders"));
        table.addCell(cell);

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getWorkerWage() != null) {
            cell = cellNoBorder(1, 1)
                    .add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getWorkerWage().toString());
        } else {
            cell = cellNoBorder(1, 1).add("");
        }
        table.addCell(cell);

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll() != null &&
                proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getWorkerWageStudent() != null) {
            cell = cellNoBorder(1, 1)
                    .add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getPayroll().getWorkerWageStudent().toString());
        } else {
            cell = cellNoBorder(1, 1).add("");
        }
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(premiumWorkerOther.getPremiumRate().toString());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(totalFeeWithTaxWorker.toString());
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(totalFeeNoTaxWorker.toString());
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 4).add("   ");
        table.addCell(cell);

        cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.wettelijkewaarborg.totaal")).setBold();
        table.addCell(cell);

        cell = cellBorderTop(1, 1, Color.BLACK).add(totaalWettelijkeWaarborgWithTax.toString()).setBold();
        table.addCell(cell);

        cell = cellBorderTop(1, 1, Color.BLACK).add(totaalWettelijkeWaarborgNoTax.toString()).setBold();
        table.addCell(cell);
        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
    }
}
