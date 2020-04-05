package be.pvgroup.tpetool.model.property;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PropertyQuality {
    OWNER("Prop_PH_Quality_OwnerManager"),
    RENTER("Prop_PH_Quality_RenterManager");

    private String value;
    private PropertyQuality(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyQuality{" +
                "value='" + value + '\'' +
                '}';
    }

    @JsonValue
    public String getValue() { return this.value; }
}
