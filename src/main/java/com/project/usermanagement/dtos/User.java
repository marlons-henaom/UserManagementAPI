package com.project.usermanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int id;
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email cant empty")
    @Size(min = 1, max = 50, message = "Email between 1 and 50 characters")
    private String email;
    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password cant empty")
    private String password;
    private LocalDate dateBorn;
    private Boolean active;
    private Dependency dependency;

}
