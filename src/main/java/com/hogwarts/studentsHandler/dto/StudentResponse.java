package com.hogwarts.studentsHandler.dto;

import com.hogwarts.studentsHandler.entities.Student;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResponse {

    private String name;
    private Integer year;
    private String houseName;

    public static StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();

        response.setName(student.getName());
        response.setYear(student.getYear());
        response.setHouseName(student.getHouse().getName());

        return response;
    }
}
