package com.web.ltw.bean;

public class Question {
	private Integer qid;
	private String title;//标题
	private Integer level;//难度
	private String options;//选项
	private String answer;//答案
	private Double score;//分数
	private Integer tid;//类型编号
	private Integer sid;//科目编号
	
	public Integer getQ_id() {
		return qid;
	}
	public void setQ_id(Integer qId) {
		qid = qId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getT_id() {
		return tid;
	}
	public void setT_id(Integer tId) {
		tid = tId;
	}
	public Integer getS_id() {
		return sid;
	}
	public void setS_id(Integer sId) {
		sid = sId;
	}
	
}
