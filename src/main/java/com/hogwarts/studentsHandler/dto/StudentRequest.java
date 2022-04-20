package com.hogwarts.studentsHandler.dto;

import lombok.Getter;

@Getter
public class StudentRequest {
    private String name;
    private Integer year;
    private String houseKey;
}
