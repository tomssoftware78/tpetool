package be.pvgroup.tpetool.pdf;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;

public class PdfUtil {

    public static Color viviumOrgange() {
        return new DeviceRgb(230, 120, 18);
    }

    public static Cell cellNoBorder(int rowspan, int colspan) {
        return new Cell(rowspan, colspan)
                .setBorder(Border.NO_BORDER)
                .setFontSize(9);

    }

    public static Cell cellBorderTop(int rowspan, int colspan) {
        return new Cell(rowspan, colspan)
                .setBorder(Border.NO_BORDER)
                .setBorderTop(new SolidBorder(viviumOrgange(), 0))
                .setFontSize(9);

    }

    public static Cell cellBorderTop(int rowspan, int colspan, Color color) {
        return new Cell(rowspan, colspan)
                .setBorder(Border.NO_BORDER)
                .setBorderTop(new SolidBorder(color, 0))
                .setFontSize(9);

    }

    public static Cell cellBorderBottom(int rowspan, int colspan, Color borderColor) {
        return new Cell(rowspan, colspan)
                .setBorder(Border.NO_BORDER)
                .setBorderBottom(new SolidBorder(borderColor, 0))
                .setFontSize(9);
    }

    public static Cell cellBorderAll(int rowspan, int colspan, Color borderColor) {
        return new Cell(rowspan, colspan)
                .setBorder(Border.NO_BORDER)
                .setBorderBottom(new SolidBorder(borderColor, 0))
                .setBorderTop(new SolidBorder(borderColor, 0))
                .setBorderLeft(new SolidBorder(borderColor, 0))
                .setBorderRight(new SolidBorder(borderColor, 0))
                .setFontSize(9);
    }

    public static Cell cellBorderLeft(int rowspan, int colspan, Color borderColor) {
        return new Cell(rowspan, colspan)
                .setBorder(Border.NO_BORDER)
                .setBorderLeft(new SolidBorder(borderColor, 0))
                .setFontSize(9);
    }
}
