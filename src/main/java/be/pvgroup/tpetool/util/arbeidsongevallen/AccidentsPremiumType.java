package be.pvgroup.tpetool.util.arbeidsongevallen;

import java.util.HashMap;
import java.util.Map;

public enum AccidentsPremiumType {

    EMPLOYEE_OTHER("employeeOther"),
    EMPLOYEE_STUDENT("employeeStudent"),
    WORKER_OTHER("workerOther"),
    WORKER_STUDENT("workerStudent"),
    BENEFICIARY_2424("2424_beneficiary"),
    BENEFICIARY2_2424("2424_beneficiary2");

    private static final Map<String, AccidentsPremiumType> BY_LABEL = new HashMap<>();

    static {
        for (AccidentsPremiumType type: values()) {
            BY_LABEL.put(type.label, type);
        }
    }

    public static AccidentsPremiumType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }


    public String label;

    private AccidentsPremiumType(String label) {
        this.label = label;
    }
}
