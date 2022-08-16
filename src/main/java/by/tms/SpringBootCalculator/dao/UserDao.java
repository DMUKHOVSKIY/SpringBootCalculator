package by.tms.SpringBootCalculator.dao;

import by.tms.SpringBootCalculator.entity.User;

import java.util.Optional;

public interface UserDao<T> {
    public void save(T user);

    public Optional<T> findByUsername(String username);

}
