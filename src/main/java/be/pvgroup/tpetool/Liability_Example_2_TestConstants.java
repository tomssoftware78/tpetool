package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.liability.LiabilityAnswers;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Liability_Example_2_TestConstants {

    public static ProposalInput proposalInput_Example_Liab_2() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalData_Example_Liab_2())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalData_Example_Liab_2() {
        ProposalData.ProposalDataBuilder builder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = builder
                .withInsuranceAnswers(insuranceAnswers_Example_Liab_2())
                .withCommonAnswers(commonAnswers())
                .withNacebel(TestConstants.NACEBEL_56210)
                .build();
        return proposalData;
    }

    public static InsuranceAnswers insuranceAnswers_Example_Liab_2() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withLiability(liabilityAnswers_Example_Liab_2())
                .build();

        return insuranceAnswers;
    }

    public static LiabilityAnswers liabilityAnswers_Example_Liab_2() {
        LiabilityAnswers.LiabilityAnswersBuilder answersBuilder = LiabilityAnswers.LiabilityAnswersBuilder.aLiabilityAnswers();

        LiabilityAnswers liabilityAnswers = answersBuilder
                .withNumberOfCoowners(new BigDecimal(0))
                .withNumberOfOwners(BigDecimal.ONE)
                .withNumberOfFullTimeEmployees(new BigDecimal(1))
                .withNumberOfPartTimeEmployees(new BigDecimal(0))
                .withExploitationLimit(new BigDecimal(1500000))
                .build();


        return liabilityAnswers;
    }
}
