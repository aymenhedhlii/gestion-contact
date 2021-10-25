package com.ant.gc.entities;

import javax.persistence.Entity;

import com.ant.gc.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


import lombok.ToString;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client extends Contact {
	
	private String matriculeFiscale;

	
}
