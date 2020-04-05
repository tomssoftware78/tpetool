package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.accidents.AccidentsAnswers;
import be.pvgroup.tpetool.model.accidents.Beneficiary;
import be.pvgroup.tpetool.model.accidents.Payroll;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Accidents_Example_2_TestConstants {
    public static ProposalInput proposalInput_Example_Acc_2() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalData_Example_Acc_2())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalData_Example_Acc_2() {
        ProposalData.ProposalDataBuilder builder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = builder
                .withInsuranceAnswers(insuranceAnswers_Example_Acc_2())
                .withCommonAnswers(commonAnswers())
                .withNacebel(TestConstants.NACEBEL_56210)
                .build();
        return proposalData;
    }

    public static InsuranceAnswers insuranceAnswers_Example_Acc_2() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withAccidents(accidentsAnswers_Example_Acc_2())
                .build();

        return insuranceAnswers;
    }

    public static AccidentsAnswers accidentsAnswers_Example_Acc_2() {
        AccidentsAnswers.AccidentsAnswersBuilder answersBuilder = AccidentsAnswers.AccidentsAnswersBuilder.anAccidentsAnswers();

        AccidentsAnswers accidentsAnswers = answersBuilder
                .withPayroll(payroll())
                .withBeneficiary(beneficiaryWithoutManualWork())
                .build();

        return accidentsAnswers;
    }

    public static Beneficiary beneficiaryWithoutManualWork() {
        Beneficiary.BeneficiaryBuilder beneficiaryBuilder = Beneficiary.BeneficiaryBuilder.aBeneficiary();
        Beneficiary beneficiary = beneficiaryBuilder
                .withFirstName("Mary")
                .withName("Poppins")
                .withDateOfBirth("31121964")
                .withSalary(new BigDecimal(40000))
                .withManualWork("no-manual")
                .build();

        return beneficiary;
    }

    public static Payroll payroll() {
        Payroll.PayrollBuilder payrollBuilder = Payroll.PayrollBuilder.aPayroll();
        Payroll payroll = payrollBuilder
                .withEmployeeWage(new BigDecimal(20000))
                .withWorkerWage(new BigDecimal(20000))
                .withWorkerWageStudent(new BigDecimal(10000)).build();

        return payroll;
    }

}
