package B201210590_EnesSmajli;

//This is a child class of Tacitc class
public class tactic1 extends Tactic {

	// Initializing the required integers we are going to use later
	int result = 0;
	int population = 0;
	int foodStock = 0;
	
	//This function will check if the result is in the range we need it
	public static boolean isInRange(int num) {
        //It returns true if the number is between 0 and 1000
		return num >= 0 && num <= 1000;
    }
	
	// The abstract function inherited by Tactic class
	@Override
	public int war(Colony player) {
		// Getting the population and food stock 
		population = player.getPopulation();
		foodStock = player.getFoodStock();
		
		// This will be the formula that we call tactics
		result = (int)((foodStock - population)/2);
		
		// Checking if the result is inside the range
		if(!tactic1.isInRange(result))
		{
			// If it is not in the range we take this action 
			while(!tactic1.isInRange(result))
			{
				result = Math.round(result/100);
			}
			// Then we return the result 
			return result;
		}else {
			//if it is already inside the range we don't need to do any thing
			// we just return the result
			return result;
		}
	}
	
	
}
