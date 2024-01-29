package com.syntaxerror.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syntaxerror.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
