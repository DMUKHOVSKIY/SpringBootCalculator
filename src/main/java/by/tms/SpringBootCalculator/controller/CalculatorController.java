package by.tms.SpringBootCalculator.controller;

import by.tms.SpringBootCalculator.entity.Operation;
import by.tms.SpringBootCalculator.entity.User;
import by.tms.SpringBootCalculator.model.FindHistoryUsernameModel;
import by.tms.SpringBootCalculator.service.CalculatorService;
import by.tms.SpringBootCalculator.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calc")
    public String calcForm(Model model) {
        model.addAttribute("operation", new Operation());
        return "calc";
    }

    @PostMapping("/calc")
    public String calc(@Valid @ModelAttribute("operation") Operation operation, BindingResult bindingResult, Model model, HttpSession session) {
        if(bindingResult.hasErrors()){
            return "calc";
        }
        Object currentUser = session.getAttribute("currentUser");
        Optional<Operation> operation1 = calculatorService.calculate(operation, (User) currentUser);
        if (operation1.isPresent()) {
            model.addAttribute("result", operation.getResult());
        }else{
            model.addAttribute("result", "Upsss");
        }
        return "calc";
    }

    @GetMapping("/history")
    public String historyOfOperationForm(Model model){
        model.addAttribute("username", new FindHistoryUsernameModel());
        return "history";
    }

    @PostMapping("/history")
    public String historyOfOperation(@Valid @ModelAttribute("username")FindHistoryUsernameModel findHistoryUsernameModel,
                                     BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "history";
        }

        model.addAttribute("operations",
                calculatorService.findAllOperationByUsername(findHistoryUsernameModel.getUsername()));
        return "history";
    }
}
