package be.pvgroup.tpetool.model.property;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PropertyValuesCapital {
    NULL("-"),
    CAPITAL_3000("Prop_Values_Capital_3000-3000"),
    CAPITAL_6000("Prop_Values_Capital_6000-6000"),
    CAPITAL_12000("Prop_Values_Capital_12000-12000");

    @Override
    public String toString() {
        return "PropertyValuesCapital{" +
                "value='" + value + '\'' +
                '}';
    }

    private String value;
    private PropertyValuesCapital(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() { return this.value; }
}
