package com.green.VO;

public class CourseLectureVO {
	private String id;
	private String name;
	private int credit;
	private String lecname;
	private int week;

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getLecname() {
		return lecname;
	}
	public void setLecname(String lecname) {
		this.lecname = lecname;
	}
	public String getWeek() {
		String weekFull="";
		switch(week) {
		case 1:
			weekFull="월";
			break;
		case 2:
			weekFull="화";
			break;
		case 3:
			weekFull="수";
			break;
		case 4:
			weekFull="목";
			break;
		case 5:
			weekFull="금";
			break;
		case 6:
			weekFull="토";
			break;
		}
		
		return weekFull;
		
	}
	public void setWeek(int week) {
		this.week = week;
	}
	
	
}