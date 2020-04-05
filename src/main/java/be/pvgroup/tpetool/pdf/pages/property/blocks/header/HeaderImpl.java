package be.pvgroup.tpetool.pdf.pages.property.blocks.header;

import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.util.LanguageLabel;
import be.pvgroup.tpetool.util.property.BasePremiumProperty;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;
import static be.pvgroup.tpetool.pdf.PdfUtil.viviumOrgange;

@Component("generalHeader")
public class HeaderImpl implements Header {

        @Autowired
        private LanguageLabel languageLabel;

        @Override
        public void createHeader(Table table, ProposalPdfData proposalPdfData) {
                Cell cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.LEFT).setBold()
                                .setFontColor(viviumOrgange()).setFontSize(10)
                                .add(languageLabel.getLabel("property.title"));
                table.addCell(cell);

                cell = cellNoBorder(1, 5).add("");
                table.addCell(cell);
                // --------------------------------------------------
                cell = cellNoBorder(1, 2).setTextAlignment(TextAlignment.LEFT).setBackgroundColor(viviumOrgange())
                                .setBold().setFontColor(Color.WHITE)
                                .add(languageLabel.getLabel("property.generalTitle"));
                table.addCell(cell);
                table.setBorder(new SolidBorder(viviumOrgange(), 0));

                cell = cellNoBorder(1, 5).add("");
                table.addCell(cell);
                // --------------------------------------------------
                cell = cellNoBorder(1, 7).add(languageLabel.getLabel("property.ligging"));
                table.addCell(cell);
                // --------------------------------------------------
                cell = cellNoBorder(1, 1).add("");
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.straat"));
                table.addCell(cell);

                cell = cellNoBorder(1, 2).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                                .getProperty().getAddress().getStreet());
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.nr"));
                table.addCell(cell);

                cell = cellNoBorder(1, 2).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                                .getProperty().getAddress().getNumber());
                table.addCell(cell);
                // --------------------------------------------------
                cell = cellNoBorder(1, 1).add("");
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.postcode"));
                table.addCell(cell);

                cell = cellNoBorder(1, 2).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                                .getProperty().getAddress().getZip());
                table.addCell(cell);

                cell = cellNoBorder(1, 1).add(languageLabel.getLabel("property.plaats"));
                table.addCell(cell);

                cell = cellNoBorder(1, 2).add(proposalPdfData.getProposalInput().getData().getInsuranceAnswers()
                                .getProperty().getAddress().getCity());
                table.addCell(cell);
                // -------------------------------------------------
                cell = cellNoBorder(1, 7).setHeight(20).add("   ");
                table.addCell(cell);
                // -------------------------------------------------
                cell = cellNoBorder(1, 2).add(languageLabel.getLabel("property.hoedanigheid"));
                table.addCell(cell);

                cell = cellNoBorder(1, 5).add(languageLabel.getLabel(proposalPdfData.getProposalInput().getData()
                                .getInsuranceAnswers().getProperty().getAddress().getQuality().getValue()));
                table.addCell(cell);
                // -------------------------------------------------

                String classBrand = BasePremiumProperty.brandKlasseTheftFireMap
                                .get(proposalPdfData.getProposalInput().getData().getNacebel());

                cell = cellNoBorder(1, 5).add(classBrand);
                table.addCell(cell);
                // -------------------------------------------------
                cell = cellNoBorder(1, 7).setHeight(20).add("   ");
                table.addCell(cell);
        }
}
