package edu.nd.se2018.homework.hwk1;
import java.util.*;
public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		HashSet<Integer> h = new HashSet<Integer>();
		// We go through the vector and remove duplicates
		for (int i=0; i<numbers.length; i++){
			h.add(numbers[i]);
		}
		//initialize sum and add as we iterate over the set 
		int sum = 0;
        Iterator<Integer> i = h.iterator();
        while (i.hasNext())
            sum += i.next();
		
		return sum;	
	}
}
