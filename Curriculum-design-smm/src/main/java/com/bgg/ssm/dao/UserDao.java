package com.bgg.ssm.dao;

import java.util.List;

import com.bgg.ssm.entity.Teacher;
import com.bgg.ssm.entity.fault_info;
import com.bgg.ssm.entity.fault_review;
import com.bgg.ssm.entity.insertClass;
import com.bgg.ssm.entity.machine_fault;
import com.bgg.ssm.entity.machine_info;
import com.bgg.ssm.entity.table1;

import junit.framework.Test;

public interface UserDao {
	public List<Teacher> findAllTeacher();
	public List<Teacher> findTeacherById(String id);	
	public List<table1> findTable1(String t_id);
	public String findTeacherId(String t_name);
	public void insertClass(insertClass insertClass);
	public List<machine_info> getAllMachineInfo();
	public List<machine_fault> getMachineFault(String machine_id);
	public List<fault_info> getFaultMassage();
	public void insertFault(fault_info fault_info);
	public void insertFaultInfo(machine_fault machine_fault);
	public void addFaultStat(fault_review fault_review);
	public List<fault_review> getFaultReview();
	public void updateFaultReviewStat(String fault_id);
}
