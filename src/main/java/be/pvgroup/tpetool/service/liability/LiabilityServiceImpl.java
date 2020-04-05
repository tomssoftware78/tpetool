package be.pvgroup.tpetool.service.liability;

import be.pvgroup.tpetool.model.LiabilityPremium;
import be.pvgroup.tpetool.model.liability.LiabilityInput;
import be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LiabilityServiceImpl implements LiabilityService {

    private static final BigDecimal LIMIT_1 = new BigDecimal(1500000);
    private static final BigDecimal LIMIT_2 = new BigDecimal(2500000);

    Logger logger = LoggerFactory.getLogger(LiabilityServiceImpl.class);

    BigDecimal totalNumberOfEmployeeOwner;
    BigDecimal classBA;
    BigDecimal procentOps;
    BigDecimal procentPropInCare;
    BigDecimal procentAfterDel;
    BigDecimal tarifRc;

    BigDecimal procentBAU;
    BigDecimal liabOpsBasePremium;

    BigDecimal liabOpsPremiumNoTax;
    BigDecimal liabOpsPremiumWithTax;

    BigDecimal liabPropInCareBasePremium;
    BigDecimal liabPropInCarePremiumWithTax;

    BigDecimal procentTG;

    BigDecimal procentBANL;
    BigDecimal liabAfterDeliveryBasePremium;
    BigDecimal liabAfterDeliveryPremiumNoTax;
    BigDecimal liabAfterDeliveryPremiumWithTax;
    BigDecimal liabLegalPBasePremium;
    BigDecimal liabLegalPPremiumTax;

    BigDecimal liabObjectiveBasePremium;
    BigDecimal liabObjectivePremiumTax;

    @Override
    public BigDecimal calculateTotalNumbersOfEmployees(LiabilityInput liabilityInput) {
        BigDecimal halfOfPartimeEmployees = liabilityInput.getData().getAnswers().getNumberOfPartTimeEmployees()
                .divide(new BigDecimal(2));

        logger.trace("NumberOfOwners: " + liabilityInput.getData().getAnswers().getNumberOfOwners());
        logger.trace("NumberOfCoowners: " + liabilityInput.getData().getAnswers().getNumberOfCoowners());
        logger.trace(
                "NumberOfFullTimeEmployees: " + liabilityInput.getData().getAnswers().getNumberOfFullTimeEmployees());
        logger.trace("half of NumberOfPartTimeEmployeesPartimeEmployees: " + halfOfPartimeEmployees);

        BigDecimal result = liabilityInput.getData().getAnswers().getNumberOfOwners()
                .add(liabilityInput.getData().getAnswers().getNumberOfCoowners())
                .add(liabilityInput.getData().getAnswers().getNumberOfFullTimeEmployees()).add(halfOfPartimeEmployees);
        result = result.setScale(0, RoundingMode.DOWN);
        return result;
    }

    @Override
    public List<LiabilityPremium> calculate(LiabilityInput liabilityInput) {
        logger.debug("=============================================================================");
        logger.debug("Start calculation for Liability");
        logger.debug("\t with input: " + liabilityInput);

        initValues();

        liabilityInput.getData().getAnswers().setNumberOfOwners(BigDecimal.ONE);

        totalNumberOfEmployeeOwner = calculateTotalNumbersOfEmployees(liabilityInput);
        logger.debug("total number of employees: " + totalNumberOfEmployeeOwner);

        classBA = BasePremiumBurgerlijkeAansprakelijkheid.rcBaMap.get(liabilityInput.getData().getNacebel());
        procentOps = BasePremiumBurgerlijkeAansprakelijkheid.bauMap.get(liabilityInput.getData().getNacebel());
        procentPropInCare = BasePremiumBurgerlijkeAansprakelijkheid.tgMap.get(liabilityInput.getData().getNacebel());
        procentAfterDel = BasePremiumBurgerlijkeAansprakelijkheid.banlMap.get(liabilityInput.getData().getNacebel());

        logger.debug("classBA: " + classBA);
        logger.debug("procentOps: " + procentOps);
        logger.debug("procentPropInCare: " + procentPropInCare);
        logger.debug("procentAfterDel: " + procentAfterDel);

        //// Public Liability Base Premium
        logger.debug("//// Public Liability Base Premium");
        tarifRc = BasisTariefPublicLiabilityTabel.getTarifRc(classBA.intValue(), totalNumberOfEmployeeOwner.intValue());
        logger.debug("tarifRc: " + tarifRc);

        //// 1/Public Liability Operations
        logger.debug("//// 1/Public Liability Operations");
        procentBAU = BasePremiumBurgerlijkeAansprakelijkheid.bauMap.get(liabilityInput.getData().getNacebel());
        logger.debug("procentBAU: " + procentBAU);

        liabOpsBasePremium = tarifRc.multiply(procentBAU);
        logger.debug("liabOpsBasePremium: " + liabOpsBasePremium);

        // Coefficients Impact Limit
        logger.debug("//Coefficients Impact Limit");
        if (liabilityInput.getData().getAnswers().getExploitationLimit().compareTo(LIMIT_1) == 0) {
            logger.debug("Exploitation Limit : " + liabilityInput.getData().getAnswers().getExploitationLimit()
                    + "(LIMIT 1)");

            liabOpsPremiumNoTax = new BigDecimal(liabOpsBasePremium.toPlainString());
            liabOpsPremiumWithTax = liabOpsPremiumNoTax
                    .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

            logger.debug("liabOpsPremiumNoTax: " + liabOpsPremiumNoTax);
            logger.debug("liabOpsPremiumWithTax: " + liabOpsPremiumWithTax);

        } else if (liabilityInput.getData().getAnswers().getExploitationLimit().compareTo(LIMIT_2) == 0) {
            logger.debug("Exploitation Limit : " + liabilityInput.getData().getAnswers().getExploitationLimit()
                    + "(LIMIT 2)");

            liabOpsPremiumNoTax = new BigDecimal(liabOpsBasePremium.toPlainString());
            liabOpsPremiumNoTax = liabOpsPremiumNoTax
                    .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Coef_BAU_Increased_Limit));
            liabOpsPremiumWithTax = liabOpsPremiumNoTax
                    .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

            logger.debug("liabOpsPremiumNoTax: " + liabOpsPremiumNoTax);
            logger.debug("liabOpsPremiumWithTax: " + liabOpsPremiumWithTax);

        } else {
            logger.debug("Exploitation Limit : NO SUITABLE LIMIT");
        }

        //// 2/Public Liability Property in Care
        logger.debug("////2/Public Liability Property in Care");
        procentTG = BasePremiumBurgerlijkeAansprakelijkheid.tgMap.get(liabilityInput.getData().getNacebel());

        liabPropInCareBasePremium = tarifRc.multiply(procentTG);
        liabPropInCarePremiumWithTax = liabPropInCareBasePremium
                .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

        logger.debug("procentTG: " + procentTG);
        logger.debug("liabPropInCareBasePremium: " + liabPropInCareBasePremium);
        logger.debug("liabPropInCarePremiumWithTax: " + liabPropInCarePremiumWithTax);

        //// 3/Public Liability After Delivery
        logger.debug("////3/Public Liability After Delivery");
        procentBANL = BasePremiumBurgerlijkeAansprakelijkheid.banlMap.get(liabilityInput.getData().getNacebel());
        liabAfterDeliveryBasePremium = tarifRc.multiply(procentBANL);

        logger.debug("procentBANL: " + procentBANL);
        logger.debug("liabAfterDeliveryBasePremium: " + liabAfterDeliveryBasePremium);

        // Coefficients Impact Limit
        logger.debug("//Coefficients Impact Limit");
        if (liabilityInput.getData().getAnswers().getExploitationLimit().compareTo(LIMIT_1) == 0) {
            logger.debug("LIMIT 1");

            liabAfterDeliveryPremiumNoTax = new BigDecimal(liabAfterDeliveryBasePremium.toPlainString());
            liabAfterDeliveryPremiumWithTax = liabAfterDeliveryPremiumNoTax
                    .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

            logger.debug("liabAfterDeliveryPremiumNoTax: " + liabAfterDeliveryPremiumNoTax);
            logger.debug("liabAfterDeliveryPremiumWithTax: " + liabAfterDeliveryPremiumWithTax);

        } else if (liabilityInput.getData().getAnswers().getExploitationLimit().compareTo(LIMIT_2) == 0) {
            logger.debug("LIMIT 2");

            liabAfterDeliveryPremiumNoTax = new BigDecimal(liabAfterDeliveryBasePremium.toPlainString());
            liabAfterDeliveryPremiumNoTax = liabAfterDeliveryPremiumNoTax
                    .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Coef_BANL_Increased_Limit));
            liabAfterDeliveryPremiumWithTax = liabAfterDeliveryPremiumNoTax
                    .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

            logger.debug("liabAfterDeliveryPremiumNoTax: " + liabAfterDeliveryPremiumNoTax);
            logger.debug("liabAfterDeliveryPremiumWithTax: " + liabAfterDeliveryPremiumWithTax);

        } else {
            logger.debug("NO SUITABLE LIMIT");
        }

        // Legal Protection Base Premium
        logger.debug("//Legal Protection Base Premium");
        liabLegalPBasePremium = BasisTariefLegalProtectionTabel.getTarifPj(classBA.intValue(),
                totalNumberOfEmployeeOwner.intValue());
        liabLegalPPremiumTax = liabLegalPBasePremium
                .multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Legal_Protection));

        logger.debug("liabLegalPBasePremium: " + liabLegalPBasePremium);
        logger.debug("liabLegalPPremiumTax: " + liabLegalPPremiumTax);

        // Objective Liability
        logger.debug("//Objective Liability");
        liabObjectiveBasePremium = new BigDecimal(98.06);
        liabObjectivePremiumTax = liabObjectiveBasePremium
                .multiply(BigDecimal.ONE.add(ParametersRCOBurgerlijkeAansprakelijkheid.R_Objective));

        logger.debug("liabObjectiveBasePremium: " + liabObjectiveBasePremium);
        logger.debug("liabObjectivePremiumTax: " + liabObjectivePremiumTax);

        List<LiabilityPremium> result = new ArrayList<>();

        List<LiabilityPremium> result1 = Arrays.asList(
                new LiabilityPremium(LiabilityPremiumType.PUBLIC_LIABILITY_OPERATIONS.label,
                        liabOpsPremiumNoTax.setScale(2, RoundingMode.HALF_UP),
                        liabOpsPremiumWithTax.setScale(2, RoundingMode.HALF_UP)),
                new LiabilityPremium(LiabilityPremiumType.PUBLIC_LIABILITY_PROPERTY_IN_CARE.label,
                        liabPropInCareBasePremium.setScale(2, RoundingMode.HALF_UP),
                        liabPropInCarePremiumWithTax.setScale(2, RoundingMode.HALF_UP)),
                new LiabilityPremium(LiabilityPremiumType.PUBLIC_COVERAGE_AFTER_DELIVERY.label,
                        liabAfterDeliveryPremiumNoTax.setScale(2, RoundingMode.HALF_UP),
                        liabAfterDeliveryPremiumWithTax.setScale(2, RoundingMode.HALF_UP)),
                new LiabilityPremium(LiabilityPremiumType.LEGAL_PROTECTION_BASE_PREMIUM.label,
                        liabLegalPBasePremium.setScale(2, RoundingMode.HALF_UP),
                        liabLegalPPremiumTax.setScale(2, RoundingMode.HALF_UP))

        );
        result.addAll(result1);

        if (liabilityInput.getData().getAnswers().getLiabilityFireAndExplosion()) {
            result.add(new LiabilityPremium(LiabilityPremiumType.OBJECTIVE_LIABILITY.label,
                    liabObjectiveBasePremium.setScale(2, RoundingMode.HALF_UP),
                    liabObjectivePremiumTax.setScale(2, RoundingMode.HALF_UP)));
        }

        logger.debug("");
        logger.debug("");
        logger.debug("");
        logger.debug("Premiums: " + result);
        logger.debug("End calculation for Liability");
        logger.debug("=============================================================================");
        return result;
    }

    private void initValues() {
        logger.debug("Init values before starting to calculate");

        totalNumberOfEmployeeOwner = BigDecimal.ZERO;
        classBA = BigDecimal.ZERO;
        procentOps = BigDecimal.ZERO;
        procentPropInCare = BigDecimal.ZERO;
        procentAfterDel = BigDecimal.ZERO;
        tarifRc = BigDecimal.ZERO;

        procentBAU = BigDecimal.ZERO;
        liabOpsBasePremium = BigDecimal.ZERO;

        liabOpsPremiumNoTax = BigDecimal.ZERO;
        liabOpsPremiumWithTax = BigDecimal.ZERO;

        liabPropInCareBasePremium = BigDecimal.ZERO;
        liabPropInCarePremiumWithTax = BigDecimal.ZERO;

        procentTG = BigDecimal.ZERO;

        procentBANL = BigDecimal.ZERO;
        liabAfterDeliveryBasePremium = BigDecimal.ZERO;
        liabAfterDeliveryPremiumNoTax = BigDecimal.ZERO;
        liabAfterDeliveryPremiumWithTax = BigDecimal.ZERO;
        liabLegalPBasePremium = BigDecimal.ZERO;
        liabLegalPPremiumTax = BigDecimal.ZERO;

        liabObjectiveBasePremium = BigDecimal.ZERO;
        liabObjectivePremiumTax = BigDecimal.ZERO;
    }
}
