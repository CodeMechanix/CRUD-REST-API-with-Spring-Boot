package com.learnwithhasan.crud.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.learnwithhasan.crud.model.Student;

/*************************************************************************
* {@link Student} service class 
* 
* @author Hasan Mahmud
* @since  2020-10-10
*************************************************************************/
public interface StudentService {
	
	/*************************************************************************
     * Create a new Student
     * @param ob {@link Student} object
	 * @param rs 
     * @return {@link Student}
     *************************************************************************/
	Student create(Student ob);
	/*************************************************************************
     * Get {@link Student} by id and isActive
     * @param id  Id of a {@link Student}
     * @return {@link Student}
     *************************************************************************/
	Student getById(Long id);
	/*************************************************************************
     * Update {@link Student}
     * @param ob {@link Student} object
	 * @param rs 
     * @return {@link Student}
     *************************************************************************/
	Student update(Student ob);
	/*************************************************************************
     * Check if Student email already exist
     * 
     * @return
     *************************************************************************/
	Boolean existsByEmail(String email);
	/*************************************************************************
     * Get all 
     * @return {@link List<Student>}
     *************************************************************************/
	List<Student> getAll();
	/*************************************************************************
     * Delete Data
     *************************************************************************/
	ResponseEntity<Map<String, Boolean>> deleteData(Long id);
}
