package by.tms.SpringBootCalculator.service;

import by.tms.SpringBootCalculator.dao.OperationDao;
import by.tms.SpringBootCalculator.entity.Operation;
import by.tms.SpringBootCalculator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeService {

    @Autowired
    private OperationDao<Operation> operations;

    public String changeName(String name, User user) {
        user.setName(name);
        changeAllOperationsByUserName(user.getUsername(), name);
        return user.getName();
    }

    public void changePassword(String newPassword, User user) {
        user.setPassword(newPassword);
    }

    private void changeAllOperationsByUserName(String username, String newName) {
        for (Operation operation : operations.findAllOperationByUsername(username)) {
            operation.getUser().setName(newName);
        }
    }
}
