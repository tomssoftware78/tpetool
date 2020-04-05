package be.pvgroup.tpetool.model.proposal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Intermediary {
    private String producerNr;
    private String fsmaNr;
    private String name;
    private String firstName;
    private String phone;
    private String cell;
    private String email;

    public String getProducerNr() {
        return producerNr;
    }

    public void setProducerNr(String producerNr) {
        this.producerNr = producerNr;
    }

    @JsonProperty("FSMANr")
    public String getFsmaNr() {
        return fsmaNr;
    }

    @JsonProperty("FSMANr")
    public void setFsmaNr(String fsmaNr) {
        this.fsmaNr = fsmaNr;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Intermediary{" +
                "producerNr='" + producerNr + '\'' +
                ", fsmaNr='" + fsmaNr + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class IntermediaryBuilder {
        private String producerNr;
        private String fsmaNr;
        private String name;
        private String firstName;
        private String phone;
        private String cell;
        private String email;

        private IntermediaryBuilder() {
        }

        public static IntermediaryBuilder anIntermediary() {
            return new IntermediaryBuilder();
        }

        public IntermediaryBuilder withProducerNr(String producerNr) {
            this.producerNr = producerNr;
            return this;
        }

        public IntermediaryBuilder withFsmaNr(String fsmaNr) {
            this.fsmaNr = fsmaNr;
            return this;
        }

        public IntermediaryBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public IntermediaryBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public IntermediaryBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public IntermediaryBuilder withCell(String cell) {
            this.cell = cell;
            return this;
        }

        public IntermediaryBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Intermediary build() {
            Intermediary intermediary = new Intermediary();
            intermediary.setProducerNr(producerNr);
            intermediary.setFsmaNr(fsmaNr);
            intermediary.setName(name);
            intermediary.setFirstName(firstName);
            intermediary.setPhone(phone);
            intermediary.setCell(cell);
            intermediary.setEmail(email);
            return intermediary;
        }
    }
}
