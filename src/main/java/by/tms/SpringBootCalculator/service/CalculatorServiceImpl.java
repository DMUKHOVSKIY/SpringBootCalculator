package by.tms.SpringBootCalculator.service;

import by.tms.SpringBootCalculator.dao.OperationDao;
import by.tms.SpringBootCalculator.entity.Operation;
import by.tms.SpringBootCalculator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    @Autowired
    OperationDao operationDao;

    @Override
    public Optional<Operation> calculate(Operation operation, User user) { //TODO
        switch (operation.getOperation()) {
            case "sum": {
                operation.setResult(operation.getNum1() + operation.getNum2());
                break;
            }
            case "diff": {
                operation.setResult(operation.getNum1() - operation.getNum2());
                break;
            }
            case "mul": {
                operation.setResult(operation.getNum1() * operation.getNum2());
                break;
            }
            case "div": {
                operation.setResult(operation.getNum1() / operation.getNum2());
                break;
            }
        }
        operation.setUser(user);
        operationDao.save(operation);
        return Optional.of(operation);
    }

    @Override
    public List<Operation> findAllOperationByUsername(String username) {
        return operationDao.findAllOperationByUsername(username);
    }
}

