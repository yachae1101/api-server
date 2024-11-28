package com.yachae1101.apiserver.repository;

import com.yachae1101.apiserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
