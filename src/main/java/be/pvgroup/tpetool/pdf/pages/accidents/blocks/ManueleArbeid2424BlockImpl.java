package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import be.pvgroup.tpetool.util.arbeidsongevallen.AccidentsPremiumType;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

@Component
public class ManueleArbeid2424BlockImpl extends AbstractBlock implements ManueleArbeid2424Block {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createManueleArbeid2424Block(Table table, ProposalPdfData proposalPdfData) {
        this.proposalPdfData = proposalPdfData;
        initPremiumValues();

        boolean atLeastOneBeneficiary = (proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                .getAccidents().getBeneficiary().getName().trim().length() > 0)
                || (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getBeneficiary2()
                        .getName().trim().length() > 0);

        Cell cell = null;
        if (atLeastOneBeneficiary) {
            cell = cellNoBorder(1, 7).setBold().add(languageLabel.getLabel("accidents.2424.title"));
            table.addCell(cell);
            // -------------------------------------------------
            cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.2424.description"));
            table.addCell(cell);
            // -------------------------------------------------
            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.2424.verzekerden"));
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.2424.geboortedatum"));
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.2424.conventioneelloon"));
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(languageLabel.getLabel("accidents.2424.formule"));
            table.addCell(cell);

            cell = cellNoBorder(1, 1).setBold().add(languageLabel.getLabel("accidents.2424.premievoet")).setBold();
            table.addCell(cell);

            cell = cellNoBorder(1, 1).setBold().add(languageLabel.getLabel("accidents.2424.premieMetTaks")).setBold();
            table.addCell(cell);

            cell = cellNoBorder(1, 1).setBold().add(languageLabel.getLabel("accidents.2424.premieNetto")).setBold();
            table.addCell(cell);
        }
        // -------------------------------------------------
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getBeneficiary().getName()
                .trim().length() > 0) {
            cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getAccidents().getBeneficiary().getFullName());
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getAccidents().getBeneficiary().getDateOfBirth());
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getAccidents().getBeneficiary().getSalary() != null
                            ? proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents()
                                    .getBeneficiary().getSalary().toString()
                            : "");
            table.addCell(cell);

            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getBeneficiary()
                    .getManualWork().equals("")) {
                cell = cellNoBorder(1, 1).add("  ");
                table.addCell(cell);
            } else {
                String label2424Beneficiary = "accidents.2424." + proposalPdfData.getProposalInput().getData()
                        .getInsuranceAnswers().getAccidents().getBeneficiary().getManualWork();
                cell = cellNoBorder(1, 1).add(languageLabel.getLabel(label2424Beneficiary));
                table.addCell(cell);
            }

            if (accidentPremiumForBeneficiary != null) {
                cell = cellNoBorder(1, 1).add(accidentPremiumForBeneficiary.getPremiumRate().toString());
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(accidentPremiumForBeneficiary.getFeeWithTax().toString());
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(accidentPremiumForBeneficiary.getFeeNoTax().toString());
                table.addCell(cell);
            } else {
                cell = cellNoBorder(1, 3).add("  ");
                table.addCell(cell);
            }
        }
        // -------------------------------------------------
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getBeneficiary2()
                .getName().trim().length() > 0) {
            cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getAccidents().getBeneficiary2().getFullName());
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getAccidents().getBeneficiary2().getDateOfBirth());
            table.addCell(cell);

            cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getAccidents().getBeneficiary2().getSalary() != null
                            ? proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents()
                                    .getBeneficiary2().getSalary().toString()
                            : "");
            table.addCell(cell);

            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents().getBeneficiary2()
                    .getManualWork().equals("")) {
                cell = cellNoBorder(1, 1).add("  ");
                table.addCell(cell);
            } else {
                String label2424Beneficiary2 = "accidents.2424." + proposalPdfData.getProposalInput().getData()
                        .getInsuranceAnswers().getAccidents().getBeneficiary2().getManualWork();
                cell = cellNoBorder(1, 1).add(languageLabel.getLabel(label2424Beneficiary2));
                table.addCell(cell);
            }

            if (accidentPremiumForBeneficiary2 != null) {
                cell = cellNoBorder(1, 1).add(accidentPremiumForBeneficiary2.getPremiumRate().toString());
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(accidentPremiumForBeneficiary2.getFeeWithTax().toString());
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(accidentPremiumForBeneficiary2.getFeeNoTax().toString());
                table.addCell(cell);
            } else {
                cell = cellNoBorder(1, 3).add("  ");
                table.addCell(cell);
            }
        }

        if (atLeastOneBeneficiary) {

            // -------------------------------------------------
            cell = cellNoBorder(1, 4).add("   ");
            table.addCell(cell);

            cell = cellNoBorder(1, 1).setBold().add(languageLabel.getLabel("accidents.2424.totaal")).setBold();
            table.addCell(cell);

            cell = cellBorderTop(1, 1, Color.BLACK).add(sumFeeWithTaxBeneficiaries.toString()).setBold();
            table.addCell(cell);
            cell = cellBorderTop(1, 1, Color.BLACK).add(sumFeeNoTaxBeneficiaries.toString()).setBold();
            table.addCell(cell);
            // -------------------------------------------------
            cell = cellNoBorder(1, 7).setHeight(20).add("   ");
            table.addCell(cell);

            // -------------------------------------------------
        }
    }
}
