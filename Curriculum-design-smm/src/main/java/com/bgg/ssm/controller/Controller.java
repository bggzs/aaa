package com.bgg.ssm.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.json.JsonArray;

import org.apache.commons.httpclient.HttpException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bgg.ssm.dao.UserDao;
import com.bgg.ssm.entity.Teacher;
import com.bgg.ssm.entity.User;
import com.bgg.ssm.entity.fault_info;
import com.bgg.ssm.entity.fault_review;
import com.bgg.ssm.entity.insertClass;
import com.bgg.ssm.entity.machine_fault;
import com.bgg.ssm.entity.machine_info;
import com.bgg.ssm.entity.table1;
import com.bgg.ssm.service.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import massage.duanxing;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@org.springframework.stereotype.Controller
public class Controller {
	@Resource
	UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public String login(User user) {
		System.out.println(user.getUser_id()+" "+user.getUser_password());
		Subject subject =  SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUser_id(),user.getUser_password());
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return "error";
		}
		System.out.println("验证成功");
		if (subject.hasRole("admin")) {
			return "admin";
		}else if(subject.hasRole("teacher")){
			return "teacher";
		}else if(subject.hasRole("bgg")) {
			return "bgg";
		}
		return "not admin";

	}
	
	
	
	@RequestMapping("/index")
	public String index() {
		Subject subject =  SecurityUtils.getSubject();
		if(subject.hasRole("admin") || subject.hasRole("teacher") || subject.hasRole("bgg")) {
			return "index";
		}
		return "unauthorized";

	}
	@RequestMapping("/getMachineInfo")
	@ResponseBody
	public String getMachineInfo() {
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin") || subject.hasRole("teacher")) {
			List<machine_info> result=userService.getAllMachineInfo();
			JSONArray jsonArray =JSONArray.fromObject(result);
			String json = jsonArray.toString();
			System.out.println(json);
			return json;
		}
		
		
		return "error";
		
	}
	
	@RequestMapping("/getMachineFault")
	@ResponseBody
	public String getMachineFault(@RequestBody String machine) {
		
		String[] string=machine.split("=");
		String machine_id=string[1];
		System.out.println(machine_id);
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin") || subject.hasRole("teacher")) {
			List<machine_fault> result=userService.getMachineFault(machine_id);
			JSONArray jsonArray =JSONArray.fromObject(result);
			String json = jsonArray.toString();
			System.out.println(json);
			return json;
		}
		return "error";
		
	}
	@RequestMapping("/getFaultMassage")
	@ResponseBody
	public String getFaultMassage() {
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin")) {
			List<fault_info> result=userService.getFaultMassage();
			JSONArray jsonArray =JSONArray.fromObject(result);
			String json = jsonArray.toString();
			System.out.println(json);
			return json;
		}
		return "error";
		
		
	}
	@RequestMapping("/insertFault")
	@ResponseBody
	public String insertFault(fault_info fault_info) {
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin")) {
			userService.insertFault(fault_info);
			System.out.println("插入成功");
		}
		return null;
		
	}
	
	@RequestMapping("/insertFaultInfo")
	@ResponseBody
	public String insertFaultInfo(fault_review fault_review) {
		System.out.println(fault_review.getFault_special());
		
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin")) {
			userService.addFaultStat(fault_review);
			return "添加成功";
		}
		return "error";
		
	}
	
	@RequestMapping("/getFaultReview")
	@ResponseBody
	public String getFaultReview(@RequestBody String msg) {
		System.out.println(msg);
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin")) {
			List<fault_review> result=userService.getFaultReview();
			JSONArray jsonArray =JSONArray.fromObject(result);
			String json = jsonArray.toString();
			System.out.println(json);
			return json;
		}
		return "error";
	}
	
	@RequestMapping("/insertFaultMassage" )
	@ResponseBody
	public String insertFaultMassage(machine_fault machine_fault) {
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin")) {
			userService.insertFaultInfo(machine_fault);
			userService.updateFaultReviewStat(machine_fault.getFault_id());
			return "添加成功";
		}
		return "error";
	}
	
	
	@RequestMapping("/massage")
	@ResponseBody
	public String massage(@RequestParam(value="s_id",required=true)String s_id) {
		Subject subject=SecurityUtils.getSubject();
		if(subject.hasRole("admin") || subject.hasRole("teacher")) {
			try {
				duanxing.sendMassage();
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s_id;

	}

	


	//	@RequiresPermissions("admin")
	@RequiresRoles("admin")
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		System.out.println("拥有权限");
		return "success";

	}
	@RequestMapping("/unauthorized")
	@ResponseBody
	public String unauthorized() {
		System.out.println("没有权限");
		return "not permissions";
	}

}
