package by.tms.SpringBootCalculator.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class PasswordModel {
    @NotBlank
    @NotEmpty
    private String oldPassword;
    @NotBlank
    @NotEmpty
    private String newPassword;
}
