package be.pvgroup.tpetool.service.property;

import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.property.CommercialUnemploymentFormula;
import be.pvgroup.tpetool.model.property.PropertyInput;
import be.pvgroup.tpetool.model.property.PropertyQuality;
import be.pvgroup.tpetool.model.property.PropertyValuesCapital;
import be.pvgroup.tpetool.service.liability.LiabilityServiceImpl;
import be.pvgroup.tpetool.util.property.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static be.pvgroup.tpetool.util.CalculationUtils.THOUSAND;

@Component
public class PropertyServiceImpl implements PropertyService {

	Logger logger = LoggerFactory.getLogger(LiabilityServiceImpl.class);

	BigDecimal initialPremium;

	BigDecimal Prop_RegularHabitation_coef_Base;
	BigDecimal Prop_Building_Evaluation_coef;
	BigDecimal Prop_Building_Structure_Cement;
	BigDecimal Prop_Building_GroudFloor_Yes;
	BigDecimal Prop_Building_Capital_Ratio_coef;

	BigDecimal baseCoverage;
	BigDecimal formulePlus;
	BigDecimal basePremiumBasePlusRate;
	BigDecimal basePremiumBasePlusNoTax;
	BigDecimal basePremiumBasePlusWithTax;

	BigDecimal initialPremiumBaseCoveragesContent;
	BigDecimal basePremiumBaseCoveragesContentRate;
	BigDecimal basePremiumBaseCoveragesContentNoTax;
	BigDecimal basePremiumBaseCoveragesContentWithTax;

	BigDecimal Prop_CatNat_Coef;
	BigDecimal buildingNoTax;
	BigDecimal buildingWithTax;
	BigDecimal contentNoTax;
	BigDecimal contentWithTax;

	Integer theftClass;
	String postalCodeClass;

	BigDecimal indirectLossCoefficient;
	BigDecimal basePremiumIndirectLossBuilding;
	BigDecimal basePremiumIndirectLossBuildingNoTax;
	BigDecimal basePremiumIndirectLossBuildingWithTax;
	BigDecimal basePremiumIndirectLossContent;
	BigDecimal basePremiumBaseIndirectLossContentNoTax;
	BigDecimal basePremiumBaseIndirectLossContentWithTax;

	BigDecimal legalProtectionCoverageCoefficient;
	BigDecimal basePremiumLegalProtectionCoverateBuildingNoTax;
	BigDecimal basePremiumLegalProtectionCoverateBuildingWithTax;
	BigDecimal basePremiumLegalProtectionCoverateContentNoTax;
	BigDecimal basePremiumLegalProtectionCoverateContentWithTax;

	BigDecimal merchandiseDamagesCoverageCoefficient;
	BigDecimal basePremiumMerchandiseDamagesCoverageNoTax;
	BigDecimal basePremiumMerchandiseDamagesCoverageWithTax;

	Integer brandKlasse;
	BigDecimal initialPremiumCommercialUnemploymentCoverage;
	BigDecimal Base_Content_coefficients;
	BigDecimal basePremiumCommercialUnemploymentCoverage_Daily_Rate;
	BigDecimal basePremiumCommercialUnemploymentCoverage_Daily_NoTax;
	BigDecimal basePremiumCommercialUnemploymentCoverage_Daily_WithTax;
	BigDecimal Prop_CommercialUnemployment_Revenues_coef;
	BigDecimal basePremiumCommercialUnemploymentCoverage_Revenue_Rate;
	BigDecimal basePremiumCommercialUnemploymentCoverage_Revenue_NoTax;
	BigDecimal basePremiumCommercialUnemploymentCoverage_Revenue_WithTax;

	BigDecimal Prop_Theft_Content_BasePremium;
	BigDecimal Prop_Contiguity_coef;
	BigDecimal Prop_AlarmSystem_Coef;
	BigDecimal Prop_Content_Capital_Ratio_coef;
	BigDecimal Prop_RegularHabitation_coef_Theft;
	BigDecimal Prop_Theft_Formula_coef;
	BigDecimal basePremiumTheftCoverageRate;
	BigDecimal basePremiumTheftCoverageNoTax;
	BigDecimal basePremiumTheftCoverageWithTax;

	BigDecimal initialPremiumValuesCoverage;
	BigDecimal initialPremiumValuesCoverageNoTax;
	BigDecimal initialPremiumValuesCoverageWithTax;

	@Override
	public List<PropertyPremium> calculate(PropertyInput propertyInput) {
		logger.debug("=============================================================================");
		logger.debug("Start calculation for Property");
		logger.debug("\t with input: " + propertyInput);

		initValues();

		//// BASE -Formule + COVERAGES - Building
		logger.debug("");
		logger.debug("");
		logger.debug("////BASE -Formule + COVERAGES - Building");
		logger.debug("");
		if (propertyInput.getData().getAnswers().getAddress().getQuality().equals(PropertyQuality.OWNER)) {
			initialPremium = BasePremiumProperty.getBrandeigenaaruitbatermap()
					.get(propertyInput.getData().getNacebel());
			logger.debug("is owner");
		} else if (propertyInput.getData().getAnswers().getAddress().getQuality().equals(PropertyQuality.RENTER)) {
			initialPremium = BasePremiumProperty.getBrandhuurderuitbatermap().get(propertyInput.getData().getNacebel());
			logger.debug("is renter");
		} else {
			logger.debug("not owner AND not renter");
		}
		logger.debug("Initial Premium: " + initialPremium);

		Prop_RegularHabitation_coef_Base = ParametersProperty.coefFactorBaseRegularHabitationMap
				.get(propertyInput.getData().getAnswers().getAddress().getInhabitedRegurarly());

		Prop_Building_Evaluation_coef = ParametersProperty.coefFactorBaseBuildingEvaluationMap
				.get(propertyInput.getData().getAnswers().getMandatoryCoverage().getBuildingEvaluation());

		Prop_Building_Structure_Cement = ParametersProperty.PROP_BUILDING_STRUCTURE_CEMENT;
		Prop_Building_GroudFloor_Yes = ParametersProperty.PROP_BUILDING_GROUNDFLOOR_YES;
		Prop_Building_Capital_Ratio_coef = ParametersProperty
				.getPropBuildingCapitalRatio(propertyInput.getData().getAnswers().getMandatoryCoverage().getContents()
						.add(propertyInput.getData().getAnswers().getMandatoryCoverage().getLiability()));

		logger.debug("Prop_RegularHabitation_coef_Base: " + Prop_RegularHabitation_coef_Base);
		logger.debug("Prop_Building_Evaluation_coef: " + Prop_Building_Evaluation_coef);
		logger.debug("Prop_Building_Structure_Cement: " + Prop_Building_Structure_Cement);
		logger.debug("Prop_Building_GroudFloor_Yes: " + Prop_Building_GroudFloor_Yes);
		logger.debug("Prop_Building_Capital_Ratio_coef: " + Prop_Building_Capital_Ratio_coef);

		baseCoverage = initialPremium.multiply(Prop_RegularHabitation_coef_Base).multiply(Prop_Building_Evaluation_coef)
				.multiply(Prop_Building_Structure_Cement).multiply(Prop_Building_GroudFloor_Yes)
				.multiply(Prop_Building_Capital_Ratio_coef);

		logger.debug("Base coverage: " + baseCoverage);

		formulePlus = ParametersProperty.PROP_FORMULE_PLUS;

		logger.debug("formulePlus: " + formulePlus);
		basePremiumBasePlusRate = baseCoverage.add(formulePlus).setScale(3, RoundingMode.HALF_UP);
		basePremiumBasePlusNoTax = basePremiumBasePlusRate
				.multiply(propertyInput.getData().getAnswers().getMandatoryCoverage().getLiability()).divide(THOUSAND);
		basePremiumBasePlusWithTax = basePremiumBasePlusNoTax
				.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

		logger.debug("basePremiumBasePlusRate: " + basePremiumBasePlusRate);
		logger.debug("basePremiumBasePlusNoTax: " + basePremiumBasePlusNoTax);
		logger.debug("basePremiumBasePlusWithTax: " + basePremiumBasePlusWithTax);

		//// Base Coverages - Content
		logger.debug("");
		logger.debug("");
		logger.debug("////Base Coverages - Content");
		logger.debug("");
		initialPremiumBaseCoveragesContent = BasePremiumProperty.getInhoudmap()
				.get(propertyInput.getData().getNacebel());

		logger.debug("initialPremiumBaseCoveragesContent: " + initialPremiumBaseCoveragesContent);
		logger.debug("Prop_RegularHabitation_coef_Base: " + Prop_RegularHabitation_coef_Base);
		logger.debug("Prop_Building_Structure_Cement: " + Prop_Building_Structure_Cement);
		logger.debug("Prop_Building_GroudFloor_Yes: " + Prop_Building_GroudFloor_Yes);
		logger.debug("Prop_Building_Capital_Ratio_coef: " + Prop_Building_Capital_Ratio_coef);

		basePremiumBaseCoveragesContentRate = initialPremiumBaseCoveragesContent
				.multiply(Prop_RegularHabitation_coef_Base).multiply(Prop_Building_Structure_Cement)
				.multiply(Prop_Building_GroudFloor_Yes).multiply(Prop_Building_Capital_Ratio_coef)
				.setScale(3, RoundingMode.HALF_UP);
		basePremiumBaseCoveragesContentNoTax = basePremiumBaseCoveragesContentRate
				.multiply(propertyInput.getData().getAnswers().getMandatoryCoverage().getContents()).divide(THOUSAND);
		basePremiumBaseCoveragesContentWithTax = basePremiumBaseCoveragesContentNoTax
				.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

		logger.debug("basePremiumBaseCoveragesContentRate: " + basePremiumBaseCoveragesContentRate);
		logger.debug("basePremiumBaseCoveragesContentNoTax: " + basePremiumBaseCoveragesContentNoTax);
		logger.debug("basePremiumBaseCoveragesContentWithTax: " + basePremiumBaseCoveragesContentWithTax);

		//// CATNAT Coverage
		logger.debug("");
		logger.debug("");
		logger.debug("////CATNAT Coverage");
		logger.debug("");
		Prop_CatNat_Coef = ParametersCatNatProperty.getRiskSimpleNoRiskWithIndex(
				propertyInput.getData().getAnswers().getMandatoryCoverage().getLiability());
		Prop_CatNat_Coef = Prop_CatNat_Coef.setScale(3, RoundingMode.HALF_UP);

		logger.debug("Prop_CatNat_Coef: " + Prop_CatNat_Coef);

		buildingNoTax = BigDecimal.ZERO;
		buildingWithTax = BigDecimal.ZERO;
		if (propertyInput.getData().getAnswers().getAddress().getQuality().equals(PropertyQuality.OWNER)) {
			buildingNoTax = propertyInput.getData().getAnswers().getMandatoryCoverage().getLiability()
					.multiply(Prop_CatNat_Coef).divide(THOUSAND);

			buildingWithTax = buildingNoTax
					.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));
		}

		logger.debug("buildingNoTax: " + buildingNoTax);
		logger.debug("buildingWithTax: " + buildingWithTax);

		contentNoTax = Prop_CatNat_Coef
				.multiply(propertyInput.getData().getAnswers().getMandatoryCoverage().getContents()).divide(THOUSAND);
		contentWithTax = contentNoTax.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

		logger.debug("contentNoTax: " + contentNoTax);
		logger.debug("contentWithTax: " + contentWithTax);

		//// THEFT Coverage
		logger.debug("");
		logger.debug("");
		logger.debug("////THEFT Coverage");
		logger.debug("");
		theftClass = BasePremiumProperty.diefstapMap.get(propertyInput.getData().getNacebel());
		postalCodeClass = ParametersTheftProperty
				.postCodeClass(propertyInput.getData().getAnswers().getAddress().getZip());
		Prop_Theft_Content_BasePremium = ParametersTheftProperty.getBasisTariefDiefstal(postalCodeClass, theftClass);
		Prop_Contiguity_coef = ParametersProperty.coefFactorTheftContiguityMap
				.get(propertyInput.getData().getAnswers().getTheft().getContinguity());
		Prop_AlarmSystem_Coef = ParametersProperty.coefFactorTheftAlarmSystemMap
				.get(propertyInput.getData().getAnswers().getTheft().getAlarmSystem());
		Prop_Content_Capital_Ratio_coef = ParametersProperty
				.getPropContentCapitalRatio(propertyInput.getData().getAnswers().getMandatoryCoverage().getContents());
		Prop_RegularHabitation_coef_Theft = ParametersProperty.coefFactorTheftRegularHabitationMap
				.get(propertyInput.getData().getAnswers().getAddress().getInhabitedRegurarly());
		Prop_Theft_Formula_coef = ParametersProperty.PROP_THEFT_FORMULA_1RISK_50;

		basePremiumTheftCoverageRate = Prop_Theft_Content_BasePremium.multiply(Prop_Contiguity_coef)
				.multiply(Prop_AlarmSystem_Coef).multiply(Prop_Content_Capital_Ratio_coef)
				.multiply(Prop_RegularHabitation_coef_Theft).multiply(Prop_Theft_Formula_coef)
				.setScale(3, RoundingMode.HALF_UP);
		basePremiumTheftCoverageNoTax = basePremiumTheftCoverageRate
				.multiply(propertyInput.getData().getAnswers().getMandatoryCoverage().getContents()).divide(THOUSAND);
		basePremiumTheftCoverageWithTax = basePremiumTheftCoverageNoTax
				.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

		logger.debug("theftClass: " + theftClass);
		logger.debug("postalCodeClass: " + postalCodeClass);
		logger.debug("Prop_Theft_Content_BasePremium: " + Prop_Theft_Content_BasePremium);
		logger.debug("Prop_Contiguity_coef: " + Prop_Contiguity_coef);
		logger.debug("Prop_AlarmSystem_Coef: " + Prop_AlarmSystem_Coef);
		logger.debug("Prop_Content_Capital_Ratio_coef: " + Prop_Content_Capital_Ratio_coef);
		logger.debug("Prop_RegularHabitation_coef_Theft: " + Prop_RegularHabitation_coef_Theft);
		logger.debug("Prop_Theft_Formula_coef: " + Prop_Theft_Formula_coef);
		logger.debug("basePremiumTheftCoverageRate: " + basePremiumTheftCoverageRate);
		logger.debug("basePremiumTheftCoverageNoTax: " + basePremiumTheftCoverageNoTax);
		logger.debug("basePremiumTheftCoverageWithTax: " + basePremiumTheftCoverageWithTax);

		//// INDIRECT LOSS
		logger.debug("");
		logger.debug("");
		logger.debug("////INDIRECT LOSS");
		logger.debug("");
		indirectLossCoefficient = ParametersProperty.INDIRECT_LOSS;

		basePremiumIndirectLossBuilding = indirectLossCoefficient.multiply(basePremiumBasePlusRate).setScale(3,
				RoundingMode.HALF_UP);
		basePremiumIndirectLossBuildingNoTax = propertyInput.getData().getAnswers().getMandatoryCoverage()
				.getLiability().multiply(basePremiumIndirectLossBuilding).divide(THOUSAND);
		basePremiumIndirectLossBuildingWithTax = basePremiumIndirectLossBuildingNoTax
				.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

		basePremiumIndirectLossContent = indirectLossCoefficient.multiply(basePremiumBaseCoveragesContentRate)
				.setScale(3, RoundingMode.HALF_UP);
		basePremiumBaseIndirectLossContentNoTax = propertyInput.getData().getAnswers().getMandatoryCoverage()
				.getContents().multiply(basePremiumIndirectLossContent).divide(THOUSAND);
		basePremiumBaseIndirectLossContentWithTax = basePremiumBaseIndirectLossContentNoTax
				.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));
		logger.debug("indirectLossCoefficient: " + indirectLossCoefficient);
		logger.debug("basePremiumIndirectLossBuilding: " + basePremiumIndirectLossBuilding);
		logger.debug("basePremiumIndirectLossBuildingNoTax: " + basePremiumIndirectLossBuildingNoTax);
		logger.debug("basePremiumIndirectLossBuildingWithTax: " + basePremiumIndirectLossBuildingWithTax);
		logger.debug("basePremiumIndirectLossContent: " + basePremiumIndirectLossContent);
		logger.debug("basePremiumBaseIndirectLossContentNoTax: " + basePremiumBaseIndirectLossContentNoTax);
		logger.debug("basePremiumBaseIndirectLossContentWithTax: " + basePremiumBaseIndirectLossContentWithTax);

		//// Legal Protection Coverage
		logger.debug("");
		logger.debug("");
		logger.debug("////Legal Protection Coverage");
		logger.debug("");
		legalProtectionCoverageCoefficient = ParametersProperty.LEGAL_PROTECTION;
		basePremiumLegalProtectionCoverateBuildingNoTax = propertyInput.getData().getAnswers().getMandatoryCoverage()
				.getLiability().multiply(legalProtectionCoverageCoefficient).divide(THOUSAND);
		;
		basePremiumLegalProtectionCoverateBuildingWithTax = basePremiumLegalProtectionCoverateBuildingNoTax
				.multiply(BigDecimal.ONE.add(ParametersProperty.LEGAL_PROTECTION_TAX));

		basePremiumLegalProtectionCoverateContentNoTax = propertyInput.getData().getAnswers().getMandatoryCoverage()
				.getContents().multiply(legalProtectionCoverageCoefficient).divide(THOUSAND);
		basePremiumLegalProtectionCoverateContentWithTax = basePremiumLegalProtectionCoverateContentNoTax
				.multiply(BigDecimal.ONE.add(ParametersProperty.LEGAL_PROTECTION_TAX));

		logger.debug("legalProtectionCoverageCoefficient: " + legalProtectionCoverageCoefficient);
		logger.debug(
				"basePremiumLegalProtectionCoverateBuildingNoTax: " + basePremiumLegalProtectionCoverateBuildingNoTax);
		logger.debug("basePremiumLegalProtectionCoverateBuildingWithTax: "
				+ basePremiumLegalProtectionCoverateBuildingWithTax);
		logger.debug(
				"basePremiumLegalProtectionCoverateContentNoTax: " + basePremiumLegalProtectionCoverateContentNoTax);
		logger.debug("basePremiumLegalProtectionCoverateContentWithTax: "
				+ basePremiumLegalProtectionCoverateContentWithTax);

		//// Merchandise Damages Coverage
		logger.debug("");
		logger.debug("");
		logger.debug("////Merchandise Damages Coverage");
		logger.debug("");

		if ((propertyInput.getData().getAnswers().getAccidentalDamage().getCovered() != null)
				&& propertyInput.getData().getAnswers().getAccidentalDamage().getCovered()) {

			if (propertyInput.getData().getAnswers().getAccidentalDamage().getCapital() == null) {
				logger.debug("AccidentalDamage.Capital is NULL");
				logger.debug("\tSet AccidentalDamage.Capital to ZERO manually");

				propertyInput.getData().getAnswers().getAccidentalDamage().setCapital(BigDecimal.ZERO);
			}

			merchandiseDamagesCoverageCoefficient = new BigDecimal(2);
			basePremiumMerchandiseDamagesCoverageNoTax = merchandiseDamagesCoverageCoefficient
					.multiply(propertyInput.getData().getAnswers().getAccidentalDamage().getCapital()).divide(THOUSAND);
			basePremiumMerchandiseDamagesCoverageWithTax = basePremiumMerchandiseDamagesCoverageNoTax
					.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

			logger.debug("merchandiseDamagesCoverageCoefficient: " + merchandiseDamagesCoverageCoefficient);
			logger.debug("basePremiumMerchandiseDamagesCoverageNoTax: " + basePremiumMerchandiseDamagesCoverageNoTax);
			logger.debug(
					"basePremiumMerchandiseDamagesCoverageWithTax: " + basePremiumMerchandiseDamagesCoverageWithTax);
		} else {
			logger.debug("merchandiseDamagesCoverageCoefficient not calculated - not covered");
			logger.debug("basePremiumMerchandiseDamagesCoverageNoTax not calculated - not covered");
			logger.debug("basePremiumMerchandiseDamagesCoverageWithTax not calculated - not covered");
		}

		//// CommercialUnemploymentBlock Coverage
		logger.debug("");
		logger.debug("");
		logger.debug("////CommercialUnemploymentBlock Coverage");
		logger.debug("");
		if (propertyInput.getData().getAnswers().getValues().getCapital() != null
				&& !propertyInput.getData().getAnswers().getValues().getCapital().equals(PropertyValuesCapital.NULL)) {
			initialPremiumValuesCoverage = ParametersValuesProperty.getBasisTariefValues(postalCodeClass,
					propertyInput.getData().getAnswers().getValues().getCapital());

			initialPremiumValuesCoverageNoTax = initialPremiumValuesCoverage;
			initialPremiumValuesCoverageWithTax = initialPremiumValuesCoverageNoTax
					.multiply(BigDecimal.ONE.add(ParametersProperty.VALUE_TAX));

			logger.debug("initialPremiumValuesCoverage: " + initialPremiumValuesCoverage);
			logger.debug("initialPremiumValuesCoverageNoTax: " + initialPremiumValuesCoverageNoTax);
			logger.debug("initialPremiumValuesCoverageWithTax: " + initialPremiumValuesCoverageWithTax);
		} else {
			logger.debug("Values.Capital is NULL");
			logger.debug("initialPremiumValuesCoverage: " + initialPremiumValuesCoverage);
			logger.debug("initialPremiumValuesCoverageNoTax: " + initialPremiumValuesCoverageNoTax);
			logger.debug("initialPremiumValuesCoverageWithTax: " + initialPremiumValuesCoverageWithTax);
		}

		//// Commercial Unemployment Coverage / Dagvergoeding
		logger.debug("");
		logger.debug("");
		logger.debug("////Commercial Unemployment Coverage / Dagvergoeding");
		logger.debug("");

		if (propertyInput.getData().getAnswers().getCommercialUnemployment().getFormula()
				.equals(CommercialUnemploymentFormula.DAILY)) {
			brandKlasse = BasePremiumProperty.brandKlasseMap.get(propertyInput.getData().getNacebel());
			initialPremiumCommercialUnemploymentCoverage = ParametersCommUnemploymentProperty.basisGaranties
					.get(brandKlasse);

			Base_Content_coefficients = Prop_RegularHabitation_coef_Base.multiply(Prop_Building_Structure_Cement)
					.multiply(Prop_Building_GroudFloor_Yes).multiply(Prop_Building_Capital_Ratio_coef);
			basePremiumCommercialUnemploymentCoverage_Daily_Rate = initialPremiumCommercialUnemploymentCoverage
					.multiply(Base_Content_coefficients).setScale(3, RoundingMode.HALF_UP);

			basePremiumCommercialUnemploymentCoverage_Daily_NoTax = basePremiumCommercialUnemploymentCoverage_Daily_Rate
					.multiply(propertyInput.getData().getAnswers().getCommercialUnemployment().getDaily());
			basePremiumCommercialUnemploymentCoverage_Daily_WithTax = basePremiumCommercialUnemploymentCoverage_Daily_NoTax
					.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

			logger.debug("brandKlasse: " + brandKlasse);
			logger.debug(
					"initialPremiumCommercialUnemploymentCoverage: " + initialPremiumCommercialUnemploymentCoverage);
			logger.debug("Base_Content_coefficients: " + Base_Content_coefficients);
			logger.debug("basePremiumCommercialUnemploymentCoverage_Daily_Rate: "
					+ basePremiumCommercialUnemploymentCoverage_Daily_Rate);
			logger.debug("basePremiumCommercialUnemploymentCoverage_Daily_NoTax: "
					+ basePremiumCommercialUnemploymentCoverage_Daily_NoTax);
			logger.debug("basePremiumCommercialUnemploymentCoverage_Daily_WithTax: "
					+ basePremiumCommercialUnemploymentCoverage_Daily_WithTax);

		} else {
			logger.debug("Commercial Unemployment Coverage / Dagvergoeding     not calculated - not covered");
		}

		//// Commercial Unemployment Coverage / Omzet
		logger.debug("");
		logger.debug("");
		logger.debug("////Commercial Unemployment Coverage / Omzet");
		logger.debug("");

		if (propertyInput.getData().getAnswers().getCommercialUnemployment().getFormula()
				.equals(CommercialUnemploymentFormula.REVENUE)) {
			Prop_CommercialUnemployment_Revenues_coef = ParametersProperty.COMMERCIAL_UNEMPLOYMENT_REVENUES_COEFF;
			Base_Content_coefficients = Prop_RegularHabitation_coef_Base.multiply(Prop_Building_Structure_Cement)
					.multiply(Prop_Building_GroudFloor_Yes).multiply(Prop_Building_Capital_Ratio_coef);

			basePremiumCommercialUnemploymentCoverage_Revenue_Rate = initialPremiumBaseCoveragesContent
					.add(Prop_CatNat_Coef);
			basePremiumCommercialUnemploymentCoverage_Revenue_Rate = basePremiumCommercialUnemploymentCoverage_Revenue_Rate
					.multiply(Prop_CommercialUnemployment_Revenues_coef).multiply(Base_Content_coefficients)
					.setScale(3, RoundingMode.HALF_UP);

			basePremiumCommercialUnemploymentCoverage_Revenue_NoTax = basePremiumCommercialUnemploymentCoverage_Revenue_Rate
					.multiply(propertyInput.getData().getAnswers().getCommercialUnemployment().getRevenue())
					.divide(THOUSAND);
			basePremiumCommercialUnemploymentCoverage_Revenue_WithTax = basePremiumCommercialUnemploymentCoverage_Revenue_NoTax
					.multiply(BigDecimal.ONE.add(ParametersProperty.PROPERTY_COMM_UNEMPLOYMENT_TAX));

			logger.debug("Prop_Base_Content_BasePremium: " + initialPremiumBaseCoveragesContent);
			logger.debug("Prop_CatNat_Coef: " + Prop_CatNat_Coef);
			logger.debug("Prop_CommercialUnemployment_Revenues_coef: " + Prop_CommercialUnemployment_Revenues_coef);
			logger.debug("Base_Content_coefficients: " + Base_Content_coefficients);

			logger.debug("basePremiumCommercialUnemploymentCoverage_Revenue_Rate: "
					+ basePremiumCommercialUnemploymentCoverage_Revenue_Rate);
			logger.debug("basePremiumCommercialUnemploymentCoverage_Revenue_NoTax: "
					+ basePremiumCommercialUnemploymentCoverage_Revenue_NoTax);
			logger.debug("basePremiumCommercialUnemploymentCoverage_Revenue_WithTax: "
					+ basePremiumCommercialUnemploymentCoverage_Revenue_WithTax);
		} else {
			logger.debug("Commercial Unemployment Coverage / Omzet     not calculated - not covered");
		}

		List<PropertyPremium> result = Arrays.asList(
				new PropertyPremium(PropertyPremiumType.BASE_COVERAGES_BUILDING.label,
						basePremiumBasePlusRate.setScale(4, RoundingMode.HALF_UP),
						basePremiumBasePlusNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumBasePlusWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.BASE_COVERAGES_CONTENT.label,
						basePremiumBaseCoveragesContentRate.setScale(4, RoundingMode.HALF_UP),
						basePremiumBaseCoveragesContentNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumBaseCoveragesContentWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.CATNAT_COVERAGE_BUILDING.label,
						Prop_CatNat_Coef.setScale(4, RoundingMode.HALF_UP),
						buildingNoTax.setScale(4, RoundingMode.HALF_UP),
						buildingWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.CATNAT_COVERAGE_CONTENT.label,
						Prop_CatNat_Coef.setScale(4, RoundingMode.HALF_UP),
						contentNoTax.setScale(4, RoundingMode.HALF_UP),
						contentWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.THEFT_COVERAGE.label,
						basePremiumTheftCoverageRate.setScale(4, RoundingMode.HALF_UP),
						basePremiumTheftCoverageNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumTheftCoverageWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.INDIRECT_LOSS_BUILDING.label,
						basePremiumIndirectLossBuilding.setScale(4, RoundingMode.HALF_UP),
						basePremiumIndirectLossBuildingNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumIndirectLossBuildingWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.INDIRECT_LOSS_CONTENT.label,
						basePremiumIndirectLossContent.setScale(4, RoundingMode.HALF_UP),
						basePremiumBaseIndirectLossContentNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumBaseIndirectLossContentWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.LEGAL_PROTECTION_COVERAGE_BUILDING.label,
						legalProtectionCoverageCoefficient.setScale(4, RoundingMode.HALF_UP),
						basePremiumLegalProtectionCoverateBuildingNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumLegalProtectionCoverateBuildingWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.LEGAL_PROTECTION_COVERAGE_CONTENT.label,
						legalProtectionCoverageCoefficient.setScale(4, RoundingMode.HALF_UP),
						basePremiumLegalProtectionCoverateContentNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumLegalProtectionCoverateContentWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.MERCHANDISE_DAMAGES_COVERAGE.label,
						merchandiseDamagesCoverageCoefficient.setScale(4, RoundingMode.HALF_UP),
						basePremiumMerchandiseDamagesCoverageNoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumMerchandiseDamagesCoverageWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.VALUES_COVERAGE.label,
						initialPremiumValuesCoverage.setScale(4, RoundingMode.HALF_UP),
						initialPremiumValuesCoverageNoTax.setScale(4, RoundingMode.HALF_UP),
						initialPremiumValuesCoverageWithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.COMMERCIAL_UNEMPLOYMENT_COVERAGE_DAILY.label,
						basePremiumCommercialUnemploymentCoverage_Daily_Rate.setScale(4, RoundingMode.HALF_UP),
						basePremiumCommercialUnemploymentCoverage_Daily_NoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumCommercialUnemploymentCoverage_Daily_WithTax.setScale(4, RoundingMode.HALF_UP)),

				new PropertyPremium(PropertyPremiumType.COMMERCIAL_UNEMPLOYMENT_COVERAGE_REVENUE.label,
						basePremiumCommercialUnemploymentCoverage_Revenue_Rate.setScale(4, RoundingMode.HALF_UP),
						basePremiumCommercialUnemploymentCoverage_Revenue_NoTax.setScale(4, RoundingMode.HALF_UP),
						basePremiumCommercialUnemploymentCoverage_Revenue_WithTax.setScale(4, RoundingMode.HALF_UP)));

		logger.debug("");
		logger.debug("");
		logger.debug("");
		logger.debug("Premiums: " + result);
		logger.debug("End calculation for Property");
		logger.debug("=============================================================================");

		return result;
	}

	private void initValues() {
		logger.debug("Init values before starting to calculate");

		initialPremium = BigDecimal.ZERO;

		Prop_RegularHabitation_coef_Base = BigDecimal.ZERO;
		Prop_Building_Evaluation_coef = BigDecimal.ZERO;
		Prop_Building_Structure_Cement = BigDecimal.ZERO;
		Prop_Building_GroudFloor_Yes = BigDecimal.ZERO;
		Prop_Building_Capital_Ratio_coef = BigDecimal.ZERO;

		baseCoverage = BigDecimal.ZERO;
		formulePlus = BigDecimal.ZERO;
		basePremiumBasePlusRate = BigDecimal.ZERO;
		basePremiumBasePlusNoTax = BigDecimal.ZERO;
		basePremiumBasePlusWithTax = BigDecimal.ZERO;

		initialPremiumBaseCoveragesContent = BigDecimal.ZERO;
		basePremiumBaseCoveragesContentRate = BigDecimal.ZERO;
		basePremiumBaseCoveragesContentNoTax = BigDecimal.ZERO;
		basePremiumBaseCoveragesContentWithTax = BigDecimal.ZERO;

		Prop_CatNat_Coef = BigDecimal.ZERO;
		buildingNoTax = BigDecimal.ZERO;
		buildingWithTax = BigDecimal.ZERO;
		contentNoTax = BigDecimal.ZERO;
		contentWithTax = BigDecimal.ZERO;

		theftClass = 0;
		postalCodeClass = null;

		indirectLossCoefficient = BigDecimal.ZERO;
		basePremiumIndirectLossBuilding = BigDecimal.ZERO;
		basePremiumIndirectLossBuildingNoTax = BigDecimal.ZERO;
		basePremiumIndirectLossBuildingWithTax = BigDecimal.ZERO;
		basePremiumIndirectLossContent = BigDecimal.ZERO;
		basePremiumBaseIndirectLossContentNoTax = BigDecimal.ZERO;
		basePremiumBaseIndirectLossContentWithTax = BigDecimal.ZERO;

		legalProtectionCoverageCoefficient = BigDecimal.ZERO;
		basePremiumLegalProtectionCoverateBuildingNoTax = BigDecimal.ZERO;
		basePremiumLegalProtectionCoverateBuildingWithTax = BigDecimal.ZERO;
		basePremiumLegalProtectionCoverateContentNoTax = BigDecimal.ZERO;
		basePremiumLegalProtectionCoverateContentWithTax = BigDecimal.ZERO;

		merchandiseDamagesCoverageCoefficient = BigDecimal.ZERO;
		basePremiumMerchandiseDamagesCoverageNoTax = BigDecimal.ZERO;
		basePremiumMerchandiseDamagesCoverageWithTax = BigDecimal.ZERO;

		brandKlasse = 0;
		initialPremiumCommercialUnemploymentCoverage = BigDecimal.ZERO;
		Base_Content_coefficients = BigDecimal.ZERO;
		basePremiumCommercialUnemploymentCoverage_Daily_Rate = BigDecimal.ZERO;
		basePremiumCommercialUnemploymentCoverage_Daily_NoTax = BigDecimal.ZERO;
		basePremiumCommercialUnemploymentCoverage_Daily_WithTax = BigDecimal.ZERO;
		Prop_CommercialUnemployment_Revenues_coef = BigDecimal.ZERO;
		basePremiumCommercialUnemploymentCoverage_Revenue_Rate = BigDecimal.ZERO;
		basePremiumCommercialUnemploymentCoverage_Revenue_NoTax = BigDecimal.ZERO;
		basePremiumCommercialUnemploymentCoverage_Revenue_WithTax = BigDecimal.ZERO;

		Prop_Theft_Content_BasePremium = BigDecimal.ZERO;
		Prop_Contiguity_coef = BigDecimal.ZERO;
		Prop_AlarmSystem_Coef = BigDecimal.ZERO;
		Prop_Content_Capital_Ratio_coef = BigDecimal.ZERO;
		Prop_RegularHabitation_coef_Theft = BigDecimal.ZERO;
		Prop_Theft_Formula_coef = BigDecimal.ZERO;
		basePremiumTheftCoverageRate = BigDecimal.ZERO;
		basePremiumTheftCoverageNoTax = BigDecimal.ZERO;
		basePremiumTheftCoverageWithTax = BigDecimal.ZERO;

		initialPremiumValuesCoverage = BigDecimal.ZERO;
		initialPremiumValuesCoverageNoTax = BigDecimal.ZERO;
		initialPremiumValuesCoverageWithTax = BigDecimal.ZERO;
	}
}
