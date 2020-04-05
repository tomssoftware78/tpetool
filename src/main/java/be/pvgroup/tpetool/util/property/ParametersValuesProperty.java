package be.pvgroup.tpetool.util.property;

import be.pvgroup.tpetool.model.property.PropertyValuesCapital;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParametersValuesProperty {

    private static final Map<PropertyValuesCapital, BigDecimal> basePremiumValuesMap_Regio_A;
    private static final Map<PropertyValuesCapital, BigDecimal> basePremiumValuesMap_Regio_B;
    private static final Map<PropertyValuesCapital, BigDecimal> basePremiumValuesMap_Regio_C;
    public static final Map<String, Map<PropertyValuesCapital, BigDecimal>> basePremiumValuesMap;

    static {
        basePremiumValuesMap_Regio_A = new HashMap<PropertyValuesCapital, BigDecimal>();
        basePremiumValuesMap_Regio_A.put(PropertyValuesCapital.CAPITAL_3000, new BigDecimal(64.85));
        basePremiumValuesMap_Regio_A.put(PropertyValuesCapital.CAPITAL_6000, new BigDecimal(129.71));
        basePremiumValuesMap_Regio_A.put(PropertyValuesCapital.CAPITAL_12000, new BigDecimal(259.42));

        basePremiumValuesMap_Regio_B = new HashMap<PropertyValuesCapital, BigDecimal>();
        basePremiumValuesMap_Regio_B.put(PropertyValuesCapital.CAPITAL_3000, new BigDecimal(86.47));
        basePremiumValuesMap_Regio_B.put(PropertyValuesCapital.CAPITAL_6000, new BigDecimal(172.94));
        basePremiumValuesMap_Regio_B.put(PropertyValuesCapital.CAPITAL_12000, new BigDecimal(345.89));

        basePremiumValuesMap_Regio_C = new HashMap<PropertyValuesCapital, BigDecimal>();
        basePremiumValuesMap_Regio_C.put(PropertyValuesCapital.CAPITAL_3000, new BigDecimal(118.90));
        basePremiumValuesMap_Regio_C.put(PropertyValuesCapital.CAPITAL_6000, new BigDecimal(237.80));
        basePremiumValuesMap_Regio_C.put(PropertyValuesCapital.CAPITAL_12000, new BigDecimal(475.60));

        basePremiumValuesMap = new HashMap<String, Map<PropertyValuesCapital, BigDecimal>>();
        basePremiumValuesMap.put("A", basePremiumValuesMap_Regio_A);
        basePremiumValuesMap.put("B", basePremiumValuesMap_Regio_B);
        basePremiumValuesMap.put("C", basePremiumValuesMap_Regio_C);
    }

    public static BigDecimal getBasisTariefValues(String postCodeClass, PropertyValuesCapital propertyValuesCapital) {
        Map<PropertyValuesCapital, BigDecimal> basisTarieven_Regio = basePremiumValuesMap.get(postCodeClass);

        BigDecimal basisTarief = basisTarieven_Regio.get(propertyValuesCapital);
        return basisTarief;
    }


}
