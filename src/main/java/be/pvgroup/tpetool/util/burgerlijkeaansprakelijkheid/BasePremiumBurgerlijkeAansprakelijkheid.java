package be.pvgroup.tpetool.util.burgerlijkeaansprakelijkheid;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BasePremiumBurgerlijkeAansprakelijkheid {
    public static final Map<String, BigDecimal> bauMap;
    public static final Map<String, BigDecimal> tgMap;
    public static final Map<String, BigDecimal> banlMap;

    public static final Map<String, BigDecimal> rcBaMap;
    public static final Map<String, String> basisFormule;

    static {
        bauMap = new HashMap<String, BigDecimal>();
        bauMap.put("56101", new BigDecimal(0.8));
        bauMap.put("56102", new BigDecimal(0.8));
        bauMap.put("56210", new BigDecimal(0.8));

        tgMap = new HashMap<String, BigDecimal>();
        tgMap.put("56101", new BigDecimal(0.1));
        tgMap.put("56102", new BigDecimal(0.1));
        tgMap.put("56210", new BigDecimal(0.1));

        banlMap = new HashMap<String, BigDecimal>();
        banlMap.put("56101", new BigDecimal(0.1));
        banlMap.put("56102", new BigDecimal(0.1));
        banlMap.put("56210", new BigDecimal(0.1));

        rcBaMap = new HashMap<String, BigDecimal>();
        rcBaMap.put("56101", new BigDecimal(2));
        rcBaMap.put("56102", new BigDecimal(2));
        rcBaMap.put("56210", new BigDecimal(5));

        basisFormule = new HashMap<String, String>();
        basisFormule.put("56101", "D2");
        basisFormule.put("56102", "D2");
        basisFormule.put("56210", "D1");


    }

}
