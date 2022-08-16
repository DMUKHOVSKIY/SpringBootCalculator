package by.tms.SpringBootCalculator.service;

import by.tms.SpringBootCalculator.entity.Operation;
import by.tms.SpringBootCalculator.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface CalculatorService {
    Optional<Operation> calculate(Operation operation, User user);

    List<Operation> findAllOperationByUsername(String username);
}
