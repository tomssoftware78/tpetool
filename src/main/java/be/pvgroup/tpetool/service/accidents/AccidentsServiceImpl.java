package be.pvgroup.tpetool.service.accidents;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.accidents.AccidentsInput;
import be.pvgroup.tpetool.util.arbeidsongevallen.AccidentsPremiumType;
import be.pvgroup.tpetool.util.arbeidsongevallen.BasePremiumArbeidsOngevallen;
import be.pvgroup.tpetool.util.arbeidsongevallen.ParametersArbeidsOngevallen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccidentsServiceImpl implements AccidentsService {

    Logger logger = LoggerFactory.getLogger(AccidentsServiceImpl.class);

    BigDecimal rpArbeiders_BediendenMetHandenarbeid_Verkopers;
    BigDecimal rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten;
    BigDecimal ctAdminBedienden_BediendenMetOccasioneleBuitenopdrachten;
    BigDecimal rpBedienden;
    BigDecimal rpArbeiders;
    BigDecimal ctBedienden;
    BigDecimal ctArbeiders;
    BigDecimal rateLawBedienden;
    BigDecimal rateLawArbeiders;

    BigDecimal feeAdministratieveBedienden_Other_NoTax = BigDecimal.ZERO;
    BigDecimal feeAdministratieveBedienden_Other_WithTax = BigDecimal.ZERO;
    BigDecimal feeAdministratieveBedienden_Student_NoTax = BigDecimal.ZERO;
    BigDecimal feeAdministratieveBedienden_Student_WithTax = BigDecimal.ZERO;
    BigDecimal feeArbeiders_Other_NoTax = BigDecimal.ZERO;
    BigDecimal feeArbeiders_Other_WithTax = BigDecimal.ZERO;
    BigDecimal feeArbeiders_Student_NoTax = BigDecimal.ZERO;
    BigDecimal feeArbeiders_Student_WithTax = BigDecimal.ZERO;

    @Autowired
    private ManualWorkCalculator manualWorkCalculator;

    public AccidentsServiceImpl(ManualWorkCalculator manualWorkCalculator) {
        this.manualWorkCalculator = manualWorkCalculator;
    }

    @Override
    public List<AccidentPremium> calculate(AccidentsInput accidentsInput) {
        logger.debug("=============================================================================");
        logger.debug("Start calculation for Accidents");
        logger.debug("\t with input: " + accidentsInput);

        initValues();

        rpArbeiders_BediendenMetHandenarbeid_Verkopers = BasePremiumArbeidsOngevallen.rpArbeidersMap.get(accidentsInput.getData().getNacebel());
        rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten = ParametersArbeidsOngevallen.RP_Employee;
        ctAdminBedienden_BediendenMetOccasioneleBuitenopdrachten = ParametersArbeidsOngevallen.CT_Employee;

        ctArbeiders = ParametersArbeidsOngevallen.CT_Worker;;

        logger.debug("");
        logger.debug("");
        logger.debug("rpArbeiders_BediendenMetHandenarbeid_Verkopers: " + rpArbeiders_BediendenMetHandenarbeid_Verkopers);
        logger.debug("ctArbeiders: " + ctArbeiders);
        logger.debug("rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten: " + rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten);
        logger.debug("ctAdminBedienden_BediendenMetOccasioneleBuitenopdrachten: " + ctAdminBedienden_BediendenMetOccasioneleBuitenopdrachten);


        rpBedienden = ParametersArbeidsOngevallen.RP_Employee;;
        rpArbeiders = BasePremiumArbeidsOngevallen.rpArbeidersMap.get(accidentsInput.getData().getNacebel());;
        ctBedienden = ParametersArbeidsOngevallen.CT_Employee;

        rateLawBedienden = rpBedienden.add(ctBedienden);
        rateLawArbeiders = rpArbeiders.add(ctArbeiders);

        logger.debug("");
        logger.debug("rpBedienden: " + rpBedienden);
        logger.debug("rpArbeiders: " + rpArbeiders);
        logger.debug("ctBedienden: " + ctBedienden);
        logger.debug("ctArbeiders: " + ctArbeiders);
        logger.debug("rateLawBedienden: " + rateLawBedienden);
        logger.debug("rateLawArbeiders: " + rateLawArbeiders);

        BigDecimal HUNDRED = new BigDecimal(100);

        if (accidentsInput.getData().getAnswers().getPayroll().getEmployeeWage() != null
                && accidentsInput.getData().getAnswers().getPayroll().getEmployeeWage().compareTo(BigDecimal.ZERO) > 0) {
            feeAdministratieveBedienden_Other_NoTax = rateLawBedienden
                    .multiply(accidentsInput.getData().getAnswers().getPayroll().getEmployeeWage())
                    .divide(HUNDRED);
            feeAdministratieveBedienden_Other_WithTax = feeAdministratieveBedienden_Other_NoTax
                    .multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_other));
        }

        if (accidentsInput.getData().getAnswers().getPayroll().getEmployeeWageStudent() != null
                && accidentsInput.getData().getAnswers().getPayroll().getEmployeeWageStudent().compareTo(BigDecimal.ZERO) > 0) {
            feeAdministratieveBedienden_Student_NoTax = rateLawBedienden
                    .multiply(accidentsInput.getData().getAnswers().getPayroll().getEmployeeWageStudent())
                    .divide(HUNDRED);
            feeAdministratieveBedienden_Student_WithTax = feeAdministratieveBedienden_Student_NoTax
                    .multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_student));
        }

        if (accidentsInput.getData().getAnswers().getPayroll().getWorkerWage() != null
                && accidentsInput.getData().getAnswers().getPayroll().getWorkerWage().compareTo(BigDecimal.ZERO) > 0) {
            feeArbeiders_Other_NoTax = rateLawArbeiders
                    .multiply(accidentsInput.getData().getAnswers().getPayroll().getWorkerWage())
                    .divide(HUNDRED);
            feeArbeiders_Other_WithTax = feeArbeiders_Other_NoTax
                    .multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_other));
        }

        if (accidentsInput.getData().getAnswers().getPayroll().getWorkerWageStudent() != null
                && accidentsInput.getData().getAnswers().getPayroll().getWorkerWageStudent().compareTo(BigDecimal.ZERO) > 0) {
            feeArbeiders_Student_NoTax = rateLawArbeiders
                    .multiply(accidentsInput.getData().getAnswers().getPayroll().getWorkerWageStudent())
                    .divide(HUNDRED);
            feeArbeiders_Student_WithTax = feeArbeiders_Student_NoTax
                    .multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_student));
        }

        logger.debug("");
        logger.debug("feeAdministratieveBedienden_Other_NoTax: " + feeAdministratieveBedienden_Other_NoTax);
        logger.debug("feeAdministratieveBedienden_Student_NoTax: " + feeAdministratieveBedienden_Student_NoTax);
        logger.debug("feeArbeiders_Other_NoTax: " + feeArbeiders_Other_NoTax);
        logger.debug("feeArbeiders_Student_NoTax: " + feeArbeiders_Student_NoTax);
        logger.debug("feeAdministratieveBedienden_Other_WithTax: " + feeAdministratieveBedienden_Other_WithTax);
        logger.debug("feeAdministratieveBedienden_Student_WithTax: " + feeAdministratieveBedienden_Student_WithTax);
        logger.debug("feeArbeiders_Other_WithTax: " + feeArbeiders_Other_WithTax);
        logger.debug("feeArbeiders_Student_WithTax: " + feeArbeiders_Student_WithTax);



        AccidentPremium accidentPremiumBeneficiary1 = manualWorkCalculator.calculatePremium(
                accidentsInput.getData().getAnswers().getBeneficiary(),
                accidentsInput.getData().getNacebel());
        AccidentPremium accidentPremiumBeneficiary2 = manualWorkCalculator.calculatePremium(
                accidentsInput.getData().getAnswers().getBeneficiary2(),
                accidentsInput.getData().getNacebel());

        AccidentPremium premiumEmployeeOther = new AccidentPremium(
                AccidentsPremiumType.EMPLOYEE_OTHER.label,
                rateLawBedienden.setScale(4, RoundingMode.HALF_UP),
                feeAdministratieveBedienden_Other_NoTax.setScale(4, RoundingMode.HALF_UP),
                feeAdministratieveBedienden_Other_WithTax.setScale(4, RoundingMode.HALF_UP));

        AccidentPremium premiumEmployeeStudent = new AccidentPremium(
                AccidentsPremiumType.EMPLOYEE_STUDENT.label,
                rateLawBedienden.setScale(4, RoundingMode.HALF_UP),
                feeAdministratieveBedienden_Student_NoTax.setScale(4, RoundingMode.HALF_UP),
                feeAdministratieveBedienden_Student_WithTax.setScale(4, RoundingMode.HALF_UP));

        AccidentPremium premiumWorkerOther = new AccidentPremium(
                AccidentsPremiumType.WORKER_OTHER.label,
                rateLawArbeiders.setScale(4, RoundingMode.HALF_UP),
                feeArbeiders_Other_NoTax.setScale(4, RoundingMode.HALF_UP),
                feeArbeiders_Other_WithTax.setScale(4, RoundingMode.HALF_UP));

        AccidentPremium premiumWorkerStudent = new AccidentPremium(
                AccidentsPremiumType.WORKER_STUDENT.label,
                rateLawArbeiders.setScale(4, RoundingMode.HALF_UP),
                feeArbeiders_Student_NoTax.setScale(4, RoundingMode.HALF_UP),
                feeArbeiders_Student_WithTax.setScale(4, RoundingMode.HALF_UP));

        List<AccidentPremium> accidentPremiums = new ArrayList<AccidentPremium>();
        accidentPremiums.add(premiumEmployeeOther);
        accidentPremiums.add(premiumEmployeeStudent);
        accidentPremiums.add(premiumWorkerOther);
        accidentPremiums.add(premiumWorkerStudent);

        if (accidentPremiumBeneficiary1 != null) {
            accidentPremiumBeneficiary1.setCode(AccidentsPremiumType.BENEFICIARY_2424.label);
            accidentPremiums.add(accidentPremiumBeneficiary1);
        }
        if (accidentPremiumBeneficiary2 != null) {
            accidentPremiumBeneficiary2.setCode(AccidentsPremiumType.BENEFICIARY2_2424.label);
            accidentPremiums.add(accidentPremiumBeneficiary2);
        }

        logger.debug("");
        logger.debug("");
        logger.debug("");
        logger.debug("Premiums: " + accidentPremiums);
        logger.debug("End calculation for Accidents");
        logger.debug("=============================================================================");
        return accidentPremiums;
    }


    private void initValues() {
        logger.debug("Init values before starting to calculate");
        rpArbeiders_BediendenMetHandenarbeid_Verkopers = BigDecimal.ZERO;
        rpAdminBedienden_BediendenMetOccasioneleBuitenopdrachten = BigDecimal.ZERO;
        ctAdminBedienden_BediendenMetOccasioneleBuitenopdrachten = BigDecimal.ZERO;
        rpBedienden = BigDecimal.ZERO;
        rpArbeiders = BigDecimal.ZERO;
        ctBedienden = BigDecimal.ZERO;
        ctArbeiders = BigDecimal.ZERO;
        rateLawBedienden = BigDecimal.ZERO;
        rateLawArbeiders = BigDecimal.ZERO;

        feeAdministratieveBedienden_Other_NoTax = BigDecimal.ZERO;
        feeAdministratieveBedienden_Other_WithTax = BigDecimal.ZERO;
        feeAdministratieveBedienden_Student_NoTax = BigDecimal.ZERO;
        feeAdministratieveBedienden_Student_WithTax = BigDecimal.ZERO;
        feeArbeiders_Other_NoTax = BigDecimal.ZERO;
        feeArbeiders_Other_WithTax = BigDecimal.ZERO;
        feeArbeiders_Student_NoTax = BigDecimal.ZERO;
        feeArbeiders_Student_WithTax = BigDecimal.ZERO;
    }
}
