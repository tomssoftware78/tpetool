package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.User;

import java.util.Optional;

public interface LoginService {

    Optional<User> login(String email, String password);
}
