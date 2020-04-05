package be.pvgroup.tpetool.pdf.pages.liability.blocks;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderAll;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderBottom;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellBorderTop;
import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.model.proposal.ProposalData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;

@Component
public class LiabilityHeaderImpl extends AbstractBlock implements LiabilityHeader {
	@Autowired
	private LanguageLabel languageLabel;

	@Override
	public void createLiabilityHeader(Table table, ProposalPdfData proposalPdfData) {
		this.proposalPdfData = proposalPdfData;
		initPremiumValues();
		// -------------------------------------------------
		Cell cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.LEFT).setBackgroundColor(viviumOrgange())
				.setBold().setFontColor(Color.WHITE).add(languageLabel.getLabel("liability.title"));
		table.addCell(cell);
		table.setBorder(new SolidBorder(viviumOrgange(), 0));

		cell = cellBorderTop(1, 1).add("   ");
		table.addCell(cell);

		cell = cellBorderTop(1, 1).add(languageLabel.getLabel("liability.startdatum"));
		table.addCell(cell);

		cell = cellBorderTop(1, 3).add(
				proposalPdfData.getProposalInput().getData().getCommonAnswers().getStartDates().getLiabilityAsString());
		table.addCell(cell);
		// --------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 2).setBold().add(languageLabel.getLabel("liability.verzekerde_bedragen"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setBold().add(languageLabel.getLabel("liability.totaalMetTaks"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setBold().add(languageLabel.getLabel("liability.totaalNetto"));
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 5).setBold().add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_OPERATIONS.title"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremium.getFeeWithTax().toString());
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremium.getFeeNoTax().toString());
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3)
				.add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_OPERATIONS.lichamelijkeschade"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
				.getExploitationLimit().toString()).setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7)
				.add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_OPERATIONS.stoffelijkeschade"));
		table.addCell(cell);
		// -------------------------------------------------

		cell = cellNoBorder(1, 3)
				.add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_OPERATIONS.onstoffelijkeschade"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
				.getLimietOnstoffelijkeSchade().toString()).setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);
		// -------------------------------------------------

		cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_OPERATIONS.schadebrand"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
				.getLimietBrandSchade().toString()).setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);
		// -------------------------------------------------

		cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_OPERATIONS.schade_art_554"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
				.getLimietSchadeArtikel544().toString()).setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);
		// -------------------------------------------------

		cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_OPERATIONS.pollutie"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
				.getLimietSchadePollutie().toString()).setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);
		// --------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setBold()
				.add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_PROPERTY_IN_CARE.title"));
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3)
				.add(languageLabel.getLabel("liability.PUBLIC_LIABILITY_PROPERTY_IN_CARE.schade_aan_goederen"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add("25000").setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add("");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumPropInCare.getFeeWithTax().toString());
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumPropInCare.getFeeNoTax().toString());
		table.addCell(cell);
		// --------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setBold()
				.add(languageLabel.getLabel("liability.PUBLIC_COVERAGE_AFTER_DELIVERY.title"));
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3)
				.add(languageLabel.getLabel("liability.PUBLIC_COVERAGE_AFTER_DELIVERY.lichamelijkeschade"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
				.getExploitationLimit().toString()).setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add("");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumAfterDelivery.getFeeWithTax().toString());
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumAfterDelivery.getFeeNoTax().toString());
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 7)
				.add(languageLabel.getLabel("liability.PUBLIC_COVERAGE_AFTER_DELIVERY.stoffelijkeschade"));
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.PUBLIC_COVERAGE_AFTER_DELIVERY.schadebrand"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
				.getLimietBrandSchade().toString()).setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.PUBLIC_COVERAGE_AFTER_DELIVERY.pollutie"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1)
				.add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getLiability()
						.getLimietPollutie_Public_Coverage_After_Delivery().toString())
				.setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);
		cell = cellNoBorder(1, 3).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3).add(languageLabel.getLabel("liability.LEGAL_PROTECTION_BASE_PREMIUM.title"))
				.setBold();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add("25000").setTextAlignment(TextAlignment.RIGHT);
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add("");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumLegalProtection.getFeeWithTax().toString());
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumLegalProtection.getFeeNoTax().toString());
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellBorderBottom(1, 1, Color.BLACK).add(languageLabel.getLabel("liability.franchises")).setBold();
		table.addCell(cell);
		cell = cellBorderBottom(1, 1, Color.BLACK).add("");
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(languageLabel.getLabel("liability.franchises.percent"));
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(languageLabel.getLabel("liability.franchises.min"));
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(languageLabel.getLabel("liability.franchises.max"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellBorderBottom(1, 1, Color.BLACK).add(languageLabel.getLabel("liability.franchises.ba_uitbating"));
		table.addCell(cell);
		cell = cellBorderBottom(1, 1, Color.BLACK).add("");
		table.addCell(cell);

		String nacebel = proposalPdfData.getProposalInput().getData().getNacebel();

		String franchisePercent = "";
		String franchiseMin = "";
		String franchiseMax = "";

		if (ProposalData.NACEBEL_56210.equals(nacebel)) {
			franchisePercent = languageLabel.getLabel("Franchises.d1.percent");
			franchiseMin = languageLabel.getLabel("Franchises.d1.min");
			franchiseMax = languageLabel.getLabel("Franchises.d1.max");
		} else {
			franchisePercent = languageLabel.getLabel("Franchises.d2.percent");
			franchiseMin = languageLabel.getLabel("Franchises.d2.min");
			franchiseMax = languageLabel.getLabel("Franchises.d2.max");
		}

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchisePercent);
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchiseMin);
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchiseMax);
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellBorderBottom(1, 1, Color.BLACK).add(languageLabel.getLabel("liability.franchises.ba_in_care"));
		table.addCell(cell);
		cell = cellBorderBottom(1, 1, Color.BLACK).add("");
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchisePercent);
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchiseMin);
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchiseMax);
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellBorderBottom(1, 1, Color.BLACK)
				.add(languageLabel.getLabel("liability.franchises.ba_after_delivery"));
		table.addCell(cell);
		cell = cellBorderBottom(1, 1, Color.BLACK).add("");
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchisePercent);
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchiseMin);
		table.addCell(cell);

		cell = cellBorderAll(1, 1, Color.BLACK).add(franchiseMax);
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.franchises.beroepsaansprakelijkheid"));
		table.addCell(cell);
		cell = cellNoBorder(1, 1).add("");
		table.addCell(cell);

		cell = cellBorderTop(1, 3).add(languageLabel.getLabel("liability.franchises.not_covered"))
				.setTextAlignment(TextAlignment.CENTER);
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.waarborgen")).setBold();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.waarborgen.totaalMetTaks")).setBold();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.waarborgen.totaalNetto")).setBold();
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 3).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.waarborgen.ba"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(sumLiabilityBA_WithTax.toString());
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(sumLiabilityBA_NoTax.toString());
		table.addCell(cell);
		// -------------------------------------------------

		cell = cellNoBorder(1, 3).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.waarborgen.legalprotection"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumLegalProtection.getFeeWithTax().toString());
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(liabilityPremiumLegalProtection.getFeeNoTax().toString());
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 4).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.waarborgen.totaal")).setBold();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(sumLiability_WithTax.toString()).setBorderTop(new SolidBorder(Color.BLACK, 0))
				.setBold();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(sumLiability_NoTax.toString()).setBorderTop(new SolidBorder(Color.BLACK, 0))
				.setBold();
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.ba.footer"));
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.ba.footer.article"));
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);

		// -------------------------------------------------

		if (liabilityPremiumObjectiveLiability != null) {
			cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.LEFT).setBackgroundColor(viviumOrgange()).setBold()
					.setFontColor(Color.WHITE).add(languageLabel.getLabel("liability.brand_ontploffing.title"));
			table.addCell(cell);
			table.setBorder(new SolidBorder(viviumOrgange(), 0));

			cell = cellBorderTop(1, 1).add("   ");
			table.addCell(cell);

			cell = cellBorderTop(1, 1).add(languageLabel.getLabel("liability.startdatum"));
			table.addCell(cell);

			cell = cellBorderTop(1, 3).add(proposalPdfData.getProposalInput().getData().getCommonAnswers()
					.getStartDates().getLiabilityAsString().toString());
			table.addCell(cell);
			// --------------------------------------------------
			cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.brand_ontploffing.description"));
			table.addCell(cell);
			// --------------------------------------------------
			cell = cellNoBorder(1, 7).setHeight(20).add("   ");
			table.addCell(cell);
			// --------------------------------------------------
			cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.brand_ontploffing.ligging"));
			table.addCell(cell);
			// --------------------------------------------------
			cell = cellNoBorder(1, 1).add("   ");
			table.addCell(cell);
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.straat"));
			table.addCell(cell);
			cell = cellNoBorder(1, 2)
					.add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null
							? proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty()
									.getAddress().getStreet()
							: "");
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.nr"));
			table.addCell(cell);

			cell = cellNoBorder(1, 2)
					.add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null
							? proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty()
									.getAddress().getNumber()
							: "");
			table.addCell(cell);
			// --------------------------------------------------
			cell = cellNoBorder(1, 1).add("");
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.postcode"));
			table.addCell(cell);

			cell = cellNoBorder(1, 2)
					.add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null
							? proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty()
									.getAddress().getZip()
							: "");
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.plaats"));
			table.addCell(cell);

			cell = cellNoBorder(1, 2)
					.add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty() != null
							? proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty()
									.getAddress().getCity()
							: "");
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 7).setHeight(20).add("   ");
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.soortrisico"));
			table.addCell(cell);

			cell = cellNoBorder(1, 6)
					.add(languageLabel.getLabel("liability.brand_ontploffing.soortrisico.description"));
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 7).setHeight(20).add("   ");
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 3).add("");
			table.addCell(cell);
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.waarborgen")).setBold();
			table.addCell(cell);
			cell = cellNoBorder(1, 1).add("");
			table.addCell(cell);
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.totaalMetTaks"))
					.setBold();
			table.addCell(cell);
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.totaalNetto")).setBold();
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 3).add("");
			table.addCell(cell);
			cell = cellNoBorder(1, 2).add(languageLabel.getLabel("liability.brand_ontploffing.object_aanspr"));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(liabilityPremiumObjectiveLiability.getFeeWithTax().toString());
			table.addCell(cell);
			cell = cellNoBorder(1, 1).add(liabilityPremiumObjectiveLiability.getFeeNoTax().toString());
			table.addCell(cell);

			// -------------------------------------------------
			cell = cellNoBorder(1, 4).add("");
			table.addCell(cell);
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.brand_ontploffing.totaal")).setBold();
			table.addCell(cell);
			cell = cellBorderTop(1, 1, Color.BLACK).add(liabilityPremiumObjectiveLiability.getFeeWithTax().toString())
					.setBold();
			table.addCell(cell);
			cell = cellBorderTop(1, 1, Color.BLACK).add(liabilityPremiumObjectiveLiability.getFeeNoTax().toString())
					.setBold();
			table.addCell(cell);

			// -------------------------------------------------
			cell = cellNoBorder(1, 7).setHeight(20).add("   ");
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.brand_ontploffing.footer"));
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 7).add(languageLabel.getLabel("liability.brand_ontploffing.footer.article"));
			table.addCell(cell);
			// -------------------------------------------------
			cell = cellNoBorder(1, 7).setHeight(20).add("   ");
			table.addCell(cell);
		}
		// -------------------------------------------------
		cell = cellNoBorder(1, 4).setTextAlignment(TextAlignment.LEFT).setBackgroundColor(viviumOrgange()).setBold()
				.setFontColor(Color.WHITE).add(languageLabel.getLabel("liability.totaal.title"));
		table.addCell(cell);
		table.setBorder(new SolidBorder(viviumOrgange(), 0));

		cell = cellBorderTop(1, 3).add("   ");
		table.addCell(cell);
		// --------------------------------------------------
		cell = cellNoBorder(1, 5).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.totaal.totaalMetTaks"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.totaal.totaalNetto"));
		table.addCell(cell);
		// --------------------------------------------------
		cell = cellNoBorder(1, 4).setHeight(20).add("   ");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("liability.totaal")).setBold();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(totaalLiability_WithTaks.toString()).setBold();
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(totaalLiability_NoTax.toString()).setBold();
		table.addCell(cell);
		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
	}
}