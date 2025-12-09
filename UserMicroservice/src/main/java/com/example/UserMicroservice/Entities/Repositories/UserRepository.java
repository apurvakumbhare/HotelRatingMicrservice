package com.example.UserMicroservice.Entities.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserMicroservice.Entities.User;

public interface UserRepository extends JpaRepository<User,String> {

}
