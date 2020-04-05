package be.pvgroup.tpetool.service.liability;

import be.pvgroup.tpetool.model.liability.LiabilityInput;
import org.junit.Before;
import org.junit.Test;

import static be.pvgroup.tpetool.LiabilityTestConstants.liabilityInput;
import static be.pvgroup.tpetool.LiabilityTestConstants.liabilityInputLimi2500000;

public class LiabilityServiceImplTest {

    private LiabilityInput input1;
    private LiabilityInput input2;

    @Before
    public void init() {
        input1 = liabilityInput();
        input2 = liabilityInputLimi2500000();
    }

    @Test
    public void testLiability1() {
        System.out.println(input1.toString());
        System.out.println("");
        LiabilityServiceImpl service = new LiabilityServiceImpl();

        //service.calculate(input1);
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
        LiabilityServiceImpl service = new LiabilityServiceImpl();

        //service.calculate(input2);
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
