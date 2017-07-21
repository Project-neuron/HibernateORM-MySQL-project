package model;

public class DateHolder  
{ 
	private int day = 0; 
	private int month = 0; 
	private int year = 0; 
	
	public DateHolder(int month, int day, int year) 
	{
		this.day= day; 
		this.month = month; 
		this.year = year; 
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	} 
	
	

}
