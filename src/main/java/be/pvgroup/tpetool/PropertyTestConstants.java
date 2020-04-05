package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.property.*;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.TestConstants.NACEBEL_56101;

public class PropertyTestConstants {

    public static AccidentalDamage accidentalDamage() {
        AccidentalDamage.AccidentalDamageBuilder accidentalDamageBuilder = AccidentalDamage.AccidentalDamageBuilder.anAccidentalDamage();
        AccidentalDamage accidentalDamage = accidentalDamageBuilder
                .withCovered(Boolean.TRUE)
                .withCapital(new BigDecimal(20000))
                .build();

        return accidentalDamage;
    }

    public static Address address() {
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

    public static MandatoryCoverage mandatoryCoverage() {
        MandatoryCoverage.MandatoryCoverageBuilder mandatoryCoverageBuilder = MandatoryCoverage.MandatoryCoverageBuilder.aMandatoryCoverage();
        MandatoryCoverage mandatoryCoverage = mandatoryCoverageBuilder
                .withContents(new BigDecimal(50000))
                .withLiability(new BigDecimal(550000))
                .withBuildingEvaluation(BuildingEvaluation.GRID_EXPERTISE_COMPANY)
                .build();

        return mandatoryCoverage;
    }

    public static CommercialUnemployment commercialUnemployment_Daily() {
        CommercialUnemployment.CommercialUnemploymentBuilder commercialUnemploymentBuilder = CommercialUnemployment.CommercialUnemploymentBuilder.aCommercialUnemployment();
        CommercialUnemployment commercialUnemployment = commercialUnemploymentBuilder
                .withCovered(Boolean.TRUE)
                .withFormula(CommercialUnemploymentFormula.DAILY)
                .withDaily(new BigDecimal(600))
                .build();

        return commercialUnemployment;
    }

    public static Theft theft() {
        Theft.TheftBuilder theftBuilder = Theft.TheftBuilder.aTheft();
        Theft theft = theftBuilder
                .withCovered(Boolean.TRUE)
                .withContinguity(PropertyContinguity.CONTINGUITY)
                .withAlarmSystem(PropertyAlarmSystem.AGREED_CENTRAL)
                .build();

        return theft;
    }

    public static Values values() {
        Values.ValuesBuilder valuesBuilder = Values.ValuesBuilder.aValues();
        Values values = valuesBuilder
                .withCapital(PropertyValuesCapital.CAPITAL_6000)
                .withCovered(Boolean.TRUE)
                .build();

        return values;
    }

    public static PropertyAnswers propertyAnswers() {
        PropertyAnswers.PropertyAnswersBuilder answersBuilder = PropertyAnswers.PropertyAnswersBuilder.aPropertyAnswers();

        PropertyAnswers propertyAnswers = answersBuilder
                .withAccidentalDamage(accidentalDamage())
                .withAddress(address())
                .withCommercialUnemployment(commercialUnemployment_Daily())
                .withMandatoryCoverage(mandatoryCoverage())
                .withTheft(theft())
                .withValues(values())
                .build();

        return propertyAnswers;
    }

    public static PropertyAnswers propertyAnswersWithSelectedPremiums() {
        PropertyAnswers.PropertyAnswersBuilder answersBuilder = PropertyAnswers.PropertyAnswersBuilder.aPropertyAnswers();

        PropertyAnswers propertyAnswers = answersBuilder
                .withAccidentalDamage(accidentalDamage())
                .withAddress(address())
                .withCommercialUnemployment(commercialUnemployment_Daily())
                .withMandatoryCoverage(mandatoryCoverage())
                .withTheft(theft())
                .withValues(values())
                .withPremiums(selectedPremium())
                .build();

        return propertyAnswers;
    }

    public static PremiumSelections selectedPremium() {
            PremiumSelections.PremiumSelectionsBuilder premiumSelectionsBuilder = PremiumSelections.PremiumSelectionsBuilder.aPremiumSelections();

            PremiumSelections premiumSelections = premiumSelectionsBuilder
                .withBuildingIndirectLoss(Boolean.TRUE)
                .withBuildingLegalProtection(Boolean.TRUE)
                .withContentsIndirectLoss(Boolean.TRUE)
                .withContentsLegalProtection(Boolean.TRUE)
                .withAccidentalDamage(Boolean.TRUE)
                .withBuildingBase(Boolean.TRUE)
                .withBuildingNature(Boolean.TRUE)
                .withContentsBase(Boolean.TRUE)
                .withContentsNature(Boolean.TRUE)
                .withContentsTheft(Boolean.TRUE)
                .withAccidentalDamage(Boolean.TRUE)
                .withValues(Boolean.TRUE)
                .withCommercialUnemployment(Boolean.TRUE)
                    .build();

            return premiumSelections;
    }

    public static PropertyData propertyData() {
        PropertyData.PropertyDataBuilder dataBuilder = PropertyData.PropertyDataBuilder.aPropertyData();

        PropertyData propertyData = dataBuilder
                .withNacebel(NACEBEL_56101)
                .withAnswers(propertyAnswers())
                .build();

        return propertyData;
    }

    public static PropertyInput propertyInput() {
        PropertyInput.PropertyInputBuilder propertyInputBuilder = PropertyInput.PropertyInputBuilder.aPropertyInput();
        PropertyInput input = propertyInputBuilder
                .withData(propertyData())
                .build();

        return input;
    }

    public static CommercialUnemployment commercialUnemployment_Revenue() {
        CommercialUnemployment.CommercialUnemploymentBuilder commercialUnemploymentBuilder = CommercialUnemployment.CommercialUnemploymentBuilder.aCommercialUnemployment();
        CommercialUnemployment commercialUnemployment = commercialUnemploymentBuilder
                .withCovered(Boolean.TRUE)
                .withFormula(CommercialUnemploymentFormula.REVENUE)
                .withRevenue(new BigDecimal(100000))
                .build();

        return commercialUnemployment;
    }

    public static PropertyAnswers propertyAnswers2() {
        PropertyAnswers.PropertyAnswersBuilder answersBuilder = PropertyAnswers.PropertyAnswersBuilder.aPropertyAnswers();

        PropertyAnswers propertyAnswers = answersBuilder
                .withAccidentalDamage(accidentalDamage())
                .withAddress(address())
                .withCommercialUnemployment(commercialUnemployment_Revenue())
                .withMandatoryCoverage(mandatoryCoverage())
                .withTheft(theft())
                .withValues(values())
                .build();

        return propertyAnswers;
    }

    public static PropertyData propertyData2() {
        PropertyData.PropertyDataBuilder dataBuilder = PropertyData.PropertyDataBuilder.aPropertyData();

        PropertyData propertyData = dataBuilder
                .withNacebel(NACEBEL_56101)
                .withAnswers(propertyAnswers2())
                .build();

        return propertyData;
    }

    public static PropertyInput propertyInput2() {
        PropertyInput.PropertyInputBuilder propertyInputBuilder = PropertyInput.PropertyInputBuilder.aPropertyInput();
        PropertyInput input = propertyInputBuilder
                .withData(propertyData2())
                .build();

        return input;
    }
}
