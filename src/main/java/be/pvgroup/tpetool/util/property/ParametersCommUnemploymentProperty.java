package be.pvgroup.tpetool.util.property;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParametersCommUnemploymentProperty {

    public static Map<Integer, BigDecimal> basisGaranties;

    static {
        basisGaranties = new HashMap<Integer, BigDecimal>();
        basisGaranties.put(1, new BigDecimal(0.86472));
        basisGaranties.put(2, new BigDecimal(0.86472));
        basisGaranties.put(3, new BigDecimal(0.86472));
        basisGaranties.put(4, new BigDecimal(1.556496));
        basisGaranties.put(5, new BigDecimal(2.1618));
        basisGaranties.put(6, new BigDecimal(2.1618));
    }
}
