package be.pvgroup.tpetool.model.property;

public class PropertyInput {
    private PropertyData data;

    public PropertyData getData() {
        return data;
    }

    public void setData(PropertyData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PropertyInput{" +
                "data=" + data +
                '}';
    }

    public static final class PropertyInputBuilder {
        private PropertyData data;

        private PropertyInputBuilder() {
        }

        public static PropertyInputBuilder aPropertyInput() {
            return new PropertyInputBuilder();
        }

        public PropertyInputBuilder withData(PropertyData data) {
            this.data = data;
            return this;
        }

        public PropertyInput build() {
            PropertyInput propertyInput = new PropertyInput();
            propertyInput.setData(data);
            return propertyInput;
        }
    }
}
