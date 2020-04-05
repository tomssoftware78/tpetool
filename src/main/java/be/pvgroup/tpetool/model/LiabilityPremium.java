package be.pvgroup.tpetool.model;

import java.math.BigDecimal;

public class LiabilityPremium {

    private String code;
    private BigDecimal feeNoTax;
    private BigDecimal feeWithTax;

    public LiabilityPremium(String code, BigDecimal feeNoTax, BigDecimal feeWithTax) {
        this.code = code;
        this.feeNoTax = feeNoTax;
        this.feeWithTax = feeWithTax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return "LiabilityPremium{" +
                "code='" + code + '\'' +
                ", feeNoTax=" + feeNoTax +
                ", feeWithTax=" + feeWithTax +
                '}';
    }
}
