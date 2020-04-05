package be.pvgroup.tpetool.model.accidents;

public class AccidentsData {
    private String nacebel;

    private AccidentsAnswers answers;

    public String getNacebel() {
        return nacebel;
    }

    public void setNacebel(String nacebel) {
        this.nacebel = nacebel;
    }

    public AccidentsAnswers getAnswers() {
        return answers;
    }

    public void setAnswers(AccidentsAnswers answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "AccidentsData{" +
                "nacebel='" + nacebel + '\'' +
                ", answers=" + answers +
                '}';
    }

    public static final class AccidentsDataBuilder {
        private String nacebel;
        private AccidentsAnswers answers;

        private AccidentsDataBuilder() {
        }

        public static AccidentsDataBuilder anAccidentsData() {
            return new AccidentsDataBuilder();
        }

        public AccidentsDataBuilder withNacebel(String nacebel) {
            this.nacebel = nacebel;
            return this;
        }

        public AccidentsDataBuilder withAnswers(AccidentsAnswers answers) {
            this.answers = answers;
            return this;
        }

        public AccidentsData build() {
            AccidentsData accidentsData = new AccidentsData();
            accidentsData.setNacebel(nacebel);
            accidentsData.setAnswers(answers);
            return accidentsData;
        }
    }
}
