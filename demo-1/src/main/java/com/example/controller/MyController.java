package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.ExpertsDatabaseMapper;
import com.example.pojo.ExpertsDatabase;
import com.example.pojo.ExpertsDatabaseExample;

@RestController
public class MyController {
	@Autowired
	ExpertsDatabaseMapper mapper;
	
	
	@RequestMapping("/test")
	public String test() {
		ExpertsDatabaseExample example=new ExpertsDatabaseExample();
		example.or().andFaultIdEqualTo(2);
		List<ExpertsDatabase> res = mapper.selectByExample(example);
		System.out.println(res.get(0).getFaultMsg());
		return "login";
	}
}
