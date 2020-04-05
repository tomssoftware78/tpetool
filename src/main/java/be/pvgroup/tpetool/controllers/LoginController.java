package be.pvgroup.tpetool.controllers;

import be.pvgroup.tpetool.model.LoginResult;
import be.pvgroup.tpetool.model.User;
import be.pvgroup.tpetool.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(path = "login")
    @CrossOrigin
    public LoginResult login(@RequestBody User user) {
        Optional<User> loggedinUser = loginService.login(user.getEmail(), user.getPassword());

        String token = "";

        if (loggedinUser.isPresent()) {
            User currentUser = loggedinUser.get();
            token = currentUser.getUsername();

            if (currentUser.getUsername().equals("test")) {
                currentUser.setRoles(Arrays.asList("broker"));
            } else if (currentUser.getUsername().equals("testadmin")) {
                currentUser.setRoles(Arrays.asList("broker"));
            }
        }

        return new LoginResult(token);
    }

    @GetMapping("/api/roles")
    @CrossOrigin
    public List<String> login(@RequestParam(name = "token") String token) {
        System.out.println("token: " + token);
        return Arrays.asList("admin");
    }
}
