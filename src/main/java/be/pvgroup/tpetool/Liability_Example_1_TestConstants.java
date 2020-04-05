package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.liability.LiabilityAnswers;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Liability_Example_1_TestConstants {

    public static ProposalInput proposalInput_Example_Liab_1() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalData_Example_Liab_1())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalData_Example_Liab_1() {
        ProposalData.ProposalDataBuilder builder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = builder
                .withInsuranceAnswers(insuranceAnswers_Example_Liab_1())
                .withCommonAnswers(commonAnswers())
                .withNacebel(TestConstants.NACEBEL_56101)
                .build();
        return proposalData;

    }

    public static InsuranceAnswers insuranceAnswers_Example_Liab_1() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withLiability(liabilityAnswers_Example_Liab_1())
                .build();

        return insuranceAnswers;
    }

    public static LiabilityAnswers liabilityAnswers_Example_Liab_1() {
        LiabilityAnswers.LiabilityAnswersBuilder answersBuilder = LiabilityAnswers.LiabilityAnswersBuilder.aLiabilityAnswers();

        LiabilityAnswers liabilityAnswers = answersBuilder
                .withNumberOfCoowners(new BigDecimal(1))
                .withNumberOfOwners(BigDecimal.ONE)
                .withNumberOfFullTimeEmployees(new BigDecimal(1))
                .withNumberOfPartTimeEmployees(new BigDecimal(1))
                .withExploitationLimit(new BigDecimal(2500000))
                .build();


        return liabilityAnswers;
    }
}
