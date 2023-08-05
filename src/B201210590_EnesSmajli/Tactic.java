package B201210590_EnesSmajli;

import java.util.Random;

//This class is abstract because it was asked in the homework assignment
public abstract class Tactic {

	// This function should be in each of the child classes
    public abstract int war(Colony player);
	
    // This function will randomly a tactics method
	public static int selectTacticAndGetResult(Colony player) {
		// initializing the selector and the result to use them later
		int selectTactic;
		int result;
		
		// Initializing a random object from class Random
		Random randomT = new Random();
		// Storing a random number that will select later in switch
		selectTactic = randomT.nextInt(2);
		
		//using switch to select one of the tactics
		switch(selectTactic)
		{
		// If the random will give 0 it means the first tactics will be called
		case 0:
			// Initializing an object from tactic1 child class 
			tactic1 tac1 = new tactic1();
			// Calling the war function
			result = tac1.war(player);
			//Returning the result
			return result;
			
		// If the random will give 1 it means the second tactics will be called
		case 1: 
			// Initializing an object from tactic2 child class
			tactic2 tac2 = new tactic2();
			// Calling the war function
			result = tac2.war(player);
			//Returning the result
			return result;
			
			default:
				//If there was a mistake and none of the expected number appears
				// if send this message to the user and it should restart the game
				System.out.println("There is a mistake in the process.");
				return 0;
		}
	}
}
