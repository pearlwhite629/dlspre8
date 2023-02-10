package com.example.demo.form;


public class RsvForm {
	private Integer id;
	private String date_day;
	private String date_time;
//	private String count_heads;
	private Integer count_heads;
	private String purpose;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate_day() {
		return date_day;
	}
	public void setDate_day(String date) {
		this.date_day = date;
	}
	
	
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	//	public String getCount_heads() {
//		return count_heads;
//	}
//	public void setCount_heads(String count_heads) {
//		this.count_heads = count_heads;
//	}
	public Integer getCount_heads() {
		return count_heads;
	}
	public void setCount_heads(Integer count_heads) {
		this.count_heads = count_heads;
	}
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
