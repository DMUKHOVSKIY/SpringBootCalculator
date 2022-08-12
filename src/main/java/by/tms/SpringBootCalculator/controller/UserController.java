package by.tms.SpringBootCalculator.controller;

import by.tms.SpringBootCalculator.entity.User;
import by.tms.SpringBootCalculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String registration() {
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(User user) {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        Optional<User> byUsername = userService.findByUsername(user.getUsername());
        if (byUsername.isPresent()) {
            User user1 = byUsername.get();
            if (user1.getPassword().equals(user.getPassword())) {
                model.addAttribute("message", "Welcome!");
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else {
            model.addAttribute("message", "User not found!");
            return "login";
        }
        return "calc";
    }

}
