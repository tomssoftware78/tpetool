package be.pvgroup.tpetool.model.liability;

public class LiabilityInput {

    private LiabilityData data;

    public LiabilityData getData() {
        return data;
    }

    public void setData(LiabilityData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LiabilityInput{" +
                "data=" + data +
                '}';
    }

    public static final class LiabilityInputBuilder {
        private LiabilityData data;

        private LiabilityInputBuilder() {
        }

        public static LiabilityInputBuilder aLiabilityInput() {
            return new LiabilityInputBuilder();
        }

        public LiabilityInputBuilder withData(LiabilityData data) {
            this.data = data;
            return this;
        }

        public LiabilityInput build() {
            LiabilityInput liabilityInput = new LiabilityInput();
            liabilityInput.setData(data);
            return liabilityInput;
        }
    }
}
