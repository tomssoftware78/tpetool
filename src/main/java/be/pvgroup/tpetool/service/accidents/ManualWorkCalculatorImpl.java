package be.pvgroup.tpetool.service.accidents;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.accidents.Beneficiary;
import be.pvgroup.tpetool.util.arbeidsongevallen.BasePremiumArbeidsOngevallen;
import be.pvgroup.tpetool.util.arbeidsongevallen.ParametersArbeidsOngevallen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static be.pvgroup.tpetool.util.CalculationUtils.HUNDRED;

@Component
public class ManualWorkCalculatorImpl implements ManualWorkCalculator {

    Logger logger = LoggerFactory.getLogger(ManualWorkCalculatorImpl.class);

    BigDecimal rpArbeiders_BediendenMetHandenarbeid_Verkopers;
    BigDecimal rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten;
    BigDecimal threshold;
    BigDecimal rpBediendenMetBuitenOpdracht;

    BigDecimal rp;
    BigDecimal ct;
    BigDecimal priv;
    BigDecimal rate;
    BigDecimal feeNoTax;
    BigDecimal tax;
    BigDecimal feeWithTax;
    BigDecimal rpBediendenBuitenOpdracht;


    public AccidentPremium calculatePremium(Beneficiary beneficiary, String nacebel) {
        AccidentPremium result = null;



        if (beneficiary != null &&
                (beneficiary.getManualWork() != null
                        && !beneficiary.getManualWork().equals(""))) {
            logger.debug("Do manual calculation for beneficiary : " + beneficiary.toString());

            initValues();

            if (beneficiary.getManualWork().equals("manual")) {
                logger.debug("Calculate manual work");

                rp = new BigDecimal(0.66);
                ct = ParametersArbeidsOngevallen.CT_Employee;

                priv = ParametersArbeidsOngevallen.PrivateAcc_Law_woDelay;

                rate = rp.add(ct).divide(new BigDecimal(1.15), 4, RoundingMode.HALF_UP).add(priv);
                rate = rate.round(new MathContext(4));
                rate = rate.multiply(ParametersArbeidsOngevallen.twentyfour_Multiplicateur_factor);

                feeNoTax = (rate.multiply(beneficiary.getSalary()).divide(HUNDRED));
                feeNoTax = feeNoTax.setScale(4, RoundingMode.HALF_UP);


                tax = ParametersArbeidsOngevallen.twentyfour_Tax;
                feeWithTax = feeNoTax.multiply((BigDecimal.ONE.add(tax)));

                logger.debug("rp: " + rp);
                logger.debug("ct: " + ct);

                logger.debug("priv: " + priv);

                logger.debug("rate: " + rate);
                logger.debug("feeNoTax: " + feeNoTax);
                logger.debug("feeWithTax: " + feeWithTax);

                result = new AccidentPremium(
                        "",
                        rate.setScale(4, RoundingMode.HALF_UP),
                        feeNoTax.setScale(4, RoundingMode.HALF_UP),
                        feeWithTax.setScale(4, RoundingMode.HALF_UP));

            } else if (beneficiary.getManualWork().equals("no-manual")) {
                logger.debug("Calculate no manual work");

                rpArbeiders_BediendenMetHandenarbeid_Verkopers = BasePremiumArbeidsOngevallen.rpArbeidersMap.get(nacebel);
                rpBediendenBuitenOpdracht = BasePremiumArbeidsOngevallen.rpMedewerkersMetMissieMap.get(nacebel);
                rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten = ParametersArbeidsOngevallen.RP_Employee;
                threshold = ParametersArbeidsOngevallen.twentyfour_RP_threshold;
                rpBediendenMetBuitenOpdracht = BasePremiumArbeidsOngevallen.rpMedewerkersMetMissieMap.get(nacebel);


                if (threshold.multiply(rpArbeiders_BediendenMetHandenarbeid_Verkopers).compareTo(rpBediendenBuitenOpdracht) < 0) {
                    rp = threshold.multiply(rpArbeiders_BediendenMetHandenarbeid_Verkopers);
                } else {
                    rp = rpBediendenMetBuitenOpdracht;
                }

                logger.debug("rpArbeiders_BediendenMetHandenarbeid_Verkopers: " + rpArbeiders_BediendenMetHandenarbeid_Verkopers);
                logger.debug("rpBediendenBuitenOpdracht123: " + rpBediendenBuitenOpdracht);
                logger.debug("rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten: " + rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten);
                logger.debug("threshold: " + threshold);
                logger.debug("rp: " + rp);

                ct = ParametersArbeidsOngevallen.CT_Employee;

                priv = ParametersArbeidsOngevallen.PrivateAcc_Law_woDelay;


                rate = rp.add(ct).divide(new BigDecimal(1.15), 4, RoundingMode.HALF_UP).add(priv);
                rate = rate.round(new MathContext(4));
                rate = rate.multiply(ParametersArbeidsOngevallen.twentyfour_Multiplicateur_factor);

                feeNoTax = (rate.multiply(beneficiary.getSalary()).divide(HUNDRED));
                feeNoTax = feeNoTax.setScale(4, RoundingMode.HALF_UP);


                tax = ParametersArbeidsOngevallen.twentyfour_Tax;
                feeWithTax = feeNoTax.multiply((BigDecimal.ONE.add(tax)));

                logger.debug("ct: " + ct);
                logger.debug("priv: " + priv);

                logger.debug("rate: " + rate);
                logger.debug("feeNoTax: " + feeNoTax);
                logger.debug("feeWithTax: " + feeWithTax);

                result = new AccidentPremium(
                        "",
                        rate.setScale(4, RoundingMode.HALF_UP),
                        feeNoTax.setScale(4, RoundingMode.HALF_UP),
                        feeWithTax.setScale(4, RoundingMode.HALF_UP));
            }
        } else {
            logger.debug("No manual calculation possible for beneficiary : " + (beneficiary == null ? "beneficiary is null" : beneficiary.toString()));
            if (beneficiary != null) {
                logger.debug("\tprobably no appropriate input for beneficiary.getManualWork()");
            }
        }

        return result;
    }

    private void initValues() {
        logger.debug("Init values before starting to calculate");
        rpArbeiders_BediendenMetHandenarbeid_Verkopers = BigDecimal.ZERO;
        rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten = BigDecimal.ZERO;
        threshold = BigDecimal.ZERO;
        rpBediendenMetBuitenOpdracht = BigDecimal.ZERO;

        rp = BigDecimal.ZERO;
        ct = BigDecimal.ZERO;
        priv = BigDecimal.ZERO;
        rate = BigDecimal.ZERO;
        feeNoTax = BigDecimal.ZERO;
        tax = BigDecimal.ZERO;
        feeWithTax = BigDecimal.ZERO;
        rpBediendenBuitenOpdracht = BigDecimal.ZERO;
    }
}
