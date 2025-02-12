package com.project.usermanagement.entities;

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
@Table(name = "\"user\"")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "date_born", nullable = false)
    private LocalDate dateBorn;
    @Column(name = "active", nullable = false)
    private Boolean active;

    // Relation ManyToOne with Dependency (key forbear)
    @ManyToOne
    @JoinColumn(name = "dependency_id", nullable = false)
    private DependencyEntity dependency;

    // Relation ManyToMany with Profile
    @ManyToMany
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "profile_id"})
    )
    private List<ProfileEntity> profile;

}
