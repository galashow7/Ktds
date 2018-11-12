package com.ktds.diet.management.history.member.vo;

public class HistoryMemberVO {

	private int id;
	private String startDay;
	private String height;
	private String startWeight;
	private String nowWeight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(String startWeight) {
		this.startWeight = startWeight;
	}

	public String getNowWeight() {
		return nowWeight;
	}

	public void setNowWeight(String nowWeight) {
		this.nowWeight = nowWeight;
	}

}
