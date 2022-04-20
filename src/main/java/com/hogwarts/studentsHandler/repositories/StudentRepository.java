package com.hogwarts.studentsHandler.repositories;

import com.hogwarts.studentsHandler.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
