package com.technews.repository;

import com.technews.model.User;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// extend with JpaRepository so we can use CRUD methods
@Repository

public interface UserRepository extends JpaRepository<User, Integer>  {
    User findUserByEmail(String email) throws Exception;



}
