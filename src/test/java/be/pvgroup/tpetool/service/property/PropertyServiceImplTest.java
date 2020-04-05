package be.pvgroup.tpetool.service.property;

import be.pvgroup.tpetool.model.property.*;
import be.pvgroup.tpetool.util.property.BasePremiumProperty;
import be.pvgroup.tpetool.util.property.ParametersCatNatProperty;
import be.pvgroup.tpetool.util.property.ParametersProperty;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.PropertyTestConstants.propertyInput;
import static be.pvgroup.tpetool.PropertyTestConstants.propertyInput2;

public class PropertyServiceImplTest {

	private PropertyInput input1;
	private PropertyInput input2;

	@Before
	public void init() {
		input1 = propertyInput();
		input2 = propertyInput2();
	}

	@Test
	public void testProperty1() {

		PropertyServiceImpl service = new PropertyServiceImpl();

		//service.calculate(input1);
	}

	@Test
	public void testProperty2() {

		PropertyServiceImpl service = new PropertyServiceImpl();

		//service.calculate(input2);
	}

	@Test
	public void testParametersProperty() {
		System.out.println("BASE_INDEX: " + ParametersProperty.BASE_INDEX);
		System.out.println("CATNAT_INDEX: " + ParametersProperty.CATNAT_INDEX);
		System.out.println("PROPERTY_COMM_UNEMPLOYMENT_TAX: " + ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX);
		System.out.println("VALUE_TAX: " + ParametersProperty.VALUE_TAX);
		System.out.println("LEGAL_PROTECTION_TAX: " + ParametersProperty.LEGAL_PROTECTION_TAX);
		System.out.println("TAFIF_INDEXATION_VALUE_INDEX: " + ParametersProperty.TAFIF_INDEXATION_VALUE_INDEX);

		System.out.println("");
		System.out.println("PROP_BUILDING_STRUCTURE_CEMENT: " + ParametersProperty.PROP_BUILDING_STRUCTURE_CEMENT);
		System.out.println("PROP_BUILDING_GROUNDFLOOR_YES: " + ParametersProperty.PROP_BUILDING_GROUNDFLOOR_YES);
		System.out.println("PROP_FORMULE_PLUS: " + ParametersProperty.PROP_FORMULE_PLUS);

		System.out.println("");
		System.out.println("PROP_THEFT_FORMULA_1RISK_50: " + ParametersProperty.PROP_THEFT_FORMULA_1RISK_50);
		System.out.println("INDIRECT_LOSS: " + ParametersProperty.INDIRECT_LOSS);
		System.out.println("LEGAL_PROTECTION: " + ParametersProperty.LEGAL_PROTECTION);
		System.out.println("COMMERCIAL_UNEMPLOYMENT_REVENUES_PERCENT: "
				+ ParametersProperty.COMMERCIAL_UNEMPLOYMENT_REVENUES_PERCENT);
		System.out.println(
				"COMMERCIAL_UNEMPLOYMENT_MARKET_PARAM: " + ParametersProperty.COMMERCIAL_UNEMPLOYMENT_MARKET_PARAM);
		System.out.println("PROP_COMMERCIAL_UNEMPLOYMENT_DURATION_12: "
				+ ParametersProperty.PROP_COMMERCIAL_UNEMPLOYMENT_DURATION_12);
		System.out.println(
				"COMMERCIAL_UNEMPLOYMENT_REVENUES_COEFF: " + ParametersProperty.COMMERCIAL_UNEMPLOYMENT_REVENUES_COEFF);

		System.out.println("Prop_RegularHabitation Base - TRUE: "
				+ ParametersProperty.coefFactorBaseRegularHabitationMap.get(Boolean.TRUE));
		System.out.println("Prop_RegularHabitation Base - FALSE: "
				+ ParametersProperty.coefFactorBaseRegularHabitationMap.get(Boolean.FALSE));
		System.out.println("Prop_RegularHabitation Theft - TRUE: "
				+ ParametersProperty.coefFactorTheftRegularHabitationMap.get(Boolean.TRUE));
		System.out.println("Prop_RegularHabitation Theft - FALSE: "
				+ ParametersProperty.coefFactorTheftRegularHabitationMap.get(Boolean.FALSE));

		System.out.println("Prop_Building_Capital_Ratio for 0: "
				+ ParametersProperty.getPropBuildingCapitalRatio(BigDecimal.ZERO));
		System.out.println("Prop_Building_Capital_Ratio for 200000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(200000)));
		System.out.println("Prop_Building_Capital_Ratio for 500000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(500000)));
		System.out.println("Prop_Building_Capital_Ratio for 750000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(750000)));
		System.out.println("Prop_Building_Capital_Ratio for 1000000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(1000000)));
		System.out.println("Prop_Building_Capital_Ratio for 1250000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(1250000)));
		System.out.println("Prop_Building_Capital_Ratio for 1500000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(1500000)));
		System.out.println("Prop_Building_Capital_Ratio for 1750000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(1750000)));
		System.out.println("Prop_Building_Capital_Ratio for 2000000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(2000000)));
		System.out.println("Prop_Building_Capital_Ratio for 2500000: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(2500000)));
		System.out.println("Prop_Building_Capital_Ratio for -1: "
				+ ParametersProperty.getPropBuildingCapitalRatio(new BigDecimal(-1)));

		System.out.println("Prop_Content_Capital_Ratio_coef for 0: "
				+ ParametersProperty.getPropContentCapitalRatio(BigDecimal.ZERO));
		System.out.println("Prop_Content_Capital_Ratio_coef for 200000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(200000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 250000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(250000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 450000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(450000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 500000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(500000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 600000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(600000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 750000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(750000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 800000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(800000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 1000000: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(1000000)));
		System.out.println("Prop_Content_Capital_Ratio_coef for 9999999: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(9999999)));
		System.out.println("Prop_Content_Capital_Ratio_coef for -1: "
				+ ParametersProperty.getPropContentCapitalRatio(new BigDecimal(-1)));
	}

	@Test
	public void testBasePremiumProperty() {
		System.out.println("Incendie Brand (classe)");
		System.out.println("56101: " + BasePremiumProperty.brandKlasseMap.get("56101"));
		System.out.println("56102: " + BasePremiumProperty.brandKlasseMap.get("56102"));
		System.out.println("56210: " + BasePremiumProperty.brandKlasseMap.get("56210"));
		System.out.println("");
		System.out.println("Incendie Brand (Propriét. Exploitant)");
		System.out.println("56101: " + BasePremiumProperty.getBrandeigenaaruitbatermap().get("56101"));
		System.out.println("56102: " + BasePremiumProperty.getBrandeigenaaruitbatermap().get("56102"));
		System.out.println("56210: " + BasePremiumProperty.getBrandeigenaaruitbatermap().get("56210"));
		System.out.println("");
		System.out.println("Incendie Brand (Locataire Exploitant)");
		System.out.println("56101: " + BasePremiumProperty.getBrandhuurderuitbatermap().get("56101"));
		System.out.println("56102: " + BasePremiumProperty.getBrandhuurderuitbatermap().get("56102"));
		System.out.println("56210: " + BasePremiumProperty.getBrandhuurderuitbatermap().get("56210"));
		System.out.println("");
		System.out.println("Contenu");
		System.out.println("56101: " + BasePremiumProperty.getInhoudmap().get("56101"));
		System.out.println("56102: " + BasePremiumProperty.getInhoudmap().get("56102"));
		System.out.println("56210: " + BasePremiumProperty.getInhoudmap().get("56210"));
		System.out.println("");
		System.out.println("Vol Diefstal");
		System.out.println("56101: " + BasePremiumProperty.diefstapMap.get("56101"));
		System.out.println("56102: " + BasePremiumProperty.diefstapMap.get("56102"));
		System.out.println("56210: " + BasePremiumProperty.diefstapMap.get("56210"));
		System.out.println("");
		System.out.println("Dommages aux Marchandises  Schade aan koopwaarde");
		System.out.println("56101: " + BasePremiumProperty.schadeKoopwaardeMap.get("56101"));
		System.out.println("56102: " + BasePremiumProperty.schadeKoopwaardeMap.get("56102"));
		System.out.println("56210: " + BasePremiumProperty.schadeKoopwaardeMap.get("56210"));
		System.out.println("");
		System.out.println("Scoring HORECA (Classe)");
		System.out.println("56101: " + BasePremiumProperty.scoringHorecaMap.get("56101"));
		System.out.println("56102: " + BasePremiumProperty.scoringHorecaMap.get("56102"));
		System.out.println("56210: " + BasePremiumProperty.scoringHorecaMap.get("56210"));
		System.out.println("");
	}

	@Test
	public void testParametersCatnatProperty() {
		System.out.println("coefRiskSimpleNoRiskMapNoIndex - 0: "
				+ ParametersCatNatProperty.coefRiskSimpleNoRiskMapNoIndex.get("0"));
		System.out.println("coefRiskSimpleNoRiskMapNoIndex - 750000: "
				+ ParametersCatNatProperty.coefRiskSimpleNoRiskMapNoIndex.get("750000"));
		System.out.println("coefRiskSimpleNoRiskMapNoIndex - 0: "
				+ ParametersCatNatProperty.coefRiskSimpleNoRiskMapWithIndex.get("0"));
		System.out.println("coefRiskSimpleNoRiskMapNoIndex - 750000: "
				+ ParametersCatNatProperty.coefRiskSimpleNoRiskMapWithIndex.get("750000"));

		System.out.println(ParametersCatNatProperty.getRiskSimpleNoRiskWithIndex(new BigDecimal(0)));
		System.out.println(ParametersCatNatProperty.getRiskSimpleNoRiskWithIndex(new BigDecimal(749999)));
		System.out.println(ParametersCatNatProperty.getRiskSimpleNoRiskWithIndex(new BigDecimal(750000)));
	}
}
