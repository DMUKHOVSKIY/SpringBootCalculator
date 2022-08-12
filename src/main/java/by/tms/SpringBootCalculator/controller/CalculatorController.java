package by.tms.SpringBootCalculator.controller;

import by.tms.SpringBootCalculator.entity.Operation;
import by.tms.SpringBootCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calc")
    public String calc(){
        return "calc";
    }

    @PostMapping("/calc")
    public String calc(Operation operation, Model model){
       model.addAttribute("result",calculatorService.calculate(operation));
       return "calc";
    }
}
