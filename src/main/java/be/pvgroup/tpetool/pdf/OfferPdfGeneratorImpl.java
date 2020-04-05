package be.pvgroup.tpetool.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.pages.accidents.AccidentsPageGenerator;
import be.pvgroup.tpetool.pdf.pages.intro.IntroPageGenerator;
import be.pvgroup.tpetool.pdf.pages.liability.LiabilityPageGenerator;
import be.pvgroup.tpetool.pdf.pages.pagenumber.PageNumberGeneratorImpl;
import be.pvgroup.tpetool.pdf.pages.property.PropertyPageGenerator;
import be.pvgroup.tpetool.pdf.pages.summary.SummaryPageGenerator;

@Component
public class OfferPdfGeneratorImpl implements OfferPdfGenerator {

	private static Logger logger = LoggerFactory.getLogger(OfferPdfGeneratorImpl.class);

	@Autowired
	private IntroPageGenerator introPageGenerator;

	@Autowired
	private PropertyPageGenerator propertyPageGenerator;

	@Autowired
	private LiabilityPageGenerator liabilityPageGeneratorImpl;

	@Autowired
	private AccidentsPageGenerator accidentsPageGenerator;

	@Autowired
	private SummaryPageGenerator summaryPageGenerator;

	@Autowired
	private PageNumberGeneratorImpl pageNumberGenerator;

	private Document document;
	private ProposalPdfData proposalPdfData;

	public OfferPdfGeneratorImpl(IntroPageGenerator introPageGenerator, PropertyPageGenerator propertyPageGenerator,
			LiabilityPageGenerator liabilityPageGenerator, AccidentsPageGenerator accidentsPageGenerator,
			SummaryPageGenerator summaryPageGenerator) {
		this.introPageGenerator = introPageGenerator;
		this.propertyPageGenerator = propertyPageGenerator;
		this.liabilityPageGeneratorImpl = liabilityPageGenerator;
		this.accidentsPageGenerator = accidentsPageGenerator;
		this.summaryPageGenerator = summaryPageGenerator;
	}

	public ByteArrayInputStream createPdf(ProposalPdfData proposalPdfData) {
		this.proposalPdfData = proposalPdfData;

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(out));

		PdfFormXObject pdfFormXObject = new PdfFormXObject(new Rectangle(550, 803, 30, 30));

		HeaderHandler handler = new HeaderHandler();
		handler.setTemplate(pdfFormXObject);
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, handler);

		document = new Document(pdf, new PageSize(PageSize.A4), true);

		introPageGenerator.createIntroPage(document, proposalPdfData);
		propertyPageGenerator.createPropertyPage(document, proposalPdfData);
		liabilityPageGeneratorImpl.createLiabilityPage(document, proposalPdfData);
		accidentsPageGenerator.createAccidentsPage(document, proposalPdfData);
		summaryPageGenerator.createSummaryPage(document, proposalPdfData);

		document.close();

		out = pageNumberGenerator.addPageNumbers(out);

		return new ByteArrayInputStream(out.toByteArray());
	}

	public ByteArrayOutputStream createPdfStream(ProposalPdfData proposalPdfData) {
		logger.debug("");
		logger.debug("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(out);
		PdfDocument pdf = new PdfDocument(writer);

		PdfFormXObject pdfFormXObject = new PdfFormXObject(new Rectangle(550, 803, 30, 30));

		HeaderHandler handler = new HeaderHandler();
		handler.setTemplate(pdfFormXObject);
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, handler);

		document = new Document(pdf, new PageSize(PageSize.A4), true);

		introPageGenerator.createIntroPage(document, proposalPdfData);
		propertyPageGenerator.createPropertyPage(document, proposalPdfData);
		liabilityPageGeneratorImpl.createLiabilityPage(document, proposalPdfData);
		accidentsPageGenerator.createAccidentsPage(document, proposalPdfData);
		summaryPageGenerator.createSummaryPage(document, proposalPdfData);

		document.close();
		logger.debug("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
		logger.debug("");

		out = pageNumberGenerator.addPageNumbers(out);

		return out;
	}

}
