package com.learnwithhasan.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "student")
@ToString(callSuper = true)
public class Student {

	@Id
    @GeneratedValue
    private Long id;
 
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    
    @Column(nullable = false, length = 200)
    private String address;
}
