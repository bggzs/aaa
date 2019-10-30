package com.bgg.ssm.entity;

public class fault {
	private String fault_type;
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
	private String fault_msg;
	public fault() {}
	public fault(String fault_type,String fault_msg) {
		this.fault_type=fault_type;
		this.fault_msg=fault_msg;
	}
	
}
