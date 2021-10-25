package com.ant.gc.services;

import java.util.List;

import com.ant.gc.entities.Users;
import com.ant.gc.requests.PasswordRequest;
import com.ant.gc.responses.MessageResponse;

public interface UserService {
	public MessageResponse save(Users user);
	public MessageResponse update(Users user);
	public MessageResponse delete(Integer id);
	public List<Users> findAll();
	public Users findById(Integer id);
	public MessageResponse changePassword(PasswordRequest passwordRequest);
	
	

}
