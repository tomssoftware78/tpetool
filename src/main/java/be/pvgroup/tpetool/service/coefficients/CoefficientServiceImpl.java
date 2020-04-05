
package be.pvgroup.tpetool.service.coefficients;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.pvgroup.tpetool.model.Coefficient;
import be.pvgroup.tpetool.repositories.CoefficientRepository;
import be.pvgroup.tpetool.util.property.BasePremiumProperty;

@Service
public class CoefficientServiceImpl {

	@Autowired
	private CoefficientRepository coefficientRepository;

	public void loadCoefficients() {

		Map<String, BigDecimal> codesMap = coefficientRepository.loadAll();

		Map<String, BigDecimal> brandEigenaarUitbaterMap = new HashMap<String, BigDecimal>(
				BasePremiumProperty.getBrandeigenaaruitbatermap());

		BigDecimal coeff_56101 = codesMap
				.get(CoefficientConstants.TPE_TOOL_PROPERTY_INCENDIE_BRAND_PROPERTY_PROPRIET_EXPLOITANT_56101);
		BigDecimal coeff_56102 = codesMap
				.get(CoefficientConstants.TPE_TOOL_PROPERTY_INCENDIE_BRAND_PROPERTY_PROPRIET_EXPLOITANT_56102);
		BigDecimal coeff_56210 = codesMap
				.get(CoefficientConstants.TPE_TOOL_PROPERTY_INCENDIE_BRAND_PROPERTY_PROPRIET_EXPLOITANT_56210);

		if (coeff_56101 != null) {
			brandEigenaarUitbaterMap.put("56101", coeff_56101);
		}
		if (coeff_56102 != null) {
			brandEigenaarUitbaterMap.put("56102", coeff_56102);
		}
		if (coeff_56210 != null) {
			brandEigenaarUitbaterMap.put("56210", coeff_56210);
		}

		BasePremiumProperty.setBrandeigenaaruitbatermap(brandEigenaarUitbaterMap);

	}

	public Coefficient updateCoefficient(Coefficient coefficient) {
		java.util.Optional<Coefficient> optional = coefficientRepository.findByCode(coefficient.getCode());
		if (!optional.isPresent()) {
			throw new RuntimeException(
					"Coefficient with code " + coefficient.getCode() + " does not exists in the database");
		}
		Coefficient existing = optional.get();
		if (existing.getId() != coefficient.getId()) {
			throw new RuntimeException(
					"Coefficient in DB has different id compared to coefficient from frontend. Something is wrong, stopping.");
		}
		existing.setValue(coefficient.getValue());
		coefficientRepository.save(existing);

		return existing;

	}

}
