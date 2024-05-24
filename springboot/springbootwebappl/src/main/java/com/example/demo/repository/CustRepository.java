package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.CustDto;

public interface CustRepository extends JpaRepository<CustDto, Integer>{

}
