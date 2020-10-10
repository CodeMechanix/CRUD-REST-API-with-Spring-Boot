package com.learnwithhasan.crud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnwithhasan.crud.exception.ResourceNotFoundException;
import com.learnwithhasan.crud.model.Student;
import com.learnwithhasan.crud.model.StudentRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class StudentServiceImpl implements StudentService{
	
	private final  StudentRepo repo;
	
	/*************************************************************************
	 * Create a new  Student
	 * 
	 * @param ob {@link  Student} object
	 * @return {@link  Student}
	 *************************************************************************/
	@Override
	public  Student create( Student ob) {
		try {
			return repo.save(ob);
		} catch (Exception e) {
			return ob;
		}
	}
	
	/*************************************************************************
	 * Get {@link  Student} by id and isActive
	 * @param id Id of a {@link  Student}
	 * @return {@link List< Student>}
	 *************************************************************************/
	@Override
	public  Student getById(Long id) {
		Student ob = repo.findById(id).get();
		return ob;
	}
	
	/*************************************************************************
	 * Update {@link  Student}
	 * 
	 * @param ob {@link  Student} object
	 * @return {@link  Student}
	 *************************************************************************/
	@Override
	public  Student update( Student ob) {
		try {
			return repo.save(ob);
		} catch (Exception e) {
			return ob;
		}
	}
	
	
	/*************************************************************************
     * Check if Student name already exist
     * 
     * @return
     *************************************************************************/
	@Override
	public Boolean existsByEmail(String email) {
		return repo.existsByEmailIgnoreCase(email);
	}
	
	/*************************************************************************
	 * Get all 
	 * @return {@link  Student}
	 *************************************************************************/
	@Override
	public List< Student > getAll() {
		return repo.findAll().stream().peek(ob -> {
		}).collect(Collectors.toList());
	}

	/*************************************************************************
	 * Delete Data
	 * @return {@link  Student}
	 *************************************************************************/
	@Override
	public ResponseEntity<Map<String, Boolean>> deleteData(Long id) {
		 Student student = repo.findById(id)
	                .orElseThrow(() 
	                -> new ResourceNotFoundException("Student not exist with id :" + id));

	        repo.delete(student);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
	}
	
}

