package com.project.UserManagament.Entities;

import com.project.UserManagament.dto.Assignment;
import com.project.UserManagament.enums.Dependency;
import com.project.UserManagament.enums.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "\"USER\"")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date", nullable = false)
    private LocalDate date_born;
    @Column(name = "active", nullable = false)
    private Boolean active;
//    @Column(name = "USER_DEPENDENCY", nullable = false)
//    private Dependency dependency;
//    @Column(name = "USER_PROFILE", nullable = false)
//    private List<Profile> profile;
//    @Column(name = "USER_ASSIGNMENT", nullable = false)
//    private List<Assignment> assignments;
}
