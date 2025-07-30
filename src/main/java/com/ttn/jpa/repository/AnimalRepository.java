package com.ttn.jpa.repository;

import com.ttn.jpa.entity.inheritence.tableperclass.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
