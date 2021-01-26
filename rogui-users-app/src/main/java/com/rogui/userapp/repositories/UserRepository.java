package com.rogui.userapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogui.userapp.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
