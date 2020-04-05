package be.pvgroup.tpetool.service.proposal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Component;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.LiabilityPremium;
import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.User;
import be.pvgroup.tpetool.model.accidents.AccidentsData;
import be.pvgroup.tpetool.model.accidents.AccidentsInput;
import be.pvgroup.tpetool.model.liability.LiabilityData;
import be.pvgroup.tpetool.model.liability.LiabilityInput;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.model.property.PropertyData;
import be.pvgroup.tpetool.model.property.PropertyInput;
import be.pvgroup.tpetool.model.proposal.ProposalInput;
import be.pvgroup.tpetool.pdf.OfferPdfGenerator;
import be.pvgroup.tpetool.service.MailService;
import be.pvgroup.tpetool.service.accidents.AccidentsService;
import be.pvgroup.tpetool.service.liability.LiabilityService;
import be.pvgroup.tpetool.service.property.PropertyService;

@Component
public class ProposalServiceImpl implements ProposalService {

	Logger logger = LoggerFactory.getLogger(ProposalServiceImpl.class);

	@Autowired
	private AccidentsService accidentsService;

	@Autowired
	private LiabilityService liabilityService;

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private OfferPdfGenerator offerPdfGenerator;

	@Autowired
	private MailService mailService;

	private List<AccidentPremium> accidentPremiums = new ArrayList<>();
	private List<LiabilityPremium> liabilityPremiums = new ArrayList<>();
	private List<PropertyPremium> propertyPremiums = new ArrayList<>();

	public ProposalServiceImpl(AccidentsService accidentsService, LiabilityService liabilityService,
			PropertyService propertyService, OfferPdfGenerator offerPdfGenerator, MailService mailService) {
		this.accidentsService = accidentsService;
		this.liabilityService = liabilityService;
		this.propertyService = propertyService;
		this.offerPdfGenerator = offerPdfGenerator;
		this.mailService = mailService;
	}

	@Override
	public void handleProposal(ProposalInput proposalInput, String language) throws MessagingException {
		ByteArrayOutputStream byteArrayOutputStream = makeProposalStream(proposalInput, language);
		final InputStreamSource attachment = new ByteArrayResource(byteArrayOutputStream.toByteArray());

		mailService.sendMailWithAttachment(proposalInput, attachment);
	}

	@Override
	public ByteArrayInputStream makeProposal(ProposalInput proposalInput, String language) {
		System.out.println("make a proposal");

		initPremiumResults();
		doCalculationOfPremiums(proposalInput);

		ProposalPdfData proposalPdfData = createInputDataForProposalPdfGeneration(proposalInput);
		return offerPdfGenerator.createPdf(proposalPdfData);
	}

	@Override
	public ByteArrayOutputStream makeProposalStream(ProposalInput proposalInput, String language) {
		logger.debug("=============================================================================");
		logger.debug("=============================================================================");
		logger.debug("Start making proposal");
		logger.debug("\t with input: " + proposalInput);

		initPremiumResults();
		doCalculationOfPremiums(proposalInput);

		ProposalPdfData proposalPdfData = createInputDataForProposalPdfGeneration(proposalInput);
		ByteArrayOutputStream pdfStream = offerPdfGenerator.createPdfStream(proposalPdfData);

		logger.debug("End making proposal");
		logger.debug("=============================================================================");
		logger.debug("=============================================================================");
		return pdfStream;
	}

	private ProposalPdfData createInputDataForProposalPdfGeneration(ProposalInput proposalInput) {
		ProposalPdfData.ProposalPdfDataBuilder proposalPdfDataBuilder = ProposalPdfData.ProposalPdfDataBuilder
				.aProposalPdfData();

		String company = User.COMPANY_PV;
		if (proposalInput.getRequesterUsername().toUpperCase().endsWith("VIVIUM.BE")) {
			company = User.COMPANY_VIVIUM;
		}

		return proposalPdfDataBuilder.withProposalInput(proposalInput).withAccidentPremiums(accidentPremiums)
				.withLiabilityPremiums(liabilityPremiums).withPropertyPremiums(propertyPremiums).withCompany(company)
				.build();
	}

	private void initPremiumResults() {
		logger.debug("initialize premium result lists");
		accidentPremiums = new ArrayList<>();
		liabilityPremiums = new ArrayList<>();
		propertyPremiums = new ArrayList<>();
	}

	public void doCalculationOfPremiums(ProposalInput proposalInput) {
		if (proposalInput.getData() != null && proposalInput.getData().getInsuranceAnswers() != null) {
			doCalculationOfAccidentsPremiums(proposalInput);
			doCalculationOfLiabilityPremiums(proposalInput);
			doCalculationOfPropertyPremiums(proposalInput);
		} else {
			logger.debug("No premium calculation done");
			logger.debug("\tproposalInput.getData() or proposalInput.getData().getInsuranceAnswers() is NULL");
		}

		logger.debug("Premiums accident: ");
		logger.debug("\t" + accidentPremiums);
		logger.debug("");
		logger.debug("Premiums liability: ");
		logger.debug("\t" + liabilityPremiums);
		logger.debug("");
		logger.debug("Premiums property: ");
		logger.debug("\t" + propertyPremiums);
	}

	private void doCalculationOfPropertyPremiums(ProposalInput proposalInput) {
		if (proposalInput.getData().getInsuranceAnswers().getProperty() != null) {
			PropertyInput propertyInput = createPropertyInput(proposalInput);
			propertyPremiums = propertyService.calculate(propertyInput);
		} else {
			logger.debug("No premium calculation for Property done");
			logger.debug("\tproposalInput.getData().getInsuranceAnswers().getProperty() is NULL");
		}
	}

	private void doCalculationOfLiabilityPremiums(ProposalInput proposalInput) {
		if (proposalInput.getData().getInsuranceAnswers().getLiability() != null) {
			LiabilityInput liabilityInput = createLiabilityInput(proposalInput);
			liabilityPremiums = liabilityService.calculate(liabilityInput);
		} else {
			logger.debug("No premium calculation for Liability done");
			logger.debug("\tproposalInput.getData().getInsuranceAnswers().getLiability() is NULL");
		}
	}

	private void doCalculationOfAccidentsPremiums(ProposalInput proposalInput) {
		if (proposalInput.getData().getInsuranceAnswers().getAccidents() != null) {
			AccidentsInput accidentsInput = createAccidentsInput(proposalInput);
			accidentPremiums = accidentsService.calculate(accidentsInput);
		} else {
			logger.debug("No premium calculation for Accidents done");
			logger.debug("\tproposalInput.getData().getInsuranceAnswers().getAccidents() is NULL");
		}
	}

	private PropertyInput createPropertyInput(ProposalInput proposalInput) {

		PropertyInput.PropertyInputBuilder propertyInputBuilder = PropertyInput.PropertyInputBuilder.aPropertyInput();

		PropertyData.PropertyDataBuilder propertyDataBuilder = PropertyData.PropertyDataBuilder.aPropertyData();
		PropertyData propertyData = propertyDataBuilder.withNacebel(proposalInput.getData().getNacebel())
				.withAnswers(proposalInput.getData().getInsuranceAnswers().getProperty()).build();

		PropertyInput propertyInput = propertyInputBuilder.withData(propertyData).build();
		return propertyInput;
	}

	private LiabilityInput createLiabilityInput(ProposalInput proposalInput) {
		LiabilityInput.LiabilityInputBuilder liabilityInputBuilder = LiabilityInput.LiabilityInputBuilder
				.aLiabilityInput();

		LiabilityData.LiabilityDataBuilder liabilityDataBuilder = LiabilityData.LiabilityDataBuilder.aLiabilityData();
		LiabilityData liabilityData = liabilityDataBuilder.withNacebel(proposalInput.getData().getNacebel())
				.withAnswers(proposalInput.getData().getInsuranceAnswers().getLiability()).build();

		LiabilityInput liabilityInput = liabilityInputBuilder.withData(liabilityData).build();
		return liabilityInput;
	}

	private AccidentsInput createAccidentsInput(ProposalInput proposalInput) {
		AccidentsData.AccidentsDataBuilder accidentsDataBuilder = AccidentsData.AccidentsDataBuilder.anAccidentsData();
		AccidentsData accidentsData = accidentsDataBuilder.withNacebel(proposalInput.getData().getNacebel())
				.withAnswers(proposalInput.getData().getInsuranceAnswers().getAccidents()).build();

		AccidentsInput.AccidentsInputBuilder accidentsInputBuilder = AccidentsInput.AccidentsInputBuilder
				.anAccidentsInput();
		AccidentsInput accidentsInput = accidentsInputBuilder.withData(accidentsData).build();

		return accidentsInput;
	}
}
