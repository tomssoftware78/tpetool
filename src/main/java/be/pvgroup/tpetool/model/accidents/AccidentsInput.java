package be.pvgroup.tpetool.model.accidents;

public class AccidentsInput {

    private AccidentsData data;

    public AccidentsData getData() {
        return data;
    }

    public void setData(AccidentsData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AccidentsInput{" +
                "data=" + data +
                '}';
    }

    public static final class AccidentsInputBuilder {
        private AccidentsData data;

        private AccidentsInputBuilder() {
        }

        public static AccidentsInputBuilder anAccidentsInput() {
            return new AccidentsInputBuilder();
        }

        public AccidentsInputBuilder withData(AccidentsData data) {
            this.data = data;
            return this;
        }

        public AccidentsInput build() {
            AccidentsInput accidentsInput = new AccidentsInput();
            accidentsInput.setData(data);
            return accidentsInput;
        }
    }
}
