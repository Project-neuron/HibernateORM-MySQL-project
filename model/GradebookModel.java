package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class GradebookModel extends Observable 
{ 
	private ArrayList<Course> courses = new ArrayList<Course>(); 
	private ArrayList<Grades> tasks = new ArrayList<Grades>();
	
	public void addCourse(Course course) 
	{
		courses.add(course);
	} 
	
	public void taskList() 
	{ 
		for(int i = 0; i < courses.size(); i++) 
		{
			tasks.addAll(0, courses.get(i).getAssignemnts());
		} 
		Collections.sort(tasks);
		
	}

}
 