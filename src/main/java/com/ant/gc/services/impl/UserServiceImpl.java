package com.ant.gc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ant.gc.entities.Users;
import com.ant.gc.repositories.ContactRepository;
import com.ant.gc.repositories.UsersRepository;
import com.ant.gc.requests.PasswordRequest;
import com.ant.gc.responses.MessageResponse;
import com.ant.gc.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional 
	@Override
	public MessageResponse save(Users user) {
		
		boolean exist =contactRepository.existsByEmail(user.getEmail());
		if(exist) {
			
			return new MessageResponse(false, "Attention", "Email existe deja");
		}
		 exist = usersRepository.existsByUsername(user.getUsername());
		if(exist) {
			
			return new MessageResponse(false, "Attention", "User existe deja");
		}
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		// TODO Auto-generated method stub
		usersRepository.save(user);
		return new MessageResponse(true, "success", "Opération effectué");
	}
    @Transactional
	@Override
	public MessageResponse update(Users user) {
		boolean exist = contactRepository.existsByEmailAndId(user.getEmail(), user.getId());
		if (!exist) {
			exist =contactRepository.existsByEmail(user.getEmail());
			if(exist) {
				
				return new MessageResponse(false, "Attention", "Email existe deja");
			}
		}
		
		exist = usersRepository.existsByUsernameAndId(user.getUsername(), user.getId());
		if(!exist) {
		exist = usersRepository.existsByUsername(user.getUsername());
		}
		if(exist) {
		
			return new MessageResponse(false, "Attention", "Nom d'utilsateur existe deja");
		}
		usersRepository.save(user);
		
		
		return new MessageResponse(false, "Success", "Operation Effectuée");
		
	}
    @Transactional
	@Override
	public MessageResponse delete(Integer id) {
	
	Users user = findById(id);
	
	if(user==null) {
		
		return new MessageResponse(false, "Attention", "Utilisateur n'existe pas");
	}
		
		usersRepository.deleteById(id);// Or delete(user)
		
		return new MessageResponse(true, "Success", "Operation effectuée");
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}
   @Override
	public Users findById(Integer id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id)
				.orElseThrow(null);
	}
   @Transactional
   @Override
public MessageResponse changePassword(PasswordRequest passwordRequest) {
	Users user = usersRepository.findByUsername(passwordRequest.getUsername());
	
	if(user == null) {
		return new MessageResponse(false , "Attention", "Utilisateur n'exite pas");
	}
	boolean matched =passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword());
	
	
	if(!matched) {
		return new MessageResponse(false, "Attention", "Mot de passe incorrect");
	}
	String encodedPassword = passwordEncoder.encode(user.getPassword());
	user.setPassword(encodedPassword);
	
	usersRepository.save(user);
	return new MessageResponse(true, "Success" , "Operation effectuée");
	   
	   
	 
}
	

}
