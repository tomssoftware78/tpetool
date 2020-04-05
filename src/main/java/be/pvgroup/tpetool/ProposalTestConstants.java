package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.proposal.*;

import java.sql.Date;

import static be.pvgroup.tpetool.AccidentsTestConstants.beneficiaryWithManualWork;
import static be.pvgroup.tpetool.AccidentsTestConstants.beneficiaryWithNoManualWork;

public class ProposalTestConstants {

    public static ProposalInput proposalInput() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalData())
                .build();

        return proposalInput;
    }

    public static ProposalInput proposalInputWithSelectedPremiums() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalDataWithSelectedPremiums())
                .build();

        return proposalInput;
    }

    public static ProposalInput proposalInputWithSelectedPremiums_WithOnlyAccidents() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalDataWithSelectedPremiums_WithOnlyAccidents())
                .build();

        return proposalInput;
    }

    public static ProposalInput proposalInputWithSelectedPremiums_WithOnlyLiability() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalDataWithSelectedPremiums_WithOnlyLiability())
                .build();

        return proposalInput;
    }

    public static ProposalInput proposalInputWithSelectedPremiums_WithOnlyProperty() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalDataWithSelectedPremiums_WithOnlyProperty())
                .build();

        return proposalInput;
    }




    public static ProposalInput proposalInputWith2BeneficiariesAndWithSelectedPremiums() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalDataWithSelectedPremiums())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalData() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56101)
                .withInsuranceAnswers(insuranceAnswers())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }

    public static ProposalData proposalDataWithSelectedPremiums() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56101)
                .withInsuranceAnswers(insuranceAnswersWithSelectedPremiums())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }

    public static ProposalData proposalDataWithSelectedPremiums_WithOnlyAccidents() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56101)
                .withInsuranceAnswers(insuranceAnswersWithSelectedPremiums_WithOnlyAccidents())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }

    public static ProposalData proposalDataWithSelectedPremiums_WithOnlyLiability() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56101)
                .withInsuranceAnswers(insuranceAnswersWithSelectedPremiums_WithOnlyLiability())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }

    public static ProposalData proposalDataWithSelectedPremiums_WithOnlyProperty() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56101)
                .withInsuranceAnswers(insuranceAnswersWithSelectedPremiums_WithOnlyProperty())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }


    public static CommonAnswers commonAnswers() {
        CommonAnswers.CommonAnswersBuilder commonAnswersBuilder = CommonAnswers.CommonAnswersBuilder.aCommonAnswers();

        CommonAnswers commonAnswers = commonAnswersBuilder
                .withIntermediary(intermediary())
                .withProspect(prospect())
                .withStartDates(startDates())
                .build();
        return commonAnswers;
    }

    public static StartDates startDates() {

        StartDates.StartDatesBuilder startDatesBuilder = StartDates.StartDatesBuilder.aStartDates();
        StartDates startDates = startDatesBuilder
                .withAccidents(Date.valueOf("2020-05-15"))
                .withLiability(Date.valueOf("2020-05-15"))
                .withProperty(Date.valueOf("2020-05-15"))
                .build();

        return startDates;
    }

    public static Prospect prospect() {
        Prospect.ProspectBuilder prospectBuilder = Prospect.ProspectBuilder.aProspect();
        Prospect prospect = prospectBuilder
                .withBdpNr(TestConstants.BDP_NR)
                .withCity(TestConstants.CITY)
                .withCompanyNr(TestConstants.COMPANY_NR)
                .withEmail(TestConstants.EMAIL_1)
                .withFirstName(TestConstants.FIRST_NAME_1)
                .withLegalForm(TestConstants.LEGAL_FORM)
                .withName(TestConstants.NAME_1)
                .withNumber(TestConstants.NUMBER)
                .withPhone(TestConstants.PHONE_1)
                .withStreet(TestConstants.STREET)
                .withZip(TestConstants.ZIP)
                .build();

        return prospect;
    }

    public static Intermediary intermediary() {
        Intermediary.IntermediaryBuilder intermediaryBuilder = Intermediary.IntermediaryBuilder.anIntermediary();

        Intermediary intermediary = intermediaryBuilder
                .withCell(TestConstants.CELL)
                .withEmail(TestConstants.EMAIL)
                .withFirstName(TestConstants.NAME)
                .withFsmaNr(TestConstants.FSMA_NR)
                .withName(TestConstants.NAME)
                .withFirstName(TestConstants.FIRST_NAME)
                .withPhone(TestConstants.PHONE)
                .withProducerNr(TestConstants.PRODUCT_NR)
                .build();

        return intermediary;
    }

    public static InsuranceAnswers insuranceAnswersWithSelectedPremiums() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withAccidents(AccidentsTestConstants.accidentsAnswers())
                .withLiability(LiabilityTestConstants.liabilityAnswers())
                .withProperty(PropertyTestConstants.propertyAnswersWithSelectedPremiums())
                .build();

        return insuranceAnswers;
    }

    public static InsuranceAnswers insuranceAnswersWithSelectedPremiums_WithOnlyAccidents() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withAccidents(AccidentsTestConstants.accidentsAnswers())
                .build();

        return insuranceAnswers;
    }

    public static InsuranceAnswers insuranceAnswersWithSelectedPremiums_WithOnlyLiability() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withLiability(LiabilityTestConstants.liabilityAnswers())
                .build();

        return insuranceAnswers;
    }

    public static InsuranceAnswers insuranceAnswersWithSelectedPremiums_WithOnlyProperty() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withProperty(PropertyTestConstants.propertyAnswers())
                .build();

        return insuranceAnswers;
    }





    public static InsuranceAnswers insuranceAnswers() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withAccidents(AccidentsTestConstants.accidentsAnswers())
                .withLiability(LiabilityTestConstants.liabilityAnswers())
                .withProperty(PropertyTestConstants.propertyAnswers())
                .build();

        return insuranceAnswers;
    }

    public static ProposalInput proposalInputForPdf() {
        ProposalInput proposalInput = proposalInputWithSelectedPremiums();

        proposalInput.getData().getInsuranceAnswers().getAccidents().setBeneficiary(beneficiaryWithManualWork());
        proposalInput.getData().getInsuranceAnswers().getAccidents().setBeneficiary2(beneficiaryWithNoManualWork());

        return proposalInput;
    }

    public static ProposalInput proposalInputForPdf_WithOnlyAccidents() {
        ProposalInput proposalInput = proposalInputWithSelectedPremiums_WithOnlyAccidents();

        proposalInput.getData().getInsuranceAnswers().getAccidents().setBeneficiary(beneficiaryWithManualWork());
        proposalInput.getData().getInsuranceAnswers().getAccidents().setBeneficiary2(beneficiaryWithNoManualWork());

        return proposalInput;
    }

    public static ProposalInput proposalInputForPdf_WithOnlyLiability() {
        ProposalInput proposalInput = proposalInputWithSelectedPremiums_WithOnlyLiability();

        return proposalInput;
    }

    public static ProposalInput proposalInputForPdf_WithOnlyProperty() {
        ProposalInput proposalInput = proposalInputWithSelectedPremiums_WithOnlyProperty();

        return proposalInput;
    }
}
