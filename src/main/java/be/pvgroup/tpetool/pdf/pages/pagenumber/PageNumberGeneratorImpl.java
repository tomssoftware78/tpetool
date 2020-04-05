package be.pvgroup.tpetool.pdf.pages.pagenumber;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import be.pvgroup.tpetool.pdf.OfferPdfGeneratorImpl;
import be.pvgroup.tpetool.util.LanguageLabel;

@Component
public class PageNumberGeneratorImpl {

	private static Logger logger = LoggerFactory.getLogger(PageNumberGeneratorImpl.class);

	@Autowired
	private LanguageLabel languageLabel;

	// not OK to return a ByteArrayOutputStream just for the sake of having a byte
	// array to read from. Had to conform to the current architecture.
	public ByteArrayOutputStream addPageNumbers(ByteArrayOutputStream inDataStream) {

		ByteArrayOutputStream newPDFOutputStream = null;
		try {
			InputStream exitingPDFInputStream = new ByteArrayInputStream(inDataStream.toByteArray());
			newPDFOutputStream = new ByteArrayOutputStream();

			PdfDocument pdfDoc = new PdfDocument(new PdfReader(exitingPDFInputStream),
					new PdfWriter(newPDFOutputStream));

			Document doc = new Document(pdfDoc);
			int n = pdfDoc.getNumberOfPages();
			for (int i = 1; i <= n; i++) {
				doc.showTextAligned(new Paragraph(String.format("page %s of %s", i, n)), 100, 10, i,
						TextAlignment.RIGHT, VerticalAlignment.BOTTOM, 0);
			}
			doc.close();

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		return newPDFOutputStream;

	}
}
