package B201210590_EnesSmajli;

import java.util.Random;

//This class is abstract because it was asked in the homework assignment
public abstract class Factory {

	// This function should be in each of the child classes
	public abstract int produce(Colony player);
	
	// This function will randomly a producing method
	public static int selectProductsAndGetProducts(Colony player) {
		// initializing the selector and the result to use them later
		int selectProducing;
		int result;
		
		// Initializing a random object from class Random
		Random randomP = new Random();
		// Storing a random number that will select later in switch
		selectProducing = randomP.nextInt(3);
		
		//using switch to select one of the products
		switch(selectProducing)
		{
		// If the random will give 0 it means the first product will be called
		case 0:
			// Initializing an object from product1 child class
			product1 prod1 = new product1();
			// Calling the produce function
			result = prod1.produce(player);
			//Returning the product
			return result;
		// If the random will give 0 it means the second product will be called
		case 1: 
			// Initializing an object from product2 child class
			product2 prod2 = new product2();
			// Calling the produce function
			result = prod2.produce(player);
			//Returning the product
			return result;
		// If the random will give 0 it means the third product will be called
		case 2: 
			// Initializing an object from product3 child class
			product3 prod3 = new product3();
			// Calling the produce function
			result = prod3.produce(player);
			//Returning the product
			return result;
		
			default:
				//If there was a mistake and none of the expected number appears
				// if send this message to the user and it should restart the game
				System.out.println("There is a mistake in the process.");
				return 0;
		}
	}
}
