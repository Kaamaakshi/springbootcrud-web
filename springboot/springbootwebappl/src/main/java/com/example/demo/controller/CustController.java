package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CustDao;
import com.example.demo.dto.CustDto;
import com.example.demo.service.CustService;

@Controller
public class CustController {
	@Autowired
	CustService custService;
	
	
	@GetMapping("/inserthtml")
	public String inserthtml() {
		return "insert";		
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute CustDto custDto) {
		return custService.insert(custDto);		
	}
	
	@GetMapping("fallhtml")
	public String fallhtml(ModelMap modelMap) {
		List<CustDto> l=custService.fall();
		modelMap.put("obj", l);
		return "fetchall";
	}
	
	@GetMapping("/fidhtml")
	public String fidhtml() {
		return "fid.html";
	}
	@GetMapping("/fid")
	public ModelAndView fid(@RequestParam int id,ModelAndView modelAndView) {
		CustDto custDto=custService.fid(id);
		modelAndView.addObject("o", custDto);
		modelAndView.setViewName("fid.html");
		return modelAndView;
		
	}
	
	@GetMapping("/didhtml")
	public String didhtml() {
		return "did.html";
		
	}
	@RequestMapping("/did")
	@ResponseBody
	public String did(@RequestParam int id) {
		return custService.did(id);
	}
	
	@GetMapping("/dall")
	@ResponseBody
	public String dall() {
		return custService.dall();
	}
}
