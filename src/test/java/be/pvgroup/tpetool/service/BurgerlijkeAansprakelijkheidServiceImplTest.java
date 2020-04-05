package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.BurgerlijkeAansprakelijkheidInput;
import be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid.ParametersRCOBurgerlijkeAansprakelijkheid;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BurgerlijkeAansprakelijkheidServiceImplTest {

    private BurgerlijkeAansprakelijkheidInput input1;
    private BurgerlijkeAansprakelijkheidInput input2;

    @Before
    public void init() {

        BurgerlijkeAansprakelijkheidInput.BurgerlijkeAansprakelijkheidInputBuilder builder =
                BurgerlijkeAansprakelijkheidInput.BurgerlijkeAansprakelijkheidInputBuilder.aBurgerlijkeAansprakelijkheidInput();

        input1 = builder
                .withNumberOfOwners(BigDecimal.ONE)
                .withNumberOfCoowners(new BigDecimal(1))
                .withNumberOfEmployeeFullTime(new BigDecimal(1))
                .withNumberOfEmployeePartTime(new BigDecimal(1))

                //.withLimitAmount(new BigDecimal(1500000))
                .withNacebel("56101")
                .build();



        builder =
                BurgerlijkeAansprakelijkheidInput.BurgerlijkeAansprakelijkheidInputBuilder.aBurgerlijkeAansprakelijkheidInput();

        input2 = builder
                .withNumberOfOwners(BigDecimal.ONE)
                .withNumberOfCoowners(new BigDecimal(1))
                .withNumberOfEmployeeFullTime(new BigDecimal(1))
                .withNumberOfEmployeePartTime(new BigDecimal(1))

                .withLimitExploitation(new BigDecimal(2500000))
                .withNacebel("56101")
                .build();
    }

    @Test
    public void testBurgerlijkeAansprakelijkheid1() {
        System.out.println(input1.toString());
        System.out.println("");
        BurgerlijkeAansprakelijkheidServiceImpl service = new BurgerlijkeAansprakelijkheidServiceImpl();

        service.calculate(input1);
        System.out.println("totalNumberOfEmployeeOwner: " + service.totalNumberOfEmployeeOwner);
        System.out.println("classBA: " + service.classBA);
        System.out.println("procentOps: " + service.procentOps);
        System.out.println("procentPropInCare: " + service.procentPropInCare);
        System.out.println("procentAfterDel: " + service.procentAfterDel);
        System.out.println("tarifRc: " + service.tarifRc);
        System.out.println("procentBAU: " + service.procentBAU);
        System.out.println("liabOpsBasePremium: " + service.liabOpsBasePremium);

        System.out.println("liabOpsPremiumNoTax: " +  service.liabOpsPremiumNoTax);
        System.out.println("liabOpsPremiumWithTax: " + service.liabOpsPremiumWithTax);

        System.out.println("////2/Public Liability Property in Care");
        System.out.println("procentTG: " + service.procentTG);
        System.out.println("liabPropInCareBasePremium: " + service.liabPropInCareBasePremium);
        System.out.println("liabPropInCarePremiumWithTax: " + service.liabPropInCarePremiumWithTax);

        System.out.println("////3/Public Liability After Delivery");

        System.out.println("procentBANL: " + service.procentBANL);
        System.out.println("liabAfterDeliveryBasePremium: " + service.liabAfterDeliveryBasePremium);

        System.out.println("liabAfterDeliveryPremiumNoTax: " + service.liabAfterDeliveryPremiumNoTax);
        System.out.println("liabAfterDeliveryPremiumWithTax: " + service.liabAfterDeliveryPremiumWithTax);

        System.out.println("//Legal Protection Base Premium");

        System.out.println("liabLegalPBasePremium: " + service.liabLegalPBasePremium);
                System.out.println("liabLegalPPremiumTax: " + service.liabLegalPPremiumTax);

        System.out.println("//Objective Liability");
        System.out.println("liabObjectiveBasePremium: " + service.liabObjectiveBasePremium);
        System.out.println("liabObjectivePremiumTax: " + service.liabObjectivePremiumTax);
    }

    @Test
    public void testBurgerlijkeAansprakelijkheid2() {
        System.out.println(input2.toString());
        System.out.println("");
        BurgerlijkeAansprakelijkheidServiceImpl service = new BurgerlijkeAansprakelijkheidServiceImpl();

        service.calculate(input2);
        System.out.println("totalNumberOfEmployeeOwner: " + service.totalNumberOfEmployeeOwner);
        System.out.println("classBA: " + service.classBA);
        System.out.println("procentOps: " + service.procentOps);
        System.out.println("procentPropInCare: " + service.procentPropInCare);
        System.out.println("procentAfterDel: " + service.procentAfterDel);
        System.out.println("tarifRc: " + service.tarifRc);
        System.out.println("procentBAU: " + service.procentBAU);
        System.out.println("liabOpsBasePremium: " + service.liabOpsBasePremium);

        System.out.println("liabOpsPremiumNoTax: " +  service.liabOpsPremiumNoTax);
        System.out.println("liabOpsPremiumWithTax: " + service.liabOpsPremiumWithTax);

        System.out.println("////2/Public Liability Property in Care");
        System.out.println("procentTG: " + service.procentTG);
        System.out.println("liabPropInCareBasePremium: " + service.liabPropInCareBasePremium);
        System.out.println("liabPropInCarePremiumWithTax: " + service.liabPropInCarePremiumWithTax);

        System.out.println("////3/Public Liability After Delivery");

        System.out.println("procentBANL: " + service.procentBANL);
        System.out.println("liabAfterDeliveryBasePremium: " + service.liabAfterDeliveryBasePremium);

        System.out.println("liabAfterDeliveryPremiumNoTax: " + service.liabAfterDeliveryPremiumNoTax);
        System.out.println("liabAfterDeliveryPremiumWithTax: " + service.liabAfterDeliveryPremiumWithTax);

        System.out.println("//Legal Protection Base Premium");

        System.out.println("liabLegalPBasePremium: " + service.liabLegalPBasePremium);
        System.out.println("liabLegalPPremiumTax: " + service.liabLegalPPremiumTax);

        System.out.println("//Objective Liability");
        System.out.println("liabObjectiveBasePremium: " + service.liabObjectiveBasePremium);
        System.out.println("liabObjectivePremiumTax: " + service.liabObjectivePremiumTax);
    }

}