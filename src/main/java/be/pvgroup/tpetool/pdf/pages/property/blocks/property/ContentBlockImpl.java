package be.pvgroup.tpetool.pdf.pages.property.blocks.property;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.property.blocks.AbstractBlock;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

import java.text.DecimalFormat;

@Component("contentBlock")
public class ContentBlockImpl extends AbstractBlock implements ContentBlock {

	@Autowired
	private LanguageLabel languageLabel;

	public void createContentBlock(Table table, ProposalPdfData proposalPdfData) {

		DecimalFormat f2 = new DecimalFormat("##.00");
		DecimalFormat f4 = new DecimalFormat("##.0000");

		this.proposalPdfData = proposalPdfData;
		initPremiumValues();

		Cell cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.contents.title"));
		table.addCell(cell);

		cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.contents.basiswaarborg"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f4.format(propertyPremiumBaseCovContent.getPremiumRate()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumBaseCovContent.getFeeWithTax()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumBaseCovContent.getFeeNoTax()));
		table.addCell(cell);
		// -------------------------------------------------
		if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
				.getContentsTheft()) {
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.contents.bedrag")).setItalic();
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
					.getProperty().getMandatoryCoverage().getContents()));
			table.addCell(cell);

			cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.contents.diefstal"));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f4.format(propertyPremiumTheftCov.getPremiumRate()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumTheftCov.getFeeWithTax()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumTheftCov.getFeeNoTax()));
			table.addCell(cell);
		} else {
			cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.contents.bedrag")).setItalic();
			table.addCell(cell);

			cell = cellNoBorder(1, 6).add(f2.format(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
					.getProperty().getMandatoryCoverage().getContents()));
			table.addCell(cell);
		}
		// -------------------------------------------------
		cell = cellNoBorder(1, 2).add("");
		table.addCell(cell);

		cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.contents.natuurrampen"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f4.format(propertyPremiumCatNatCovContent.getPremiumRate()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumCatNatCovContent.getFeeWithTax()));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumCatNatCovContent.getFeeNoTax()));
		table.addCell(cell);
		// -------------------------------------------------
		if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
				.getContentsIndirectLoss()) {
			cell = cellNoBorder(1, 2).add("");
			table.addCell(cell);

			cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.contents.indirectverlies"));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f4.format(propertyPremiumIndirLossContent.getPremiumRate()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumIndirLossContent.getFeeWithTax()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(propertyPremiumIndirLossContent.getFeeNoTax()));
			table.addCell(cell);
		}
		// -------------------------------------------------
		if (proposalPdfData.getProposalInput().getData().getInsuranceAnswers().getProperty().getPremiums()
				.getContentsLegalProtection()) {
			cell = cellNoBorder(1, 2).add("");
			table.addCell(cell);

			cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.contents.rechtsbijstand"));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f4.format(legalProtectionCovContent.getPremiumRate()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(legalProtectionCovContent.getFeeWithTax()));
			table.addCell(cell);

			cell = cellNoBorder(1, 1).add(f2.format(legalProtectionCovContent.getFeeNoTax()));
			table.addCell(cell);
		}
		// -------------------------------------------------
		cell = cellNoBorder(1, 4).add("");
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.contents.totaal"));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(sumPremiumsContentWithTax)).setBorderTop(new SolidBorder(1));
		table.addCell(cell);

		cell = cellNoBorder(1, 1).add(f2.format(sumPremiumsContentNoTax)).setBorderTop(new SolidBorder(1));
		table.addCell(cell);

		// -------------------------------------------------
		cell = cellNoBorder(1, 7).setHeight(20).add("   ");
		table.addCell(cell);
		// -------------------------------------------------
	}
}
