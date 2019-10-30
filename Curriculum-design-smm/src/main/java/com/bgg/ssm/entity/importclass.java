package com.bgg.ssm.entity;

public class importclass {
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
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	private String c_name;
	private String t_name;
	public importclass() {}
	public importclass(String c_id,String c_name,String t_name) {
		this.c_id=c_id;
		this.c_name=c_name;
		this.t_name=t_name;
	}
}
