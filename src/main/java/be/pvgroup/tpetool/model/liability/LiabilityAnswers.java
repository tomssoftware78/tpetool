package be.pvgroup.tpetool.model.liability;

import com.itextpdf.layout.property.TextAlignment;

import java.math.BigDecimal;

public class LiabilityAnswers {
    private BigDecimal numberOfOwners;
    private BigDecimal numberOfCoowners;
    private BigDecimal numberOfFullTimeEmployees;
    private BigDecimal numberOfPartTimeEmployees;

    private BigDecimal exploitationLimit;
    private BigDecimal propertyLimit;
    private BigDecimal counselLimit;
    private Boolean liabilityFireAndExplosion;

    public BigDecimal getNumberOfOwners() {
        return numberOfOwners;
    }

    public void setNumberOfOwners(BigDecimal numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    public BigDecimal getNumberOfCoowners() {
        return numberOfCoowners;
    }

    public void setNumberOfCoowners(BigDecimal numberOfCoowners) {
        this.numberOfCoowners = numberOfCoowners;
    }

    public BigDecimal getNumberOfFullTimeEmployees() {
        return numberOfFullTimeEmployees;
    }

    public void setNumberOfFullTimeEmployees(BigDecimal numberOfFullTimeEmployees) {
        this.numberOfFullTimeEmployees = numberOfFullTimeEmployees;
    }

    public BigDecimal getNumberOfPartTimeEmployees() {
        return numberOfPartTimeEmployees;
    }

    public void setNumberOfPartTimeEmployees(BigDecimal numberOfPartTimeEmployees) {
        this.numberOfPartTimeEmployees = numberOfPartTimeEmployees;
    }

    public BigDecimal getExploitationLimit() {
        return exploitationLimit;
    }

    public void setExploitationLimit(BigDecimal exploitationLimit) {
        this.exploitationLimit = exploitationLimit;
    }

    public BigDecimal getPropertyLimit() {
        return propertyLimit;
    }

    public void setPropertyLimit(BigDecimal propertyLimit) {
        this.propertyLimit = propertyLimit;
    }

    public BigDecimal getCounselLimit() {
        return counselLimit;
    }

    public void setCounselLimit(BigDecimal counselLimit) {
        this.counselLimit = counselLimit;
    }

    public Boolean getLiabilityFireAndExplosion() {
        return liabilityFireAndExplosion;
    }

    public void setLiabilityFireAndExplosion(Boolean liabilityFireAndExplosion) {
        this.liabilityFireAndExplosion = liabilityFireAndExplosion;
    }

    public BigDecimal getLimietOnstoffelijkeSchade() {
        BigDecimal result = new BigDecimal(750000);
        if (this.exploitationLimit.compareTo(new BigDecimal(1500000)) == 0) {
            result = new BigDecimal(450000);
        }
        return result;
    }

    public BigDecimal getLimietBrandSchade() {
        BigDecimal result = new BigDecimal(750000);
        if (this.exploitationLimit.compareTo(new BigDecimal(1500000)) == 0) {
            result = new BigDecimal(450000);
        }
        return result;
    }

    public BigDecimal getLimietSchadeArtikel544() {
        BigDecimal result = new BigDecimal(750000);
        if (this.exploitationLimit.compareTo(new BigDecimal(1500000)) == 0) {
            result = new BigDecimal(450000);
        }
        return result;
    }

    public BigDecimal getLimietSchadePollutie() {
        BigDecimal result = new BigDecimal(750000);
        if (this.exploitationLimit.compareTo(new BigDecimal(1500000)) == 0) {
            result = new BigDecimal(450000);
        }
        return result;
    }

    public BigDecimal getLimietPollutie_Public_Coverage_After_Delivery() {
        BigDecimal result = new BigDecimal(0);
        if (this.exploitationLimit.compareTo(new BigDecimal(1500000)) == 0) {
            result = new BigDecimal(0);
        }
        return result;
    }

    @Override
    public String toString() {
        return "LiabilityAnswers{" +
                "numberOfOwners=" + numberOfOwners +
                ", numberOfCoowners=" + numberOfCoowners +
                ", numberOfFullTimeEmployees=" + numberOfFullTimeEmployees +
                ", numberOfPartTimeEmployees=" + numberOfPartTimeEmployees +
                ", exploitationLimit=" + exploitationLimit +
                ", propertyLimit=" + propertyLimit +
                ", counselLimit=" + counselLimit +
                ", liabilityFireAndExplosion=" + liabilityFireAndExplosion +
                '}';
    }

    public static final class LiabilityAnswersBuilder {
        private BigDecimal numberOfOwners;
        private BigDecimal numberOfCoowners;
        private BigDecimal numberOfFullTimeEmployees;
        private BigDecimal numberOfPartTimeEmployees;
        private BigDecimal exploitationLimit = new BigDecimal(1500000);
        private BigDecimal propertyLimit;
        private BigDecimal counselLimit;
        private Boolean liabilityFireAndExplosion;

        private LiabilityAnswersBuilder() {
        }

        public static LiabilityAnswersBuilder aLiabilityAnswers() {
            return new LiabilityAnswersBuilder();
        }

        public LiabilityAnswersBuilder withNumberOfOwners(BigDecimal numberOfOwners) {
            this.numberOfOwners = numberOfOwners;
            return this;
        }

        public LiabilityAnswersBuilder withNumberOfCoowners(BigDecimal numberOfCoowners) {
            this.numberOfCoowners = numberOfCoowners;
            return this;
        }

        public LiabilityAnswersBuilder withNumberOfFullTimeEmployees(BigDecimal numberOfFullTimeEmployees) {
            this.numberOfFullTimeEmployees = numberOfFullTimeEmployees;
            return this;
        }

        public LiabilityAnswersBuilder withNumberOfPartTimeEmployees(BigDecimal numberOfPartTimeEmployees) {
            this.numberOfPartTimeEmployees = numberOfPartTimeEmployees;
            return this;
        }

        public LiabilityAnswersBuilder withExploitationLimit(BigDecimal exploitationLimit) {
            this.exploitationLimit = exploitationLimit;
            return this;
        }

        public LiabilityAnswersBuilder withPropertyLimit(BigDecimal propertyLimit) {
            this.propertyLimit = propertyLimit;
            return this;
        }

        public LiabilityAnswersBuilder withCounselLimit(BigDecimal counselLimit) {
            this.counselLimit = counselLimit;
            return this;
        }

        public LiabilityAnswersBuilder withLiabilityFireAndExplosion(Boolean liabilityFireAndExplosion) {
            this.liabilityFireAndExplosion = liabilityFireAndExplosion;
            return this;
        }

        public LiabilityAnswers build() {
            LiabilityAnswers liabilityAnswers = new LiabilityAnswers();
            liabilityAnswers.setNumberOfOwners(numberOfOwners);
            liabilityAnswers.setNumberOfCoowners(numberOfCoowners);
            liabilityAnswers.setNumberOfFullTimeEmployees(numberOfFullTimeEmployees);
            liabilityAnswers.setNumberOfPartTimeEmployees(numberOfPartTimeEmployees);
            liabilityAnswers.setExploitationLimit(exploitationLimit);
            liabilityAnswers.setPropertyLimit(propertyLimit);
            liabilityAnswers.setCounselLimit(counselLimit);
            liabilityAnswers.setLiabilityFireAndExplosion(liabilityFireAndExplosion);
            return liabilityAnswers;
        }
    }
}
