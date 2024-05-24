package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustDto {
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CustDto [id=" + id + ", name=" + name + "]";
	}
}
