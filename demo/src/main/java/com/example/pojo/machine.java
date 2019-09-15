package com.example.pojo;

public class machine {
	private int fault_id;
	public int getFault_id() {
		return fault_id;
	}
	public void setFault_id(int fault_id) {
		this.fault_id = fault_id;
	}
	public String getFault_type() {
		return fault_type;
	}
	public void setFault_type(String fault_type) {
		this.fault_type = fault_type;
	}
	public String getFault_msg() {
		return fault_msg;
	}
	public void setFault_msg(String fault_msg) {
		this.fault_msg = fault_msg;
	}
	private String fault_type;
	private String fault_msg;
	public machine() {
		// TODO Auto-generated constructor stub
	}
	public machine(int fault_id,String fault_type,String fault_msg) {
		// TODO Auto-generated constructor stub
		this.fault_id=fault_id;
		this.fault_msg=fault_msg;
		this.fault_type=fault_type;
	}
	
}
