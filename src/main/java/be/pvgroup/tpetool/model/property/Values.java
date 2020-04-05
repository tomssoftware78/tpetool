package be.pvgroup.tpetool.model.property;

import java.math.BigDecimal;

public class Values {
    private Boolean covered = Boolean.FALSE;
    private PropertyValuesCapital capital;

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public PropertyValuesCapital getCapital() {
        return capital;
    }

    public void setCapital(PropertyValuesCapital capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Values{" +
                "covered=" + covered +
                ", capital=" + capital +
                '}';
    }

    public static final class ValuesBuilder {
        private Boolean covered;
        private PropertyValuesCapital capital;

        private ValuesBuilder() {
        }

        public static ValuesBuilder aValues() {
            return new ValuesBuilder();
        }

        public ValuesBuilder withCovered(Boolean covered) {
            this.covered = covered;
            return this;
        }

        public ValuesBuilder withCapital(PropertyValuesCapital capital) {
            this.capital = capital;
            return this;
        }

        public Values build() {
            Values values = new Values();
            values.setCovered(covered);
            values.setCapital(capital);
            return values;
        }
    }
}
