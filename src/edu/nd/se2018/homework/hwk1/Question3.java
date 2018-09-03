package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int len = numbers.length;
    	if (len == 0){
    		return 0; // empty case in test 
    	}
        int maxCount = 1;
     // flag used when checking numbers on opposite sides of mirror are equal 
        boolean flag = false; 

        //iterating from left to right
        for (int i = 0; i<len; i++){
        	
            int tempCount = 1;
            int count = i;
            //iterating from right to left 
            for (int j = len-1; j>= 0 && (count<len); j--){
            	
                if (numbers[count] == numbers[j] && !flag){
                    flag = true;
                    count++;
                    continue;
                }
                
                if (numbers[count] == numbers[j] && flag){
                    tempCount++;
                    count++;
                    // if tempCount > maxCount maxCount = tempCount else stay maxCount
                    maxCount = (tempCount>maxCount)?tempCount:maxCount;
                    continue;
                }
                
                if (numbers[i] != numbers[j] && flag){
                    flag = false;
                    count = i;
                    tempCount = 1;
                    continue;
                }
                // end of loop as we reached right side index = left side index
                if (j == count || (j-count)==1){
                    flag = false;
                    break;
                }
            }
        }
        
		return maxCount;	
	}
}
