package com.yeswanth.expensetrackerapi.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {
    @NotBlank(message = "Name should not be empty")
    private String name;

    @NotNull(message = "password should not be empty")
    @Size(min =5, message ="Password should be atleast 5 characters")
    private String password;

    @NotNull(message = "Email should not be empty")
    @Email(message = "Enter a valid email")
    private String email;

    private Long age = 0L;
}
