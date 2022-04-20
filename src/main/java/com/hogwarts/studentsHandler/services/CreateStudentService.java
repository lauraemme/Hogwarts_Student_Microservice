package com.hogwarts.studentsHandler.services;

import com.hogwarts.studentsHandler.clients.GetHouseKeyInfoClient;
import com.hogwarts.studentsHandler.dto.StudentRequest;
import com.hogwarts.studentsHandler.dto.StudentResponse;
import com.hogwarts.studentsHandler.dto.clients.HouseKeyStatus;
import com.hogwarts.studentsHandler.entities.House;
import com.hogwarts.studentsHandler.entities.Student;
import com.hogwarts.studentsHandler.repositories.HouseRepository;
import com.hogwarts.studentsHandler.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentService {

    private StudentRepository studentRepository;
    private HouseRepository houseRepository;
    private GetHouseKeyInfoClient getHouseKeyInfoClient;

    public StudentResponse execute(StudentRequest studentRequest) {
        Student student = new Student();

        student.setName(studentRequest.getName());
        student.setYear(studentRequest.getYear());

        House house = new House();
        house.setHouseKey(studentRequest.getHouseKey());

        student.setHouse(house);

        if(getHouseKeyInfoClient.execute(studentRequest.getHouseKey()).getHouseKeyStatus().equals(HouseKeyStatus.AVAILABLE)){
            houseRepository.save(house);
            studentRepository.save(student);

            return StudentResponse.toResponse(student);
        }

        return null;
    }
}
