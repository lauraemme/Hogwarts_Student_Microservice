package com.hogwarts.studentsHandler.repositories;

import com.hogwarts.studentsHandler.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
