package be.pvgroup.tpetool.model.property;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PropertyContinguity {
    NULL("-"),
    CONTINGUITY("Prop_Contiguity_Continguity"),
    NO_CONTINGUITY("Prop_Contiguity_NoContinguity");

    @Override
    public String toString() {
        return "PropertyContinguity{" +
                "value='" + value + '\'' +
                '}';
    }

    private String value;
    private PropertyContinguity(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() { return this.value; }
}
