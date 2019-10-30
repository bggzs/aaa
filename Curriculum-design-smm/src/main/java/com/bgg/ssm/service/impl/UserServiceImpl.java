package com.bgg.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bgg.ssm.dao.UserDao;
import com.bgg.ssm.entity.Teacher;
import com.bgg.ssm.entity.fault_info;
import com.bgg.ssm.entity.fault_review;
import com.bgg.ssm.entity.machine_fault;
import com.bgg.ssm.entity.machine_info;
import com.bgg.ssm.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	@Override
	public List<Teacher> findAllTeacher() {
		// TODO Auto-generated method stub
		return userDao.findAllTeacher();
	}
	@Override
	public List<Teacher> findTeacherById(String id) {
		// TODO Auto-generated method stub
		return userDao.findTeacherById(id);
	}
	@Override
	public List<machine_info> getAllMachineInfo() {
		// TODO Auto-generated method stub
		return userDao.getAllMachineInfo();
	}
	@Override
	public List<machine_fault> getMachineFault(String machine_id) {
		// TODO Auto-generated method stub
		return userDao.getMachineFault(machine_id);
	}
	@Override
	public List<fault_info> getFaultMassage() {
		// TODO Auto-generated method stub
		return userDao.getFaultMassage();
	}
	@Override
	public void insertFault(fault_info fault_info) {
		userDao.insertFault(fault_info);
		
	}
	@Override
	public void insertFaultInfo(machine_fault machine_fault) {
		// TODO Auto-generated method stub
		userDao.insertFaultInfo(machine_fault);
	}
	@Override
	public void addFaultStat(fault_review fault_review) {
		// TODO Auto-generated method stub
		userDao.addFaultStat(fault_review);
	}
	@Override
	public List<fault_review> getFaultReview() {
		// TODO Auto-generated method stub
		
		return userDao.getFaultReview();
	}
	@Override
	public void updateFaultReviewStat(String fault_id) {
		// TODO Auto-generated method stub
		userDao.updateFaultReviewStat(fault_id);
	}

}
