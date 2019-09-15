package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pojo.machine;

@Mapper
public interface MachineMapper {
	public List<machine> findMachine();
}
