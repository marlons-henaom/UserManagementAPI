package com.project.usermanagement.entities;

import com.project.usermanagement.dtos.Task;
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
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    // Relation ManyToOne with User (key forbear)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "duration", nullable = false)
    private int duration;

}
