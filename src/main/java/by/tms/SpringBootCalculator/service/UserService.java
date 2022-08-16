package by.tms.SpringBootCalculator.service;

import by.tms.SpringBootCalculator.entity.User;

import java.util.Optional;

public interface UserService {
    boolean save(User user);

    Optional<User> findByUsername(String username);
}
