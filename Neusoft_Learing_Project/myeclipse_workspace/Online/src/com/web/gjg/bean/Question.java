package com.web.gjg.bean;

public class Question {
	private Integer qid;
	private String title;// 标题
	private Integer level;// 难度
	private String options;// 选项
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;// 答案
	private Double score;// 分数
	private Integer tid;// 类型编号
	private Integer sid;// 科目编号  



	
    public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
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
