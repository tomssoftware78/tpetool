package be.pvgroup.tpetool.model;

import java.math.BigDecimal;

public class Premie {

    private String code;
    private String descriptionNL;
    private String descriptionFR;

    private BigDecimal feeNoTax;
    private BigDecimal feeWithTax;


    public Premie(String code, String descriptionNL, String descriptionFR, BigDecimal feeNoTax, BigDecimal feeWithTax) {
        this.code = code;
        this.descriptionNL = descriptionNL;
        this.descriptionFR = descriptionFR;
        this.feeNoTax = feeNoTax;
        this.feeWithTax = feeWithTax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptionNL() {
        return descriptionNL;
    }

    public void setDescriptionNL(String descriptionNL) {
        this.descriptionNL = descriptionNL;
    }

    public String getDescriptionFR() {
        return descriptionFR;
    }

    public void setDescriptionFR(String descriptionFR) {
        this.descriptionFR = descriptionFR;
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
}
