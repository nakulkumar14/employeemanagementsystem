package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{

    User findByUsername(String username);
}
