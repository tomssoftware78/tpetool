package be.pvgroup.tpetool.util.property;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParametersCatNatProperty {


    public static final Map<String , BigDecimal> coefRiskSimpleNoRiskMapNoIndex;
    public static final Map<String , BigDecimal> coefRiskSimpleNoRiskMapWithIndex;

    static {
        coefRiskSimpleNoRiskMapNoIndex = new HashMap<String, BigDecimal>();

        coefRiskSimpleNoRiskMapNoIndex.put("0", new BigDecimal(0.3));
        coefRiskSimpleNoRiskMapNoIndex.put("750000", new BigDecimal(0.25));

        coefRiskSimpleNoRiskMapWithIndex = new HashMap<String, BigDecimal>();


        coefRiskSimpleNoRiskMapWithIndex.put("0",
                coefRiskSimpleNoRiskMapNoIndex.get("0").multiply(BigDecimal.ONE.add(ParametersProperty.CATNAT_INDEX)));
        coefRiskSimpleNoRiskMapWithIndex.put("750000",
                coefRiskSimpleNoRiskMapNoIndex.get("750000").multiply(BigDecimal.ONE.add(ParametersProperty.CATNAT_INDEX)));

    }

    public static BigDecimal getRiskSimpleNoRiskWithIndex(BigDecimal buildingCapital) {
        BigDecimal result = BigDecimal.ONE;

        BigDecimal value_1 = new BigDecimal(750000);

        if (buildingCapital != null) {
            if (buildingCapital.compareTo(BigDecimal.ZERO) >= 0 && buildingCapital.compareTo(value_1) < 0) {
                result = coefRiskSimpleNoRiskMapWithIndex.get("0");
            } else {
                result = coefRiskSimpleNoRiskMapWithIndex.get("750000");
            }
        }

        return result;
    }
}
