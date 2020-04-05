package be.pvgroup.tpetool.model.proposal;

public class CommonAnswers {

    private Intermediary intermediary;
    private Prospect prospect;
    private StartDates startDates;

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public StartDates getStartDates() {
        return startDates;
    }

    public void setStartDates(StartDates startDates) {
        this.startDates = startDates;
    }

    @Override
    public String toString() {
        return "CommonAnswers{" +
                "intermediary=" + intermediary +
                ", prospect=" + prospect +
                ", startDates=" + startDates +
                '}';
    }

    public static final class CommonAnswersBuilder {
        private Intermediary intermediary;
        private Prospect prospect;
        private StartDates startDates;

        private CommonAnswersBuilder() {
        }

        public static CommonAnswersBuilder aCommonAnswers() {
            return new CommonAnswersBuilder();
        }

        public CommonAnswersBuilder withIntermediary(Intermediary intermediary) {
            this.intermediary = intermediary;
            return this;
        }

        public CommonAnswersBuilder withProspect(Prospect prospect) {
            this.prospect = prospect;
            return this;
        }

        public CommonAnswersBuilder withStartDates(StartDates startDates) {
            this.startDates = startDates;
            return this;
        }

        public CommonAnswers build() {
            CommonAnswers commonAnswers = new CommonAnswers();
            commonAnswers.setIntermediary(intermediary);
            commonAnswers.setProspect(prospect);
            commonAnswers.setStartDates(startDates);
            return commonAnswers;
        }
    }
}
