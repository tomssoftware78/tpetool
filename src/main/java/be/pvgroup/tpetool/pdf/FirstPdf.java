package be.pvgroup.tpetool.pdf;

/*import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.samples.GenericTest;
import com.itextpdf.test.annotations.type.SampleTest;

import org.junit.experimental.categories.Category;
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;



public class FirstPdf {

    /*public static ByteArrayInputStream customerPDFReport() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();


        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            //addMetaData(document);
            addTitlePage(document);
            //addContent(document);
            document.close();





            PdfPTable table = new PdfPTable(UnitValue.createPercentArray(8)).useAllAvailableWidth();
                for (int i = 0; i < 16; i++) {
                    table.addCell("hi");
                }
                doc.add(table);

                doc.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }




        public static final String DEST = "./target/test/resources/sandbox/tables/simple_table.pdf";

        public static void main(String[] args) throws Exception {
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            new SimpleTable().manipulatePdf(DEST);
        }

        @Override
        protected void manipulatePdf(String dest) throws Exception {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
            Document doc = new Document(pdfDoc);

            Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
            for (int i = 0; i < 16; i++) {
                table.addCell("hi");
            }
            doc.add(table);

            doc.close();
        }
    }
    */
}
