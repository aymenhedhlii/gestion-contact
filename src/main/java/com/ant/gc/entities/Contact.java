package com.ant.gc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.ant.gc.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Contact implements Serializable  {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String adresse;
	
	

}
