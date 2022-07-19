package com.example.gerenciarpessoas.repository;

import com.example.gerenciarpessoas.dto.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
