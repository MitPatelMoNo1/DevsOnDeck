package com.codingdojo.devsondeck.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.devsondeck.models.Devs;

@Repository
public interface DevRepo extends CrudRepository<Devs, Long> {
	List<Devs> findAll();
}
