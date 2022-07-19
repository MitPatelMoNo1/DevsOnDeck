package com.codingdojo.devsondeck.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.devsondeck.models.Org;

@Repository
public interface OrgRepo extends CrudRepository<Org, Long>{
List<Org> findAll();
Optional<Org> findByEmail(String email);
}
