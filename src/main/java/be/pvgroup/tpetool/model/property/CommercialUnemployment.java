package be.pvgroup.tpetool.model.property;

import java.math.BigDecimal;

public class CommercialUnemployment {
    private Boolean covered;
    private CommercialUnemploymentFormula formula;
    private BigDecimal daily;
    private BigDecimal revenue;

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public CommercialUnemploymentFormula getFormula() {
        return formula;
    }

    public void setFormula(CommercialUnemploymentFormula formula) {
        this.formula = formula;
    }

    public BigDecimal getDaily() {
        return daily;
    }

    public void setDaily(BigDecimal daily) {
        this.daily = daily;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "CommercialUnemployment{" +
                "covered=" + covered +
                ", formula=" + formula +
                ", daily=" + daily +
                ", revenue=" + revenue +
                '}';
    }

    public static final class CommercialUnemploymentBuilder {
        private Boolean covered;
        private CommercialUnemploymentFormula formula;
        private BigDecimal daily;
        private BigDecimal revenue;

        private CommercialUnemploymentBuilder() {
        }

        public static CommercialUnemploymentBuilder aCommercialUnemployment() {
            return new CommercialUnemploymentBuilder();
        }

        public CommercialUnemploymentBuilder withCovered(Boolean covered) {
            this.covered = covered;
            return this;
        }

        public CommercialUnemploymentBuilder withFormula(CommercialUnemploymentFormula formula) {
            this.formula = formula;
            return this;
        }

        public CommercialUnemploymentBuilder withDaily(BigDecimal daily) {
            this.daily = daily;
            return this;
        }

        public CommercialUnemploymentBuilder withRevenue(BigDecimal revenue) {
            this.revenue = revenue;
            return this;
        }

        public CommercialUnemployment build() {
            CommercialUnemployment commercialUnemployment = new CommercialUnemployment();
            commercialUnemployment.setCovered(covered);
            commercialUnemployment.setFormula(formula);
            commercialUnemployment.setDaily(daily);
            commercialUnemployment.setRevenue(revenue);
            return commercialUnemployment;
        }
    }
}
