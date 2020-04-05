package be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid;

import java.util.HashMap;
import java.util.Map;

public enum LiabilityPremiumType {

    PUBLIC_LIABILITY_OPERATIONS("Public Liability Operations"),
    PUBLIC_LIABILITY_PROPERTY_IN_CARE("Public Liability Property in Care"),
    PUBLIC_COVERAGE_AFTER_DELIVERY("Public Liability After Delivery"),
    LEGAL_PROTECTION_BASE_PREMIUM("Legal Protection Base Premium"),
    OBJECTIVE_LIABILITY("Objective Liability");

    private static final Map<String, LiabilityPremiumType> BY_LABEL = new HashMap<>();

    static {
        for (LiabilityPremiumType type: values()) {
            BY_LABEL.put(type.label, type);
        }
    }

    public static LiabilityPremiumType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }


    public String label;

    private LiabilityPremiumType(String label) {
        this.label = label;
    }
}
