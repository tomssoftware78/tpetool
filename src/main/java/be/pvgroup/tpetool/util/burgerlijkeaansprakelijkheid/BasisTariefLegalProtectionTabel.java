package be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid;

import java.math.BigDecimal;

public class BasisTariefLegalProtectionTabel {

    private static BigDecimal[][] table = {
            {new BigDecimal(12.8544), new BigDecimal(13.6578), new BigDecimal(14.4612), new BigDecimal(15.2646), new BigDecimal(16.0680), new BigDecimal(16.0680), new BigDecimal(16.0680), new BigDecimal(16.0680), new BigDecimal(16.0680), new BigDecimal(16.0680)},
            {new BigDecimal(13.9256), new BigDecimal(16.8714), new BigDecimal(19.8172), new BigDecimal(22.7630), new BigDecimal(25.7088), new BigDecimal(26.9942), new BigDecimal(28.2797), new BigDecimal(29.5651), new BigDecimal(30.8506), new BigDecimal(32.1360)},
            {new BigDecimal(21.4240), new BigDecimal(25.7088), new BigDecimal(29.9936), new BigDecimal(34.2784), new BigDecimal(38.5632), new BigDecimal(40.4914), new BigDecimal(42.4195), new BigDecimal(44.3477), new BigDecimal(46.2758), new BigDecimal(48.2040)},
            {new BigDecimal(29.9936), new BigDecimal(36.1530), new BigDecimal(42.3124), new BigDecimal(48.4718), new BigDecimal(54.6312), new BigDecimal(56.5594), new BigDecimal(58.4875), new BigDecimal(60.4157), new BigDecimal(62.3438), new BigDecimal(64.2720)},
            {new BigDecimal(33.2072), new BigDecimal(39.9022), new BigDecimal(46.5972), new BigDecimal(53.2922), new BigDecimal(59.9872), new BigDecimal(64.0578), new BigDecimal(68.1283), new BigDecimal(72.1989), new BigDecimal(76.2694), new BigDecimal(80.3400)},
            {new BigDecimal(34.2784), new BigDecimal(41.2412), new BigDecimal(48.2040), new BigDecimal(55.1668), new BigDecimal(62.1296), new BigDecimal(68.9853), new BigDecimal(75.8410), new BigDecimal(82.6966), new BigDecimal(89.5523), new BigDecimal(96.4080)},
            {new BigDecimal(35.3496), new BigDecimal(42.8480), new BigDecimal(50.3464), new BigDecimal(57.8448), new BigDecimal(65.3432), new BigDecimal(74.7698), new BigDecimal(84.1963), new BigDecimal(93.6229), new BigDecimal(103.0494), new BigDecimal(112.4760)},
            {new BigDecimal(38.5632), new BigDecimal(46.0616), new BigDecimal(53.5600), new BigDecimal(61.0584), new BigDecimal(68.5568), new BigDecimal(80.5542), new BigDecimal(92.5517), new BigDecimal(104.5491), new BigDecimal(116.5466), new BigDecimal(128.5440)},
            {new BigDecimal(39.6344), new BigDecimal(47.4006), new BigDecimal(55.1668), new BigDecimal(62.9330), new BigDecimal(70.6992), new BigDecimal(85.4818), new BigDecimal(100.2643), new BigDecimal(115.0469), new BigDecimal(129.8294), new BigDecimal(144.6120)},
            {new BigDecimal(41.7768), new BigDecimal(49.8108), new BigDecimal(57.8448), new BigDecimal(65.8788), new BigDecimal(73.9128), new BigDecimal(91.2662), new BigDecimal(108.6197), new BigDecimal(125.9731), new BigDecimal(143.3266), new BigDecimal(160.6800)},
            {new BigDecimal(43.9192), new BigDecimal(52.2210), new BigDecimal(60.5228), new BigDecimal(68.8246), new BigDecimal(77.1264), new BigDecimal(97.0507), new BigDecimal(116.9750), new BigDecimal(136.8994), new BigDecimal(156.8237), new BigDecimal(176.7480)}
    };

    public static BigDecimal getTarifPj(int row, int col) {
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