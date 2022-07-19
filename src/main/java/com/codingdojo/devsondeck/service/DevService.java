package com.codingdojo.devsondeck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.devsondeck.models.Devs;
import com.codingdojo.devsondeck.repos.DevRepo;

@Service
public class DevService {
	
	@Autowired
	private DevRepo devRepo;
	
	private DevService(DevRepo devRepo) {
		this.devRepo = devRepo;
	}
	
	public Devs findById(Long id) {
		Optional<Devs> result = devRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public List<Devs> all(){
		return devRepo.findAll();
	}
	
	public Devs update(Devs dev) {
		return devRepo.save(dev);
	}
	
	public Devs create(Devs dev) {
		return devRepo.save(dev);
	}
	
	public void deleteDev(Devs dev) {
		devRepo.delete(dev);
	}
}

