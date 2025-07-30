package com.ttn.jpa.repository;

import com.ttn.jpa.entity.inheritence.singletable.Monkey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonkeyRepository extends JpaRepository<Monkey, Long> {
}
