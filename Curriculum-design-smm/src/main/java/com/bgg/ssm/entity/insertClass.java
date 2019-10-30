package com.bgg.ssm.entity;

public class insertClass {
	private String c_id;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_stat() {
		return c_stat;
	}
	public void setC_stat(String c_stat) {
		this.c_stat = c_stat;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	private String c_name;
	private String c_stat;
	private String t_id;
	public insertClass() {
		// TODO Auto-generated constructor stub
	}
	public insertClass(String c_id,String c_name,String t_id,String c_stat) {
		this.c_id=c_id;
		this.c_name=c_name;
		this.t_id=t_id;
		this.c_stat=c_stat;
	}
}
