package be.pvgroup.tpetool.model.proposal;

import be.pvgroup.tpetool.model.accidents.AccidentsAnswers;
import be.pvgroup.tpetool.model.liability.LiabilityAnswers;
import be.pvgroup.tpetool.model.property.PropertyAnswers;

import java.math.BigDecimal;

public class InsuranceAnswers {
    private AccidentsAnswers accidents;
    private LiabilityAnswers liability;
    private PropertyAnswers property;

    public AccidentsAnswers getAccidents() {
        return accidents;
    }

    public void setAccidents(AccidentsAnswers accidents) {
        this.accidents = accidents;
    }

    public LiabilityAnswers getLiability() {
        return liability;
    }

    public void setLiability(LiabilityAnswers liability) {
        this.liability = liability;
    }

    public PropertyAnswers getProperty() {
        return property;
    }

    public void setProperty(PropertyAnswers property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "InsuranceAnswers{" +
                "accidents=" + accidents +
                ", liability=" + liability +
                ", property=" + property +
                '}';
    }



    public static final class InsuranceAnswersBuilder {
        private AccidentsAnswers accidents;
        private LiabilityAnswers liability;
        private PropertyAnswers property;

        private InsuranceAnswersBuilder() {
        }

        public static InsuranceAnswersBuilder anInsuranceAnswers() {
            return new InsuranceAnswersBuilder();
        }

        public InsuranceAnswersBuilder withAccidents(AccidentsAnswers accidents) {
            this.accidents = accidents;
            return this;
        }

        public InsuranceAnswersBuilder withLiability(LiabilityAnswers liability) {
            this.liability = liability;
            return this;
        }

        public InsuranceAnswersBuilder withProperty(PropertyAnswers property) {
            this.property = property;
            return this;
        }

        public InsuranceAnswers build() {
            InsuranceAnswers insuranceAnswers = new InsuranceAnswers();
            insuranceAnswers.setAccidents(accidents);
            insuranceAnswers.setLiability(liability);
            insuranceAnswers.setProperty(property);
            return insuranceAnswers;
        }
    }
}
