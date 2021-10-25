package com.ant.gc.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ant.gc.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Users extends Contact{
	
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
}
