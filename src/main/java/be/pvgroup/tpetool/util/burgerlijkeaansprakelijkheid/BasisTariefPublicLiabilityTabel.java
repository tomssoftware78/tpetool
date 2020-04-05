package be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid;

import java.math.BigDecimal;

public class BasisTariefPublicLiabilityTabel {

    private static BigDecimal[][]table = {
            { new BigDecimal(53.5600), new BigDecimal(68.5668), new BigDecimal(83.5536), new BigDecimal(98.5504), new BigDecimal(114.6184), new BigDecimal(131.7576), new BigDecimal(148.8968), new BigDecimal(166.0360), new BigDecimal(183.1752), new BigDecimal(203.5280) },
            { new BigDecimal(74.9840), new BigDecimal(92.1232), new BigDecimal(109.2624), new BigDecimal(126.4016), new BigDecimal(144.6120), new BigDecimal(167.1072), new BigDecimal(189.6024), new BigDecimal(212.0976), new BigDecimal(234.5928), new BigDecimal(257.0880)} ,
            { new BigDecimal(107.1200), new BigDecimal(139.2560), new BigDecimal(171.3920), new BigDecimal(203.5280), new BigDecimal(235.6640), new BigDecimal(272.0848), new BigDecimal(308.5056), new BigDecimal(344.9264), new BigDecimal(381.3472), new BigDecimal(417.7680) },
            { new BigDecimal(160.6800), new BigDecimal(208.8840), new BigDecimal(257.0880), new BigDecimal(305.2920), new BigDecimal(356.7096), new BigDecimal(410.2696), new BigDecimal(463.8296), new BigDecimal(517.3896), new BigDecimal(570.9496), new BigDecimal(626.6520) },
            { new BigDecimal(224.9520), new BigDecimal(279.5832), new BigDecimal(334.2144), new BigDecimal(388.8456), new BigDecimal(444.5480), new BigDecimal(512.0336), new BigDecimal(579.5192), new BigDecimal(647.0048), new BigDecimal(714.4904), new BigDecimal(781.9760) },
            { new BigDecimal(294.5800), new BigDecimal(356.7096), new BigDecimal(418.8392), new BigDecimal(480.9688), new BigDecimal(546.3120), new BigDecimal(640.5776), new BigDecimal(734.8432), new BigDecimal(829.1088), new BigDecimal(923.3744), new BigDecimal(1017.6400) },
            { new BigDecimal(353.4960), new BigDecimal(433.8360), new BigDecimal(514.1760), new BigDecimal(594.5160), new BigDecimal(674.8560), new BigDecimal(796.9728), new BigDecimal(919.0896), new BigDecimal(1041.2064), new BigDecimal(1163.3232), new BigDecimal(1285.4400) },
            { new BigDecimal(460.6160), new BigDecimal(562.3800), new BigDecimal(664.1440), new BigDecimal(765.9080), new BigDecimal(867.6720), new BigDecimal(1026.2096), new BigDecimal(1184.7472), new BigDecimal(1343.2848), new BigDecimal(1501.8224), new BigDecimal(1660.3600) },
            { new BigDecimal(642.7200), new BigDecimal(794.8304), new BigDecimal(946.9408), new BigDecimal(1099.0512), new BigDecimal(1253.3040), new BigDecimal(1468.6152), new BigDecimal(1683.9264), new BigDecimal(1899.2376), new BigDecimal(2114.5488), new BigDecimal(2329.8600) },
            { new BigDecimal(910.5200), new BigDecimal(1092.6240), new BigDecimal(1274.7280), new BigDecimal(1456.8320), new BigDecimal(1638.9360), new BigDecimal(1953.8688), new BigDecimal(2268.8016), new BigDecimal(2583.7344), new BigDecimal(2898.6672), new BigDecimal(3213.6000) },
            { new BigDecimal(1103.3360), new BigDecimal(1319.7184), new BigDecimal(1536.1008), new BigDecimal(1752.4832), new BigDecimal(1971.0080), new BigDecimal(2348.0704), new BigDecimal(2725.1328), new BigDecimal(3102.1952), new BigDecimal(3479.2576),  new BigDecimal(3856.3200) }
    };

    public static BigDecimal getTarifRc(int row, int col) {
        int i = row - 1;
        int j = col - 1;

        BigDecimal result = BigDecimal.ZERO;

        try {
            result = table[i][j];
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        return table[i][j];
    }


}
