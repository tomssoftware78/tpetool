package be.pvgroup.tpetool.pdf.pages.property.blocks;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.LiabilityPremium;
import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.model.property.CommercialUnemploymentFormula;
import be.pvgroup.tpetool.util.arbeidsongevallen.AccidentsPremiumType;
import be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid.LiabilityPremiumType;
import be.pvgroup.tpetool.util.property.PropertyPremiumType;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.TextAlignment;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

public class AbstractBlock {

    protected ProposalPdfData proposalPdfData;

    protected PropertyPremium propertyPremiumBaseCovBuilding;
    protected PropertyPremium propertyPremiumCatNatCovBuilding;
    protected PropertyPremium propertyPremiumIndirLossBuilding;
    protected PropertyPremium legalProtectionCovBuilding;
    protected BigDecimal sumPremiumsBuildingWithTax;
    protected BigDecimal sumPremiumsBuildingNoTax;

    protected PropertyPremium propertyPremiumBaseCovContent;
    protected PropertyPremium propertyPremiumTheftCov;
    protected PropertyPremium propertyPremiumCatNatCovContent;
    protected PropertyPremium propertyPremiumIndirLossContent;
    protected PropertyPremium legalProtectionCovContent;
    protected BigDecimal sumPremiumsContentWithTax;
    protected BigDecimal sumPremiumsContentNoTax;

    protected PropertyPremium propertyPremiumMerchDamageCov;

    protected PropertyPremium propertyPremiumValuesCoverage;
    protected BigDecimal sumPremiumsWithTax;
    protected BigDecimal sumPremiumsNoTax;

    protected BigDecimal sumValuesWithTax;
    protected BigDecimal sumValuesNoTax;

    protected PropertyPremium propertyPremiumCommUnemployRevenue;
    protected PropertyPremium propertyPremiumCommUnemployDaily;
    protected BigDecimal sumComUnemploWithTax;
    protected BigDecimal sumComUnemploNoTax;

    protected LiabilityPremium liabilityPremium;
    protected LiabilityPremium liabilityPremiumPropInCare;
    protected LiabilityPremium liabilityPremiumAfterDelivery;
    protected LiabilityPremium liabilityPremiumLegalProtection;
    protected LiabilityPremium liabilityPremiumObjectiveLiability;

    protected BigDecimal sumLiabilityBA_NoTax;
    protected BigDecimal sumLiabilityBA_WithTax;
    protected BigDecimal sumLiability_NoTax;
    protected BigDecimal sumLiability_WithTax;
    protected BigDecimal totaalLiability_NoTax;
    protected BigDecimal totaalLiability_WithTaks;

    protected AccidentPremium premiumEmployeeOther;
    protected AccidentPremium premiumEmployeeStudent;
    protected AccidentPremium premiumWorkerOther;
    protected AccidentPremium premiumWorkerStudent;
    protected AccidentPremium accidentPremiumForBeneficiary;
    protected AccidentPremium accidentPremiumForBeneficiary2;

    protected BigDecimal totalFeeNoTaxEmployee;
    protected BigDecimal totalFeeWithTaxEmployee;
    protected BigDecimal totalFeeNoTaxWorker;
    protected BigDecimal totalFeeWithTaxWorker;

    protected BigDecimal totaalWettelijkeWaarborgNoTax;
    protected BigDecimal totaalWettelijkeWaarborgWithTax;

    protected BigDecimal sumFeeNoTaxBeneficiaries;
    protected BigDecimal sumFeeWithTaxBeneficiaries;

    protected BigDecimal accidentsTotaalNoTax;
    protected BigDecimal accidentsTotaalWithTax;

    protected BigDecimal totalAllProductsNoTax = BigDecimal.ZERO;
    protected BigDecimal totalAllProductsWithTax = BigDecimal.ZERO;

    protected void initPremiumValues() {
        totalAllProductsNoTax = BigDecimal.ZERO;
        totalAllProductsWithTax = BigDecimal.ZERO;
        initPropertyPremiumValues();
        initLiabilityPremiumValues();
        initAccidentsPremiumValues();

        totalAllProductsNoTax = totalAllProductsNoTax.add(sumPremiumsNoTax);
        totalAllProductsNoTax = totalAllProductsNoTax.add(this.sumValuesNoTax);
        totalAllProductsNoTax = totalAllProductsNoTax.add(this.sumComUnemploNoTax);
        totalAllProductsNoTax = totalAllProductsNoTax.add(sumLiabilityBA_NoTax);
        totalAllProductsNoTax = totalAllProductsNoTax
                .add(liabilityPremiumLegalProtection != null ? liabilityPremiumLegalProtection.getFeeNoTax()
                        : BigDecimal.ZERO);
        totalAllProductsNoTax = totalAllProductsNoTax
                .add(liabilityPremiumObjectiveLiability != null ? liabilityPremiumObjectiveLiability.getFeeNoTax()
                        : BigDecimal.ZERO);
        totalAllProductsNoTax = totalAllProductsNoTax.add(totaalWettelijkeWaarborgNoTax);
        totalAllProductsNoTax = totalAllProductsNoTax.add(sumFeeNoTaxBeneficiaries);

        totalAllProductsWithTax = totalAllProductsWithTax.add(sumPremiumsWithTax);
        totalAllProductsWithTax = totalAllProductsWithTax.add(this.sumValuesWithTax);
        totalAllProductsWithTax = totalAllProductsWithTax.add(this.sumComUnemploWithTax);
        totalAllProductsWithTax = totalAllProductsWithTax.add(sumLiabilityBA_WithTax);
        totalAllProductsWithTax = totalAllProductsWithTax
                .add(liabilityPremiumLegalProtection != null ? liabilityPremiumLegalProtection.getFeeWithTax()
                        : BigDecimal.ZERO);
        totalAllProductsWithTax = totalAllProductsWithTax
                .add(liabilityPremiumObjectiveLiability != null ? liabilityPremiumObjectiveLiability.getFeeWithTax()
                        : BigDecimal.ZERO);
        totalAllProductsWithTax = totalAllProductsWithTax.add(totaalWettelijkeWaarborgWithTax);
        totalAllProductsWithTax = totalAllProductsWithTax.add(sumFeeWithTaxBeneficiaries);
    }

    private void initAccidentsPremiumValues() {
        totalFeeNoTaxWorker = BigDecimal.ZERO;
        totalFeeWithTaxWorker = BigDecimal.ZERO;
        totaalWettelijkeWaarborgNoTax = BigDecimal.ZERO;
        totaalWettelijkeWaarborgWithTax = BigDecimal.ZERO;
        sumFeeNoTaxBeneficiaries = BigDecimal.ZERO;
        sumFeeWithTaxBeneficiaries = BigDecimal.ZERO;
        accidentsTotaalNoTax = BigDecimal.ZERO;
        accidentsTotaalWithTax = BigDecimal.ZERO;

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getAccidents() != null) {
            premiumEmployeeOther = proposalPdfData.getAccidentPremiumByType(AccidentsPremiumType.EMPLOYEE_STUDENT);
            premiumEmployeeStudent = proposalPdfData.getAccidentPremiumByType(AccidentsPremiumType.EMPLOYEE_OTHER);

            totalFeeNoTaxEmployee = premiumEmployeeOther.getFeeNoTax().add(premiumEmployeeStudent.getFeeNoTax());
            totalFeeWithTaxEmployee = premiumEmployeeOther.getFeeWithTax().add(premiumEmployeeStudent.getFeeWithTax());

            premiumWorkerOther = proposalPdfData.getAccidentPremiumByType(AccidentsPremiumType.WORKER_OTHER);
            premiumWorkerStudent = proposalPdfData.getAccidentPremiumByType(AccidentsPremiumType.WORKER_STUDENT);

            totalFeeNoTaxWorker = premiumWorkerOther.getFeeNoTax().add(premiumWorkerStudent.getFeeNoTax());
            totalFeeWithTaxWorker = premiumWorkerOther.getFeeWithTax().add(premiumWorkerStudent.getFeeWithTax());

            totaalWettelijkeWaarborgNoTax = totalFeeNoTaxEmployee.add(totalFeeNoTaxWorker);
            totaalWettelijkeWaarborgWithTax = totalFeeWithTaxEmployee.add(totalFeeWithTaxWorker);

            accidentPremiumForBeneficiary = proposalPdfData
                    .getAccidentPremiumByType(AccidentsPremiumType.BENEFICIARY_2424);
            accidentPremiumForBeneficiary2 = proposalPdfData
                    .getAccidentPremiumByType(AccidentsPremiumType.BENEFICIARY2_2424);

            if (accidentPremiumForBeneficiary != null) {
                sumFeeNoTaxBeneficiaries = sumFeeNoTaxBeneficiaries.add(accidentPremiumForBeneficiary.getFeeNoTax());
                sumFeeWithTaxBeneficiaries = sumFeeWithTaxBeneficiaries
                        .add(accidentPremiumForBeneficiary.getFeeWithTax());
            }
            if (accidentPremiumForBeneficiary2 != null) {
                sumFeeNoTaxBeneficiaries = sumFeeNoTaxBeneficiaries.add(accidentPremiumForBeneficiary2.getFeeNoTax());
                sumFeeWithTaxBeneficiaries = sumFeeWithTaxBeneficiaries
                        .add(accidentPremiumForBeneficiary2.getFeeWithTax());
            }

            accidentsTotaalNoTax = sumFeeNoTaxBeneficiaries.add(totaalWettelijkeWaarborgNoTax);
            accidentsTotaalWithTax = sumFeeWithTaxBeneficiaries.add(totaalWettelijkeWaarborgWithTax);
        }
    }

    private void initLiabilityPremiumValues() {
        sumLiabilityBA_NoTax = BigDecimal.ZERO;
        sumLiabilityBA_WithTax = BigDecimal.ZERO;

        sumLiability_NoTax = BigDecimal.ZERO;
        sumLiability_WithTax = BigDecimal.ZERO;

        totaalLiability_NoTax = BigDecimal.ZERO;
        totaalLiability_WithTaks = BigDecimal.ZERO;

        liabilityPremium = proposalPdfData.getLiabilityPremiumByType(LiabilityPremiumType.PUBLIC_LIABILITY_OPERATIONS);
        liabilityPremiumPropInCare = proposalPdfData
                .getLiabilityPremiumByType(LiabilityPremiumType.PUBLIC_LIABILITY_PROPERTY_IN_CARE);
        liabilityPremiumAfterDelivery = proposalPdfData
                .getLiabilityPremiumByType(LiabilityPremiumType.PUBLIC_COVERAGE_AFTER_DELIVERY);
        liabilityPremiumLegalProtection = proposalPdfData
                .getLiabilityPremiumByType(LiabilityPremiumType.LEGAL_PROTECTION_BASE_PREMIUM);
        liabilityPremiumObjectiveLiability = proposalPdfData
                .getLiabilityPremiumByType(LiabilityPremiumType.OBJECTIVE_LIABILITY);

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability() != null) {
            sumLiabilityBA_NoTax = liabilityPremium.getFeeNoTax().add(liabilityPremiumPropInCare.getFeeNoTax())
                    .add(liabilityPremiumAfterDelivery.getFeeNoTax());
            sumLiabilityBA_WithTax = liabilityPremium.getFeeWithTax().add(liabilityPremiumPropInCare.getFeeWithTax())
                    .add(liabilityPremiumAfterDelivery.getFeeWithTax());

            sumLiability_NoTax = sumLiabilityBA_NoTax.add(liabilityPremiumLegalProtection.getFeeNoTax());
            sumLiability_WithTax = sumLiabilityBA_WithTax.add(liabilityPremiumLegalProtection.getFeeWithTax());

            if (liabilityPremiumObjectiveLiability != null) {
                totaalLiability_NoTax = liabilityPremiumObjectiveLiability.getFeeNoTax().add(sumLiability_NoTax);
                totaalLiability_WithTaks = liabilityPremiumObjectiveLiability.getFeeWithTax().add(sumLiability_WithTax);
            }
        }
    }

    private void initPropertyPremiumValues() {
        sumValuesWithTax = BigDecimal.ZERO;
        sumValuesNoTax = BigDecimal.ZERO;

        sumComUnemploWithTax = BigDecimal.ZERO;
        sumComUnemploNoTax = BigDecimal.ZERO;

        sumPremiumsBuildingWithTax = BigDecimal.ZERO;
        sumPremiumsBuildingNoTax = BigDecimal.ZERO;
        sumPremiumsContentWithTax = BigDecimal.ZERO;
        sumPremiumsContentNoTax = BigDecimal.ZERO;
        sumPremiumsWithTax = BigDecimal.ZERO;
        sumPremiumsNoTax = BigDecimal.ZERO;
        sumValuesWithTax = BigDecimal.ZERO;
        sumValuesNoTax = BigDecimal.ZERO;

        sumComUnemploWithTax = BigDecimal.ZERO;
        sumComUnemploNoTax = BigDecimal.ZERO;

        if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null) {

            propertyPremiumBaseCovBuilding = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.BASE_COVERAGES_BUILDING);
            propertyPremiumCatNatCovBuilding = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.CATNAT_COVERAGE_BUILDING);
            propertyPremiumIndirLossBuilding = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.INDIRECT_LOSS_BUILDING);
            legalProtectionCovBuilding = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.LEGAL_PROTECTION_COVERAGE_BUILDING);
            sumPremiumsBuildingWithTax = propertyPremiumBaseCovBuilding.getFeeWithTax()
                    .add(propertyPremiumCatNatCovBuilding.getFeeWithTax());

            if (propertyPremiumIndirLossBuilding != null
                    && proposalPdfData.getProposalInput().getData().getInsuranceAnswers() != null
                    && proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null
                    && proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
                            .getBuildingIndirectLoss()) {
                sumPremiumsBuildingWithTax = sumPremiumsBuildingWithTax
                        .add(propertyPremiumIndirLossBuilding.getFeeWithTax());
            }

            if (legalProtectionCovBuilding != null
                    && proposalPdfData.getProposalInput().getData().getInsuranceAnswers() != null
                    && proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null
                    && proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
                            .getBuildingLegalProtection()) {
                sumPremiumsBuildingWithTax = sumPremiumsBuildingWithTax.add(legalProtectionCovBuilding.getFeeWithTax());
            }
            sumPremiumsBuildingNoTax = propertyPremiumBaseCovBuilding.getFeeNoTax()
                    .add(propertyPremiumCatNatCovBuilding.getFeeNoTax());

            if (propertyPremiumIndirLossBuilding != null && proposalPdfData.getProposalInput().getData()
                    .getInsuranceAnswers().getProperty().getPremiums().getBuildingIndirectLoss()) {
                sumPremiumsBuildingNoTax = sumPremiumsBuildingNoTax.add(propertyPremiumIndirLossBuilding.getFeeNoTax());
            }

            if (legalProtectionCovBuilding != null && proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getProperty().getPremiums().getBuildingLegalProtection()) {
                sumPremiumsBuildingNoTax = sumPremiumsBuildingNoTax.add(legalProtectionCovBuilding.getFeeNoTax());
            }

            propertyPremiumBaseCovContent = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.BASE_COVERAGES_CONTENT);
            propertyPremiumCatNatCovContent = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.CATNAT_COVERAGE_CONTENT);

            propertyPremiumTheftCov = proposalPdfData.getPropertyPremiumByType(PropertyPremiumType.THEFT_COVERAGE);
            propertyPremiumIndirLossContent = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.INDIRECT_LOSS_CONTENT);
            legalProtectionCovContent = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.LEGAL_PROTECTION_COVERAGE_CONTENT);

            sumPremiumsContentWithTax = propertyPremiumBaseCovContent.getFeeWithTax()
                    .add(propertyPremiumCatNatCovContent.getFeeWithTax());
            sumPremiumsContentNoTax = propertyPremiumBaseCovContent.getFeeNoTax()
                    .add(propertyPremiumCatNatCovContent.getFeeNoTax());

            if (propertyPremiumTheftCov != null && proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getProperty().getPremiums().getContentsTheft()) {
                sumPremiumsContentWithTax = sumPremiumsContentWithTax.add(propertyPremiumTheftCov.getFeeWithTax());
                sumPremiumsContentNoTax = sumPremiumsContentNoTax.add(propertyPremiumTheftCov.getFeeNoTax());
            }

            if (propertyPremiumIndirLossContent != null && proposalPdfData.getProposalInput().getData()
                    .getInsuranceAnswers().getProperty().getPremiums().getContentsIndirectLoss()) {
                sumPremiumsContentWithTax = sumPremiumsContentWithTax
                        .add(propertyPremiumIndirLossContent.getFeeWithTax());
                sumPremiumsContentNoTax = sumPremiumsContentNoTax.add(propertyPremiumIndirLossContent.getFeeNoTax());
            }

            if (legalProtectionCovContent != null && proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                    .getProperty().getPremiums().getContentsLegalProtection()) {
                sumPremiumsContentWithTax = sumPremiumsContentWithTax.add(legalProtectionCovContent.getFeeWithTax());
                sumPremiumsContentNoTax = sumPremiumsContentNoTax.add(legalProtectionCovContent.getFeeNoTax());
            }

            propertyPremiumMerchDamageCov = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.MERCHANDISE_DAMAGES_COVERAGE);

            sumPremiumsWithTax = sumPremiumsBuildingWithTax.add(sumPremiumsContentWithTax);
            sumPremiumsNoTax = sumPremiumsBuildingNoTax.add(sumPremiumsContentNoTax);

            if (propertyPremiumMerchDamageCov != null && proposalPdfData.getProposalInput().getData()
                    .getInsuranceAnswers().getProperty().getPremiums().getAccidentalDamage()) {
                sumPremiumsWithTax = sumPremiumsWithTax.add(propertyPremiumMerchDamageCov.getFeeWithTax());
                sumPremiumsNoTax = sumPremiumsNoTax.add(propertyPremiumMerchDamageCov.getFeeNoTax());
            }

            propertyPremiumValuesCoverage = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.VALUES_COVERAGE);
            if (propertyPremiumValuesCoverage != null && proposalPdfData.getProposalInput().getData()
                    .getInsuranceAnswers().getProperty().getPremiums().getValues()) {
                sumValuesWithTax = propertyPremiumValuesCoverage.getFeeWithTax();
                sumValuesNoTax = propertyPremiumValuesCoverage.getFeeNoTax();
            }

            propertyPremiumCommUnemployRevenue = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.COMMERCIAL_UNEMPLOYMENT_COVERAGE_REVENUE);
            propertyPremiumCommUnemployDaily = proposalPdfData
                    .getPropertyPremiumByType(PropertyPremiumType.COMMERCIAL_UNEMPLOYMENT_COVERAGE_DAILY);

            if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
                    .getCommercialUnemployment()) {
                if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty()
                        .getCommercialUnemployment().getFormula().equals(CommercialUnemploymentFormula.DAILY)) {
                    sumComUnemploWithTax = propertyPremiumCommUnemployDaily.getFeeWithTax();
                    sumComUnemploNoTax = propertyPremiumCommUnemployDaily.getFeeNoTax();
                } else {
                    sumComUnemploWithTax = propertyPremiumCommUnemployRevenue.getFeeWithTax();
                    sumComUnemploNoTax = propertyPremiumCommUnemployRevenue.getFeeNoTax();
                }
            }
        }
    }

    public BigDecimal getTotalWithTax() {
        BigDecimal result = BigDecimal.ZERO;

        if (sumPremiumsWithTax != null) {
            result = result.add(sumPremiumsWithTax);
        }

        if (sumValuesWithTax != null) {
            result = result.add(sumValuesWithTax);
        }

        if (sumComUnemploWithTax != null) {
            result = result.add(sumComUnemploWithTax);
        }

        return result;
    }

    public BigDecimal getTotalNoTax() {
        BigDecimal result = BigDecimal.ZERO;

        if (sumPremiumsNoTax != null) {
            result = result.add(sumPremiumsNoTax);
        }

        if (sumValuesNoTax != null) {
            result = result.add(sumValuesNoTax);
        }

        if (sumComUnemploNoTax != null) {
            result = result.add(sumComUnemploNoTax);
        }
        return result;
    }
}
