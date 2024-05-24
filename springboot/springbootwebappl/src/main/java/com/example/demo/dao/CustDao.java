package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CustDto;
import com.example.demo.repository.CustRepository;

@Repository
public class CustDao {
	@Autowired
	CustRepository  custRepository;
	public String insert(CustDto custDto) {
		custRepository.save(custDto);
		return "data inserted";
		
	}
	public List<CustDto> fall() {
		 List<CustDto> l=custRepository.findAll();
		 if(l.isEmpty()) {
			 return null;
		 }else {
			 return l;
		 }
	}
	public CustDto fid(int id) {
		Optional<CustDto> op = custRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	public String did(int id) {
		Optional<CustDto> op=custRepository.findById(id);
		if(op.isPresent()) {
		 custRepository.deleteById(id);
		 return "data deleted";
		}else {
			return "data not found";
		}

	}
	public String dall() {
		 custRepository.deleteAll();
		 return "data deleted";
	}



}
