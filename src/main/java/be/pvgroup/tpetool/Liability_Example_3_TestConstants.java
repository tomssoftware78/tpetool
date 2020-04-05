package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.liability.LiabilityAnswers;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Liability_Example_3_TestConstants {

    public static ProposalInput proposalInput_Example_Liab_3() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalData_Example_Liab_3())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalData_Example_Liab_3() {
        ProposalData.ProposalDataBuilder builder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = builder
                .withInsuranceAnswers(insuranceAnswers_Example_Liab_3())
                .withCommonAnswers(commonAnswers())
                .withNacebel(TestConstants.NACEBEL_56102)
                .build();
        return proposalData;
    }

    public static InsuranceAnswers insuranceAnswers_Example_Liab_3() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withLiability(liabilityAnswers_Example_Liab_3())
                .build();

        return insuranceAnswers;
    }

    public static LiabilityAnswers liabilityAnswers_Example_Liab_3() {
        LiabilityAnswers.LiabilityAnswersBuilder answersBuilder = LiabilityAnswers.LiabilityAnswersBuilder.aLiabilityAnswers();

        LiabilityAnswers liabilityAnswers = answersBuilder
                .withNumberOfCoowners(new BigDecimal(1))
                .withNumberOfOwners(BigDecimal.ONE)
                .withNumberOfFullTimeEmployees(new BigDecimal(0))
                .withNumberOfPartTimeEmployees(new BigDecimal(0))
                .withExploitationLimit(new BigDecimal(1500000))
                .build();


        return liabilityAnswers;
    }
}
