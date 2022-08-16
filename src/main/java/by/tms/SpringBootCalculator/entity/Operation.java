package by.tms.SpringBootCalculator.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Operation {
    @NotNull
    private double num1;
    @NotNull
    private double num2;
    @NotBlank
    @NotEmpty
    private String operation;
    private double result;
    private User user;

    @Override
    public String toString() {
        return "Name = " + user.getName() + " " + operation + "(" + num1 + "; " + num2 + ")" + " = " + result;
    }
}
