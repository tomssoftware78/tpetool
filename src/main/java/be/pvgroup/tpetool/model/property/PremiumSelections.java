package be.pvgroup.tpetool.model.property;

public class PremiumSelections {
    private Boolean buildingBase = Boolean.FALSE; //gebouw - basiswaarborgen
    private Boolean buildingNature = Boolean.FALSE; //gebouw - natuurrampen
    private Boolean buildingIndirectLoss = Boolean.FALSE; //gebouw - indirect verlies
    private Boolean  buildingLegalProtection = Boolean.FALSE; //gebouw rechtsbijstand

    private Boolean contentsBase = Boolean.FALSE; //inhoud - basiswaarborgen
    private Boolean contentsTheft = Boolean.FALSE; //inhoud - diefstal
    private Boolean contentsNature = Boolean.FALSE; //inhoud - natuurrampen
    private Boolean contentsIndirectLoss = Boolean.FALSE; //inhoud - indirect verlies
    private Boolean contentsLegalProtection = Boolean.FALSE; //inhoud rechtsbijstand

    private Boolean accidentalDamage = Boolean.FALSE; //Accidentele schade aan koopwaar

    private Boolean values = Boolean.FALSE; //Waarden

    private Boolean commercialUnemployment = Boolean.FALSE; //Bedrijfsschade

    public Boolean getBuildingIndirectLoss() {
        return buildingIndirectLoss;
    }

    public void setBuildingIndirectLoss(Boolean buildingIndirectLoss) {
        this.buildingIndirectLoss = buildingIndirectLoss;
    }

    public Boolean getBuildingLegalProtection() {
        return buildingLegalProtection;
    }

    public void setBuildingLegalProtection(Boolean buildingLegalProtection) {
        this.buildingLegalProtection = buildingLegalProtection;
    }

    public Boolean getContentsIndirectLoss() {
        return contentsIndirectLoss;
    }

    public void setContentsIndirectLoss(Boolean contentsIndirectLoss) {
        this.contentsIndirectLoss = contentsIndirectLoss;
    }

    public Boolean getContentsLegalProtection() {
        return contentsLegalProtection;
    }

    public void setContentsLegalProtection(Boolean contentsLegalProtection) {
        this.contentsLegalProtection = contentsLegalProtection;
    }

    public Boolean getBuildingBase() {
        return buildingBase;
    }

    public void setBuildingBase(Boolean buildingBase) {
        this.buildingBase = buildingBase;
    }

    public Boolean getBuildingNature() {
        return buildingNature;
    }

    public void setBuildingNature(Boolean buildingNature) {
        this.buildingNature = buildingNature;
    }

    public Boolean getContentsBase() {
        return contentsBase;
    }

    public void setContentsBase(Boolean contentsBase) {
        this.contentsBase = contentsBase;
    }

    public Boolean getContentsNature() {
        return contentsNature;
    }

    public void setContentsNature(Boolean contentsNature) {
        this.contentsNature = contentsNature;
    }

    public Boolean getContentsTheft() {
        return contentsTheft;
    }

    public void setContentsTheft(Boolean contentsTheft) {
        this.contentsTheft = contentsTheft;
    }

    public Boolean getAccidentalDamage() {
        return accidentalDamage;
    }

    public void setAccidentalDamage(Boolean accidentalDamage) {
        this.accidentalDamage = accidentalDamage;
    }

    public Boolean getValues() {
        return values;
    }

    public void setValues(Boolean values) {
        this.values = values;
    }

    public Boolean getCommercialUnemployment() {
        return commercialUnemployment;
    }

    public void setCommercialUnemployment(Boolean commercialUnemployment) {
        this.commercialUnemployment = commercialUnemployment;
    }

    @Override
    public String toString() {
        return "PremiumSelections{" +
                "buildingBase=" + buildingBase +
                ", buildingNature=" + buildingNature +
                ", buildingIndirectLoss=" + buildingIndirectLoss +
                ", buildingLegalProtection=" + buildingLegalProtection +
                ", contentsBase=" + contentsBase +
                ", contentsTheft=" + contentsTheft +
                ", contentsNature=" + contentsNature +
                ", contentsIndirectLoss=" + contentsIndirectLoss +
                ", contentsLegalProtection=" + contentsLegalProtection +
                ", accidentalDamage=" + accidentalDamage +
                ", values=" + values +
                ", commercialUnemployment=" + commercialUnemployment +
                '}';
    }

    public static final class PremiumSelectionsBuilder {
        private Boolean buildingIndirectLoss;
        private Boolean  buildingLegalProtection;
        private Boolean contentsIndirectLoss;
        private Boolean contentsLegalProtection;
        private Boolean buildingBase;
        private Boolean buildingNature;
        private Boolean contentsBase;
        private Boolean contentsNature;
        private Boolean contentsTheft;
        private Boolean accidentalDamage;
        private Boolean values;
        private Boolean commercialUnemployment;

        private PremiumSelectionsBuilder() {
        }

        public static PremiumSelectionsBuilder aPremiumSelections() {
            return new PremiumSelectionsBuilder();
        }

        public PremiumSelectionsBuilder withBuildingIndirectLoss(Boolean buildingIndirectLoss) {
            this.buildingIndirectLoss = buildingIndirectLoss;
            return this;
        }

        public PremiumSelectionsBuilder withBuildingLegalProtection(Boolean buildingLegalProtection) {
            this.buildingLegalProtection = buildingLegalProtection;
            return this;
        }

        public PremiumSelectionsBuilder withContentsIndirectLoss(Boolean contentsIndirectLoss) {
            this.contentsIndirectLoss = contentsIndirectLoss;
            return this;
        }

        public PremiumSelectionsBuilder withContentsLegalProtection(Boolean contentsLegalProtection) {
            this.contentsLegalProtection = contentsLegalProtection;
            return this;
        }

        public PremiumSelectionsBuilder withBuildingBase(Boolean buildingBase) {
            this.buildingBase = buildingBase;
            return this;
        }

        public PremiumSelectionsBuilder withBuildingNature(Boolean buildingNature) {
            this.buildingNature = buildingNature;
            return this;
        }

        public PremiumSelectionsBuilder withContentsBase(Boolean contentsBase) {
            this.contentsBase = contentsBase;
            return this;
        }

        public PremiumSelectionsBuilder withContentsNature(Boolean contentsNature) {
            this.contentsNature = contentsNature;
            return this;
        }

        public PremiumSelectionsBuilder withContentsTheft(Boolean contentsTheft) {
            this.contentsTheft = contentsTheft;
            return this;
        }

        public PremiumSelectionsBuilder withAccidentalDamage(Boolean accidentalDamage) {
            this.accidentalDamage = accidentalDamage;
            return this;
        }

        public PremiumSelectionsBuilder withValues(Boolean values) {
            this.values = values;
            return this;
        }

        public PremiumSelectionsBuilder withCommercialUnemployment(Boolean commercialUnemployment) {
            this.commercialUnemployment = commercialUnemployment;
            return this;
        }

        public PremiumSelections build() {
            PremiumSelections premiumSelections = new PremiumSelections();
            premiumSelections.setBuildingIndirectLoss(buildingIndirectLoss);
            premiumSelections.setBuildingLegalProtection(buildingLegalProtection);
            premiumSelections.setContentsIndirectLoss(contentsIndirectLoss);
            premiumSelections.setContentsLegalProtection(contentsLegalProtection);
            premiumSelections.setBuildingBase(buildingBase);
            premiumSelections.setBuildingNature(buildingNature);
            premiumSelections.setContentsBase(contentsBase);
            premiumSelections.setContentsNature(contentsNature);
            premiumSelections.setContentsTheft(contentsTheft);
            premiumSelections.setAccidentalDamage(accidentalDamage);
            premiumSelections.setValues(values);
            premiumSelections.setCommercialUnemployment(commercialUnemployment);
            return premiumSelections;
        }
    }
}
