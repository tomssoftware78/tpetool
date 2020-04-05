package be.pvgroup.tpetool.controllers;

import be.pvgroup.tpetool.model.BurgerlijkeAansprakelijkheidInput;
import be.pvgroup.tpetool.service.BurgerlijkeAansprakelijkheidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/burgerlijkeaansprakelijkheid")
public class BurgerlijkeAansprakelijkheidController {

    @Autowired
    private BurgerlijkeAansprakelijkheidService burgerlijkeAansprakelijkheidService;

    public BurgerlijkeAansprakelijkheidController(BurgerlijkeAansprakelijkheidService burgerlijkeAansprakelijkheidService) {
        this.burgerlijkeAansprakelijkheidService = burgerlijkeAansprakelijkheidService;
    }

    @PostMapping("/calculate")
    public String[] doCalculation(@RequestBody BurgerlijkeAansprakelijkheidInput burgerlijkeAansprakelijkheidInput) {
        System.out.println(burgerlijkeAansprakelijkheidInput.toString());
        burgerlijkeAansprakelijkheidService.calculate(burgerlijkeAansprakelijkheidInput);
        return new String[] {"test", "test1", "test2"};
    }
}
