package com.bgg.ssm.entity;

public class fault_info {
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
	public String getFault_content() {
		return fault_content;
	}
	public void setFault_content(String fault_content) {
		this.fault_content = fault_content;
	}
	private String fault_type;
	private String fault_content;
	public fault_info() {}
	public fault_info(int fault_id,String falut_type,String fault_content) {
		this.fault_id=fault_id;
		this.fault_content=fault_content;
		this.fault_type=fault_type;
	}
}
