package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.ArbeidsOngevallenInput;
import be.pvgroup.tpetool.util.arbeidsongevallen.ParametersArbeidsOngevallen;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArbeidsOngevallenServiceImplTest {

    private ArbeidsOngevallenInput input;
    private ArbeidsOngevallenInput input2;

    @Before
    public void init() {
        ArbeidsOngevallenInput.ArbeidsOngevallenInputBuilder builder =
                ArbeidsOngevallenInput.ArbeidsOngevallenInputBuilder.anArbeidsOngevallenInput();

        input = builder
                .withLawWageEmployeeAdminOther(new BigDecimal(10000))
                .withLawWageEmployeeManualWorkOther(new BigDecimal(20000))
                .withLawWageWorkerOther(new BigDecimal(18000))
                .withLawWageWorkerStudent(new BigDecimal(10000))
                .withName1_2424("aaaaa")
                .withFirstName1_2424("bbbbb")
                .withBirthDate1_2424("ccccc")
                .withWage1_2424(new BigDecimal(35000))
                .withName2_2424("null")
                .withFirstName2_2424("null")
                .withBirthDate2_2424("null")
                .withWage2_2424(null)
                .withSelectedManualWork_2424(ArbeidsOngevallenServiceImpl.LIMITED_MANUAL_WORK)
                .withNacebel("56101")
                .build();

        builder = ArbeidsOngevallenInput.ArbeidsOngevallenInputBuilder.anArbeidsOngevallenInput();

        input2 = builder
                .withLawWageEmployeeAdminOther(new BigDecimal(30000))
                .withLawWageEmployeeTempExternalMissionOther(new BigDecimal(30000))
                .withLawWageEmployeeExternalMissionOther(new BigDecimal(30000))
                .withLawWageEmployeeManualWorkOther(new BigDecimal(30000))
                .withLawWageWorkerOther(new BigDecimal(30000))
                .withLawWageEmployeeAdminStudent(new BigDecimal(20000))
                .withLawWageEmployeeTempExternalMissionStudent(new BigDecimal(200000))
                .withLawWageWorkerStudent(new BigDecimal(30000))
                .withWage1_2424(new BigDecimal(30000))
                .withSelectedManualWork_2424(ArbeidsOngevallenServiceImpl.NO_MANUAL_WORK)
                .withNacebel("56101")
                .build();

    }

    @Test
    public void testArbeidsOngevallen1() {
        ArbeidsOngevallenServiceImpl service = new ArbeidsOngevallenServiceImpl();

        service.calculate(input);

        service.printCalculationData();
        service.printLimitedManualWorkData();
    }

    @Test
    public void testArbeidsOngevallen2() {
        ArbeidsOngevallenServiceImpl service = new ArbeidsOngevallenServiceImpl();

        service.calculate(input2);

        service.printCalculationData();
        service.printLimitedManualWorkData();
    }

    @Test
    public void testRounding() {
        System.out.println(ParametersArbeidsOngevallen.CT_Worker);
    }

    private String printBigDecimal(BigDecimal value) {
        BigDecimal result = new BigDecimal(value.toString()).setScale(4, RoundingMode.FLOOR);
        return result.toString();
    }
}