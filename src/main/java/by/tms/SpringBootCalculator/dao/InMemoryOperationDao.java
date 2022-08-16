package by.tms.SpringBootCalculator.dao;

import by.tms.SpringBootCalculator.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryOperationDao implements OperationDao<Operation> {

    List<Operation> operations = new ArrayList();

    @Override

    public void save(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> findAllOperationByUsername(String username) {
        List<Operation> operationOfUser = new ArrayList<>();
        for (Operation operation : operations) {
            if(operation.getUser().getUsername().equals(username)){
                operationOfUser.add(operation);
            }
        }
        return operationOfUser;
    }
}
