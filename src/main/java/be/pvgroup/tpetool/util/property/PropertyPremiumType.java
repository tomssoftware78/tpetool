package be.pvgroup.tpetool.util.property;

import java.util.HashMap;
import java.util.Map;

public enum PropertyPremiumType {
    BASE_COVERAGES_BUILDING("BASE -Formule + COVERAGES - Building"),
    BASE_COVERAGES_CONTENT("Base Coverages - Content"),
    CATNAT_COVERAGE_BUILDING("CATNAT Coverage - Building"),
    CATNAT_COVERAGE_CONTENT("CATNAT Coverage - Content"),
    THEFT_COVERAGE("THEFT Coverage"),
    INDIRECT_LOSS_BUILDING("INDIRECT LOSS - Building"),
    INDIRECT_LOSS_CONTENT("INDIRECT LOSS - Content"),
    LEGAL_PROTECTION_COVERAGE_BUILDING("Legal Protection Coverage - Building"),
    LEGAL_PROTECTION_COVERAGE_CONTENT("Legal Protection Coverage - Content"),
    MERCHANDISE_DAMAGES_COVERAGE("Merchandise Damages Coverage"),
    VALUES_COVERAGE("CommercialUnemploymentBlock Coverage"),
    COMMERCIAL_UNEMPLOYMENT_COVERAGE_DAILY("Commercial Unemployment Coverage - Daily"),
    COMMERCIAL_UNEMPLOYMENT_COVERAGE_REVENUE("Commercial Unemployment Coverage - Revenue");

    private static final Map<String, PropertyPremiumType> BY_LABEL = new HashMap<>();

    static {
        for (PropertyPremiumType type: values()) {
            BY_LABEL.put(type.label, type);
        }
    }

    public static PropertyPremiumType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }


    public String label;

    private PropertyPremiumType(String label) {
        this.label = label;
    }
}
