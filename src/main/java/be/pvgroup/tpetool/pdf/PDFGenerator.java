package be.pvgroup.tpetool.pdf;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PDFGenerator {

	/*
	 * doc.add(new Paragraph(String.format(
	 * "You have submitted the following text using the %s method:",
	 * request.getMethod()))); doc.add(new Paragraph(text)); doc.close();
	 * 
	 * // setting some response headers response.setHeader("Expires", "0");
	 * response.setHeader("Cache-Control",
	 * "must-revalidate, post-check=0, pre-check=0"); response.setHeader("Pragma",
	 * "public"); // setting the content type
	 * response.setContentType("application/pdf"); // the contentlength
	 * response.setContentLength(baos.size()); // write ByteArrayOutputStream to the
	 * ServletOutputStream OutputStream os = response.getOutputStream();
	 * baos.writeTo(os); os.flush(); os.close();
	 */

	private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

	public static ByteArrayInputStream createPdf() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(out));

		Document document = new Document(pdf);

		Table table = new Table(3);
		Cell cell = new Cell(1, 3).setTextAlignment(TextAlignment.CENTER).add("Cell with colspan 3");
		table.addCell(cell);
		cell = new Cell(2, 1).add("Cell with rowspan 2").setVerticalAlignment(VerticalAlignment.MIDDLE);
		table.addCell(cell);
		table.addCell("Cell 1.1");
		table.addCell(new Cell().add("Cell 1.2"));
		table.addCell(new Cell().add("Cell 2.1").setBackgroundColor(Color.LIGHT_GRAY).setMargin(5));
		table.addCell(new Cell().add("Cell 1.2").setBackgroundColor(Color.LIGHT_GRAY).setPadding(5));
		document.add(table);

		table = new Table(3);
		cell = new Cell(1, 3).setTextAlignment(TextAlignment.CENTER).add("Cell with colspan 3");
		table.addCell(cell);
		cell = new Cell(2, 1).add("Cell with rowspan 2").setVerticalAlignment(VerticalAlignment.MIDDLE);
		table.addCell(cell);
		table.addCell("Cell 1.1");
		table.addCell(new Cell().add("Cell 1.2"));
		table.addCell(new Cell().add("Cell 2.1").setBackgroundColor(Color.LIGHT_GRAY).setMargin(5));
		table.addCell(new Cell().add("Cell 1.2").setBackgroundColor(Color.LIGHT_GRAY).setPadding(5));
		document.add(table);

		document.close();
		return new ByteArrayInputStream(out.toByteArray());

	}

	/*
	 * public static final String LOGO_PV = "\\vivium\\pdf_resources\\logo_pv.jpg";
	 * 
	 * private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);
	 * 
	 * public static ByteArrayInputStream customerPDFReport() {
	 * 
	 * Document document = new Document(); ByteArrayOutputStream out = new
	 * ByteArrayOutputStream();
	 * 
	 * 
	 * try { PdfWriter.getInstance(document, out); document.open();
	 * 
	 * 
	 * // Add Text to PDF file -> Font font =
	 * FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK); Paragraph para
	 * = new Paragraph( "Customer Table", font);
	 * para.setAlignment(Element.ALIGN_CENTER); document.add(para);
	 * document.add(Chunk.NEWLINE);
	 * 
	 * PdfPTable table = new PdfPTable(3);
	 * 
	 * // Add PDF Table LiabilityIntroHeader -> Stream.of("ID", "First Name",
	 * "Last Name") .forEach(headerTitle -> { PdfPCell header = new PdfPCell(); Font
	 * headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	 * header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	 * header.setHorizontalAlignment(Element.ALIGN_CENTER);
	 * header.setBorderWidth(2); header.setPhrase(new Phrase(headerTitle,
	 * headFont)); table.addCell(header); }); document.add(table);
	 * 
	 * Param p = new Paragraph() PdfPTable table0 = new PdfPTable(2);
	 * table0.setWidthPercentage(100); table0.addCell(createImageCell(LOGO_PV));
	 * document.add(table0);
	 * 
	 * 
	 * document.close(); } catch (DocumentException e) { logger.error(e.toString());
	 * }
	 * 
	 * return new ByteArrayInputStream(out.toByteArray());
	 * 
	 * }
	 * 
	 * public static PdfPCell createImageCell(String path) throws IOException,
	 * BadElementException { //ImageDataFactory Image img = Image.getInstance(path);
	 * PdfPCell cell = new PdfPCell(img, true); cell.set
	 * 
	 * return cell; }
	 */
}
