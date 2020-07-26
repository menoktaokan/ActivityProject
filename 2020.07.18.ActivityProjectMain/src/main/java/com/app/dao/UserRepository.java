package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
