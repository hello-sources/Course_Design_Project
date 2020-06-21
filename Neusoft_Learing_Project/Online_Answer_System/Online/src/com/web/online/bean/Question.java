package com.web.online.bean;

public class Question {
	private int qid;
	private String title;// 标题
	private int level;// 难度
	private String options;// 选项
	private String answer;// 答案
	private Double score;// 分数
	private int tid;// 类型编号
	private int sid;// 科目编号  

    public String getOptionA() {
		return options.split("；")[0];
	}
	
	public String getOptionB() {
		return options.split("；")[1];
	}
	
	public String getOptionC() {
		return options.split("；")[2];
	}
	
	public String getOptionD() {
		return options.split("；")[3];
	}
	
	public static void main(String[] args) {
    	Question  qu=new Question();
		qu.setOptions("A-3:B-2:C-1:D-0");
		System.out.println(qu.getOptionA());
		System.out.println(qu.getOptionB());
		System.out.println(qu.getOptionC());
		System.out.println(qu.getOptionD());
	}
	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
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

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

}
