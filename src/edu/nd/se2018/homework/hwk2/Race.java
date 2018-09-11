package edu.nd.se2018.homework.hwk2;

public class Race {
    Horse[] horse; // array of horses in the race
    public Race(Horse[] h) {
        System.out.println("And they have left ground...");
        horse = h;
    }
    public void run() {
        System.out.print("Horse Label==>");
        for (int i=0; i<horse.length; i++) {
            System.out.printf("%5d ", (i+1));
        }
        System.out.println();
        while (!Horse.done()) {
            System.out.println();
            System.out.print("Distance      ");
            for (int i=0; i<horse.length; i++) {
                System.out.printf("%5d ", horse[i].getDistance());
            }
        }
        System.out.print("\r");
        System.out.print("Distance      ");
        for (int i=0; i<horse.length; i++) {
            System.out.printf("%5d ", horse[i].getDistance());
        }
        System.out.println("\nAnd the winner is "+ Horse.getWinner());
    }
}
