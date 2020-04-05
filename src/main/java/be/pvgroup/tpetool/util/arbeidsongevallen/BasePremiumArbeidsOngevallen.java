package be.pvgroup.tpetool.util.arbeidsongevallen;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BasePremiumArbeidsOngevallen {

    public static final Map<String, BigDecimal> rpArbeidersMap;
    public static final Map<String, BigDecimal> rpMedewerkersMetMissieMap;
    public static final Map<String, BigDecimal> rcBaMap;

    static {
        rpArbeidersMap = new HashMap<String, BigDecimal>();
        rpArbeidersMap.put("56101", new BigDecimal(0.66));
        rpArbeidersMap.put("56102", new BigDecimal(1.2296));
        rpArbeidersMap.put("56210", new BigDecimal(1.2826));

        rpMedewerkersMetMissieMap = new HashMap<String, BigDecimal>();
        rpMedewerkersMetMissieMap.put("56101", new BigDecimal(0.59));
        rpMedewerkersMetMissieMap.put("56102", new BigDecimal(0.59));
        rpMedewerkersMetMissieMap.put("56210", new BigDecimal(0.59));

        rcBaMap = new HashMap<String, BigDecimal>();
        rcBaMap.put("56101", new BigDecimal(2));
        rcBaMap.put("56102", new BigDecimal(3));
        rcBaMap.put("56210", new BigDecimal(5));
    }

}