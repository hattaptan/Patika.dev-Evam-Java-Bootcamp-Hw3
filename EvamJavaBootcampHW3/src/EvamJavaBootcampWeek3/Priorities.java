package EvamJavaBootcampWeek3;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Priorities {
	public ArrayList<Student> getStudents(List<String> events)
    {   // define a priority queue
        PriorityQueue<Student> pq = new PriorityQueue<Student>();
        
        for(String i:events)
        { 
        	// Define a string array to to hold 4 values of each data
            String[] s = new String[4];
            s = i.split("\\s");
            if(s.length>1)
            {  
            	// if it is data to record
                pq.add(new Student(s[1],Double.valueOf(s[2]),Integer.valueOf(s[3])));
            }
            else
            {    // if it is served, than delete the last data
                pq.poll();
            }
        }
        while(pq.size()>1)
        {
        	// print to screen
            System.out.println(" - "+pq.poll().name+" - ");
        }
        return new ArrayList<Student>(pq);
    }
}
