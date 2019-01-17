package com.yurtcan.astronaut.repository;

import com.yurtcan.astronaut.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUserName(String userName);

}
