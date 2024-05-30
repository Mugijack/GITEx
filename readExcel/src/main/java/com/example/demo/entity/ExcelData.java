package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExcelData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String column1;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public ExcelData(Long id, String column1, String column2) {
		super();
		this.id = id;
		this.column1 = column1;
		this.column2 = column2;
	}
	public String getColumn2() {
		return column2;
	}
	public ExcelData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	private String column2;
    // Add more fields as needed for your Excel columns

    // Getters and setters
    // Constructors
    // Other methods
}
