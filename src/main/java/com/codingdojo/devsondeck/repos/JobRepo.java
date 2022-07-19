package com.codingdojo.devsondeck.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.devsondeck.models.Job;

@Repository
public interface JobRepo extends CrudRepository<Job, Long> {
	List<Job> findAll();
}
