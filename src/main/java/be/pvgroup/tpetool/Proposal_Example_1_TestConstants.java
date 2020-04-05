package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.property.*;
import be.pvgroup.tpetool.model.proposal.InsuranceAnswers;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.model.proposal.ProposalInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.ProposalTestConstants.commonAnswers;

public class Proposal_Example_1_TestConstants {

    public static ProposalInput proposalInput_Example_Prop_1() {
        ProposalInput.ProposalInputBuilder proposalInputBuilder = ProposalInput.ProposalInputBuilder.aProposalInput();

        ProposalInput proposalInput = proposalInputBuilder
                .withData(proposalInputData_Example_Prop_1())
                .build();

        return proposalInput;
    }

    public static ProposalData proposalInputData_Example_Prop_1() {
        ProposalData.ProposalDataBuilder proposalDataBuilder = ProposalData.ProposalDataBuilder.aProposalData();

        ProposalData proposalData = proposalDataBuilder
                .withNacebel(TestConstants.NACEBEL_56101)
                .withInsuranceAnswers(insuranceAnswers_Example_Prop_1())
                .withCommonAnswers(commonAnswers())
                .build();

        return proposalData;
    }

    public static InsuranceAnswers insuranceAnswers_Example_Prop_1() {
        InsuranceAnswers.InsuranceAnswersBuilder insuranceAnswersBuilder = InsuranceAnswers.InsuranceAnswersBuilder.anInsuranceAnswers();

        InsuranceAnswers insuranceAnswers = insuranceAnswersBuilder
                .withProperty(propertyAnswers_Example_Prop_1())
                .build();

        return insuranceAnswers;
    }

    public static PropertyAnswers propertyAnswers_Example_Prop_1() {
        PropertyAnswers.PropertyAnswersBuilder answersBuilder = PropertyAnswers.PropertyAnswersBuilder.aPropertyAnswers();

        PropertyAnswers propertyAnswers = answersBuilder
                .withAccidentalDamage(accidentalDamage_Example_Prop_1())
                .withAddress(address_Example_Prop_1())
                .withCommercialUnemployment(commercialUnemployment_Daily_Example_Prop_1())
                .withMandatoryCoverage(mandatoryCoverage_Example_Prop_1())
                .withTheft(theft_Example_Prop_1())
                .withValues(values_Example_Prop_1())
                .build();

        return propertyAnswers;
    }

    public static CommercialUnemployment commercialUnemployment_Daily_Example_Prop_1() {
        CommercialUnemployment.CommercialUnemploymentBuilder commercialUnemploymentBuilder = CommercialUnemployment.CommercialUnemploymentBuilder.aCommercialUnemployment();
        CommercialUnemployment commercialUnemployment = commercialUnemploymentBuilder
                .withCovered(Boolean.TRUE)
                .withFormula(CommercialUnemploymentFormula.DAILY)
                .withDaily(new BigDecimal(600))
                .withRevenue(new BigDecimal(100000))
                .build();

        return commercialUnemployment;
    }

    public static Values values_Example_Prop_1() {
        Values.ValuesBuilder valuesBuilder = Values.ValuesBuilder.aValues();
        Values values = valuesBuilder
                .withCapital(PropertyValuesCapital.CAPITAL_6000)
                .withCovered(Boolean.TRUE)
                .build();

        return values;
    }

    public static AccidentalDamage accidentalDamage_Example_Prop_1() {
        AccidentalDamage.AccidentalDamageBuilder accidentalDamageBuilder = AccidentalDamage.AccidentalDamageBuilder.anAccidentalDamage();
        AccidentalDamage accidentalDamage = accidentalDamageBuilder
                .withCovered(Boolean.TRUE)
                .withCapital(new BigDecimal(20000))
                .build();

        return accidentalDamage;
    }

    public static MandatoryCoverage mandatoryCoverage_Example_Prop_1() {
        MandatoryCoverage.MandatoryCoverageBuilder mandatoryCoverageBuilder = MandatoryCoverage.MandatoryCoverageBuilder.aMandatoryCoverage();
        MandatoryCoverage mandatoryCoverage = mandatoryCoverageBuilder
                .withContents(new BigDecimal(50000))
                .withLiability(new BigDecimal(550000))
                .withBuildingEvaluation(BuildingEvaluation.GRID_EXPERTISE_COMPANY)
                .build();

        return mandatoryCoverage;
    }

    public static Theft theft_Example_Prop_1() {
        Theft.TheftBuilder theftBuilder = Theft.TheftBuilder.aTheft();
        Theft theft = theftBuilder
                .withCovered(Boolean.TRUE)
                .withContinguity(PropertyContinguity.CONTINGUITY)
                .withAlarmSystem(PropertyAlarmSystem.AGREED_CENTRAL)
                .build();

        return theft;
    }

    public static Address address_Example_Prop_1() {
        Address.AddressBuilder addressBuilder = Address.AddressBuilder.anAddress();
        Address address = addressBuilder
                .withNumber("151")
                .withZip("1210")
                .withStreet("Koningsstraat")
                .withCity("Brussel")
                .withInhabitedRegurarly(Boolean.FALSE)
                .withQuality(PropertyQuality.OWNER)
                .build();

        return address;
    }
}
