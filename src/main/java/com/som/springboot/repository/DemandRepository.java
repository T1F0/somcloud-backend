package com.som.springboot.repository;

import com.som.springboot.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand,Integer> {
}
