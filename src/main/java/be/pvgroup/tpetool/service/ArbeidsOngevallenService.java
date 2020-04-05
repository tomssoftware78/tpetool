package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.ArbeidsOngevallenInput;
import be.pvgroup.tpetool.model.Premie;

import java.util.List;

public interface ArbeidsOngevallenService {

    List<Premie> calculate(ArbeidsOngevallenInput arbeidsOngevallenInput);
}
