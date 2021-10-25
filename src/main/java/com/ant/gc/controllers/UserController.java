package com.ant.gc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ant.gc.entities.Users;
import com.ant.gc.requests.PasswordRequest;
import com.ant.gc.responses.MessageResponse;
import com.ant.gc.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
@CrossOrigin("*")
@RestController
@RequestMapping("/users")
@Api(description ="aaaaaaa")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Users>findAll(){
	return userService.findAll();
	}
	@PostMapping
	public MessageResponse save(@RequestBody @ApiParam("objet userr") Users user) {
		return userService.save(user);
	}
	@PutMapping
	public MessageResponse update(@RequestBody  Users user) {
		return userService.update(user);
	}
	@PatchMapping
	public MessageResponse changePassword(@RequestBody  PasswordRequest passwordRequest) {
		return userService.changePassword(passwordRequest);
	}
	@GetMapping("/{id}")
	public Users findById(@PathVariable("id") Integer id) {
		return userService.findById(id);
	}
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable("id")  Integer id) {
		return userService.delete(id);
	}
	

}
