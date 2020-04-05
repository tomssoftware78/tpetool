package be.pvgroup.tpetool.controllers;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.accidents.AccidentsInput;
import be.pvgroup.tpetool.service.accidents.AccidentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premium")
public class AccidentsController {

    Logger logger = LoggerFactory.getLogger(AccidentsController.class);

    @Autowired
    private AccidentsService accidentsService;

    public AccidentsController(AccidentsService accidentsService) {
        this.accidentsService = accidentsService;
    }

    @PostMapping("/accidents")
    @CrossOrigin
    public List<AccidentPremium> doCalculation(@RequestBody AccidentsInput accidentsInput) {

        logger.debug("Incoming request to do calculation for accidents");
        logger.debug("\twith input: " + accidentsInput);


        return accidentsService.calculate(accidentsInput);
    }
}
