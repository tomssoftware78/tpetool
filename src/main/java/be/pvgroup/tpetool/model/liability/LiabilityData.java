package be.pvgroup.tpetool.model.liability;

public class LiabilityData {
    private String nacebel;
    private LiabilityAnswers answers;

    public String getNacebel() {
        return nacebel;
    }

    public void setNacebel(String nacebel) {
        this.nacebel = nacebel;
    }

    public LiabilityAnswers getAnswers() {
        return answers;
    }

    public void setAnswers(LiabilityAnswers answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "LiabilityData{" +
                "nacebel='" + nacebel + '\'' +
                ", answers=" + answers +
                '}';
    }

    public static final class LiabilityDataBuilder {
        private String nacebel;
        private LiabilityAnswers answers;

        private LiabilityDataBuilder() {
        }

        public static LiabilityDataBuilder aLiabilityData() {
            return new LiabilityDataBuilder();
        }

        public LiabilityDataBuilder withNacebel(String nacebel) {
            this.nacebel = nacebel;
            return this;
        }

        public LiabilityDataBuilder withAnswers(LiabilityAnswers answers) {
            this.answers = answers;
            return this;
        }

        public LiabilityData build() {
            LiabilityData liabilityData = new LiabilityData();
            liabilityData.setNacebel(nacebel);
            liabilityData.setAnswers(answers);
            return liabilityData;
        }
    }
}
