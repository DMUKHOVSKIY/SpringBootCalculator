package by.tms.SpringBootCalculator.service;

import by.tms.SpringBootCalculator.dao.InMemoryUserDao;
import by.tms.SpringBootCalculator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();

    public void save(User user) {
        inMemoryUserDao.save(user);
    }

    public Optional<User> findByUsername(String username){
        return inMemoryUserDao.findByUsername(username);
    }
}
