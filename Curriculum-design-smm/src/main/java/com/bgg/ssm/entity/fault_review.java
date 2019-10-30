package com.bgg.ssm.entity;

public class fault_review {
	private String fault_id;
	public String getFault_id() {
		return fault_id;
	}
	public void setFault_id(String fault_id) {
		this.fault_id = fault_id;
	}
	public String getFault_type() {
		return fault_type;
	}
	public void setFault_type(String fault_type) {
		this.fault_type = fault_type;
	}
	public String getFault_special() {
		return fault_special;
	}
	public void setFault_special(String fault_special) {
		this.fault_special = fault_special;
	}
	public String getFault_time() {
		return fault_time;
	}
	public void setFault_time(String fault_time) {
		this.fault_time = fault_time;
	}
	public String getMaintenance_personnel() {
		return maintenance_personnel;
	}
	public void setMaintenance_personnel(String maintenance_personnel) {
		this.maintenance_personnel = maintenance_personnel;
	}
	public String getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}
	public String getReview_stat() {
		return review_stat;
	}
	public void setReview_stat(String review_stat) {
		this.review_stat = review_stat;
	}
	private String fault_type;
	private String fault_special;
	private String fault_time;
	private String maintenance_personnel;
	private String machine_id;
	private String review_stat;
	public fault_review() {}
	public fault_review(String fault_id,String fault_type,String fault_special,String fault_time,String maintenance_personnel,String machine_id,String review_stat) {
		this.fault_id=fault_id;
		this.fault_type=fault_type;
		this.fault_special=fault_special;
		this.fault_time=fault_time;
		this.maintenance_personnel=maintenance_personnel;
		this.machine_id=machine_id;
		this.review_stat=review_stat;
	}
}
