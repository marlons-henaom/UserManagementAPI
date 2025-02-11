package com.project.usermanagament.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.usermanagament.enums.Dependency;
import com.project.usermanagament.enums.Profile;

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
    private String email;
    private String password;
    private LocalDate dateBorn;
    private Boolean active;
    private Dependency dependency;
    private List<Profile> profile;
    private List<Assignment> assignments;

}
