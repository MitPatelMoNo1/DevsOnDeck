package com.codingdojo.devsondeck.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.devsondeck.models.Org;
import com.codingdojo.devsondeck.models.OrgUser;
import com.codingdojo.devsondeck.repos.OrgRepo;

@Service
public class OrgService {

	@Autowired
    private OrgRepo orgRepo;
    

    public Org register(Org newOrg, BindingResult result) {
    	Optional<Org> lookOrg = orgRepo.findByEmail(newOrg.getEmail());
        if(lookOrg.isPresent()) {
        	result.rejectValue("email", "Matches", "That Email Is Already In Use!");
        }
        
        if(!newOrg.getPassword().equals(newOrg.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        
        if(result.hasErrors()) {
            return null;
        }
        
        String hashed = BCrypt.hashpw(newOrg.getPassword(), BCrypt.gensalt());
        newOrg.setPassword(hashed);
    	return orgRepo.save(newOrg);
    }
    
    
    
    public Org login(OrgUser newOrgLogin, BindingResult result) {
    	Optional<Org> lookOrg = orgRepo.findByEmail(newOrgLogin.getEmail());
    	
    	if(!lookOrg.isPresent()) {
        	result.rejectValue("email", "Matches", "This User Does Not Exist!");
        	return null;
        }
    	
    	Org org = lookOrg.get();
    	
    	if(!BCrypt.checkpw(newOrgLogin.getPassword(), org.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
            return null;
        }
    	
    	return org;
        
    }
    public Org findById(Long id) {
		Optional<Org> result = orgRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
    }
}
