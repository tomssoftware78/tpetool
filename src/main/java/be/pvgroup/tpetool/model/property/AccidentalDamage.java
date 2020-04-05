package be.pvgroup.tpetool.model.property;

import java.math.BigDecimal;

public class AccidentalDamage {

    private Boolean covered = Boolean.FALSE;
    private BigDecimal capital;

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "AccidentalDamage{" +
                "covered=" + covered +
                ", capital=" + capital +
                '}';
    }

    public static final class AccidentalDamageBuilder {
        private Boolean covered;
        private BigDecimal capital;

        private AccidentalDamageBuilder() {
        }

        public static AccidentalDamageBuilder anAccidentalDamage() {
            return new AccidentalDamageBuilder();
        }

        public AccidentalDamageBuilder withCovered(Boolean covered) {
            this.covered = covered;
            return this;
        }

        public AccidentalDamageBuilder withCapital(BigDecimal capital) {
            this.capital = capital;
            return this;
        }

        public AccidentalDamage build() {
            AccidentalDamage accidentalDamage = new AccidentalDamage();
            accidentalDamage.setCovered(covered);
            accidentalDamage.setCapital(capital);
            return accidentalDamage;
        }
    }
}
