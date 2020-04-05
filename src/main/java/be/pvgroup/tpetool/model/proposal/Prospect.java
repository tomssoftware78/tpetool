package be.pvgroup.tpetool.model.proposal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prospect {
    private String bdpNr;
    private String companyNr;
    private String legalForm;
    private String name;
    private String firstName;
    private String street;
    private String number;
    private String zip;
    private String city;
    private String phone;
    private String email;

    @JsonProperty("BDPNr")
    public String getBdpNr() {
        return bdpNr;
    }

    @JsonProperty("BDPNr")
    public void setBdpNr(String bdpNr) {
        this.bdpNr = bdpNr;
    }

    public String getCompanyNr() {
        return companyNr;
    }

    public void setCompanyNr(String companyNr) {
        this.companyNr = companyNr;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Prospect{" +
                "bdpNr='" + bdpNr + '\'' +
                ", companyNr='" + companyNr + '\'' +
                ", legalForm='" + legalForm + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class ProspectBuilder {
        private String bdpNr;
        private String companyNr;
        private String legalForm;
        private String name;
        private String firstName;
        private String street;
        private String number;
        private String zip;
        private String city;
        private String phone;
        private String email;

        private ProspectBuilder() {
        }

        public static ProspectBuilder aProspect() {
            return new ProspectBuilder();
        }

        public ProspectBuilder withBdpNr(String bdpNr) {
            this.bdpNr = bdpNr;
            return this;
        }

        public ProspectBuilder withCompanyNr(String companyNr) {
            this.companyNr = companyNr;
            return this;
        }

        public ProspectBuilder withLegalForm(String legalForm) {
            this.legalForm = legalForm;
            return this;
        }

        public ProspectBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProspectBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProspectBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public ProspectBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public ProspectBuilder withZip(String zip) {
            this.zip = zip;
            return this;
        }

        public ProspectBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public ProspectBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public ProspectBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Prospect build() {
            Prospect prospect = new Prospect();
            prospect.setBdpNr(bdpNr);
            prospect.setCompanyNr(companyNr);
            prospect.setLegalForm(legalForm);
            prospect.setName(name);
            prospect.setFirstName(firstName);
            prospect.setStreet(street);
            prospect.setNumber(number);
            prospect.setZip(zip);
            prospect.setCity(city);
            prospect.setPhone(phone);
            prospect.setEmail(email);
            return prospect;
        }
    }
}
