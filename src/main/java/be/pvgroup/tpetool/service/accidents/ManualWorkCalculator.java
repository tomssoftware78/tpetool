package be.pvgroup.tpetool.service.accidents;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.accidents.Beneficiary;

public interface ManualWorkCalculator {

    AccidentPremium calculatePremium(Beneficiary beneficiary, String nacebel);
}
