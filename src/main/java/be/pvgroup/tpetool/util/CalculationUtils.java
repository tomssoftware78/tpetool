package be.pvgroup.tpetool.util;

import be.pvgroup.tpetool.model.ArbeidsOngevallenInput;
import be.pvgroup.tpetool.model.accidents.AccidentsInput;

import java.math.BigDecimal;

public class CalculationUtils {

    public static BigDecimal HUNDRED = new BigDecimal(100);
    public static BigDecimal THOUSAND = new BigDecimal(1000);

    public static BigDecimal getLawWage(ArbeidsOngevallenInput arbeidsOngevallenInput) {
        BigDecimal result = BigDecimal.ZERO;

        if (arbeidsOngevallenInput != null) {
            if (arbeidsOngevallenInput.getLawWageEmployeeAdminOther() != null) {
                result = result.add(arbeidsOngevallenInput.getLawWageEmployeeAdminOther());
            }
            if (arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionOther() != null) {
                result = result.add(arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionOther());
            }
            if (arbeidsOngevallenInput.getLawWageEmployeeAdminStudent() != null) {
                result = result.add(arbeidsOngevallenInput.getLawWageEmployeeAdminStudent());
            }
            if (arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionStudent() != null) {
                result = result.add(arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionStudent());
            }
        }
        return result;

    }
}
