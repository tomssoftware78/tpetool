package be.pvgroup.tpetool.model.accidents;

public class AccidentsAnswers {
    private Payroll payroll;
    private Beneficiary beneficiary;
    private Beneficiary beneficiary2;

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Beneficiary getBeneficiary2() {
        return beneficiary2;
    }

    public void setBeneficiary2(Beneficiary beneficiary2) {
        this.beneficiary2 = beneficiary2;
    }

    @Override
    public String toString() {
        return "AccidentsAnswers{" +
                "payroll=" + payroll +
                ", beneficiary=" + beneficiary +
                ", beneficiary2=" + beneficiary2 +
                '}';
    }

    public static final class AccidentsAnswersBuilder {
        private Payroll payroll;
        private Beneficiary beneficiary;
        private Beneficiary beneficiary2;

        private AccidentsAnswersBuilder() {
        }

        public static AccidentsAnswersBuilder anAccidentsAnswers() {
            return new AccidentsAnswersBuilder();
        }

        public AccidentsAnswersBuilder withPayroll(Payroll payroll) {
            this.payroll = payroll;
            return this;
        }

        public AccidentsAnswersBuilder withBeneficiary(Beneficiary beneficiary) {
            this.beneficiary = beneficiary;
            return this;
        }

        public AccidentsAnswersBuilder withBeneficiary2(Beneficiary beneficiary2) {
            this.beneficiary2 = beneficiary2;
            return this;
        }

        public AccidentsAnswers build() {
            AccidentsAnswers accidentsAnswers = new AccidentsAnswers();
            accidentsAnswers.setPayroll(payroll);
            accidentsAnswers.setBeneficiary(beneficiary);
            accidentsAnswers.setBeneficiary2(beneficiary2);
            return accidentsAnswers;
        }
    }
}
