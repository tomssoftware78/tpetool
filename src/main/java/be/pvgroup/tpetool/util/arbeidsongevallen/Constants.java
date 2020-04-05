package be.pvgroup.tpetool.util.arbeidsongevallen;

import java.math.BigDecimal;

public class Constants {

    public static final String CODE_ADMINISTRATIEVE_BEDIENDEN_OTHER = "employee_admin_other";
    public static final String CODE_ADMINISTRATIEVE_BEDIENDEN_STUDENT = "employee_admin_student";

    public static final String CODE_BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_OTHER = "employee_TempExternalMission_other";
    public static final String CODE_BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_STUDENT = "employee_TempExternalMission_student";

    public static final String CODE_BEDIENDEN_BUITEN_OPDRACHT_OTHER = "employee_ExtenalMission_other";
    public static final String CODE_BEDIENDEN_BUITEN_OPDRACHT_STUDENT = "employee_ExternalMission_student";

    public static final String CODE_BEDIENDEN_MET_HANDENARBEID_OTHER = "employee_ManualWork_other";
    public static final String CODE_BEDIENDEN_MET_HANDENARBEID_STUDENT = "employee_ManualWork_student";

    public static final String CODE_ARBEIDERS_OTHER = "worker_other";
    public static final String CODE_ARBEIDERS_STUDENT = "worker_student";

    public static final String ADMINISTRATIEVE_BEDIENDEN_DESCR_NL = "Administratieve bedienden";
    public static final String ADMINISTRATIEVE_BEDIENDEN_DESCR_FR = "Employés administratifs";


    public static final String BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_DESCR_NL = "Bedienden met occasionele buitenopdrachten";
    public static final String BEDIENDEN_OCCASIONELE_BUITEN_OPDRACHT_DESCR_FR = "Employés avec missions ext. occasionnelles";

    public static final String BEDIENDEN_BUITEN_OPDRACHT_DESCR_NL = "Bedienden met buiten opdrachten";
    public static final String BEDIENDEN_BUITEN_OPDRACHT_DESCR_FR = "Employés avec missions extérieures";

    public static final String BEDIENDEN_MET_HANDEN_ARBEID_DESCR_NL = "Bedienden met handenarbeid/verkopers";
    public static final String BEDIENDEN_MET_HANDEN_ARBEID_DESCR_FR = "Employés avec travail manuel/vendeurs";

    public static final String ARBEIDERS_DESCR_NL = "Arbeiders";
    public static final String ARBEIDERS_DESCR_FR = "Ouvriers";







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
}
