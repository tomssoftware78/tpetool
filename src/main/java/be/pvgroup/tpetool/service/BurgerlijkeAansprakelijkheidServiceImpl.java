package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.BurgerlijkeAansprakelijkheidInput;
import be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class BurgerlijkeAansprakelijkheidServiceImpl implements BurgerlijkeAansprakelijkheidService {

    private static final BigDecimal LIMIT_1 = new BigDecimal(1500000);
    private static final BigDecimal LIMIT_2 = new BigDecimal(2500000);

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
    public void calculate(BurgerlijkeAansprakelijkheidInput burgerlijkeAansprakelijkheidInput) {
        BigDecimal half = burgerlijkeAansprakelijkheidInput.getNumberOfEmployeePartTime().divide(new BigDecimal(2));

        totalNumberOfEmployeeOwner = burgerlijkeAansprakelijkheidInput.getNumberOfOwners()
                .add(burgerlijkeAansprakelijkheidInput.getNumberOfCoowners())
                .add(burgerlijkeAansprakelijkheidInput.getNumberOfEmployeeFullTime())
                .add(
                        burgerlijkeAansprakelijkheidInput.getNumberOfEmployeePartTime().divide(new BigDecimal(2))
                );
        totalNumberOfEmployeeOwner = totalNumberOfEmployeeOwner.setScale(0, RoundingMode.DOWN);

        classBA = BasePremiumBurgerlijkeAansprakelijkheid.rcBaMap.get(burgerlijkeAansprakelijkheidInput.getNacebel());
        procentOps = BasePremiumBurgerlijkeAansprakelijkheid.bauMap.get(burgerlijkeAansprakelijkheidInput.getNacebel());
        procentPropInCare = BasePremiumBurgerlijkeAansprakelijkheid.tgMap.get(burgerlijkeAansprakelijkheidInput.getNacebel());
        procentAfterDel = BasePremiumBurgerlijkeAansprakelijkheid.banlMap.get(burgerlijkeAansprakelijkheidInput.getNacebel());

        //// Public Liability Base Premium
        tarifRc = BasisTariefPublicLiabilityTabel.getTarifRc(classBA.intValue(), totalNumberOfEmployeeOwner.intValue());


        //// 1/Public Liability Operations
        procentBAU = BasePremiumBurgerlijkeAansprakelijkheid.bauMap.get(burgerlijkeAansprakelijkheidInput.getNacebel());

        liabOpsBasePremium = tarifRc.multiply(procentBAU);

        //Coefficients Impact Limit
        if (burgerlijkeAansprakelijkheidInput.getLimitExploitation().compareTo(LIMIT_1) == 0) {
            //liabOpsBasePremium =
            System.out.println("LIMIT 1");

            liabOpsPremiumNoTax = new BigDecimal(liabOpsBasePremium.toPlainString());
            liabOpsPremiumWithTax = liabOpsPremiumNoTax.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

        } else if (burgerlijkeAansprakelijkheidInput.getLimitExploitation().compareTo(LIMIT_2) == 0) {
            System.out.println("LIMIT 2");

            liabOpsPremiumNoTax = new BigDecimal(liabOpsBasePremium.toPlainString());
            liabOpsPremiumNoTax = liabOpsPremiumNoTax.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Coef_BAU_Increased_Limit));
            liabOpsPremiumWithTax = liabOpsPremiumNoTax.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

        } else {
            System.out.println("NO SUITABLE LIMIT");
        }

        ////2/Public Liability Property in Care
        procentTG = BasePremiumBurgerlijkeAansprakelijkheid.tgMap.get(burgerlijkeAansprakelijkheidInput.getNacebel());

        liabPropInCareBasePremium = tarifRc.multiply(procentTG);
        liabPropInCarePremiumWithTax = liabPropInCareBasePremium.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

        ////3/Public Liability After Delivery
        procentBANL = BasePremiumBurgerlijkeAansprakelijkheid.banlMap.get(burgerlijkeAansprakelijkheidInput.getNacebel());
        liabAfterDeliveryBasePremium = tarifRc.multiply(procentBANL);

        //Coefficients Impact Limit
        if (burgerlijkeAansprakelijkheidInput.getLimitExploitation().compareTo(LIMIT_1) == 0) {
            System.out.println("LIMIT 1");

            liabAfterDeliveryPremiumNoTax = new BigDecimal(liabAfterDeliveryBasePremium.toPlainString());
            liabAfterDeliveryPremiumWithTax = liabAfterDeliveryPremiumNoTax.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

        } else if (burgerlijkeAansprakelijkheidInput.getLimitExploitation().compareTo(LIMIT_2) == 0) {
            System.out.println("LIMIT 2");

            liabAfterDeliveryPremiumNoTax = new BigDecimal(liabAfterDeliveryBasePremium.toPlainString());
            liabAfterDeliveryPremiumNoTax = liabAfterDeliveryPremiumNoTax.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Coef_BANL_Increased_Limit));
            liabAfterDeliveryPremiumWithTax = liabAfterDeliveryPremiumNoTax.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Public_Liability));

        } else {
            System.out.println("NO SUITABLE LIMIT");
        }


        //Legal Protection Base Premium
        liabLegalPBasePremium = BasisTariefLegalProtectionTabel.getTarifPj(classBA.intValue(), totalNumberOfEmployeeOwner.intValue());
        liabLegalPPremiumTax = liabLegalPBasePremium.multiply(BigDecimal.ONE.add(ParametersBurgerlijkeAansprakelijkheid.Tax_Legal_Protection));


        //Objective Liability

        liabObjectiveBasePremium = new BigDecimal(98.06);
        liabObjectivePremiumTax = liabObjectiveBasePremium.multiply(BigDecimal.ONE.add(ParametersRCOBurgerlijkeAansprakelijkheid.R_Objective));
    }
}
