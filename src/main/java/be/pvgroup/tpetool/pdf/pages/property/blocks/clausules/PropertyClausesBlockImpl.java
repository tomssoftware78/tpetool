package be.pvgroup.tpetool.pdf.pages.property.blocks.clausules;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.pvgroup.tpetool.model.User;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.model.property.BuildingEvaluation;
import be.pvgroup.tpetool.model.property.CommercialUnemploymentFormula;
import be.pvgroup.tpetool.model.property.PropertyAlarmSystem;
import be.pvgroup.tpetool.model.property.PropertyContinguity;
import be.pvgroup.tpetool.util.LanguageLabel;

@Component
public class PropertyClausesBlockImpl implements ClausesBlock {

    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createClauses(Table table, ProposalPdfData proposalPdfData) {
        // -------------------------------------------------
        Cell cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.LEFT).setBackgroundColor(viviumOrgange())
                .setBold().setFontColor(Color.WHITE).add(languageLabel.getLabel("property.clausules.title"));
        table.addCell(cell);
        table.setBorder(new SolidBorder(viviumOrgange(), 0));

        cell = cellBorderTop(1, 5).add("   ");
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);

        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.1"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.ja"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.2"));
        table.addCell(cell);
        String yesNoInhabited = null;
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getAddress()
                .getInhabitedRegurarly()) {
            yesNoInhabited = languageLabel.getLabel("property.clausules.ja");
        } else {
            yesNoInhabited = languageLabel.getLabel("property.clausules.nee");
        }
        cell = cellNoBorder(1, 3).add(yesNoInhabited);
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.3"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.ja"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.4"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.nee"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.5"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.nee"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.6"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.basisvrijstelling"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.7"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.duurtijd"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.8"));
        table.addCell(cell);

        String yesNoFirstRisk = null;
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getMandatoryCoverage()
                .getBuildingEvaluation().equals(BuildingEvaluation.FIRST_RISK)) {
            yesNoFirstRisk = languageLabel.getLabel("property.clausules.ja");
        } else {
            yesNoFirstRisk = languageLabel.getLabel("property.clausules.nee");
        }
        cell = cellNoBorder(1, 3).add(yesNoFirstRisk);
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.9"));
        table.addCell(cell);
        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.nee"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.10"));
        table.addCell(cell);

        String contiguity = null;
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getTheft().getContinguity()
                .equals(PropertyContinguity.CONTINGUITY)) {
            contiguity = languageLabel.getLabel("Prop_Contiguity_Continguity");

        } else {
            contiguity = languageLabel.getLabel("Prop_Contiguity_NoContinguity");
        }

        cell = cellNoBorder(1, 3).add(contiguity);
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.11"));
        table.addCell(cell);

        String alarmSystem = null;
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getTheft().getAlarmSystem()
                .equals(PropertyAlarmSystem.AGREED_CENTRAL)) {
            alarmSystem = languageLabel.getLabel("Prop_AlarmSystem_AgreedCentral");
        } else if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getTheft()
                .getAlarmSystem().equals(PropertyAlarmSystem.GSM)) {
            alarmSystem = languageLabel.getLabel("Prop_AlarmSystem_GSM");
        } else {
            alarmSystem = languageLabel.getLabel("Prop_AlarmSystem_NoAlarm");
        }

        cell = cellNoBorder(1, 3).add(alarmSystem);
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.12"));
        table.addCell(cell);
        String yesNoOccupiedRegularly = null;
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getAddress()
                .getInhabitedRegurarly()) {
            yesNoOccupiedRegularly = languageLabel.getLabel("property.clausules.ja");
        } else {
            yesNoOccupiedRegularly = languageLabel.getLabel("property.clausules.nee");
        }
        cell = cellNoBorder(1, 3).add(yesNoOccupiedRegularly);
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.13"));
        table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.ja"));
        table.addCell(cell);
        // -------------------------------------------------
        cell = cellNoBorder(1, 4).add(languageLabel.getLabel("property.clausules.14"));
        table.addCell(cell);

        cell = cellNoBorder(1, 3).add(languageLabel.getLabel("property.clausules.basisvrijstelling"));
        table.addCell(cell);
        // -------------------------------------------------
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.title", true);
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.1");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.2");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.3");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.3.1", 50);
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.3.2", 50);
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.3.3", 50);
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.4");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.5");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.6");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.7");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.8");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.9");
        addTextLine(table, "property.clausules.verzekeringsnemer.verklaring.10");
        // -------------------------------------------------

        addTextLine(table, "property.clausules.horeca.title", true);
        addTextLine(table, "property.clausules.horeca.blusmiddelen.title");
        addTextLine(table, "property.clausules.horeca.blusmiddelen.1");
        addTextLine(table, "property.clausules.horeca.blusmiddelen.2");
        addTextLine(table, "property.clausules.horeca.blusmiddelen.3");
        addTextLine(table, "property.clausules.horeca.blusmiddelen.4");
        addTextLine(table, "property.clausules.horeca.blusmiddelen.5");
        addTextLine(table, "property.clausules.horeca.blusmiddelen.6");
        addTextLine(table, "property.clausules.horeca.blusmiddelen.7");

        addTextLine(table, "property.clausules.horeca.elektrischeinstallatie.title");
        addTextLine(table, "property.clausules.horeca.elektrischeinstallatie.1");
        addTextLine(table, "property.clausules.horeca.elektrischeinstallatie.2");

        addTextLine(table, "property.clausules.horeca.housekeeping.title");
        addTextLine(table, "property.clausules.horeca.housekeeping.1");
        addTextLine(table, "property.clausules.horeca.housekeeping.2");
        addTextLine(table, "property.clausules.horeca.housekeeping.3");
        addTextLine(table, "property.clausules.horeca.housekeeping.4");
        addTextLine(table, "property.clausules.horeca.housekeeping.5");

        addTextLine(table, "property.clausules.varia.title");
        addTextLine(table, "property.clausules.varia.1");
        addTextLine(table, "property.clausules.varia.2");
        addTextLine(table, "property.clausules.varia.3");

        // -------------------------------------------------
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment()
                .getCovered()) {
            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty()
                    .getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.REVENUE)) {
                addTextLine(table, "property.clausules.bedrijfsschade.omzet.title", true);
                addTextLine(table, "property.clausules.bedrijfsschade.omzet.description");
            }
        }

        // -------------------------------------------------
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment()
                .getCovered()) {
            addTextLine(table, "property.clausules.bedrijfsschade.waarborgen.title", true);
            addTextLine(table, "property.clausules.bedrijfsschade.waarborgen.description");
        }
        // -------------------------------------------------

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getCommercialUnemployment()
                .getCovered()) {
            addTextLine(table, "property.clausules.bedrijfsschade.vergoedingstermijn.title", true);
            addTextLine(table, "property.clausules.bedrijfsschade.vergoedingstermijn.description");
        }
        // -------------------------------------------------
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getMandatoryCoverage()
                .getBuildingEvaluation().equals(BuildingEvaluation.FIRST_RISK)) {
            addTextLine(table, "property.clausules.bedrijfsschade.risico.title", true);
            addTextLine(table, "property.clausules.bedrijfsschade.risico.description");
        }
        // -------------------------------------------------
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getTheft().getCovered()) {
            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getTheft()
                    .getAlarmSystem().equals(PropertyAlarmSystem.AGREED_CENTRAL)) {
                addTextLine(table, "property.clausules.diefstal.title", true);
                addTextLine(table, "property.clausules.diefstal.1");
                addTextLine(table, "property.clausules.diefstal.2");
                addTextLine(table, "property.clausules.diefstal.3");
                addTextLine(table, "property.clausules.diefstal.4");

            }
        }
        // -------------------------------------------------
        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getTheft().getCovered()) {
            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getTheft()
                    .getAlarmSystem().equals(PropertyAlarmSystem.GSM)) {
                addTextLine(table, "property.clausules.diefstal.gms.title", true);
                addTextLine(table, "property.clausules.diefstal.gsm.1");

            }
        }
        // -------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);

        addTextLine(table, "property.footer");

        if (User.COMPANY_VIVIUM.equals(proposalPdfData.getCompany())) {
            addTextLine(table, "proposal.footer.vivium.4");
        } else {
            addTextLine(table, "proposal.footer.pv.4");
        }
    }

    private void addTextLine(Table table, String messageKey, boolean bold, Integer marginLeft) {
        Cell cell = cellNoBorder(1, 7).add(languageLabel.getLabel(messageKey));
        if (bold) {
            cell.setBold();
        }
        cell.setPaddingLeft(marginLeft);
        table.addCell(cell);

    }

    private void addTextLine(Table table, String messageKey) {
        addTextLine(table, messageKey, false, 0);
    }

    private void addTextLine(Table table, String messageKey, boolean bold) {
        addTextLine(table, messageKey, bold, 0);
    }

    private void addTextLine(Table table, String messageKey, Integer marginLeft) {
        addTextLine(table, messageKey, false, marginLeft);
    }
}
