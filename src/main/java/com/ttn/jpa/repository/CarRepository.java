package com.ttn.jpa.repository;

import com.ttn.jpa.entity.inheritence.joined.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
