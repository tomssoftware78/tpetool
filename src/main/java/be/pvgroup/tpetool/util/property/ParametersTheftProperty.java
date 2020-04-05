package be.pvgroup.tpetool.util.property;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParametersTheftProperty {

    private static Map<Integer, BigDecimal> basisTariefDiefstal_Regio_A;
    private static Map<Integer, BigDecimal> basisTariefDiefstal_Regio_B;
    private static Map<Integer, BigDecimal> basisTariefDiefstal_Regio_C;
    public static Map<String, Map<Integer, BigDecimal>> basisTariefDiefstal;

    public static Integer[] postCodeIntervals = {
        1000, 1315, 1320, 1325, 1340, 1350, 1360, 1380, 1390, 1400, 1401, 1410, 1421, 1430, 1435, 1540, 1560, 1570, 1600, 1620,
        1651, 1670, 1700, 1701, 1702, 1703, 1731, 1740, 1745, 1750, 1760, 1780, 1785, 1790, 1800, 1840, 1850, 1851, 1853, 1861,
        1880, 1910, 1932, 1890, 2000, 2030, 2220, 2230, 2235, 2240, 2260, 2270, 2290, 2390, 2400, 2460, 2480, 2520, 2530, 2550,
        2560, 2580, 2590, 2600, 2620, 2800, 2830, 2850, 2900, 2940, 2950, 2980, 2990, 3060, 3080, 3110, 3150, 3200, 3270, 3500,
        3520, 3530, 3540, 3560, 3570, 3600, 3660, 3670, 3690, 3920, 3930, 3945, 3950, 3980, 3990, 4000, 4130, 4420, 4450, 4700,
        4800, 4840, 4860, 4910, 4920, 4950, 5000, 5001, 5004, 5020, 5100, 5140, 5310, 5330, 5360, 5520, 5521, 5523, 5561, 5570,
        5641, 5644, 6000, 6210, 6460, 6470, 6560, 6940, 6941, 7000, 7012, 7140, 7180, 7370, 7390, 7502, 7600, 7608, 7700, 7730,
        7800, 7830, 7850, 7860, 8300, 8310, 8500, 8520, 8550, 8570, 8930, 8940, 9000, 9040, 9051, 9060, 9100, 9120, 9160, 9170,
        9250, 9255, 9830, 9850
    };

    public static String[] postCodeClasses = {
        "C", "B", "A", "C", "B", "A", "B", "C", "B", "C", "B", "C", "B", "A", "B", "A", "C", "A", "B", "C",
        "B", "A", "C", "B", "C", "B", "C", "B", "A", "B", "A", "C", "B", "A", "B", "A", "C", "B", "C", "B",
        "A", "B", "C", "B", "C", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B",
        "A", "B", "A", "C", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "C", "B", "A", "B", "A", "B",
        "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "C", "B", "C", "B", "A",
        "B", "A", "B", "A", "B", "A", "C", "B", "C", "B", "C", "B", "A", "B", "A", "B", "A", "B", "A", "B",
        "A", "B", "C", "B", "A", "B", "A", "B", "A", "C", "B", "C", "B", "A", "B", "A", "B", "A", "B", "A",
        "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A", "B", "A",
        "B", "A", "B", "A"
    };


    static {
        basisTariefDiefstal_Regio_A = new HashMap<Integer, BigDecimal>();
        basisTariefDiefstal_Regio_A.put(1, new BigDecimal(1.267896));
        basisTariefDiefstal_Regio_A.put(2, new BigDecimal(1.491642));
        basisTariefDiefstal_Regio_A.put(3, new BigDecimal(1.94562));
        basisTariefDiefstal_Regio_A.put(4, new BigDecimal(2.81034));
        basisTariefDiefstal_Regio_A.put(5, new BigDecimal(3.67506));
        basisTariefDiefstal_Regio_A.put(6, new BigDecimal(5.51259));
        basisTariefDiefstal_Regio_A.put(7, new BigDecimal(1.118732));

        basisTariefDiefstal_Regio_B = new HashMap<Integer, BigDecimal>();
        basisTariefDiefstal_Regio_B.put(1, new BigDecimal(1.497587));
        basisTariefDiefstal_Regio_B.put(2, new BigDecimal(1.761867));
        basisTariefDiefstal_Regio_B.put(3, new BigDecimal(2.37798));
        basisTariefDiefstal_Regio_B.put(4, new BigDecimal(3.512925));
        basisTariefDiefstal_Regio_B.put(5, new BigDecimal(4.593825));
        basisTariefDiefstal_Regio_B.put(6, new BigDecimal(6.890738));
        basisTariefDiefstal_Regio_B.put(7, new BigDecimal(1.3214));

        basisTariefDiefstal_Regio_C = new HashMap<Integer, BigDecimal>();
        basisTariefDiefstal_Regio_C.put(1, new BigDecimal(1.865093));
        basisTariefDiefstal_Regio_C.put(2, new BigDecimal(2.194227));
        basisTariefDiefstal_Regio_C.put(3, new BigDecimal(3.188655));
        basisTariefDiefstal_Regio_C.put(4, new BigDecimal(4.701915));
        basisTariefDiefstal_Regio_C.put(5, new BigDecimal(6.107085));
        basisTariefDiefstal_Regio_C.put(6, new BigDecimal(9.160628));
        basisTariefDiefstal_Regio_C.put(7, new BigDecimal(1.64567));

        basisTariefDiefstal = new HashMap<String, Map<Integer, BigDecimal>>();
        basisTariefDiefstal.put("A", basisTariefDiefstal_Regio_A);
        basisTariefDiefstal.put("B", basisTariefDiefstal_Regio_B);
        basisTariefDiefstal.put("C", basisTariefDiefstal_Regio_C);
    }

    public static BigDecimal getBasisTariefDiefstal(String postCodeClass, Integer theftClass) {
        Map<Integer, BigDecimal> basisTarieven_Regio = basisTariefDiefstal.get(postCodeClass);

        BigDecimal basisTarief = basisTarieven_Regio.get(theftClass);
        return basisTarief;

    }

    public static String postCodeClass(String postCode) {
        Integer postCodeValue = Integer.valueOf(postCode);

        int postCodeIndex = 0;

        for (int i = 1; i < postCodeIntervals.length; i++) {
            if (postCodeIntervals[i].compareTo(postCodeValue) > 0) {
                postCodeIndex = i - 1;
                break;
            }
        }

        return postCodeClasses[postCodeIndex];
    }
}
