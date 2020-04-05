package be.pvgroup.tpetool.util.property;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BasePremiumProperty {

	public static final BigDecimal coefBrandHuurderUitbater = new BigDecimal(0.88);
	public static final BigDecimal coefInhoud = new BigDecimal(1.13);

	public static final Map<String, Integer> brandKlasseMap;

	public static final Map<String, String> brandKlasseTheftFireMap;

	private static Map<String, BigDecimal> brandEigenaarUitbaterMap;
	private static Map<String, BigDecimal> brandHuurderUitbaterMap;
	private static Map<String, BigDecimal> inhoudMap;

	public static final Map<String, Integer> diefstapMap;
	public static final Map<String, BigDecimal> schadeKoopwaardeMap;
	public static final Map<String, BigDecimal> scoringHorecaMap;

	static {
		brandKlasseMap = new HashMap<String, Integer>();
		brandKlasseMap.put("56101", 5);
		brandKlasseMap.put("56102", 2);
		brandKlasseMap.put("56210", 5);

		brandKlasseTheftFireMap = new HashMap<String, String>();
		brandKlasseTheftFireMap.put("56101", "5/3");
		brandKlasseTheftFireMap.put("56102", "2/2");
		brandKlasseTheftFireMap.put("56210", "5/2");

		brandEigenaarUitbaterMap = new HashMap<String, BigDecimal>();
		brandEigenaarUitbaterMap.put("56101", new BigDecimal(2.584211396));
		brandEigenaarUitbaterMap.put("56102", new BigDecimal(1.137487277));
		brandEigenaarUitbaterMap.put("56210", new BigDecimal(2.584211396));
		setBrandeigenaaruitbatermap(brandEigenaarUitbaterMap);

		brandHuurderUitbaterMap = new HashMap<String, BigDecimal>();
		// brandHuurderUitbaterMap.put("56101",
		// brandEigenaarUitbaterMap.get("56101").multiply(coefBrandHuurderUitbater));
		// brandHuurderUitbaterMap.put("56102",
		// brandEigenaarUitbaterMap.get("56102").multiply(coefBrandHuurderUitbater));
		// brandHuurderUitbaterMap.put("56210",
		// brandEigenaarUitbaterMap.get("56210").multiply(coefBrandHuurderUitbater));
		brandHuurderUitbaterMap.put("56101", new BigDecimal(2.274106029));
		brandHuurderUitbaterMap.put("56102", new BigDecimal(1.000988804));
		brandHuurderUitbaterMap.put("56210", new BigDecimal(2.274106029));
		setBrandhuurderuitbatermap(brandHuurderUitbaterMap);

		inhoudMap = new HashMap<String, BigDecimal>();
		// inhoudMap.put("56101",
		// brandEigenaarUitbaterMap.get("56101").multiply(coefInhoud));
		// inhoudMap.put("56102",
		// brandEigenaarUitbaterMap.get("56102").multiply(coefInhoud));
		// inhoudMap.put("56210",
		// brandEigenaarUitbaterMap.get("56210").multiply(coefInhoud));
		inhoudMap.put("56101", new BigDecimal(3.106551998));
		inhoudMap.put("56102", new BigDecimal(1.275159348));
		inhoudMap.put("56210", new BigDecimal(3.451724442));
		setInhoudmap(inhoudMap);

		diefstapMap = new HashMap<String, Integer>();
		diefstapMap.put("56101", 3);
		diefstapMap.put("56102", 2);
		diefstapMap.put("56210", 2);

		schadeKoopwaardeMap = new HashMap<String, BigDecimal>();
		schadeKoopwaardeMap.put("56101", new BigDecimal(2));
		schadeKoopwaardeMap.put("56102", new BigDecimal(2));
		schadeKoopwaardeMap.put("56210", new BigDecimal(2));

		scoringHorecaMap = new HashMap<String, BigDecimal>();
		scoringHorecaMap.put("56101", new BigDecimal(2));
		scoringHorecaMap.put("56102", new BigDecimal(1));
		scoringHorecaMap.put("56210", new BigDecimal(2));
	}

	public static void setBrandeigenaaruitbatermap(Map<String, BigDecimal> map) {
		brandEigenaarUitbaterMap = Collections.unmodifiableMap(map);
	}

	public static Map<String, BigDecimal> getBrandeigenaaruitbatermap() {
		return brandEigenaarUitbaterMap;
	}

	public static void setBrandhuurderuitbatermap(Map<String, BigDecimal> map) {
		brandHuurderUitbaterMap = Collections.unmodifiableMap(map);
	}

	public static Map<String, BigDecimal> getBrandhuurderuitbatermap() {
		return brandHuurderUitbaterMap;
	}

	public static void setInhoudmap(Map<String, BigDecimal> map) {
		inhoudMap = Collections.unmodifiableMap(map);
	}

	public static Map<String, BigDecimal> getInhoudmap() {
		return inhoudMap;
	}
}
