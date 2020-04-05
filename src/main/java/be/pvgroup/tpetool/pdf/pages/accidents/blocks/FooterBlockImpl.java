package be.pvgroup.tpetool.pdf.pages.accidents.blocks;

import be.pvgroup.tpetool.model.User;
import be.pvgroup.tpetool.model.pdf.ProposalPdfData;
import be.pvgroup.tpetool.util.LanguageLabel;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static be.pvgroup.tpetool.pdf.PdfUtil.cellNoBorder;

@Component
public class FooterBlockImpl implements FooterBlock {
    @Autowired
    private LanguageLabel languageLabel;

    @Override
    public void createFooterBlock(Table table, ProposalPdfData proposalPdfData) {
        Cell cell = cellNoBorder(1, 7).add(languageLabel.getLabel("accidents.footer"));
        table.addCell(cell);

        String footerRef = null;
		if (User.COMPANY_VIVIUM.equals(proposalPdfData.getCompany())) {
			footerRef = languageLabel.getLabel("accidents.footer.article.vivium");
		} else {
			footerRef = languageLabel.getLabel("accidents.footer.article.pv");
		}

        cell = cellNoBorder(1, 7).add(footerRef);
        table.addCell(cell);

        //-------------------------------------------------
        cell = cellNoBorder(1, 7).setHeight(20).add("   ");
        table.addCell(cell);
        //-------------------------------------------------
    }
}
