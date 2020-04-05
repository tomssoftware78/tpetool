package be.pvgroup.tpetool.model.property;

public class PropertyData {

    private String nacebel;

    private PropertyAnswers answers;

    public String getNacebel() {
        return nacebel;
    }

    public void setNacebel(String nacebel) {
        this.nacebel = nacebel;
    }

    public PropertyAnswers getAnswers() {
        return answers;
    }

    public void setAnswers(PropertyAnswers answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "PropertyData{" +
                "nacebel='" + nacebel + '\'' +
                ", answers=" + answers +
                '}';
    }

    public static final class PropertyDataBuilder {
        private String nacebel;
        private PropertyAnswers answers;

        private PropertyDataBuilder() {
        }

        public static PropertyDataBuilder aPropertyData() {
            return new PropertyDataBuilder();
        }

        public PropertyDataBuilder withNacebel(String nacebel) {
            this.nacebel = nacebel;
            return this;
        }

        public PropertyDataBuilder withAnswers(PropertyAnswers answers) {
            this.answers = answers;
            return this;
        }

        public PropertyData build() {
            PropertyData propertyData = new PropertyData();
            propertyData.setNacebel(nacebel);
            propertyData.setAnswers(answers);
            return propertyData;
        }
    }
}
