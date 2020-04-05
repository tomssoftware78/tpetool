package be.pvgroup.tpetool.model.property;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CommercialUnemploymentFormula {
    NULL(""),
    DAILY("Prop_CommercialUnemployment_Formula_Daily"),
    REVENUE("Prop_CommercialUnemployment_Formula_Revenue");

    private String value;
    private CommercialUnemploymentFormula(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CommercialUnemploymentFormula{" +
                "value='" + value + '\'' +
                '}';
    }

    @JsonValue
    public String getValue() { return this.value; }
}
