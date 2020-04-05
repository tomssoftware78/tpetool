package be.pvgroup.tpetool.model.property;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BuildingEvaluation {

    POLICY_HOLDER("Prop_Building_Evaluation_PolicyHolder"),
    GRID_EXPERTISE_COMPANY("Prop_Building_Evaluation_GridExpertise_Company"),
    GRID_EXPERTISE_EXTERN("Prop_Building_Evaluation_GridExpertise_Extern"),
    FIRST_RISK("Prop_Building_Evaluation_1Risk");

    private String value;
    private BuildingEvaluation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BuildingEvaluation{" +
                "value='" + value + '\'' +
                '}';
    }

    @JsonValue
    public String getValue() { return this.value; }
}
