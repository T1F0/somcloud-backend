package com.som.springboot.repository;

import com.som.springboot.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData,Integer> {
}
