package be.pvgroup.tpetool.model;

import java.math.BigDecimal;

public class BurgerlijkeAansprakelijkheidInput {

    private BigDecimal numberOfOwners;
    private BigDecimal numberOfCoowners;
    private BigDecimal numberOfEmployeeFullTime;
    private BigDecimal numberOfEmployeePartTime;

    private BigDecimal limitExploitation;
    private BigDecimal limitAmount;
    private BigDecimal limitAmountLegal;

    private String nacebel;

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

    public BigDecimal getNumberOfEmployeeFullTime() {
        return numberOfEmployeeFullTime;
    }

    public void setNumberOfEmployeeFullTime(BigDecimal numberOfEmployeeFullTime) {
        this.numberOfEmployeeFullTime = numberOfEmployeeFullTime;
    }

    public BigDecimal getNumberOfEmployeePartTime() {
        return numberOfEmployeePartTime;
    }

    public void setNumberOfEmployeePartTime(BigDecimal numberOfEmployeePartTime) {
        this.numberOfEmployeePartTime = numberOfEmployeePartTime;
    }

    public BigDecimal getLimitExploitation() {
        return limitExploitation;
    }

    public void setLimitExploitation(BigDecimal limitExploitation) {
        this.limitExploitation = limitExploitation;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public BigDecimal getLimitAmountLegal() {
        return limitAmountLegal;
    }

    public void setLimitAmountLegal(BigDecimal limitAmountLegal) {
        this.limitAmountLegal = limitAmountLegal;
    }

    public String getNacebel() {
        return nacebel;
    }

    public void setNacebel(String nacebel) {
        this.nacebel = nacebel;
    }

    @Override
    public String toString() {
        return "BurgerlijkeAansprakelijkheidInput{" +
                "numberOfOwners=" + numberOfOwners +
                ", numberOfCoowners=" + numberOfCoowners +
                ", numberOfEmployeeFullTime=" + numberOfEmployeeFullTime +
                ", numberOfEmployeePartTime=" + numberOfEmployeePartTime +
                ", limitExploitation=" + limitExploitation +
                ", limitAmount=" + limitAmount +
                ", limitAmountLegal=" + limitAmountLegal +
                ", nacebel='" + nacebel + '\'' +
                '}';
    }


    public static final class BurgerlijkeAansprakelijkheidInputBuilder {
        private BigDecimal numberOfOwners;
        private BigDecimal numberOfCoowners;
        private BigDecimal numberOfEmployeeFullTime;
        private BigDecimal numberOfEmployeePartTime;
        private BigDecimal limitExploitation = new BigDecimal(1500000);;
        private BigDecimal limitAmount;
        private BigDecimal limitAmountLegal;
        private String nacebel;

        private BurgerlijkeAansprakelijkheidInputBuilder() {
        }

        public static BurgerlijkeAansprakelijkheidInputBuilder aBurgerlijkeAansprakelijkheidInput() {
            return new BurgerlijkeAansprakelijkheidInputBuilder();
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withNumberOfOwners(BigDecimal numberOfOwners) {
            this.numberOfOwners = numberOfOwners;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withNumberOfCoowners(BigDecimal numberOfCoowners) {
            this.numberOfCoowners = numberOfCoowners;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withNumberOfEmployeeFullTime(BigDecimal numberOfEmployeeFullTime) {
            this.numberOfEmployeeFullTime = numberOfEmployeeFullTime;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withNumberOfEmployeePartTime(BigDecimal numberOfEmployeePartTime) {
            this.numberOfEmployeePartTime = numberOfEmployeePartTime;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withLimitExploitation(BigDecimal limitExploitation) {
            this.limitExploitation = limitExploitation;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withLimitAmount(BigDecimal limitAmount) {
            this.limitAmount = limitAmount;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withLimitAmountLegal(BigDecimal limitAmountLegal) {
            this.limitAmountLegal = limitAmountLegal;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInputBuilder withNacebel(String nacebel) {
            this.nacebel = nacebel;
            return this;
        }

        public BurgerlijkeAansprakelijkheidInput build() {
            BurgerlijkeAansprakelijkheidInput burgerlijkeAansprakelijkheidInput = new BurgerlijkeAansprakelijkheidInput();
            burgerlijkeAansprakelijkheidInput.setNumberOfOwners(numberOfOwners);
            burgerlijkeAansprakelijkheidInput.setNumberOfCoowners(numberOfCoowners);
            burgerlijkeAansprakelijkheidInput.setNumberOfEmployeeFullTime(numberOfEmployeeFullTime);
            burgerlijkeAansprakelijkheidInput.setNumberOfEmployeePartTime(numberOfEmployeePartTime);
            burgerlijkeAansprakelijkheidInput.setLimitExploitation(limitExploitation);
            burgerlijkeAansprakelijkheidInput.setLimitAmount(limitAmount);
            burgerlijkeAansprakelijkheidInput.setLimitAmountLegal(limitAmountLegal);
            burgerlijkeAansprakelijkheidInput.setNacebel(nacebel);
            return burgerlijkeAansprakelijkheidInput;
        }
    }
}
