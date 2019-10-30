package com.bgg.ssm.entity;

public class machine_info {
	private String machine_id;
	public String getMachine_id() {
		return machine_id;
	}

	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}

	public String getMachine_type() {
		return machine_type;
	}

	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getMaintenance_stat() {
		return maintenance_stat;
	}

	public void setMaintenance_stat(String maintenance_stat) {
		this.maintenance_stat = maintenance_stat;
	}

	private String machine_type;
	private String person;
	private String maintenance_stat;
	
	public machine_info() {
		// TODO Auto-generated constructor stub
	}
	public machine_info(String machine_id,String machine_type,String person,String maintenance_stat) {
		this.machine_id=machine_id;
		this.machine_type=machine_type;
		this.person=person;
		this.maintenance_stat=maintenance_stat;
	}
}
