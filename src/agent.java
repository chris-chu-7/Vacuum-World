//Christopher Chu Github: wanderingessence
//Date: 2/12/2019 
//Duration: 5 hours to complete.

//This algorithm implementation is for Chapter 2: Inteligent agents for Artificial Intelligence: 
//a Modern Approach

//This vacuum Agent is a reflex agent for a vacuum cleaner. The floor is represented with a 
//one dimensional array and the Vacuum has 3 actions: Suck, move to the left and move to the right.
//There is a condition action in the agent in the algorithm in the program. The sensors can only sense 
//the current array indices in the world and the condition action rules decide what action the agent should do at a moment 

//Algorithm runs in O(n) and takes O(n) space. The condition action method runs in O(1) time all the others
//run in O(n). A user can expect the number of steps to be twice the size of the array. 

import java.util.Scanner;

public class agent {
	
	static int[] percept;
	private static Scanner operator;
	
	public static int conditionaction(int i) {
		if(i >= percept.length) {
			return i % percept.length;
		}
		if(percept[i] > 0) {
			percept[i]--;
			return i;
		}
		if((i + 1) < percept.length && (i-1 >= 0) && percept[i-1]>percept[i+1] ) {
			return i-1;
		}
		if((i + 1) < percept.length && (i-1) >= 0 && percept[i+1]>percept[i-1]) {
			return i+1;
		}
		i = (i + 1) % percept.length;
		return i;
	}
	
	public static void printArray() {
		for(int i = 0; i < percept.length; i++) {
			System.out.print(percept[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean taskComplete() {
		for(int i = 0; i < percept.length; i++) {
			if(percept[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Vacuum Cleaner Problem! Do you need to clean anything?\n");
		operator = new Scanner(System.in);
		
		String nextThing = operator.next();
		if(nextThing.equals("no")) {
			System.out.println("All cleaned up!");
		}
		if(nextThing.equals("yes")) {
			System.out.print("Enter the number of tiles you want to clean: ");
			int number = operator.nextInt();
			percept = new int[number];
			for(int i = 0; i < percept.length; i++) {
				//generates a number between 0 and 2 in the percept array
				percept[i] = (int) (Math.random() * 2 + Math.random());
			}
			int i = (int) (Math.random() * percept.length);

			int numSteps = 0; 
			
			while(!taskComplete()) {
				numSteps++;
				i = conditionaction(i);
			}
			
			System.out.println("All cleaned up! ");
			System.out.println("The agent took " + numSteps + " iterations to successfully vacuum the floor");
			 System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));
		}
		
		
	}
	
}
