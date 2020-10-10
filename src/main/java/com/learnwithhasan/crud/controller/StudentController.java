package com.learnwithhasan.crud.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithhasan.crud.model.Student;
import com.learnwithhasan.crud.service.StudentService;

import lombok.RequiredArgsConstructor;

/*************************************************************************
 * {@link  Student} Controller 
 *  
 * @author Hasan Mahmud
 * @since  2020-10-10
 *************************************************************************/
@RestController
@RequestMapping("/api/Student")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {
	
	private final  StudentService service;
	
	/*************************************************************************
     * Create a new  Student
     * @param ob {@link  Student} object
     * @param rs {@link HttpServletResponse} object
     * @return {@link  Student}
     *************************************************************************/
	@PostMapping
    public  Student create(@Valid @RequestBody  Student ob) {
    	return service.create(ob);
    }
	
	/*************************************************************************
     * Get active {@link  Student}
     * @param id Id of a {@link  Student}
     * @return {@link  Student}
     *************************************************************************/
	@GetMapping("/get/{id}")
	public  Student getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	/*************************************************************************
     * Update {@link  Student}
     * @param ob {@link  Student} object
     * @return {@link  Student}
     *************************************************************************/
	@PutMapping
    public  Student update(@Valid @RequestBody  Student ob) {
    	return service.update(ob);
    }

	/*************************************************************************
     * Check if Student email already exist
     * 
     * @return
     *************************************************************************/
	@GetMapping("/exists/byEmail")
	public  Boolean existsByEmail(@RequestParam String email) {
		return service.existsByEmail(email);
	}
	
	/*************************************************************************
     * Get All Data
     * 
     * @return
     *************************************************************************/
	@GetMapping("/getAll")
    public List< Student > getAllStudent() {
    	return service.getAll();
    }
	
	/*************************************************************************
     * Delete Data
     * 
     * @return
     *************************************************************************/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
    	return service.deleteData(id);
    }
	
}
