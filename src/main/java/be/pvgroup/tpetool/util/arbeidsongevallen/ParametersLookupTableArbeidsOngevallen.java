package be.pvgroup.tpetool.util.arbeidsongevallen;

import java.math.BigDecimal;

public class ParametersLookupTableArbeidsOngevallen {

    public static final BigDecimal getRTPremiumForAdministrativeWorkers(BigDecimal wage) {
        return new BigDecimal(0.2);
    }

    public static final BigDecimal getCTPremiumForAdministrativeWorkers(BigDecimal wage) {
        return new BigDecimal(0.43);
    }
}