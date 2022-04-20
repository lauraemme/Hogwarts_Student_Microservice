package com.hogwarts.studentsHandler.services;

import com.hogwarts.studentsHandler.dto.StudentResponse;
import com.hogwarts.studentsHandler.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetStudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentResponse getById(Long id) {
        return  StudentResponse.toResponse(studentRepository.getById(id));
    }
}
