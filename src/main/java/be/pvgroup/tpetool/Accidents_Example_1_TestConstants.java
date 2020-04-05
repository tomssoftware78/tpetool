package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.accidents.AccidentsAnswers;
import be.pvgroup.tpetool.model.accidents.Beneficiary;
import be.pvgroup.tpetool.model.accidents.Payroll;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Accidents_Example_1_TestConstants {

    public static ProposalInput proposalInput_Example_Acc_1() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalData_Example_Acc_1())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalData_Example_Acc_1() {
        ProposalData.ProposalDataBuilder builder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = builder
                .withInsuranceAnswers(insuranceAnswers_Example_Acc_1())
                .withCommonAnswers(commonAnswers())
                .withNacebel(TestConstants.NACEBEL_56101)
                .build();
        return proposalData;
    }

    public static InsuranceAnswers insuranceAnswers_Example_Acc_1() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withAccidents(accidentsAnswers_Example_Acc_1())
                .build();

        return insuranceAnswers;
    }

    public static AccidentsAnswers accidentsAnswers_Example_Acc_1() {
        AccidentsAnswers.AccidentsAnswersBuilder answersBuilder = AccidentsAnswers.AccidentsAnswersBuilder.anAccidentsAnswers();

        AccidentsAnswers accidentsAnswers = answersBuilder
                .withPayroll(payroll())
                .withBeneficiary(beneficiaryWithoutManualWork())
                .withBeneficiary2(beneficiaryWithManualWork())
                .build();

        return accidentsAnswers;
    }

    public static Beneficiary beneficiaryWithoutManualWork() {
        Beneficiary.BeneficiaryBuilder beneficiaryBuilder = Beneficiary.BeneficiaryBuilder.aBeneficiary();
        Beneficiary beneficiary = beneficiaryBuilder
                .withFirstName("Jane")
                .withName("Banks")
                .withDateOfBirth("01011980")
                .withSalary(new BigDecimal(35000))
                .withManualWork("no-manual")
                .build();

        return beneficiary;
    }

    public static Beneficiary beneficiaryWithManualWork() {
        Beneficiary.BeneficiaryBuilder beneficiaryBuilder = Beneficiary.BeneficiaryBuilder.aBeneficiary();
        Beneficiary beneficiary = beneficiaryBuilder
                .withFirstName("Jonathan")
                .withName("Banks")
                .withDateOfBirth("01011982")
                .withSalary(new BigDecimal(30000))
                .withManualWork("manual")
                .build();

        return beneficiary;
    }


    public static Payroll payroll() {
        Payroll.PayrollBuilder payrollBuilder = Payroll.PayrollBuilder.aPayroll();
        Payroll payroll = payrollBuilder
                .withEmployeeWage(new BigDecimal(10000))
                .withWorkerWage(new BigDecimal(18000))
                .withWorkerWageStudent(new BigDecimal(10000)).build();

        return payroll;
    }
}
