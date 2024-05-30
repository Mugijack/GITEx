package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExcelData;
import com.example.demo.repo.ExcelDataRepository;

@Service
public class ExcelDataService {

    @Autowired
    private ExcelDataRepository excelDataRepository;

    public void saveExcelData(List<List<String>> excelData) {
        for (List<String> rowData : excelData) {
            ExcelData entity = new ExcelData();
            // Map rowData to entity fields
            // For example:
            entity.setColumn1(rowData.get(0));
            entity.setColumn2(rowData.get(1));
            // Save the entity
            excelDataRepository.save(entity);
        }
    }
}
