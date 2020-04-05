package be.pvgroup.tpetool.model.property;

public class Theft {

    private Boolean covered;
    private PropertyContinguity continguity;
    private PropertyAlarmSystem alarmSystem;

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public PropertyContinguity getContinguity() {
        return continguity;
    }

    public void setContinguity(PropertyContinguity continguity) {
        this.continguity = continguity;
    }

    public PropertyAlarmSystem getAlarmSystem() {
        return alarmSystem;
    }

    public void setAlarmSystem(PropertyAlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public String toString() {
        return "Theft{" +
                "covered=" + covered +
                ", continguity=" + continguity +
                ", alarmSystem=" + alarmSystem +
                '}';
    }

    public static final class TheftBuilder {
        private Boolean covered;
        private PropertyContinguity continguity;
        private PropertyAlarmSystem alarmSystem;

        private TheftBuilder() {
        }

        public static TheftBuilder aTheft() {
            return new TheftBuilder();
        }

        public TheftBuilder withCovered(Boolean covered) {
            this.covered = covered;
            return this;
        }

        public TheftBuilder withContinguity(PropertyContinguity continguity) {
            this.continguity = continguity;
            return this;
        }

        public TheftBuilder withAlarmSystem(PropertyAlarmSystem alarmSystem) {
            this.alarmSystem = alarmSystem;
            return this;
        }

        public Theft build() {
            Theft theft = new Theft();
            theft.setCovered(covered);
            theft.setContinguity(continguity);
            theft.setAlarmSystem(alarmSystem);
            return theft;
        }
    }
}
