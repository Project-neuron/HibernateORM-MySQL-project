package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Id;

import java.util.Date; 

//Do more research into calendar class. Apparently it is the better class to use 

public class Course  
{ 
	@Id
	//Overall course information 
	private String courseName = ""; 
	private int courseCredits = 0; 
	private int clsWrkWeight = 0; 
	private int hmWrkWeight  = 0; 
	private int testWeight = 0; 
	private String overAllLetterGrade = "";  
	private double overAllNumericGrade = 0.0;
	
	//overall course points
	private double totalClassWorkPoints = 0.0; 
	private double totalHomeWorkPoints = 0.0; 
	private double totalTestPoints = 0.0; 
	private double earnedClassWorkPoints = 0.0; 
	private double earnedHomeWorkPoints = 0.0; 
	private double earnedTestPoints = 0.0;  
	private double extraCredit = 0.0;
	
	private double hwScore = 0.0; 
	private double classworkScore = 0.0; 
	private double testScore = 0.0; 
	
	private double weightedHwScore = 0.0; 
	private double weightedClassworkScore = 0.0; 
	private double weightedTestScore = 0.0;
	
	//Arrays that hold the finished work
	private ArrayList<Grades> finishedClasswork =  new ArrayList<Grades>();  
	private ArrayList<Grades> finishedHomeWork = new ArrayList<Grades>(); 
	private ArrayList<Grades> finishedTests = new ArrayList<Grades>();  
	
	//Arrays that hold the upcoming still to be counted work
	public ArrayList<Grades>upcomingClasswork =  new ArrayList<Grades>();  
	public ArrayList<Grades> upcomingHomeWork = new ArrayList<Grades>(); 
	public ArrayList<Grades> upcomingTests = new ArrayList<Grades>(); 
	 
	//constructor for the new course gets all the basic information
	public Course(String courseName, int courseCredits, int classWorkWeight, 
			int homeWorkWeight, int testWeight) 
	{
		this.courseName = courseName; 
		this.courseCredits = courseCredits; 
		this.clsWrkWeight = classWorkWeight; 
		this.hmWrkWeight = homeWorkWeight; 
		this.testWeight = testWeight;
	}  
	
	//hw point 
	public void addToPointTotalHW(double tPoints, double gPoints) 
	{ 
		
		totalHomeWorkPoints = totalHomeWorkPoints + tPoints; 
		earnedHomeWorkPoints = earnedHomeWorkPoints + gPoints;
	}
	
	//classwork points 
	public void addToPointTotalClass(double tPoints, double gPoints) 
	{ 
		
		totalClassWorkPoints = totalClassWorkPoints + tPoints; 
		earnedClassWorkPoints = earnedClassWorkPoints + gPoints;
	}
	
	//Test points 
	public void addToPointTotalTest(double tPoints, double gPoints) 
	{ 
		
		totalTestPoints = totalTestPoints + tPoints; 
		earnedTestPoints = earnedTestPoints + gPoints;
	}
	
	//Adding grades to finished arrays along with the points they are worth 
	public void addFinishedGrade(Grades g) 
	{ 
		if(g.getTypeOfGrade() == "classwork") 
		{
			finishedClasswork.add(g); 
			addToPointTotalClass(g.getTotalPoints(), g.getEarnedPoints());
		
		} 
		if(g.getTypeOfGrade() == "homework") 
		{
			finishedHomeWork.add(g); 
			addToPointTotalHW(g.getTotalPoints(),g.getEarnedPoints());
		} 
		if(g.getTypeOfGrade() == "tests") 
		{
			finishedTests.add(g); 
			addToPointTotalTest(g.getTotalPoints(),g.getEarnedPoints());
		} 
		
		
	} 
	
	//Adding unfinished work to the arrays
	public void addUnfinishedGrade(Grades g) 
	{ 
		if(g.getTypeOfGrade() == "classwork") 
		{
			upcomingClasswork.add(g); 
			
		
		} 
		if(g.getTypeOfGrade() == "homework") 
		{
			upcomingHomeWork.add(g); 
			
		} 
		if(g.getTypeOfGrade() == "tests") 
		{
			upcomingTests.add(g); 
			
		} 
		
		
	} 	

	//Calculating each individual point score setting each score variable
	public void setScore() 
	{
		classworkScore = earnedClassWorkPoints / totalClassWorkPoints;  
		classworkScore = classworkScore + extraCredit;
		weightedClassworkScore = classworkScore * clsWrkWeight;
		hwScore = earnedHomeWorkPoints / totalHomeWorkPoints; 
		weightedHwScore = hwScore * hmWrkWeight;
		testScore = earnedTestPoints / totalTestPoints; 
		weightedTestScore = testScore * testWeight;
	}

	//Calculate overall grade 
	public void overAllGrade() 
	{ 
		overAllNumericGrade = weightedClassworkScore + weightedHwScore + weightedTestScore;
		
	}

	//Setting letter Grade 
	public void setLetterGrade() 
	{
		if(overAllNumericGrade >= 96) overAllLetterGrade = "A+";  
		else if(overAllNumericGrade >= 94)overAllLetterGrade = "A";  
		else if(overAllNumericGrade >= 90)overAllLetterGrade = "A-";  
		else if(overAllNumericGrade >= 86)overAllLetterGrade = "B+"; 
		else if(overAllNumericGrade >= 84)overAllLetterGrade = "B"; 
		else if(overAllNumericGrade >= 80)overAllLetterGrade = "B-"; 
		else if(overAllNumericGrade >= 76)overAllLetterGrade = "C+"; 
		else if(overAllNumericGrade >= 74)overAllLetterGrade = "C"; 
		else if(overAllNumericGrade >= 70)overAllLetterGrade = "C-";  
		else if(overAllNumericGrade >= 66)overAllLetterGrade = "D+"; 
		else if(overAllNumericGrade >= 64)overAllLetterGrade = "D"; 
		else if(overAllNumericGrade >= 60)overAllLetterGrade = "D-"; 
		else if(overAllNumericGrade <= 60)overAllLetterGrade = "F";
	} 
	

	public void sort() 
	{
		Collections.sort(upcomingHomeWork); 
		Collections.sort(upcomingTests); 
		Collections.sort(upcomingClasswork);
	} 
	
	public ArrayList getClasswork() 
	{
		return this.upcomingClasswork;
	} 
	
	public ArrayList getHomeWork() 
	{
		return this.upcomingHomeWork;
	} 
	
	public ArrayList getTests() 
	{
		return this.upcomingTests;
	}  
	
	//gets all the assignements due within a date range from tests, homework and classwork  
	//possibly create an assignment class that extends grade for assignments that aren't graded  
	//have the week variable filled by a method that gets an instance of todays date if that date is a monday 
	//get all assignments for 7 days from monday. 
	public ArrayList getAssignemnts() 
	{   
		ArrayList<Grades> classAssignments = new ArrayList<Grades>(); 
		ArrayList<Grades> homeAssignments = new ArrayList<Grades>(); 
		ArrayList<Grades> TestsAssignments = new ArrayList<Grades>(); 
		ArrayList<Grades> allAssignments = new ArrayList<Grades>();
		//Get an instance of today 
		//Add two weeks to it 
		Calendar twoweeks = Calendar.getInstance();
		Calendar assignment = this.upcomingClasswork.get(0).getDueDate();  
		twoweeks.add(twoweeks.DAY_OF_MONTH, 14); 
		
		//if assignment due date is equal or greater than the two week part 
		//add assignment to the assignments list 
		if(twoweeks.after(assignment) || twoweeks.equals(assignment))		
		{ 
			classAssignments.add(this.upcomingClasswork.get(0)); 
			this.upcomingClasswork.remove(0);
			
		}
			
		Calendar oneweek = Calendar.getInstance(); 
		Calendar hWassignment = this.upcomingHomeWork.get(0).getDueDate();  
		oneweek.add(oneweek.DAY_OF_MONTH, 7); 
		
		if(oneweek.after(hWassignment) || oneweek.equals(hWassignment)) 
		{
			homeAssignments.add(this.upcomingHomeWork.get(0)); 
			this.upcomingHomeWork.remove(0);
		} 
		
		Calendar oneMonth = Calendar.getInstance(); 
		Calendar testAssignment = this.upcomingTests.get(0).getDueDate(); 
		oneMonth.add(oneMonth.MONTH, 1);   
		
		if(oneMonth.after(testAssignment) || oneMonth.equals(testAssignment)) 
		{
			TestsAssignments.add(this.upcomingTests.get(0)); 
			this.upcomingTests.remove(0);
			
		}
		
		allAssignments.addAll(0, classAssignments);
		allAssignments.addAll(0, homeAssignments); 
		allAssignments.addAll(0, TestsAssignments); 
		
		Collections.sort(allAssignments);
		return allAssignments; 
		
	}
	
	

}
