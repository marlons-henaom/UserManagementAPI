package com.project.usermanagament.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Assignment {
    private Task task;
    private int duration;
}
