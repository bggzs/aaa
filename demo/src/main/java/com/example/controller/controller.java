package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.MachineMapper;
import com.example.pojo.machine;

@RestController
public class controller {
	@Autowired
	MachineMapper mapper;
	@RequestMapping("/hello")
	public String test() {
		List<machine> res=mapper.findMachine();
		System.out.println(res.size());
		return "login";
	}
}
