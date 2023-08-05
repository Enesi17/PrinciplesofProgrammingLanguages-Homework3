package B201210590_EnesSmajli;

import java.util.Random;

//This class is a child class of Factory class
public class product1 extends Factory{

	//Initializing all the integers we need later to store things
	int result = 0;
	int population = 0;
	int foodStock = 0;
	
	//This function will check if the result is in the range we need it
	public static boolean isInRange(int num) {
		//It returns true if the number is between 1 and 10
        return num > 0 && num <= 10;
    }
	
	// The abstract function inherited by Factory class
	@Override
	public int produce(Colony player) {
		// Getting the population and storing it
		int population = player.getPopulation();
		// Creating an random value in case we need one
		Random randomProductValue = new Random();

		//This is the formula of producing
		result=(int) (population*0.4);
		
		if(!isInRange(result))
		{
			// If out result is not in the range we want it 
			// we will make the producing function select a random result
			result = randomProductValue.nextInt(10)+1;
			// Returning the result
			return result;
		}
		// Returning the result
		return result;
			
	}
}