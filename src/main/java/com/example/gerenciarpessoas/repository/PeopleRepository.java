package com.example.gerenciarpessoas.repository;

import com.example.gerenciarpessoas.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
