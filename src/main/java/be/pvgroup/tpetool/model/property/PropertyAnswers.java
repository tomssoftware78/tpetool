package be.pvgroup.tpetool.model.property;

public class PropertyAnswers {
    private AccidentalDamage accidentalDamage;
    private Address address;
    private CommercialUnemployment commercialUnemployment;
    private MandatoryCoverage mandatoryCoverage;
    private Theft theft;
    private Values values;
    private PremiumSelections premiums = new PremiumSelections();

    public AccidentalDamage getAccidentalDamage() {
        return accidentalDamage;
    }

    public void setAccidentalDamage(AccidentalDamage accidentalDamage) {
        this.accidentalDamage = accidentalDamage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CommercialUnemployment getCommercialUnemployment() {
        return commercialUnemployment;
    }

    public void setCommercialUnemployment(CommercialUnemployment commercialUnemployment) {
        this.commercialUnemployment = commercialUnemployment;
    }

    public MandatoryCoverage getMandatoryCoverage() {
        return mandatoryCoverage;
    }

    public void setMandatoryCoverage(MandatoryCoverage mandatoryCoverage) {
        this.mandatoryCoverage = mandatoryCoverage;
    }

    public Theft getTheft() {
        return theft;
    }

    public void setTheft(Theft theft) {
        this.theft = theft;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }

    public PremiumSelections getPremiums() {
        return premiums;
    }

    public void setPremiums(PremiumSelections premiums) {
        this.premiums = premiums;
    }

    @Override
    public String toString() {
        return "PropertyAnswers{" +
                "accidentalDamage=" + accidentalDamage +
                ", address=" + address +
                ", commercialUnemployment=" + commercialUnemployment +
                ", mandatoryCoverage=" + mandatoryCoverage +
                ", theft=" + theft +
                ", values=" + values +
                ", premiums=" + premiums +
                '}';
    }

    public static final class PropertyAnswersBuilder {
        private AccidentalDamage accidentalDamage;
        private Address address;
        private CommercialUnemployment commercialUnemployment;
        private MandatoryCoverage mandatoryCoverage;
        private Theft theft;
        private Values values;
        private PremiumSelections premiums = new PremiumSelections();

        private PropertyAnswersBuilder() {
        }

        public static PropertyAnswersBuilder aPropertyAnswers() {
            return new PropertyAnswersBuilder();
        }

        public PropertyAnswersBuilder withAccidentalDamage(AccidentalDamage accidentalDamage) {
            this.accidentalDamage = accidentalDamage;
            return this;
        }

        public PropertyAnswersBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public PropertyAnswersBuilder withCommercialUnemployment(CommercialUnemployment commercialUnemployment) {
            this.commercialUnemployment = commercialUnemployment;
            return this;
        }

        public PropertyAnswersBuilder withMandatoryCoverage(MandatoryCoverage mandatoryCoverage) {
            this.mandatoryCoverage = mandatoryCoverage;
            return this;
        }

        public PropertyAnswersBuilder withTheft(Theft theft) {
            this.theft = theft;
            return this;
        }

        public PropertyAnswersBuilder withValues(Values values) {
            this.values = values;
            return this;
        }

        public PropertyAnswersBuilder withPremiums(PremiumSelections premiums) {
            this.premiums = premiums;
            return this;
        }

        public PropertyAnswers build() {
            PropertyAnswers propertyAnswers = new PropertyAnswers();
            propertyAnswers.setAccidentalDamage(accidentalDamage);
            propertyAnswers.setAddress(address);
            propertyAnswers.setCommercialUnemployment(commercialUnemployment);
            propertyAnswers.setMandatoryCoverage(mandatoryCoverage);
            propertyAnswers.setTheft(theft);
            propertyAnswers.setValues(values);
            propertyAnswers.setPremiums(premiums);
            return propertyAnswers;
        }
    }
}
