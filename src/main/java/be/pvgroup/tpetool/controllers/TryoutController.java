package be.pvgroup.tpetool.controllers;

import be.pvgroup.tpetool.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TryoutController {

    @GetMapping(path = "/helloworld")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/user")
    @ResponseStatus(HttpStatus.OK)
    public User getUser() {
        return new User("tvde", "tvde@mail.com", "my_pwd");
    }
}
