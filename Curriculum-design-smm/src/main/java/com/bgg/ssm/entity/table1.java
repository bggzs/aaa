package com.bgg.ssm.entity;

public class table1 {
	private String c_name;
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
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	private String t_name;
	private String s_name;
	private String s_class;
	private int result ;
	private String s_id;
	public table1() {}
	public table1(String c_name,String t_name,String s_name,String s_class,int result,String s_id) {
		this.c_name=c_name;
		this.t_name=t_name;
		this.s_name=s_name;
		this.result=result;
		this.s_class=s_class;
		this.s_id=s_id;
	}
}
