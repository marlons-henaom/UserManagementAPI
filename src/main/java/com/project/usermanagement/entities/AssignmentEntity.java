package com.project.usermanagement.entities;

import com.project.usermanagement.dtos.Dependency;
import com.project.usermanagement.dtos.Profile;
import com.project.usermanagement.dtos.Task;
import com.project.usermanagement.dtos.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "\"assignment\"",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"task_id", "user_id"})
})
public class AssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Relation ManyToOne with Task (key forbear)
    @ManyToMany
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    // Relation ManyToOne with User (key forbear)
    @ManyToMany
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "duration", nullable = false)
    private int duration;

}
