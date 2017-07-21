package model; 

import java.util.Calendar;
import java.util.Date;

public class Grades  implements Comparable<Grades>
{ 
	private double numericGrade = 0.0; 
	private String letterGrade = "";  
	private String assignemnt = ""; 
	private double pointsGotten = 0.0; 
	private double totalPoints = 0.0;  
	private String typeOfGrade = ""; 
	private Calendar dueDate = Calendar.getInstance() ; 
	private Calendar assignedDate = Calendar.getInstance(); 
	
	
	public Grades(String assignment, String typeOfGrade, double pointsGotten, double totalPoints, DateHolder dueDate, DateHolder assignedDate) 
	{ 
		this.assignemnt = assignment; 
		this.typeOfGrade = typeOfGrade;
		this.pointsGotten = pointsGotten; 
		this.totalPoints = totalPoints; 
		setGrade(pointsGotten, totalPoints); 
		this.dueDate.set(dueDate.getDay(), dueDate.getMonth(), dueDate.getYear()); 
		this.assignedDate.set(assignedDate.getYear(), assignedDate.getMonth(), assignedDate.getYear());
		
	} 
	
	public void setGrade(double pointsGottent, double  totalPoints) 
	{
		numericGrade = (pointsGotten /totalPoints) * 100; 
		String num = Double.toString(numericGrade);  
		num = String.format("%.2f", num); 
		numericGrade = Double.parseDouble(num);
		
		if(numericGrade >= 96) letterGrade = "A+";  
		else if(numericGrade >= 94)letterGrade = "A";  
		else if(numericGrade >= 90)letterGrade = "A-";  
		else if(numericGrade >= 86)letterGrade = "B+"; 
		else if(numericGrade >= 84)letterGrade = "B"; 
		else if(numericGrade >= 80)letterGrade = "B-"; 
		else if(numericGrade >= 76)letterGrade = "C+"; 
		else if(numericGrade >= 74)letterGrade = "C"; 
		else if(numericGrade >= 70)letterGrade = "C-";  
		else if(numericGrade >= 66)letterGrade = "D+"; 
		else if(numericGrade >= 64)letterGrade = "D"; 
		else if(numericGrade >= 60)letterGrade = "D-"; 
		else if(numericGrade <= 60)letterGrade = "F"; 
		
	} 
	
	public String getTypeOfGrade() 
	{
		return this.typeOfGrade;
	}
	 
	public double getTotalPoints() 
	{
		return this.totalPoints;
	} 
	public double getEarnedPoints() 
	{
		return this.pointsGotten;
	} 
	
	public Calendar getDueDate() 
	{ 
		return this.dueDate;
		
	} 
	
	public int tillDue() 
	{
		int days;  
		
		days = this.dueDate.DAY_OF_MONTH - this.assignedDate.DAY_OF_MONTH;
		return days;
		
	}

	

	@Override
	public int compareTo(Grades o)  
	{ 
		int compInt = 0;
		
		if(this.dueDate.before(o.getDueDate())) 
		{
			compInt = -1;
		} 
		if(this.dueDate.equals(o.getDueDate()))
		{
				compInt = 0;
		} 
		if(this.dueDate.after(o.getDueDate())) 
		{
				compInt = 1;
		}
		
		
		return compInt;
	}

	

}
