package be.pvgroup.tpetool.model.pdf;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.LiabilityPremium;
import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.proposal.ProposalInput;
import be.pvgroup.tpetool.util.arbeidsongevallen.AccidentsPremiumType;
import be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid.LiabilityPremiumType;
import be.pvgroup.tpetool.util.property.PropertyPremiumType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProposalPdfData {

	private ProposalInput proposalInput;

	private String company;

	private List<AccidentPremium> accidentPremiums;
	private List<LiabilityPremium> liabilityPremiums;
	private List<PropertyPremium> propertyPremiums;

	private Map<PropertyPremiumType, PropertyPremium> propertyPremiumMap;
	private Map<LiabilityPremiumType, LiabilityPremium> liabilityPremiumMap;
	private Map<AccidentsPremiumType, AccidentPremium> accidentPremiumMap;

	public ProposalInput getProposalInput() {
		return proposalInput;
	}

	public void setProposalInput(ProposalInput proposalInput) {
		this.proposalInput = proposalInput;
	}

	public List<AccidentPremium> getAccidentPremiums() {
		return accidentPremiums;
	}

	public void setAccidentPremiums(List<AccidentPremium> accidentPremiums) {
		this.accidentPremiums = accidentPremiums;
		initializeAccidentsPremiumMap();
	}

	public List<LiabilityPremium> getLiabilityPremiums() {
		return liabilityPremiums;
	}

	public void setLiabilityPremiums(List<LiabilityPremium> liabilityPremiums) {
		this.liabilityPremiums = liabilityPremiums;
		initializeLiabilityPremiumMap();
	}

	public List<PropertyPremium> getPropertyPremiums() {
		return propertyPremiums;
	}

	public void setPropertyPremiums(List<PropertyPremium> propertyPremiums) {
		this.propertyPremiums = propertyPremiums;
		initializePropertyPremiumMap();
	}

	public PropertyPremium getPropertyPremiumByType(PropertyPremiumType propertyPremiumType) {
		return propertyPremiumMap.get(propertyPremiumType);
	}

	public PropertyPremium getPropertyPremiumByLabel(String propertyPremiumTypeLabel) {
		return propertyPremiumMap.get(PropertyPremiumType.valueOfLabel(propertyPremiumTypeLabel));
	}

	public AccidentPremium getAccidentPremiumByLabel(String accidentPremiumTypeLabel) {
		return accidentPremiumMap.get(AccidentsPremiumType.valueOfLabel(accidentPremiumTypeLabel));
	}

	public AccidentPremium getAccidentPremiumByType(AccidentsPremiumType accidentsPremiumType) {
		return accidentPremiumMap.get(accidentsPremiumType);
	}

	private void initializePropertyPremiumMap() {
		propertyPremiumMap = new HashMap<>();
		for (PropertyPremium propertyPremium : propertyPremiums) {
			propertyPremiumMap.put(PropertyPremiumType.valueOfLabel(propertyPremium.getCode()), propertyPremium);
		}
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public LiabilityPremium getLiabilityPremiumByType(LiabilityPremiumType liabilityPremiumType) {
		return liabilityPremiumMap.get(liabilityPremiumType);
	}

	public LiabilityPremium getLiabilityPremiumByLabel(String liabilityPremiumTypeLabel) {
		return liabilityPremiumMap.get(LiabilityPremiumType.valueOfLabel(liabilityPremiumTypeLabel));
	}

	private void initializeLiabilityPremiumMap() {
		liabilityPremiumMap = new HashMap<>();
		for (LiabilityPremium liabilityPremium : liabilityPremiums) {
			liabilityPremiumMap.put(LiabilityPremiumType.valueOfLabel(liabilityPremium.getCode()), liabilityPremium);
		}
	}

	private void initializeAccidentsPremiumMap() {
		accidentPremiumMap = new HashMap<>();
		for (AccidentPremium accidentPremium : accidentPremiums) {
			accidentPremiumMap.put(AccidentsPremiumType.valueOfLabel(accidentPremium.getCode()), accidentPremium);
		}
	}

	public static final class ProposalPdfDataBuilder {
		private ProposalInput proposalInput;
		private List<AccidentPremium> accidentPremiums;
		private List<LiabilityPremium> liabilityPremiums;
		private List<PropertyPremium> propertyPremiums;
		private String company;

		private ProposalPdfDataBuilder() {
		}

		public static ProposalPdfDataBuilder aProposalPdfData() {
			return new ProposalPdfDataBuilder();
		}

		public ProposalPdfDataBuilder withProposalInput(ProposalInput proposalInput) {
			this.proposalInput = proposalInput;
			return this;
		}

		public ProposalPdfDataBuilder withAccidentPremiums(List<AccidentPremium> accidentPremiums) {
			this.accidentPremiums = accidentPremiums;
			return this;
		}

		public ProposalPdfDataBuilder withLiabilityPremiums(List<LiabilityPremium> liabilityPremiums) {
			this.liabilityPremiums = liabilityPremiums;
			return this;
		}

		public ProposalPdfDataBuilder withPropertyPremiums(List<PropertyPremium> propertyPremiums) {
			this.propertyPremiums = propertyPremiums;
			return this;
		}

		public ProposalPdfDataBuilder withCompany(String company) {
			this.company = company;
			return this;
		}

		public ProposalPdfData build() {
			ProposalPdfData proposalPdfData = new ProposalPdfData();
			proposalPdfData.setProposalInput(proposalInput);
			proposalPdfData.setAccidentPremiums(accidentPremiums);
			proposalPdfData.setLiabilityPremiums(liabilityPremiums);
			proposalPdfData.setPropertyPremiums(propertyPremiums);
			proposalPdfData.setCompany(company);
			return proposalPdfData;
		}
	}
}
