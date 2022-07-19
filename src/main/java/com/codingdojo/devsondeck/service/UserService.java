package com.codingdojo.devsondeck.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.devsondeck.models.LoginUser;
import com.codingdojo.devsondeck.models.User;
import com.codingdojo.devsondeck.repos.UserRepo;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;
    

    public User register(User newUser, BindingResult result) {
    	Optional<User> lookUser = userRepo.findByEmail(newUser.getEmail());
        if(lookUser.isPresent()) {
        	result.rejectValue("email", "Matches", "That Email Is Already In Use!");
        }
        
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        
        if(result.hasErrors()) {
            return null;
        }
        
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    }
    
    
    
    public User login(LoginUser newLogin, BindingResult result) {
    	Optional<User> lookUser = userRepo.findByEmail(newLogin.getEmail());
    	
    	if(!lookUser.isPresent()) {
        	result.rejectValue("email", "Matches", "This User Does Not Exist!");
        	return null;
        }
    	
    	User user = lookUser.get();
    	
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
            return null;
        }
    	
    	return user;
        
    }
    public User findById(Long id) {
		Optional<User> result = userRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
    }
}
