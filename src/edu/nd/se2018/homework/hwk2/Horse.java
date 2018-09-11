package edu.nd.se2018.homework.hwk2;

public class Horse implements Strategy { //extends Thread
	
    private static final int raceLength = 10;  // length of the race  
    private int distance; 					   // distance covered by horse 
    private String name = ""; 			       // name of the horse 
    private String raceStrategy = ""; 	       // the strategy taken by the horse
    private int maxSpeed;					   // max speed of the horse
	private static String winner = ""; 		   // string holding the winner horse
	private static boolean raceOver = false;   // boolean flag for when race is over
    
 // constructor taking name and max-speed
    public Horse(int id, int speed) { 
        name = "Horse #" + id;
        maxSpeed = speed;
        distance = 0;
    }
    
    public static void resetRace() { 
        raceOver = false; 
    }
    
    public static boolean done() { 
        return raceOver; 
    }
    
    public int getDistance() { 
        return distance; 
    }
    
    public static String getWinner() { 
        return winner; 
    }
    
	@Override
	public void setStrategy(String strategy) { // 
		raceStrategy = strategy;
	}
	
    public void run() {
        while (distance<raceLength) {
        	switch (raceStrategy) {
        		case "earlySprint":
					try {
						Thread.sleep(500);
	        			for (int i=0; i<2; i++){
	        				distance += maxSpeed;
	        			}
	        			for (int i=0; i<8; i++){
	        				distance += Math.floor(0.75*maxSpeed);
	        			}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        			break;
        			
        		case "steadyRun":
					try {
						Thread.sleep(500);
	        			for (int i=0; i<10; i++){
	        				distance += Math.floor(0.8*maxSpeed);
	        			}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        			break;
     			
        		case "slowStart":
        			try {
						Thread.sleep(500);
	        			for (int i=0; i<6; i++){
	        				distance += Math.floor(0.75*maxSpeed);
	        			}
	        			for (int i=0; i<3; i++){
	        				distance += Math.floor(0.9*maxSpeed);
	        			}
	        			distance += maxSpeed;   
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        			break;	
        	}	
        }
    }

}
