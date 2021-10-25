package com.ant.gc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ant.gc.entities.Users;
import com.ant.gc.enums.Role;
import com.ant.gc.responses.MessageResponse;
import com.ant.gc.services.UserService;
@Component
public class Test implements CommandLineRunner{
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Users user = new Users();
		user.setFirstName("Amine");
		user.setLastName("Hedhli");
		user.setEmail("aymenhe@gmail.com");
		user.setUsername("amine");
		user.setPassword("1234");
		user.setRole(Role.ROLE_ADMIN);
		user.setAdresse("Bizerte");
		
		MessageResponse result =userService.save(user);
		System.out.println(result);
		
	}

}
