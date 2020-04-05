package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.accidents.*;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.TestConstants.NACEBEL_56101;

public class AccidentsTestConstants {

    public static Payroll payroll() {
        Payroll.PayrollBuilder payrollBuilder = Payroll.PayrollBuilder.aPayroll();
        Payroll payroll = payrollBuilder
                .withEmployeeWage(new BigDecimal(10000))
                .withWorkerWage(new BigDecimal(18000))
                .withWorkerWageStudent(new BigDecimal(10000)).build();

        return payroll;
    }

    public static Beneficiary beneficiaryWithManualWork() {
        Beneficiary.BeneficiaryBuilder beneficiaryBuilder = Beneficiary.BeneficiaryBuilder.aBeneficiary();
        Beneficiary beneficiary = beneficiaryBuilder
                .withFirstName("Tom")
                .withName("Van den Eynde")
                .withDateOfBirth("06301985")
                .withSalary(new BigDecimal(35000))
                .withManualWork("manual")
                .build();

        return beneficiary;
    }

    public static Beneficiary beneficiaryWithNoManualWork() {
        Beneficiary.BeneficiaryBuilder beneficiaryBuilder = Beneficiary.BeneficiaryBuilder.aBeneficiary();
        Beneficiary beneficiary = beneficiaryBuilder
                .withFirstName("Tim")
                .withName("Van den Eynde")
                .withDateOfBirth("06301985")
                .withSalary(new BigDecimal(35000))
                .withManualWork("no-manual")
                .build();

        return beneficiary;
    }

    public static AccidentsAnswers accidentsAnswers() {
        AccidentsAnswers.AccidentsAnswersBuilder answersBuilder = AccidentsAnswers.AccidentsAnswersBuilder.anAccidentsAnswers();

        AccidentsAnswers accidentsAnswers = answersBuilder
                .withPayroll(payroll())
                .withBeneficiary(beneficiaryWithManualWork())
                .build();

        return accidentsAnswers;
    }

    public static AccidentsAnswers accidentsAnswersWith2Beneficiaries() {
        AccidentsAnswers.AccidentsAnswersBuilder answersBuilder = AccidentsAnswers.AccidentsAnswersBuilder.anAccidentsAnswers();

        AccidentsAnswers accidentsAnswers = answersBuilder
                .withPayroll(payroll())
                .withBeneficiary(beneficiaryWithManualWork())
                .withBeneficiary2(beneficiaryWithNoManualWork())
                .build();

        return accidentsAnswers;
    }

    public static AccidentsData accidentsData() {

        AccidentsData.AccidentsDataBuilder accidentsDataBuilder = AccidentsData.AccidentsDataBuilder.anAccidentsData();

        AccidentsData accidentsData = accidentsDataBuilder
                .withNacebel(NACEBEL_56101)
                .withAnswers(accidentsAnswers())
                .build();

        return accidentsData;
    }

    public static AccidentsData accidentsDataWith2Beneficiaries() {

        AccidentsData.AccidentsDataBuilder accidentsDataBuilder = AccidentsData.AccidentsDataBuilder.anAccidentsData();

        AccidentsData accidentsData = accidentsDataBuilder
                .withNacebel("56101")
                .withAnswers(accidentsAnswersWith2Beneficiaries())
                .build();

        return accidentsData;
    }

    public static AccidentsInput accidentsInput() {
        AccidentsInput.AccidentsInputBuilder builder =
                AccidentsInput.AccidentsInputBuilder.anAccidentsInput();

        AccidentsInput input = builder.withData(accidentsData()).build();
        return input;
    }

    public static AccidentsInput accidentsInputWith2Beneficiaries() {
        AccidentsInput.AccidentsInputBuilder builder =
                AccidentsInput.AccidentsInputBuilder.anAccidentsInput();

        AccidentsInput input = builder.withData(accidentsDataWith2Beneficiaries()).build();
        return input;
    }
}
