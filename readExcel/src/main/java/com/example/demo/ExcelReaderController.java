package com.example.demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExcelReaderController {

    private static final String EXCEL_FILE_PATH = "C:\\Users\\Admin1\\OneDrive\\Desktop\\hello.xlsx";

    @GetMapping("/readExcel")
    public ResponseEntity<List<List<String>>> readExcel() {
        try {
            List<List<String>> excelData = readExcelFile();
            return ResponseEntity.ok(excelData);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addDataToExcel")
    public ResponseEntity<String> addDataToExcel(@RequestBody List<List<String>> newData) {
        try {
            List<List<String>> excelData = readExcelFile();

            excelData.addAll(newData);

            writeExcelFile(excelData);

            return ResponseEntity.ok("Data added to Excel file successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private List<List<String>> readExcelFile() throws IOException {
        List<List<String>> excelData = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(EXCEL_FILE_PATH));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                rowData.add(cell.toString());
            }
            excelData.add(rowData);
        }
        workbook.close();
        inputStream.close();
        return excelData;
    }

    private void writeExcelFile(List<List<String>> data) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i);
            List<String> rowData = data.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rowData.get(j));
            }
        }
        FileOutputStream outputStream = new FileOutputStream(EXCEL_FILE_PATH);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

