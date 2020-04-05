package be.pvgroup.tpetool.pdf.pages.intro;

import be.pvgroup.tpetool.model.User;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.pdf.OfferPdfGeneratorImpl;
import be.pvgroup.tpetool.pdf.pages.intro.blocks.betaling.BetalingBlock;
import be.pvgroup.tpetool.pdf.pages.intro.blocks.kandidaat.KandidaatBlock;
import be.pvgroup.tpetool.pdf.pages.intro.blocks.tussenpersoon.TussenpersoonBlock;
import be.pvgroup.tpetool.util.LanguageLabel;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

@Component
public class IntroPageGeneratorImpl implements IntroPageGenerator {

	private static Logger logger = LoggerFactory.getLogger(IntroPageGeneratorImpl.class);

	@Autowired
	private LanguageLabel languageLabel;

	@Autowired
	private TussenpersoonBlock tussenpersoonBlock;
	@Autowired
	private BetalingBlock betalingBlock;
	@Autowired
	private KandidaatBlock kandidaatBlock;

	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public void createIntroPage(Document document, ProposalPdfData proposalPdfData) {
		logger.debug("start creation intro page");

		// HACK: we don't yet have a proper authentication mechanism in place, all is
		// mocked up, therefore, for now, I'm sending username and decide the
		// organisation based
		// on e-mail address;
		ImageData imageData = null;
		try {
			InputStream imageInputStream = resourceLoader.getResource("classpath:images/logo_pv.jpg").getInputStream();

			if (User.COMPANY_VIVIUM.equals(proposalPdfData.getCompany())) {
				imageInputStream = resourceLoader.getResource("classpath:images/logo_vivium.jpg").getInputStream();
			}

			BufferedImage imgLogo = ImageIO.read(imageInputStream);
			imageData = ImageDataFactory.create(imgLogo, null);

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("logo images cannot be loaded");
		}
		Image img = new Image(imageData);
		Table tableImg = new Table(1);
		tableImg.setBorder(Border.NO_BORDER);

		Cell cellImg = new Cell().setBorder(Border.NO_BORDER);
		cellImg.add(img);
		cellImg.setPaddingBottom(30);
		cellImg.setPaddingLeft(30);

		tableImg.addCell(cellImg);
		document.add(tableImg);

		Table table = new Table(7);
		table.setBorder(Border.NO_BORDER);
		PdfFont titleFont = null;
		try {
			titleFont = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}

		Paragraph titleParagraph = new Paragraph(languageLabel.getLabel("title.offer")).setFont(titleFont);
		titleParagraph.setFontSize(25);
		titleParagraph.setTextAlignment(TextAlignment.CENTER);

		document.add(titleParagraph);
		document.add(new Paragraph());

		tussenpersoonBlock.createTussenpersoonBlock(document, proposalPdfData);

		table = new Table(7);
		table.setBorder(Border.NO_BORDER);
		table.addCell(cellNoBorder(1, 7).setHeight(20).add("   "));

		document.add(table);

		betalingBlock.createBetalingBlock(document, proposalPdfData);

		table = new Table(7);
		table.setBorder(Border.NO_BORDER);
		table.addCell(cellNoBorder(1, 7).setHeight(20).add("   "));
		document.add(table);

		kandidaatBlock.createKandidaatBlock(document, proposalPdfData);

		logger.debug("end creation intro page");
	}
}
