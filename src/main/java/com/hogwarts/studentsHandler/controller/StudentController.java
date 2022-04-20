package com.hogwarts.studentsHandler.controller;

import com.hogwarts.studentsHandler.dto.StudentRequest;
import com.hogwarts.studentsHandler.dto.StudentResponse;
import com.hogwarts.studentsHandler.services.CreateStudentService;
import com.hogwarts.studentsHandler.services.GetStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final CreateStudentService createStudentService;
    private final GetStudentService getStudentService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest){
        return createStudentService.execute(studentRequest);
    }

    @GetMapping
    public StudentResponse findStudentById(@PathParam("id")Long id){
        return getStudentService.getById(id);
    }
}
