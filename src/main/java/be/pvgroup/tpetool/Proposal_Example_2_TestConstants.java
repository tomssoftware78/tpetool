package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.property.*;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Proposal_Example_2_TestConstants {

    public static ProposalInput proposalInput_Example_Prop_2() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalInputData_Example_Prop_2())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalInputData_Example_Prop_2() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56210)
                .withInsuranceAnswers(insuranceAnswers_Example_Prop_2())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }

    public static InsuranceAnswers insuranceAnswers_Example_Prop_2() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withProperty(propertyAnswers_Example_Prop_2())
                .build();

        return insuranceAnswers;
    }

    public static PropertyAnswers propertyAnswers_Example_Prop_2() {
        PropertyAnswers.PropertyAnswersBuilder answersBuilder = PropertyAnswers.PropertyAnswersBuilder.aPropertyAnswers();

        PropertyAnswers propertyAnswers = answersBuilder
                .withAccidentalDamage(accidentalDamage_Example_Prop_2())
                .withAddress(address_Example_Prop_2())
                .withCommercialUnemployment(commercialUnemployment_Revenue_Example_Prop_2())
                .withMandatoryCoverage(mandatoryCoverage_Example_Prop_2())
                .withTheft(theft_Example_Prop_2())
                .withValues(values_Example_Prop_2())
                .withPremiums(premiums_Example_Prop_2())
                .build();

        return propertyAnswers;
    }

    private static PremiumSelections premiums_Example_Prop_2() {
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
                .withAccidentalDamage(Boolean.TRUE)
                .withValues(Boolean.TRUE)
                .withCommercialUnemployment(Boolean.TRUE)
                .build();
    }

    public static CommercialUnemployment commercialUnemployment_Revenue_Example_Prop_2() {
        CommercialUnemployment.CommercialUnemploymentBuilder commercialUnemploymentBuilder = CommercialUnemployment.CommercialUnemploymentBuilder.aCommercialUnemployment();
        CommercialUnemployment commercialUnemployment = commercialUnemploymentBuilder
                .withCovered(Boolean.TRUE)
                .withFormula(CommercialUnemploymentFormula.REVENUE)
                .withDaily(new BigDecimal(600))
                .withRevenue(new BigDecimal(100000))
                .build();

        return commercialUnemployment;
    }

    public static Values values_Example_Prop_2() {
        Values.ValuesBuilder valuesBuilder = Values.ValuesBuilder.aValues();
        Values values = valuesBuilder
                .withCapital(PropertyValuesCapital.CAPITAL_12000)
                .withCovered(Boolean.TRUE)
                .build();

        return values;
    }

    public static AccidentalDamage accidentalDamage_Example_Prop_2() {
        AccidentalDamage.AccidentalDamageBuilder accidentalDamageBuilder = AccidentalDamage.AccidentalDamageBuilder.anAccidentalDamage();
        AccidentalDamage accidentalDamage = accidentalDamageBuilder
                .withCovered(Boolean.TRUE)
                .withCapital(new BigDecimal(35000))
                .build();

        return accidentalDamage;
    }

    public static Theft theft_Example_Prop_2() {
        Theft.TheftBuilder theftBuilder = Theft.TheftBuilder.aTheft();
        Theft theft = theftBuilder
                .withCovered(Boolean.TRUE)
                .withContinguity(PropertyContinguity.NO_CONTINGUITY)
                .withAlarmSystem(PropertyAlarmSystem.GSM)
                .build();

        return theft;
    }

    public static MandatoryCoverage mandatoryCoverage_Example_Prop_2() {
        MandatoryCoverage.MandatoryCoverageBuilder mandatoryCoverageBuilder = MandatoryCoverage.MandatoryCoverageBuilder.aMandatoryCoverage();
        MandatoryCoverage mandatoryCoverage = mandatoryCoverageBuilder
                .withContents(new BigDecimal(75000))
                .withLiability(new BigDecimal(950000))
                .withBuildingEvaluation(BuildingEvaluation.FIRST_RISK)
                .build();

        return mandatoryCoverage;
    }

    public static Address address_Example_Prop_2() {
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
