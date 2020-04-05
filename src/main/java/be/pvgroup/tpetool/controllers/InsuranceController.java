package be.pvgroup.tpetool.controllers;

import be.pvgroup.tpetool.*;
import be.pvgroup.tpetool.model.proposal.ProposalInput;
import be.pvgroup.tpetool.pdf.OfferPdfGenerator;
import be.pvgroup.tpetool.service.MailService;
import be.pvgroup.tpetool.service.proposal.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;

@RestController
public class InsuranceController {

    Logger logger = LoggerFactory.getLogger(InsuranceController.class);

    @Autowired
    private OfferPdfGenerator offerPdfGenerator;

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private MailService mailService;

    public InsuranceController(MailService mailService, OfferPdfGenerator offerPdfGenerator, ProposalService proposalService) {
        this.offerPdfGenerator = offerPdfGenerator;
        this.mailService = mailService;
        this.proposalService = proposalService;
    }

    @GetMapping(value = "/pdf_nl",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> doPdfNL(@RequestHeader("Accept-Language") String language) throws MessagingException {
        LocaleContext localeContext = LocaleContextHolder.getLocaleContext();
        LocaleContextHolder.setLocale(new Locale("nl"));

        logger.debug(localeContext.getLocale().getLanguage());

        ProposalInput proposalInput_Example_PROP_1 = Proposal_Example_1_TestConstants.proposalInput_Example_Prop_1();
        ProposalInput proposalInput_Example_PROP_2 = Proposal_Example_2_TestConstants.proposalInput_Example_Prop_2();
        ProposalInput proposalInput_Example_PROP_3 = Proposal_Example_3_TestConstants.proposalInput_Example_Prop_3();

        //ProposalInput proposalInput = ProposalTestConstants.proposalInputForPdf();
        //ProposalInput proposalInput = ProposalTestConstants.proposalInputForPdf_WithOnlyAccidents();
        //ProposalInput proposalInput = ProposalTestConstants.proposalInputForPdf_WithOnlyLiability();
        //ProposalInput proposalInput = ProposalTestConstants.proposalInputForPdf_WithOnlyProperty();

        /*if (proposalInput.getData().getInsuranceAnswers().getProperty() == null ||
                proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums() == null) {
            proposalInput.getData().getInsuranceAnswers().setProperty(new PropertyAnswers());
            proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setBuildingIndirectLoss(Boolean.FALSE);
            proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setBuildingLegalProtection(Boolean.FALSE);
            proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setContentsTheft(Boolean.FALSE);
            proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setContentsIndirectLoss(Boolean.FALSE);
            proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setContentsLegalProtection(Boolean.FALSE);
            proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setAccidentalDamage(Boolean.FALSE);
        }*/
        /*proposalInput.getData().getInsuranceAnswers().getAccidents().getPayroll().setEmployeeWage(new BigDecimal(10000));
        proposalInput.getData().getInsuranceAnswers().getAccidents().getPayroll().setEmployeeWageStudent(new BigDecimal(0));
        proposalInput.getData().getInsuranceAnswers().getAccidents().getPayroll().setWorkerWage(new BigDecimal(18000));
        proposalInput.getData().getInsuranceAnswers().getAccidents().getPayroll().setWorkerWageStudent(new BigDecimal(10000));
        */
        logger.debug(proposalInput_Example_PROP_3.toString());

        logger.debug("");
        logger.debug("");
        //proposalInput.getData().getInsuranceAnswers().getProperty().getMandatoryCoverage().setBuildingEvaluation(BuildingEvaluation.FIRST_RISK);
        //logger.debug("" + proposalInput.getData().getInsuranceAnswers().getProperty().getValues().getCovered());

        //proposalInput.getData().getInsuranceAnswers().getProperty().getTheft().setContinguity(PropertyContinguity.NULL);

        //logger.debug(proposalInput.getData().getInsuranceAnswers().getProperty().getTheft().getCovered().toString());
        //logger.debug(proposalInput.getData().getInsuranceAnswers().getProperty().getTheft().getAlarmSystem().toString());
        //.equals(PropertyAlarmSystem.AGREED_CENTRAL)) {


        ProposalInput proposalInput_Example_Liab_1 = Liability_Example_1_TestConstants.proposalInput_Example_Liab_1();
        ProposalInput proposalInput_Example_Liab_2 = Liability_Example_2_TestConstants.proposalInput_Example_Liab_2();
        ProposalInput proposalInput_Example_Liab_3 = Liability_Example_3_TestConstants.proposalInput_Example_Liab_3();

        ProposalInput proposalInput_Example_Acc_1 = Accidents_Example_1_TestConstants.proposalInput_Example_Acc_1();
        ProposalInput proposalInput_Example_Acc_2 = Accidents_Example_2_TestConstants.proposalInput_Example_Acc_2();

        ByteArrayInputStream bis = proposalService.makeProposal(proposalInput_Example_Acc_2, language);

        proposalService.handleProposal(proposalInput_Example_Acc_2, language);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/pdf_fr",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> doPdfFR(@RequestHeader("Accept-Language") String language) {
        LocaleContext localeContext = LocaleContextHolder.getLocaleContext();
        LocaleContextHolder.setLocale(new Locale("fr"));

        System.out.println(localeContext.getLocale().getLanguage());
        ProposalInput proposalInput = ProposalTestConstants.proposalInputWithSelectedPremiums();
        /*proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setBuildingIndirectLoss(Boolean.FALSE);
        proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setBuildingLegalProtection(Boolean.FALSE);
        proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setContentsTheft(Boolean.FALSE);
        proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setContentsIndirectLoss(Boolean.FALSE);
        proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setContentsLegalProtection(Boolean.FALSE);
        proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setAccidentalDamage(Boolean.FALSE);
        */
        proposalInput.getData().getInsuranceAnswers().getProperty().getPremiums().setCommercialUnemployment (Boolean.FALSE);


        System.out.println(proposalInput.toString());

        ByteArrayInputStream bis = proposalService.makeProposal(proposalInput, language);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}