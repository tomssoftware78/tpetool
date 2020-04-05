package be.pvgroup.tpetool.service;

import be.pvgroup.tpetool.model.User;
import be.pvgroup.tpetool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(String email, String password) {
        //userRepository.findAll().forEach(System.out::println);

        Optional<User> loggedinUser =
                StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();

        return loggedinUser;
    }
}
