package com.bgg.ssm.entity;

public class machine_fault {
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
		return Maintenance_personnel;
	}
	public void setMaintenance_personnel(String maintenance_personnel) {
		Maintenance_personnel = maintenance_personnel;
	}
	public String getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}
	private String fault_type;
	private String fault_special;
	private String fault_time;
	private String Maintenance_personnel;
	private String machine_id;
	public machine_fault() {}
	public machine_fault(String fault_id,String fault_type,String fault_special,String fault_time,String Maintenance_personnel,String machine_id) {
		this.fault_id=fault_id;
		this.fault_type=fault_type;
		this.fault_special=fault_special;
		this.fault_time=fault_time;
		this.Maintenance_personnel=Maintenance_personnel;
		this.machine_id=machine_id;
	}
}
