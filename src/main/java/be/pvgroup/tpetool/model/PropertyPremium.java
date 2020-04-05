package be.pvgroup.tpetool.model;

import java.math.BigDecimal;

public class PropertyPremium {
    private String code;

    private BigDecimal premiumRate;
    private BigDecimal feeNoTax;
    private BigDecimal feeWithTax;

    public PropertyPremium(String code, BigDecimal premiumRate, BigDecimal feeNoTax, BigDecimal feeWithTax) {
        this.code = code;
        this.premiumRate = premiumRate;
        this.feeNoTax = feeNoTax;
        this.feeWithTax = feeWithTax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(BigDecimal premiumRate) {
        this.premiumRate = premiumRate;
    }

    public BigDecimal getFeeNoTax() {
        return feeNoTax;
    }

    public void setFeeNoTax(BigDecimal feeNoTax) {
        this.feeNoTax = feeNoTax;
    }

    public BigDecimal getFeeWithTax() {
        return feeWithTax;
    }

    public void setFeeWithTax(BigDecimal feeWithTax) {
        this.feeWithTax = feeWithTax;
    }

    @Override
    public String toString() {
        return "PropertyPremium{" +
                "code='" + code + '\'' +
                ", premiumRate=" + premiumRate +
                ", feeNoTax=" + feeNoTax +
                ", feeWithTax=" + feeWithTax +
                '}';
    }
}
