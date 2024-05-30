package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExcelData;

@Repository
public interface ExcelDataRepository extends JpaRepository<ExcelData, Long> {
    // You can add custom methods if needed
}
