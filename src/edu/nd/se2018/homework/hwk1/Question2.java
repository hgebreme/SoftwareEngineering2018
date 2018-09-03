package edu.nd.se2018.homework.hwk1;
import java.util.*;
public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		// 
		String[] inputList = input.split(" ");
		String[] stopList = stopwords.split(" ");
		HashSet<String> stopSet = new HashSet<String>(); 
		HashSet<String> keySet = new HashSet<String>();
		
		for (int i=0; i<stopList.length; i++){
			stopSet.add(stopList[i]);
		}
		
		// making hash map to keep track of count 
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<inputList.length; i++){
			
			// if you should skip it ...skip
			if (stopSet.contains(inputList[i]) ){
				continue;
			}
			
			//updating hash map with counts
			if (map.containsKey(inputList[i])){
				keySet.add(inputList[i]);
				Integer curCount = map.get(inputList[i]);
				map.put(inputList[i], curCount+1);
			} else {
				keySet.add(inputList[i]);// stores keys for iteration
				map.put(inputList[i], 1);
			}
		}
		
		// getting the one that has max occurrence 
		int max=0;
		int count=0; // keeping track of things with max occurrence 
		String word = null;
		for(String key:keySet){
			if (max < map.get(key)){
				max = map.get(key);
				word = key;
			}
		}
		for(String key:keySet){
			if (map.get(key) == max){
				count+=1;
			}
		}
		
		if (count == 1){
			return word;
		}else {
			return null;
		}
	}
}
