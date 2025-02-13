package com.project.usermanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "\"user_profile\"",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"user_id", "profile_id"})
})
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Relation ManyToOne with Task (key forbear)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    // Relation ManyToOne with User (key forbear)
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private ProfileEntity profile;

}
