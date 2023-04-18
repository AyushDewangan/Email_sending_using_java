package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

//	@Query("SELECT u FROM User u WHERE u.userId= ?1")
	Optional<User> findByUserId(String userId);

}
