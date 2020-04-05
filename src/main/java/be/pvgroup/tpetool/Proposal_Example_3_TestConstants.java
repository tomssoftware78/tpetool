package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.property.*;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Proposal_Example_3_TestConstants {

    public static ProposalInput proposalInput_Example_Prop_3() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalInputData_Example_Prop_3())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalInputData_Example_Prop_3() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56102)
                .withInsuranceAnswers(insuranceAnswers_Example_Prop_3())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }

    public static InsuranceAnswers insuranceAnswers_Example_Prop_3() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withProperty(propertyAnswers_Example_Prop_3())
                .build();

        return insuranceAnswers;
    }

    public static PropertyAnswers propertyAnswers_Example_Prop_3() {
        PropertyAnswers.PropertyAnswersBuilder answersBuilder = PropertyAnswers.PropertyAnswersBuilder.aPropertyAnswers();

        PropertyAnswers propertyAnswers = answersBuilder
                .withAccidentalDamage(accidentalDamage_Example_Prop_3())
                .withAddress(address_Example_Prop_3())
                .withCommercialUnemployment(commercialUnemployment_Revenue_Example_Prop_2())
                .withMandatoryCoverage(mandatoryCoverage_Example_Prop_3())
                .withTheft(theft_Example_Prop_3())
                .withValues(values_Example_Prop_3())
                .withPremiums(premiums_Example_Prop_3())
                .build();

        return propertyAnswers;
    }

    private static PremiumSelections premiums_Example_Prop_3() {
        PremiumSelections.PremiumSelectionsBuilder builder = PremiumSelections.PremiumSelectionsBuilder.aPremiumSelections();
        return builder.withContentsTheft(Boolean.TRUE)
                .withBuildingBase(Boolean.TRUE)
                .withContentsBase(Boolean.TRUE)
                .withContentsNature(Boolean.TRUE)
                .withBuildingNature(Boolean.TRUE)
                .withBuildingIndirectLoss(Boolean.TRUE)
                .withContentsIndirectLoss(Boolean.TRUE)
                .withBuildingLegalProtection(Boolean.TRUE)
                .withContentsLegalProtection(Boolean.TRUE)
                .withAccidentalDamage(Boolean.FALSE)
                .withValues(Boolean.FALSE)
                .withCommercialUnemployment(Boolean.TRUE)
                .build();
    }

    public static CommercialUnemployment commercialUnemployment_Revenue_Example_Prop_2() {
        CommercialUnemployment.CommercialUnemploymentBuilder commercialUnemploymentBuilder = CommercialUnemployment.CommercialUnemploymentBuilder.aCommercialUnemployment();
        CommercialUnemployment commercialUnemployment = commercialUnemploymentBuilder
                .withCovered(Boolean.TRUE)
                .withFormula(CommercialUnemploymentFormula.REVENUE)
                .withRevenue(new BigDecimal(200000))
                .build();

        return commercialUnemployment;
    }


    public static Values values_Example_Prop_3() {
        Values.ValuesBuilder valuesBuilder = Values.ValuesBuilder.aValues();
        Values values = valuesBuilder
                .withCovered(Boolean.FALSE)
                .build();

        return values;
    }

    public static AccidentalDamage accidentalDamage_Example_Prop_3() {
        AccidentalDamage.AccidentalDamageBuilder accidentalDamageBuilder = AccidentalDamage.AccidentalDamageBuilder.anAccidentalDamage();
        AccidentalDamage accidentalDamage = accidentalDamageBuilder
                .withCovered(Boolean.FALSE)
                .build();

        return accidentalDamage;
    }

    public static Theft theft_Example_Prop_3() {
        Theft.TheftBuilder theftBuilder = Theft.TheftBuilder.aTheft();
        Theft theft = theftBuilder
                .withCovered(Boolean.TRUE)
                .withContinguity(PropertyContinguity.NO_CONTINGUITY)
                .withAlarmSystem(PropertyAlarmSystem.NO_ALARM)
                .build();

        return theft;
    }

    public static MandatoryCoverage mandatoryCoverage_Example_Prop_3() {
        MandatoryCoverage.MandatoryCoverageBuilder mandatoryCoverageBuilder = MandatoryCoverage.MandatoryCoverageBuilder.aMandatoryCoverage();
        MandatoryCoverage mandatoryCoverage = mandatoryCoverageBuilder
                .withContents(new BigDecimal(75000))
                .withLiability(new BigDecimal(600000))
                .withBuildingEvaluation(BuildingEvaluation.POLICY_HOLDER)
                .build();

        return mandatoryCoverage;
    }

    public static Address address_Example_Prop_3() {
        Address.AddressBuilder addressBuilder = Address.AddressBuilder.anAddress();
        Address address = addressBuilder
                .withNumber("151")
                .withZip("1210")
                .withStreet("Koningsstraat")
                .withCity("Brussel")
                .withInhabitedRegurarly(Boolean.TRUE)
                .withQuality(PropertyQuality.RENTER)
                .build();

        return address;
    }
}
