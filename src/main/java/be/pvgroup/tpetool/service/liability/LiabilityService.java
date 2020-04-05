package be.pvgroup.tpetool.service.liability;

import be.pvgroup.tpetool.model.LiabilityPremium;
import be.pvgroup.tpetool.model.Premie;
import be.pvgroup.tpetool.model.accidents.AccidentsInput;
import be.pvgroup.tpetool.model.liability.LiabilityInput;

import java.math.BigDecimal;
import java.util.List;

public interface LiabilityService {
    List<LiabilityPremium> calculate(LiabilityInput liabilityInput);
    BigDecimal calculateTotalNumbersOfEmployees(LiabilityInput liabilityInput);
}
