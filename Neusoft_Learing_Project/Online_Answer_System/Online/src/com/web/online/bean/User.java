package com.web.online.bean;

public class User { 
    private Integer id;//流水号
    private String name;//用户名
    private String pwd;//登录密码
    private String realname;//真实姓名
    private String phone;//手机号
    private Integer role;//角色
    private String regdt;//注册时间
    private String mark;//备注
    private int javagrade;	//java成绩
	private int netgrade;	//net成绩
	private int pythongrade;	//grade成绩
	private int cppgrade;	//cpp成绩
	private int cgrade;		//c成绩
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getJavagrade() {
		return javagrade;
	}
	public void setJavagrade(int javagrade) {
		this.javagrade = javagrade;
	}
	public int getNetgrade() {
		return netgrade;
	}
	public void setNetgrade(int netgrade) {
		this.netgrade = netgrade;
	}
	public int getPythongrade() {
		return pythongrade;
	}
	public void setPythongrade(int pythongrade) {
		this.pythongrade = pythongrade;
	}
	public int getCppgrade() {
		return cppgrade;
	}
	public void setCppgrade(int cppgrade) {
		this.cppgrade = cppgrade;
	}
	public int getCgrade() {
		return cgrade;
	}
	public void setCgrade(int cgrade) {
		this.cgrade = cgrade;
	}
	

	
	
}
