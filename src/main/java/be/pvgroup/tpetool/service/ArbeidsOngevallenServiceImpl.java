package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.ArbeidsOngevallenInput;
import be.pvgroup.tpetool.model.Premie;
import be.pvgroup.tpetool.util.arbeidsongevallen.BasePremiumArbeidsOngevallen;
import be.pvgroup.tpetool.util.CalculationUtils;
import be.pvgroup.tpetool.util.arbeidsongevallen.ParametersArbeidsOngevallen;
import be.pvgroup.tpetool.util.arbeidsongevallen.ParametersLookupTableArbeidsOngevallen;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static be.pvgroup.tpetool.util.arbeidsongevallen.Constants.*;

@Component
public class ArbeidsOngevallenServiceImpl implements ArbeidsOngevallenService {

    public static final String NO_MANUAL_WORK = "24-24_NoManualWork";
    public static final String LIMITED_MANUAL_WORK = "24-24_LimitedManualWork";
    public static final String MANUAL_WORK = "24-24_ManualWork";


    BigDecimal rpArbeidersBasePremium;
    BigDecimal rpMederwerkersMetMissieBasePremium;

    BigDecimal rpAdministratieveBedienden;
    BigDecimal ctAdministratieveBedienden;
    BigDecimal rateLawAdministratieveBedienden;


    BigDecimal rpBediendenOccasioneleBuitenOpdracht;
    BigDecimal ctBediendenOccasioneleBuitenOpdracht;
    BigDecimal rateLawBediendenOccasioneleBuitenOpdracht;

    BigDecimal rpBediendenBuitenOpdracht;
    BigDecimal ctBediendenBuitenOpdracht;
    BigDecimal rateLawBediendenBuitenOpdracht;

    BigDecimal rpBediendenMetHandenArbeid;
    BigDecimal ctBediendenMetHandenArbeid;
    BigDecimal rateLawBediendenMetHandenArbeid;

    BigDecimal rpArbeiders;
    BigDecimal ctArbeiders;
    BigDecimal rateLawArbeiders;




    //without taxes
    BigDecimal feeNoTaxAdministratieveBedienden_Other = BigDecimal.ZERO;
    BigDecimal feeNoTaxAdministratieveBedienden_Student = BigDecimal.ZERO;
    BigDecimal feeNoTaxBediendenOccasioneleBuitenopdracht_Other = BigDecimal.ZERO;
    BigDecimal feeNoTaxBediendenOccasioneleBuitenopdracht_Student = BigDecimal.ZERO;
    BigDecimal feeNoTaxBediendenBuitenOpdracht_Other = BigDecimal.ZERO;
    BigDecimal feeNoTaxBediendenBuitenOpdracht_Student = BigDecimal.ZERO;
    BigDecimal feeNoTaxBediendenMetHandenArbeid_Other = BigDecimal.ZERO;
    BigDecimal feeNoTaxBediendenMetHandenArbeid_Student = BigDecimal.ZERO;
    BigDecimal feeNoTaxArbeiders_Other = BigDecimal.ZERO;
    BigDecimal feeNoTaxArbeiders_Student = BigDecimal.ZERO;

    //with taxes
    BigDecimal feeWithTaxAdministratieveBedienden_Other = BigDecimal.ZERO;
    BigDecimal feeWithTaxAdministratieveBedienden_Student = BigDecimal.ZERO;
    BigDecimal feeWithTaxBediendenOccasioneleBuitenopdracht_Other = BigDecimal.ZERO;
    BigDecimal feeWithTaxBediendenOccasioneleBuitenopdracht_Student = BigDecimal.ZERO;
    BigDecimal feeWithTaxBediendenBuitenOpdracht_Other = BigDecimal.ZERO;
    BigDecimal feeWithTaxBediendenBuitenOpdracht_Student = BigDecimal.ZERO;
    BigDecimal feeWithTaxBediendenMetHandenArbeid_Other = BigDecimal.ZERO;
    BigDecimal feeWithTaxBediendenMetHandenArbeid_Student = BigDecimal.ZERO;
    BigDecimal feeWithTaxArbeiders_Other = BigDecimal.ZERO;
    BigDecimal feeWithTaxArbeiders_Student = BigDecimal.ZERO;


    BigDecimal rp;
    BigDecimal ct;
    BigDecimal priv;
    BigDecimal rate;
    BigDecimal feeNoTax;
    BigDecimal tax;
    BigDecimal feeWithTax;
    BigDecimal rpArbeiders_BediendenMetHandenArbeid;


    @Override
    public List<Premie> calculate(ArbeidsOngevallenInput arbeidsOngevallenInput) {
        System.out.println("Start calculation");

        initValues();

        rpArbeidersBasePremium = BasePremiumArbeidsOngevallen.rpArbeidersMap.get(arbeidsOngevallenInput.getNacebel());
        rpMederwerkersMetMissieBasePremium = BasePremiumArbeidsOngevallen.rpMedewerkersMetMissieMap.get(arbeidsOngevallenInput.getNacebel());

        rpAdministratieveBedienden = ParametersLookupTableArbeidsOngevallen.getRTPremiumForAdministrativeWorkers(
                CalculationUtils.getLawWage(arbeidsOngevallenInput));
        ctAdministratieveBedienden = ParametersLookupTableArbeidsOngevallen.getCTPremiumForAdministrativeWorkers(
                CalculationUtils.getLawWage(arbeidsOngevallenInput));
        rateLawAdministratieveBedienden = rpAdministratieveBedienden.add(ctAdministratieveBedienden);


        rpBediendenOccasioneleBuitenOpdracht = ParametersLookupTableArbeidsOngevallen.getRTPremiumForAdministrativeWorkers(
                CalculationUtils.getLawWage(arbeidsOngevallenInput));
        ctBediendenOccasioneleBuitenOpdracht = ParametersLookupTableArbeidsOngevallen.getCTPremiumForAdministrativeWorkers(
                CalculationUtils.getLawWage(arbeidsOngevallenInput));
        rateLawBediendenOccasioneleBuitenOpdracht = rpBediendenOccasioneleBuitenOpdracht.add(ctBediendenOccasioneleBuitenOpdracht);

        rpBediendenBuitenOpdracht = BasePremiumArbeidsOngevallen.rpMedewerkersMetMissieMap.get(arbeidsOngevallenInput.getNacebel());
        ctBediendenBuitenOpdracht = ParametersLookupTableArbeidsOngevallen.getCTPremiumForAdministrativeWorkers(
                CalculationUtils.getLawWage(arbeidsOngevallenInput));
        rateLawBediendenBuitenOpdracht = rpBediendenBuitenOpdracht.add(ctBediendenBuitenOpdracht);

        rpBediendenMetHandenArbeid = BasePremiumArbeidsOngevallen.rpArbeidersMap.get(arbeidsOngevallenInput.getNacebel());
        ctBediendenMetHandenArbeid = ParametersLookupTableArbeidsOngevallen.getCTPremiumForAdministrativeWorkers(
                CalculationUtils.getLawWage(arbeidsOngevallenInput));
        rateLawBediendenMetHandenArbeid = rpBediendenMetHandenArbeid.add(ctBediendenMetHandenArbeid);

        rpArbeiders = BasePremiumArbeidsOngevallen.rpArbeidersMap.get(arbeidsOngevallenInput.getNacebel());
        ctArbeiders = ParametersArbeidsOngevallen.CT_Worker;
        rateLawArbeiders = rpArbeiders.add(ctArbeiders);

        BigDecimal HUNDRED = new BigDecimal(100);

        if (arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionStudent() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionStudent().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxBediendenOccasioneleBuitenopdracht_Student =
                    (this.rpBediendenOccasioneleBuitenOpdracht.add(this.ctBediendenOccasioneleBuitenOpdracht))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionStudent()).divide(HUNDRED);
            feeNoTaxBediendenOccasioneleBuitenopdracht_Student = feeNoTaxBediendenOccasioneleBuitenopdracht_Student.setScale(4, RoundingMode.HALF_UP);
        }

        if (arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionOther() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionOther().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxBediendenOccasioneleBuitenopdracht_Other =
                    (this.rpBediendenOccasioneleBuitenOpdracht.add(this.ctBediendenOccasioneleBuitenOpdracht))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeTempExternalMissionOther()).divide(HUNDRED);
            feeNoTaxBediendenOccasioneleBuitenopdracht_Other = feeNoTaxBediendenOccasioneleBuitenopdracht_Other.setScale(4, RoundingMode.HALF_UP);
        }

        if (arbeidsOngevallenInput.getLawWageEmployeeAdminStudent() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeAdminStudent().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxAdministratieveBedienden_Student =
                    (this.rpAdministratieveBedienden.add(this.ctAdministratieveBedienden))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeAdminStudent()).divide(HUNDRED);
            feeNoTaxAdministratieveBedienden_Student = feeNoTaxAdministratieveBedienden_Student.setScale(4, RoundingMode.HALF_UP);
        }
        if (arbeidsOngevallenInput.getLawWageEmployeeAdminOther() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeAdminOther().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxAdministratieveBedienden_Other =
                    (this.rpAdministratieveBedienden.add(this.ctAdministratieveBedienden))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeAdminOther()).divide(HUNDRED);
            feeNoTaxAdministratieveBedienden_Other = feeNoTaxAdministratieveBedienden_Other.setScale(4, RoundingMode.HALF_UP);
        }
        if (arbeidsOngevallenInput.getLawWageEmployeeExternalMissionOther() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeExternalMissionOther().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxBediendenBuitenOpdracht_Other =
                    (this.rpBediendenBuitenOpdracht.add(this.ctBediendenBuitenOpdracht))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeExternalMissionOther()).divide(HUNDRED);
            feeNoTaxBediendenBuitenOpdracht_Other = feeNoTaxBediendenBuitenOpdracht_Other.setScale(4, RoundingMode.HALF_UP);

        }
        if (arbeidsOngevallenInput.getLawWageEmployeeExternalMissionStudent() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeExternalMissionStudent().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxBediendenBuitenOpdracht_Student =
                    (this.rpBediendenBuitenOpdracht.add(this.ctBediendenBuitenOpdracht))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeExternalMissionStudent()).divide(HUNDRED);
            feeNoTaxBediendenBuitenOpdracht_Student = feeNoTaxBediendenBuitenOpdracht_Student.setScale(4, RoundingMode.HALF_UP);
        }
        if (arbeidsOngevallenInput.getLawWageEmployeeManualWorkOther() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeManualWorkOther().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxBediendenMetHandenArbeid_Other =
                    (this.rpBediendenMetHandenArbeid.add(this.ctBediendenMetHandenArbeid))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeManualWorkOther()).divide(HUNDRED);
            feeNoTaxBediendenMetHandenArbeid_Other = feeNoTaxBediendenMetHandenArbeid_Other.setScale(4, RoundingMode.HALF_UP);

        }
        if (arbeidsOngevallenInput.getLawWageEmployeeManualWorkStudent() != null &&
                arbeidsOngevallenInput.getLawWageEmployeeManualWorkStudent().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxBediendenMetHandenArbeid_Student =
                    (this.rpBediendenMetHandenArbeid.add(this.ctBediendenMetHandenArbeid))
                            .multiply(arbeidsOngevallenInput.getLawWageEmployeeManualWorkStudent()).divide(HUNDRED);
            feeNoTaxBediendenMetHandenArbeid_Student = feeNoTaxBediendenMetHandenArbeid_Student.setScale(4, RoundingMode.HALF_UP);

        }
        if (arbeidsOngevallenInput.getLawWageWorkerOther() != null &&
                arbeidsOngevallenInput.getLawWageWorkerOther().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxArbeiders_Other =
                    (this.rpArbeiders.add(this.ctArbeiders))
                            .multiply(arbeidsOngevallenInput.getLawWageWorkerOther()).divide(HUNDRED);
            feeNoTaxArbeiders_Other = feeNoTaxArbeiders_Other.setScale(4, RoundingMode.HALF_UP);
        }
        if (arbeidsOngevallenInput.getLawWageWorkerStudent() != null &&
                arbeidsOngevallenInput.getLawWageWorkerStudent().compareTo(BigDecimal.ZERO) != 0) {
            feeNoTaxArbeiders_Student =
                    (this.rpArbeiders.add(this.ctArbeiders))
                            .multiply(arbeidsOngevallenInput.getLawWageWorkerStudent()).divide(HUNDRED);
            feeNoTaxArbeiders_Student = feeNoTaxArbeiders_Student.setScale(4, RoundingMode.HALF_UP);
        }

        feeWithTaxAdministratieveBedienden_Other = feeNoTaxAdministratieveBedienden_Other.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_other));

        feeWithTaxAdministratieveBedienden_Student = feeNoTaxAdministratieveBedienden_Student.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_student));
        feeWithTaxBediendenOccasioneleBuitenopdracht_Other = feeNoTaxBediendenOccasioneleBuitenopdracht_Other.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_other));
        feeWithTaxBediendenOccasioneleBuitenopdracht_Student = feeNoTaxBediendenOccasioneleBuitenopdracht_Student.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_student));
        feeWithTaxBediendenBuitenOpdracht_Other = feeNoTaxBediendenBuitenOpdracht_Other.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_other));
        feeWithTaxBediendenBuitenOpdracht_Student = feeNoTaxBediendenBuitenOpdracht_Student.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_student));
        feeWithTaxBediendenMetHandenArbeid_Other = feeNoTaxBediendenMetHandenArbeid_Other.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_other));
        feeWithTaxBediendenMetHandenArbeid_Student = feeNoTaxBediendenMetHandenArbeid_Student.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_student));
        feeWithTaxArbeiders_Other = feeNoTaxArbeiders_Other.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_other));
        feeWithTaxArbeiders_Student = feeNoTaxArbeiders_Student.multiply(BigDecimal.ONE.add(ParametersArbeidsOngevallen.Law_Tax_student));

        feeWithTaxAdministratieveBedienden_Other = feeWithTaxAdministratieveBedienden_Other.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxAdministratieveBedienden_Student = feeWithTaxAdministratieveBedienden_Student.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxBediendenOccasioneleBuitenopdracht_Other = feeWithTaxBediendenOccasioneleBuitenopdracht_Other.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxBediendenOccasioneleBuitenopdracht_Student = feeWithTaxBediendenOccasioneleBuitenopdracht_Student.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxBediendenBuitenOpdracht_Other = feeWithTaxBediendenBuitenOpdracht_Other.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxBediendenBuitenOpdracht_Student = feeWithTaxBediendenBuitenOpdracht_Student.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxBediendenMetHandenArbeid_Other = feeWithTaxBediendenMetHandenArbeid_Other.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxBediendenMetHandenArbeid_Student = feeWithTaxBediendenMetHandenArbeid_Student.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxArbeiders_Other = feeWithTaxArbeiders_Other.setScale(4, RoundingMode.HALF_UP);
        feeWithTaxArbeiders_Student = feeWithTaxArbeiders_Student.setScale(4, RoundingMode.HALF_UP);



        if (arbeidsOngevallenInput.getSelectedManualWork_2424() != null &&
                !arbeidsOngevallenInput.getSelectedManualWork_2424().equals("")) {
            System.out.println("Do manual calculation");

            switch (arbeidsOngevallenInput.getSelectedManualWork_2424()) {
                case MANUAL_WORK:
                    System.out.println("Calculate manual work");
                    //RP: Output_BP21
                    //CT: CT_Employee
                    break;
                case NO_MANUAL_WORK:
                    System.out.println("Calculate no manual work");
                    //RP: If 24-24_RP_threshold*Output_BP21<Output_BP22 Then 24-24_RP_threshold*Output_BP21 Else Output_BP_22
                    //CT: CT_Employee
                    break;
                case LIMITED_MANUAL_WORK:
                    System.out.println("Calculate limited manual work");

                    rpArbeiders_BediendenMetHandenArbeid = BasePremiumArbeidsOngevallen.rpArbeidersMap.get(arbeidsOngevallenInput.getNacebel());
                    rpBediendenBuitenOpdracht = BasePremiumArbeidsOngevallen.rpMedewerkersMetMissieMap.get(arbeidsOngevallenInput.getNacebel());
                    rpAdministratieveBedienden = ParametersLookupTableArbeidsOngevallen.getRTPremiumForAdministrativeWorkers(
                            CalculationUtils.getLawWage(arbeidsOngevallenInput));


                    rp = (ParametersArbeidsOngevallen.twentyfour_RP_threshold.multiply(rpArbeiders_BediendenMetHandenArbeid))
                            .add((BigDecimal.ONE.subtract(ParametersArbeidsOngevallen.twentyfour_RP_threshold)).multiply(rpAdministratieveBedienden));
                    rp = rp.setScale(4, RoundingMode.HALF_UP);

                    ct = ParametersLookupTableArbeidsOngevallen.getCTPremiumForAdministrativeWorkers(
                            CalculationUtils.getLawWage(arbeidsOngevallenInput));
                    ct = ct.setScale(4, RoundingMode.HALF_UP);

                    priv = ParametersArbeidsOngevallen.PrivateAcc_Law_woDelay;
                    priv = priv.setScale(4, RoundingMode.HALF_UP);



                    rate = rp.add(ct).divide(new BigDecimal(1.15), 4, RoundingMode.HALF_UP).add(priv);
                    rate = rate.round(new MathContext(4));
                    rate = rate.multiply(ParametersArbeidsOngevallen.twentyfour_Multiplicateur_factor);


                    feeNoTax = (rate.multiply(arbeidsOngevallenInput.getWage1_2424()).divide(HUNDRED));
                    feeNoTax = feeNoTax.setScale(4, RoundingMode.HALF_UP);

                    tax = ParametersArbeidsOngevallen.twentyfour_Tax;
                    feeWithTax = feeNoTax.multiply((BigDecimal.ONE.add(tax)));
                    feeWithTax = feeWithTax.setScale(4, RoundingMode.HALF_UP);

                    break;
                default:
                    System.out.println("No match to calculate");
            }
        }

        System.out.println("End calculation");

        return createPremies();
    }

    private void initValues() {
        rpArbeidersBasePremium = BigDecimal.ZERO;
        rpMederwerkersMetMissieBasePremium= BigDecimal.ZERO;

        rpAdministratieveBedienden = BigDecimal.ZERO;
        ctAdministratieveBedienden = BigDecimal.ZERO;
        rateLawAdministratieveBedienden = BigDecimal.ZERO;


        rpBediendenOccasioneleBuitenOpdracht = BigDecimal.ZERO;
        ctBediendenOccasioneleBuitenOpdracht = BigDecimal.ZERO;
        rateLawBediendenOccasioneleBuitenOpdracht = BigDecimal.ZERO;

        rpBediendenBuitenOpdracht = BigDecimal.ZERO;
        ctBediendenBuitenOpdracht = BigDecimal.ZERO;
        rateLawBediendenBuitenOpdracht = BigDecimal.ZERO;

        rpBediendenMetHandenArbeid = BigDecimal.ZERO;
        ctBediendenMetHandenArbeid = BigDecimal.ZERO;
        rateLawBediendenMetHandenArbeid = BigDecimal.ZERO;

        rpArbeiders = BigDecimal.ZERO;
        ctArbeiders = BigDecimal.ZERO;
        rateLawArbeiders = BigDecimal.ZERO;




        //without taxes
        feeNoTaxAdministratieveBedienden_Other = BigDecimal.ZERO;
        feeNoTaxAdministratieveBedienden_Student = BigDecimal.ZERO;
        feeNoTaxBediendenOccasioneleBuitenopdracht_Other = BigDecimal.ZERO;
        feeNoTaxBediendenOccasioneleBuitenopdracht_Student = BigDecimal.ZERO;
        feeNoTaxBediendenBuitenOpdracht_Other = BigDecimal.ZERO;
        feeNoTaxBediendenBuitenOpdracht_Student = BigDecimal.ZERO;
        feeNoTaxBediendenMetHandenArbeid_Other = BigDecimal.ZERO;
        feeNoTaxBediendenMetHandenArbeid_Student = BigDecimal.ZERO;
        feeNoTaxArbeiders_Other = BigDecimal.ZERO;
        feeNoTaxArbeiders_Student = BigDecimal.ZERO;

        //with taxes
        feeWithTaxAdministratieveBedienden_Other = BigDecimal.ZERO;
        feeWithTaxAdministratieveBedienden_Student = BigDecimal.ZERO;
        feeWithTaxBediendenOccasioneleBuitenopdracht_Other = BigDecimal.ZERO;
        feeWithTaxBediendenOccasioneleBuitenopdracht_Student = BigDecimal.ZERO;
        feeWithTaxBediendenBuitenOpdracht_Other = BigDecimal.ZERO;
        feeWithTaxBediendenBuitenOpdracht_Student = BigDecimal.ZERO;
        feeWithTaxBediendenMetHandenArbeid_Other = BigDecimal.ZERO;
        feeWithTaxBediendenMetHandenArbeid_Student = BigDecimal.ZERO;
        feeWithTaxArbeiders_Other = BigDecimal.ZERO;
        feeWithTaxArbeiders_Student = BigDecimal.ZERO;


        rp = BigDecimal.ZERO;
        ct = BigDecimal.ZERO;
        priv = BigDecimal.ZERO;
        rate = BigDecimal.ZERO;
        feeNoTax = BigDecimal.ZERO;
        tax = BigDecimal.ZERO;
        feeWithTax = BigDecimal.ZERO;
        rpArbeiders_BediendenMetHandenArbeid = BigDecimal.ZERO;

    }

    private List<Premie> createPremies() {
        List<Premie> result = new ArrayList();
        Premie premie = new Premie(CODE_ADMINISTRATIEVE_BEDIENDEN_OTHER,
                ADMINISTRATIEVE_BEDIENDEN_DESCR_NL,
                ADMINISTRATIEVE_BEDIENDEN_DESCR_FR,
                feeNoTaxAdministratieveBedienden_Other,
                feeWithTaxAdministratieveBedienden_Other);
        result.add(premie);

        premie = new Premie(CODE_ADMINISTRATIEVE_BEDIENDEN_STUDENT,
                ADMINISTRATIEVE_BEDIENDEN_DESCR_NL,
                ADMINISTRATIEVE_BEDIENDEN_DESCR_FR,
                feeNoTaxAdministratieveBedienden_Student,
                feeWithTaxAdministratieveBedienden_Student);
        result.add(premie);

        premie = new Premie(CODE_BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_OTHER,
                BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_DESCR_NL,
                BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_DESCR_FR,
                feeNoTaxAdministratieveBedienden_Student,
                feeWithTaxAdministratieveBedienden_Student);
        result.add(premie);



        premie = new Premie(CODE_BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_OTHER,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_NL,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_FR,
                feeNoTaxBediendenOccasioneleBuitenopdracht_Other,
                feeWithTaxBediendenOccasioneleBuitenopdracht_Other);
        result.add(premie);

        premie = new Premie(CODE_BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_STUDENT,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_NL,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_FR,
                feeNoTaxBediendenOccasioneleBuitenopdracht_Student,
                feeWithTaxBediendenOccasioneleBuitenopdracht_Student);
        result.add(premie);

        premie = new Premie(CODE_BEDIENDEN_BUITEN_OPDRACHT_OTHER,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_NL,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_FR,
                feeNoTaxBediendenBuitenOpdracht_Other,
                feeWithTaxBediendenBuitenOpdracht_Other);
        result.add(premie);

        premie = new Premie(CODE_BEDIENDEN_BUITEN_OPDRACHT_STUDENT,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_NL,
                BEDIENDEN_BUITEN_OPDRACHT_DESCR_FR,
                feeNoTaxBediendenBuitenOpdracht_Student,
                feeWithTaxBediendenBuitenOpdracht_Student);
        result.add(premie);

        premie = new Premie(CODE_BEDIENDEN_MET_HANDENARBEID_OTHER,
                BEDIENDEN_MET_HANDEN_ARBEID_DESCR_NL,
                BEDIENDEN_MET_HANDEN_ARBEID_DESCR_FR,
                feeNoTaxBediendenMetHandenArbeid_Other,
                feeWithTaxBediendenMetHandenArbeid_Other);
        result.add(premie);

        premie = new Premie(CODE_BEDIENDEN_MET_HANDENARBEID_STUDENT,
                BEDIENDEN_MET_HANDEN_ARBEID_DESCR_NL,
                BEDIENDEN_MET_HANDEN_ARBEID_DESCR_FR,
                feeNoTaxBediendenMetHandenArbeid_Student,
                feeWithTaxBediendenMetHandenArbeid_Student);
        result.add(premie);

        premie = new Premie(CODE_ARBEIDERS_OTHER,
                ARBEIDERS_DESCR_NL,
                ARBEIDERS_DESCR_FR,
                feeNoTaxArbeiders_Other,
                feeWithTaxArbeiders_Other);
        result.add(premie);

        premie = new Premie(CODE_ARBEIDERS_STUDENT,
                ARBEIDERS_DESCR_NL,
                ARBEIDERS_DESCR_FR,
                feeNoTaxArbeiders_Student,
                feeWithTaxArbeiders_Student);
        result.add(premie);

        return result;
    }

    public void printCalculationData() {
        System.out.println("Administratieve bedienden:\t\t\t\t\t\t" + rpAdministratieveBedienden.toString() + "\t\t" +
                ctAdministratieveBedienden + "\t" +
                rateLawAdministratieveBedienden);
        System.out.println("Bedienden met occasionele buitenopdrachten:\t\t" + rpBediendenOccasioneleBuitenOpdracht + "\t\t" +
                ctBediendenOccasioneleBuitenOpdracht + "\t" +
                rateLawBediendenOccasioneleBuitenOpdracht);
        System.out.println("Bedienden met buiten opdrachten:\t\t\t\t" + rpBediendenBuitenOpdracht + "\t" +
                ctBediendenBuitenOpdracht + "\t" +
                rateLawBediendenBuitenOpdracht);

        System.out.println("Bedienden met hand arb./verkopers:\t\t\t\t" + rpBediendenMetHandenArbeid + "\t" +
                ctBediendenMetHandenArbeid + "\t" +
                rateLawBediendenMetHandenArbeid);

        System.out.println("Arbeiders:\t\t\t\t" + rpArbeiders + "\t" +
                ctArbeiders + "\t" +
                rateLawArbeiders);


        System.out.println("Without tax\t\t\t\t\t\t\t\t\t\t\t" + "Andere\t\t\t\t\t" + "Studenten");
        System.out.println("Administratieve bedienden:\t\t\t\t\t\t\t"
                + feeNoTaxAdministratieveBedienden_Other + "\t\t\t\t\t"
                + feeNoTaxAdministratieveBedienden_Student);

        System.out.println("Bedienden met occas. buitenopdracht:\t\t\t\t"
                + feeNoTaxBediendenOccasioneleBuitenopdracht_Other + "\t\t\t\t\t\t"
                + feeNoTaxBediendenOccasioneleBuitenopdracht_Student);
        System.out.println("Bedienden met buiten opdrachten:\t\t\t\t\t"
                + feeNoTaxBediendenBuitenOpdracht_Other + "\t\t\t\t\t\t"
                + feeNoTaxBediendenBuitenOpdracht_Student);
        System.out.println("Bedienden met handenarbeid/verkopers:\t\t\t\t"
                + feeNoTaxBediendenMetHandenArbeid_Other + "\t\t\t\t\t"
                + feeNoTaxBediendenMetHandenArbeid_Student);
        System.out.println("Arbeiders:\t\t\t\t\t\t\t\t\t\t"
                + feeNoTaxArbeiders_Other + "\t\t\t\t\t"
                + feeNoTaxArbeiders_Student);


        System.out.println("With tax\t\t\t\t\t\t\t\t\t\t\t" + "Andere\t\t\t\t\t" + "Studenten");
        System.out.println("Administratieve bedienden:\t\t\t\t\t\t\t"
                + feeWithTaxAdministratieveBedienden_Other + "\t\t\t\t\t"
                + feeWithTaxAdministratieveBedienden_Student);

        System.out.println("Bedienden met occas. buitenopdracht:\t\t\t\t"
                + feeWithTaxBediendenOccasioneleBuitenopdracht_Other + "\t\t\t\t\t\t"
                + feeWithTaxBediendenOccasioneleBuitenopdracht_Student);
        System.out.println("Bedienden met buiten opdrachten:\t\t\t\t\t"
                + feeWithTaxBediendenBuitenOpdracht_Other + "\t\t\t\t\t\t"
                + feeWithTaxBediendenBuitenOpdracht_Student);
        System.out.println("Bedienden met handenarbeid/verkopers:\t\t\t\t"
                + feeWithTaxBediendenMetHandenArbeid_Other + "\t\t\t\t\t"
                + feeWithTaxBediendenMetHandenArbeid_Student);
        System.out.println("Arbeiders:\t\t\t\t\t\t\t\t\t\t"
                + feeWithTaxArbeiders_Other.toPlainString() + "\t\t\t\t\t"
                + feeWithTaxArbeiders_Student);
    }

    public void printLimitedManualWorkData() {
        System.out.println("RP Arbeiders & Bedienden met handenarbeid/verkopers: " + rpArbeiders_BediendenMetHandenArbeid);
        System.out.println("RP Bedienden met buiten opdrachten: " + rpBediendenBuitenOpdracht);
        System.out.println("RP Admin Bedienden / met(occasionele) buitenopdrachten: " + rpBediendenOccasioneleBuitenOpdracht);
        System.out.println("Treshold: " + ParametersArbeidsOngevallen.twentyfour_RP_threshold);
        System.out.println("RP: " + rp);
        System.out.println("CT: " + ct);
        System.out.println("Private: " + priv);

        System.out.println("Rate: " + rate);

        System.out.println("Premium without tax: " + feeNoTax);
        System.out.println("Tax rate: " + tax);
        System.out.println("Premium with tax: " + feeWithTax);
    }
}