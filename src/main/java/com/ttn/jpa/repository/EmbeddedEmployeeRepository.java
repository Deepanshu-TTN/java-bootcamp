package com.ttn.jpa.repository;

import com.ttn.jpa.entity.embedded.EmbeddedEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmbeddedEmployeeRepository extends JpaRepository<EmbeddedEmployee, Long> {
}
