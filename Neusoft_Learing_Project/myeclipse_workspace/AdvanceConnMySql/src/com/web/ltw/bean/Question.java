package com.web.ltw.bean;

public class Question {
	private Integer qid;
	private String title;//����
	private Integer level;//�Ѷ�
	private String options;//ѡ��
	private String answer;//��
	private Double score;//����
	private Integer tid;//���ͱ��
	private Integer sid;//��Ŀ���
	
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
