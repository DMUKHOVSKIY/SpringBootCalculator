package by.tms.SpringBootCalculator.service;

import by.tms.SpringBootCalculator.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(Operation operation) {
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
        return operation.getResult();
    }
}

