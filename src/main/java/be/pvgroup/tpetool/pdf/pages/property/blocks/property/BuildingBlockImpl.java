package be.pvgroup.tpetool.pdf.pages.property.blocks.property;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

import java.text.DecimalFormat;

import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import be.pvgroup.tpetool.util.property.PropertyPremiumType;

@Component("buildingBlock")
public class BuildingBlockImpl extends AbstractBlock implements BuildingBlock {

	@Autowired
	private LanguageLabel languageLabel;

	@Override
	public void createBuildingBlock(Table table, ProposalPdfData proposalPdfData) {
		DecimalFormat f2 = new DecimalFormat("##.00");
		DecimalFormat f4 = new DecimalFormat("##.0000");

		this.proposalPdfData = proposalPdfData;
		initPremiumValues();

		Cell cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.building.title"));
		table.addCell(cell);

		cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.building.basiswaarborg"));
		table.addCell(cell);

		PropertyPremium propertyPremiumBaseCovBuilding = proposalPdfData
				.getPropertyPremiumByType(PropertyPremiumType.BASE_COVERAGES_BUILDING);

		cell = cellNoBorder(1, 1).add(f4.format(propertyPremiumBaseCovBuilding.getPremiumRate()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumBaseCovBuilding.getFeeWithTax()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumBaseCovBuilding.getFeeNoTax()));
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.building.bedrag")).setItalic();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty()
				.getMandatoryCoverage().getLiability().toString());
		table.addCell(cell);

		cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.building.natuurrampen"));
		table.addCell(cell);
		PropertyPremium propertyPremiumCatNatCovBuilding = proposalPdfData
				.getPropertyPremiumByType(PropertyPremiumType.CATNAT_COVERAGE_BUILDING);

		cell = cellNoBorder(1, 1).add(f4.format(propertyPremiumCatNatCovBuilding.getPremiumRate()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumCatNatCovBuilding.getFeeWithTax()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumCatNatCovBuilding.getFeeNoTax()));
		table.addCell(cell);
		// -------------------------------------------------

		String buildingEvaluation = languageLabel.getLabel(proposalPdfData.getProposalInput().getData()
				.getInsuranceAnswers().getProperty().getMandatoryCoverage().getBuildingEvaluation().getValue());

		if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
				.getBuildingIndirectLoss()) {
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.building.evaluatie")).setItalic();
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(buildingEvaluation);
			table.addCell(cell);

			cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.building.indirectverlies"));
			table.addCell(cell);
			PropertyPremium propertyPremiumIndirLossBuilding = proposalPdfData
					.getPropertyPremiumByType(PropertyPremiumType.INDIRECT_LOSS_BUILDING);

			cell = cellNoBorder(1, 1).add(f4.format(propertyPremiumIndirLossBuilding.getPremiumRate()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumIndirLossBuilding.getFeeWithTax()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumIndirLossBuilding.getFeeNoTax()));
			table.addCell(cell);
		} else {
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.building.evaluatie")).setItalic();
			table.addCell(cell);

			cell = cellNoBorder(1, 6).add(buildingEvaluation);
			table.addCell(cell);
		}

		// -------------------------------------------------

		if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
				.getBuildingLegalProtection()) {
			cell = cellNoBorder(1, 2).add("");
			table.addCell(cell);

			cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.building.rechtsbijstand"));
			table.addCell(cell);
			PropertyPremium legalProtectionCovBuilding = proposalPdfData
					.getPropertyPremiumByType(PropertyPremiumType.LEGAL_PROTECTION_COVERAGE_BUILDING);

			cell = cellNoBorder(1, 1).add(f4.format(legalProtectionCovBuilding.getPremiumRate()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(legalProtectionCovBuilding.getFeeWithTax()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(legalProtectionCovBuilding.getFeeNoTax()));
			table.addCell(cell);
			// -------------------------------------------------
		}

		cell = cellNoBorder(1, 4).add("");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.building.totaal"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(sumPremiumsBuildingWithTax.toString()).setBorderTop(new SolidBorder(1));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(sumPremiumsBuildingNoTax.toString()).setBorderTop(new SolidBorder(1));
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
	}

}
