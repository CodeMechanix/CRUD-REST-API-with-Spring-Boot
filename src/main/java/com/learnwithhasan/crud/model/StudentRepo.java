package com.learnwithhasan.crud.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long>{
	Boolean existsByEmailIgnoreCase(String email);
}
