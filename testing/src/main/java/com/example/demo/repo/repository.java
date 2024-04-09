package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.entitywork;

public interface repository extends JpaRepository<entitywork, Long> {
}
