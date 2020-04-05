package be.pvgroup.tpetool.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.pvgroup.tpetool.model.LiabilityPremium;
import be.pvgroup.tpetool.model.liability.LiabilityInput;
import be.pvgroup.tpetool.service.liability.LiabilityService;

@RestController
@RequestMapping("/api/premium")
public class LiabilityController {

    Logger logger = LoggerFactory.getLogger(LiabilityController.class);

    @Autowired
    private LiabilityService liabilityService;

    public LiabilityController(LiabilityService liabilityService) {
    }

    @PostMapping("/liability")
    @CrossOrigin
    public List<LiabilityPremium> doCalculation(@RequestBody LiabilityInput liabilityInput) {
        logger.debug("Incoming request to do calculation for liability");
        logger.debug("with input: " + liabilityInput);

        return liabilityService.calculate(liabilityInput);
    }
}
