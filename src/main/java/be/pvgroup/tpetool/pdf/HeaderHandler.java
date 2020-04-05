package be.pvgroup.tpetool.pdf;

import com.itextpdf.io.font.FontConstants;


import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;

import java.io.IOException;

public class HeaderHandler implements IEventHandler {
	protected PdfFont font;
	private PdfFormXObject template;

	@Override
	public void handleEvent(Event event) {
		//try {
			//font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
			//PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
			//PdfPage page = docEvent.getPage();
			//int pageNum = docEvent.getDocument().getPageNumber(page);
			//PdfCanvas canvas = new PdfCanvas(page);
			//canvas.beginText();
			//canvas.setFontAndSize(font, 12);
			//canvas.beginMarkedContent(PdfName.Artifact);
			//canvas.moveText(34, 24);
			//int pageCount = docEvent.getDocument().getNumberOfPages();
			//canvas.showText(String.format("%d / %d", pageNum, pageCount));
			//canvas.endText();
			//canvas.stroke();
			//canvas.addXObject(template, 0, 0);
			//canvas.endMarkedContent();
			//canvas.release();

		//} catch (IOException e) {
		//	e.printStackTrace();
		//}

	}

	public void setTemplate(PdfFormXObject template) {
		this.template = template;
	}
}