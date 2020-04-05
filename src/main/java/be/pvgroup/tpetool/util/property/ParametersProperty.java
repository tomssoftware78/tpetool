package be.pvgroup.tpetool.util.property;

import be.pvgroup.tpetool.model.property.BuildingEvaluation;
import be.pvgroup.tpetool.model.property.PropertyAlarmSystem;
import be.pvgroup.tpetool.model.property.PropertyContinguity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ParametersProperty {

    public static final BigDecimal BASE_INDEX = new BigDecimal(0.0809);
    public static final BigDecimal CATNAT_INDEX = new BigDecimal(0.0809);
    public static final BigDecimal PROPERTY_COMM_UNEMPLOYMENT_TAX = new BigDecimal(0.1575);
    public static final BigDecimal VALUE_TAX = new BigDecimal(0.099);
    public static final BigDecimal LEGAL_PROTECTION_TAX = new BigDecimal(0.0925);
    public static final BigDecimal TAFIF_INDEXATION_VALUE_INDEX = new BigDecimal(0.0809);


    public static final BigDecimal PROP_BUILDING_STRUCTURE_CEMENT = new BigDecimal(0.93);
    public static final BigDecimal PROP_BUILDING_GROUNDFLOOR_YES = new BigDecimal(0.97);
    public static final BigDecimal PROP_FORMULE_PLUS = BigDecimal.ONE.add(BASE_INDEX).multiply(new BigDecimal(0.07)).setScale(3, RoundingMode.HALF_UP);

    public static final BigDecimal PROP_THEFT_FORMULA_1RISK_50 = new BigDecimal(1.15);
    public static final BigDecimal INDIRECT_LOSS = new BigDecimal(0.1);

    public static final BigDecimal LEGAL_PROTECTION = BigDecimal.ONE.add(BASE_INDEX).multiply(new BigDecimal(0.05)).setScale(3, RoundingMode.HALF_UP);

    public static final BigDecimal COMMERCIAL_UNEMPLOYMENT_REVENUES_PERCENT = new BigDecimal(0.3);
    public static final BigDecimal COMMERCIAL_UNEMPLOYMENT_MARKET_PARAM = new BigDecimal(0.8);
    public static final BigDecimal PROP_COMMERCIAL_UNEMPLOYMENT_DURATION_12 = new BigDecimal(1.5);
    public static final BigDecimal COMMERCIAL_UNEMPLOYMENT_REVENUES_COEFF =
            COMMERCIAL_UNEMPLOYMENT_REVENUES_PERCENT
                    .multiply(COMMERCIAL_UNEMPLOYMENT_MARKET_PARAM)
                    .multiply(PROP_COMMERCIAL_UNEMPLOYMENT_DURATION_12);




    public static final Map<Boolean, BigDecimal> coefFactorBaseRegularHabitationMap;
    public static final Map<Boolean, BigDecimal> coefFactorTheftRegularHabitationMap;

    public static final Map<BuildingEvaluation, BigDecimal> coefFactorBaseBuildingEvaluationMap;
    public static final Map<String , BigDecimal> coefFactorBaseBuildingCapitalRatioMap;

    public static final Map<PropertyAlarmSystem, BigDecimal> coefFactorTheftAlarmSystemMap;
    public static final Map<PropertyContinguity, BigDecimal> coefFactorTheftContiguityMap;
    public static final Map<String, BigDecimal> coefFactorTheftContentCapitalRatioMap;



    static {
        coefFactorBaseRegularHabitationMap = new HashMap<Boolean, BigDecimal>();
        coefFactorBaseRegularHabitationMap.put(Boolean.TRUE, new BigDecimal(0.91));
        coefFactorBaseRegularHabitationMap.put(Boolean.FALSE, new BigDecimal(1));

        coefFactorTheftRegularHabitationMap = new HashMap<Boolean, BigDecimal>();
        coefFactorTheftRegularHabitationMap.put(Boolean.TRUE, new BigDecimal(1));
        coefFactorTheftRegularHabitationMap.put(Boolean.FALSE, new BigDecimal(1.1));

        coefFactorBaseBuildingEvaluationMap = new HashMap<BuildingEvaluation, BigDecimal>();
        coefFactorBaseBuildingEvaluationMap.put(BuildingEvaluation.POLICY_HOLDER, new BigDecimal(1));
        coefFactorBaseBuildingEvaluationMap.put(BuildingEvaluation.GRID_EXPERTISE_COMPANY, new BigDecimal(1));
        coefFactorBaseBuildingEvaluationMap.put(BuildingEvaluation.GRID_EXPERTISE_EXTERN, new BigDecimal(1));
        coefFactorBaseBuildingEvaluationMap.put(BuildingEvaluation.FIRST_RISK, new BigDecimal(1.15));

        coefFactorBaseBuildingCapitalRatioMap = new HashMap<String, BigDecimal>();
        coefFactorBaseBuildingCapitalRatioMap.put("0", BigDecimal.ONE);
        coefFactorBaseBuildingCapitalRatioMap.put("500000", new BigDecimal(0.98));
        coefFactorBaseBuildingCapitalRatioMap.put("1000000", new BigDecimal(0.96));
        coefFactorBaseBuildingCapitalRatioMap.put("1500000", new BigDecimal(0.94));
        coefFactorBaseBuildingCapitalRatioMap.put("2000000", new BigDecimal(0.92));
        coefFactorBaseBuildingCapitalRatioMap.put("2500000", new BigDecimal(0.9));

        coefFactorTheftAlarmSystemMap = new HashMap<PropertyAlarmSystem, BigDecimal>();
        coefFactorTheftAlarmSystemMap.put(PropertyAlarmSystem.AGREED_CENTRAL, new BigDecimal(0.7));
        coefFactorTheftAlarmSystemMap.put(PropertyAlarmSystem.GSM, new BigDecimal(0.8));
        coefFactorTheftAlarmSystemMap.put(PropertyAlarmSystem.NO_ALARM, new BigDecimal(1));
        coefFactorTheftAlarmSystemMap.put(PropertyAlarmSystem.NULL, new BigDecimal(1));

        coefFactorTheftContiguityMap = new HashMap<PropertyContinguity, BigDecimal>();
        coefFactorTheftContiguityMap.put(PropertyContinguity.NO_CONTINGUITY, new BigDecimal(1.1));
        coefFactorTheftContiguityMap.put(PropertyContinguity.CONTINGUITY, new BigDecimal(1));
        coefFactorTheftContiguityMap.put(PropertyContinguity.NULL, new BigDecimal(1));

        coefFactorTheftContentCapitalRatioMap = new HashMap<String, BigDecimal>();
        coefFactorTheftContentCapitalRatioMap.put("0", BigDecimal.ONE);
        coefFactorTheftContentCapitalRatioMap.put("250000", new BigDecimal(0.975));
        coefFactorTheftContentCapitalRatioMap.put("500000", new BigDecimal(0.95));
        coefFactorTheftContentCapitalRatioMap.put("750000", new BigDecimal(0.925));
        coefFactorTheftContentCapitalRatioMap.put("1000000", new BigDecimal(0.9));
        coefFactorTheftContentCapitalRatioMap.put("9999999", new BigDecimal(0.875));









    }

    public static BigDecimal getPropBuildingCapitalRatio(BigDecimal buildingCapital) {
        BigDecimal result = BigDecimal.ONE;

        BigDecimal value_1 = new BigDecimal(500000);
        BigDecimal value_2 = new BigDecimal(1000000);
        BigDecimal value_3 = new BigDecimal(1500000);
        BigDecimal value_4 = new BigDecimal(2000000);
        BigDecimal value_5 = new BigDecimal(2500000);

        if (buildingCapital != null) {
            if (buildingCapital.compareTo(BigDecimal.ZERO) >= 0 && buildingCapital.compareTo(value_1) < 0) {
                result = coefFactorBaseBuildingCapitalRatioMap.get("0");
            } else if (buildingCapital.compareTo(value_1) >= 0 && buildingCapital.compareTo(value_2) < 0) {
                result = coefFactorBaseBuildingCapitalRatioMap.get("500000");
            } else if (buildingCapital.compareTo(value_2) >= 0 && buildingCapital.compareTo(value_3) < 0) {
                result = coefFactorBaseBuildingCapitalRatioMap.get("1000000");
            } else if (buildingCapital.compareTo(value_3) >= 0 && buildingCapital.compareTo(value_4) < 0) {
                result = coefFactorBaseBuildingCapitalRatioMap.get("1500000");
            } else if (buildingCapital.compareTo(value_4) >= 0 && buildingCapital.compareTo(value_5) < 0) {
                result = coefFactorBaseBuildingCapitalRatioMap.get("2000000");
            } else if (buildingCapital.compareTo(value_5) >= 0) {
                result = coefFactorBaseBuildingCapitalRatioMap.get("2500000");
            }
        }

        return result;
    }

    public static BigDecimal getPropContentCapitalRatio(BigDecimal contentsCapital) {
        BigDecimal result = BigDecimal.ONE;

        BigDecimal value_1 = new BigDecimal(250000);
        BigDecimal value_2 = new BigDecimal(500000);
        BigDecimal value_3 = new BigDecimal(750000);
        BigDecimal value_4 = new BigDecimal(1000000);
        BigDecimal value_5 = new BigDecimal(9999999);

        if (contentsCapital != null) {
            if (contentsCapital.compareTo(BigDecimal.ZERO) >= 0 && contentsCapital.compareTo(value_1) < 0) {
                result = coefFactorTheftContentCapitalRatioMap.get("0");
            } else if (contentsCapital.compareTo(value_1) >= 0 && contentsCapital.compareTo(value_2) < 0) {
                result = coefFactorTheftContentCapitalRatioMap.get("250000");
            } else if (contentsCapital.compareTo(value_2) >= 0 && contentsCapital.compareTo(value_3) < 0) {
                result = coefFactorTheftContentCapitalRatioMap.get("500000");
            } else if (contentsCapital.compareTo(value_3) >= 0 && contentsCapital.compareTo(value_4) < 0) {
                result = coefFactorTheftContentCapitalRatioMap.get("750000");
            } else if (contentsCapital.compareTo(value_4) >= 0 && contentsCapital.compareTo(value_5) < 0) {
                result = coefFactorTheftContentCapitalRatioMap.get("1000000");
            } else if (contentsCapital.compareTo(value_5) >= 0) {
                result = coefFactorTheftContentCapitalRatioMap.get("9999999");
            }
        }

        return result;
    }
}
