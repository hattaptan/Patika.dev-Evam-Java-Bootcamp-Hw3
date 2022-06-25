package EvamJavaBootcampWeek3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import java.util.*;
class Student implements Comparable<Student>{
	// needed variable for students
    String name = new String();
    double cgpa;
    int id;
    
    // const. method
    public Student(String name,double cgpa,int id)
    {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }
    // set and get methods.
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
		this.name = name;
	}
    public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// method to compare all parameter by cpga than by name than by id
	public int compareTo(Student s)
    {
        if(cgpa == s.cgpa)
        {
            if(name.compareTo(s.name) == 0)
            {
                if(id == s.id)
                    return 0;
                else if (id > s.id)
                    return 1;
                else
                    return -1;
            }
            else
                return name.compareTo(s.name);
        }
        else if(cgpa > s.cgpa)
            return -1;
        else
            return 1;
    }
}
