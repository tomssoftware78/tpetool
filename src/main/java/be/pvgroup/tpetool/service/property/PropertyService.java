package be.pvgroup.tpetool.service.property;

import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.property.PropertyInput;

import java.util.List;

public interface PropertyService {

    List<PropertyPremium> calculate(PropertyInput propertyInput);
}
