package be.pvgroup.tpetool.service.accidents;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.Premie;
import be.pvgroup.tpetool.model.accidents.AccidentsInput;

import java.util.List;

public interface AccidentsService {
    List<AccidentPremium> calculate(AccidentsInput accidentsInput);
}
