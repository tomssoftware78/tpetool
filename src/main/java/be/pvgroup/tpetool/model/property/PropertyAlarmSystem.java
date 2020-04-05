package be.pvgroup.tpetool.model.property;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PropertyAlarmSystem {
    NULL("-"),
    AGREED_CENTRAL("Prop_AlarmSystem_AgreedCentral"),
    GSM("Prop_AlarmSystem_GSM"),
    NO_ALARM("Prop_AlarmSystem_NoAlarm");

    @Override
    public String toString() {
        return "PropertyAlarmSystem{" +
                "value='" + value + '\'' +
                '}';
    }

    private String value;
    private PropertyAlarmSystem(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() { return this.value; }
}
