package be.pvgroup.tpetool.controllers;

import be.pvgroup.tpetool.model.PropertyPremium;
import be.pvgroup.tpetool.model.property.PropertyInput;
import be.pvgroup.tpetool.service.property.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/premium")
public class PropertyController {

    Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/property")
    @CrossOrigin
    public List<PropertyPremium> doCalculation(@RequestBody PropertyInput propertyInput) {
        logger.debug("Incoming request to do calculation for property");
        logger.debug("with input: " + propertyInput);

        if (propertyInput.getData().getAnswers().getMandatoryCoverage().getContents() == null) {
            logger.debug("Set mandatory coverage - contents to zero");
            propertyInput.getData().getAnswers().getMandatoryCoverage().setContents(BigDecimal.ZERO);
        }
        return this.propertyService.calculate(propertyInput);

    }
}
