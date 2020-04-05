package be.pvgroup.tpetool.model.property;

public class Address {

    private String street;
    private String number;
    private String zip;
    private String city;
    private Boolean inhabitedRegurarly;
    private PropertyQuality quality;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getInhabitedRegurarly() {
        return inhabitedRegurarly;
    }

    public void setInhabitedRegurarly(Boolean inhabitedRegurarly) {
        this.inhabitedRegurarly = inhabitedRegurarly;
    }

    public PropertyQuality getQuality() {
        return quality;
    }

    public void setQuality(PropertyQuality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", inhabitedRegurarly=" + inhabitedRegurarly +
                ", quality=" + quality +
                '}';
    }

    public static final class AddressBuilder {
        private String street;
        private String number;
        private String zip;
        private String city;
        private Boolean inhabitedRegurarly;
        private PropertyQuality quality;

        private AddressBuilder() {
        }

        public static AddressBuilder anAddress() {
            return new AddressBuilder();
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public AddressBuilder withZip(String zip) {
            this.zip = zip;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder withInhabitedRegurarly(Boolean inhabitedRegurarly) {
            this.inhabitedRegurarly = inhabitedRegurarly;
            return this;
        }

        public AddressBuilder withQuality(PropertyQuality quality) {
            this.quality = quality;
            return this;
        }

        public Address build() {
            Address address = new Address();
            address.setStreet(street);
            address.setNumber(number);
            address.setZip(zip);
            address.setCity(city);
            address.setInhabitedRegurarly(inhabitedRegurarly);
            address.setQuality(quality);
            return address;
        }
    }
}
