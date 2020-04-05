package be.pvgroup.tpetool.model.proposal;

public class ProposalData {

    private String nacebel;
    private InsuranceAnswers insuranceAnswers;
    private CommonAnswers commonAnswers;

    public final static String NACEBEL_56101 = "56101";
    public final static String NACEBEL_56102 = "56102";
    public final static String NACEBEL_56210 = "56210";

    public String getNacebel() {
        return nacebel;
    }

    public void setNacebel(String nacebel) {
        this.nacebel = nacebel;
    }

    public InsuranceAnswers getInsuranceAnswers() {
        return insuranceAnswers;
    }

    public void setInsuranceAnswers(InsuranceAnswers insuranceAnswers) {
        this.insuranceAnswers = insuranceAnswers;
    }

    public CommonAnswers getCommonAnswers() {
        return commonAnswers;
    }

    public void setCommonAnswers(CommonAnswers commonAnswers) {
        this.commonAnswers = commonAnswers;
    }

    @Override
    public String toString() {
        return "ProposalData{" +
                "nacebel='" + nacebel + '\'' +
                ", insuranceAnswers=" + insuranceAnswers +
                ", commonAnswers=" + commonAnswers +
                '}';
    }

    public static final class ProposalDataBuilder {
        private String nacebel;
        private InsuranceAnswers insuranceAnswers;
        private CommonAnswers commonAnswers;

        private ProposalDataBuilder() {
        }

        public static ProposalDataBuilder aProposalData() {
            return new ProposalDataBuilder();
        }

        public ProposalDataBuilder withNacebel(String nacebel) {
            this.nacebel = nacebel;
            return this;
        }

        public ProposalDataBuilder withInsuranceAnswers(InsuranceAnswers insuranceAnswers) {
            this.insuranceAnswers = insuranceAnswers;
            return this;
        }

        public ProposalDataBuilder withCommonAnswers(CommonAnswers commonAnswers) {
            this.commonAnswers = commonAnswers;
            return this;
        }

        public ProposalData build() {
            ProposalData proposalData = new ProposalData();
            proposalData.setNacebel(nacebel);
            proposalData.setInsuranceAnswers(insuranceAnswers);
            proposalData.setCommonAnswers(commonAnswers);
            return proposalData;
        }
    }
}
