package B201210590_EnesSmajli;

import java.util.Random;

//This class is the round of a game and it has a very important place in the program
public class Round {

	// initializing an array of Colonies to store the updated population and food stock of the players
	public Colony[] playersArr; 
	// initializing an array of integers to store the results from calling tactics
	int[] tacticResultsArr;
	// initializing an array of integers to store the results from calling products
	int[] factoryResultsArr;
	// initializing an integer where we will store the results of compared results
	int comparedResult;
	
	//Class constructor that makes clear to the user that a round it starting 
	public Round()
	{
		//Writes a message to the user
		System.out.println("The game has started");
		System.out.println("A round is starting...\n");
	}
	
	//This function will be used to enter the players that will play the game
	public void enterPlayers(int[] players)
	{	
		// initializing an array of Colonies to store the players
		// It will have elements as much integers were stored into the players array 
		// It gets the players array as parameter
		Colony[] colonies = new Colony[players.length];
		
		// initializing by this for loop all the players as colonies
		// This will set their population and food stock
		for (int i = 0; i < players.length; i++) {
		     colonies[i] = new Colony(players[i]);
		}
		// We store the colonies which is local to the palyersArr which is not local and
		// we can use it later in this class
		playersArr = colonies;
		
		//Generates symbols because I didn't include the symbols in the 
		// constructor of colony class so we use this function
		generateSymbolsForPlayers(colonies);
		
		// initializing arrays because of the length 
		// we need to get the length of players parameter 
		tacticResultsArr = new int[players.length];
		factoryResultsArr = new int[players.length];

	}
	
	//This function will get us the players and their population, food stock and symbols
	public Colony[] getPlayers()
	{
		//The header of the table
		System.out.println("Symbol||Population||Food Stock||");
		
		// getting all the colonies/players
		for(int i=0;i<playersArr.length; i++)
		{
			// Checking if any player reached the 0 population or 0 food stock
			// If they reach it they should not be showed it means they lost
			if(playersArr[i].getPopulation()!=0||playersArr[i].getFoodStock()!=0)
			{
				// If colonies's population is not  nor is their food stock we show them
				System.out.println(formatInfo(playersArr[i].getSymbol(),playersArr[i].getPopulation(),playersArr[i].getFoodStock()));
			}else
			{
				//If any of them is 0 we pass
				continue;
			}
		}
		//return the updated playersArr
		return playersArr;
	}
	
	//This function will get us the players and their population, food stock and symbols without info
	public Colony[] getPlayersWithoutInfo()
	{
		// getting all the colonies/players
		for(int i=0;i<playersArr.length; i++)
		{
			// Checking if any player reached the 0 population or 0 food stock
			// If they reach it they should not be showed it means they lost
			if(playersArr[i].getPopulation()!=0||playersArr[i].getFoodStock()!=0)
			{
				//Setting the symbol, population and food stock
				playersArr[i].getSymbol();
				playersArr[i].getPopulation();
				playersArr[i].getFoodStock();
			}else
			{
				//If any of them is 0 we pass
				continue;
			}
		}
		//return the updated playersArr
		return playersArr;
	}
	
	//This function will provide symbol for each player
	public void generateSymbolsForPlayers(Colony[] players) {
	    //this integers will be use for the random part 
		int minSymbolCode = 32; // the minimum ASCII code for symbols
	    int maxSymbolCode = 126; // the maximum ASCII code for symbols
	    
	    // initializing random from Random class to generate random symbols
	    Random random = new Random();
	    // initializing String symbol to store the symbol
	    String symbol;
	    
	    //For each player we set symbol by this for-each loop
	    for(Colony player:players) {
	    	//First we are going to get an random integer
	    	int symbolCode = random.nextInt(maxSymbolCode - minSymbolCode + 1) + minSymbolCode;
	        //Then we are going to convert it to char
	    	char symbolChar = (char) symbolCode;
	    	//Then we are going to convert it to String because we need to store it as String
	        symbol = String.valueOf(symbolChar);
	        // setting symbol with colony method setSymbol(String symbol)
	        player.setSymbol(symbol);
	    }
	}
	
	//This function will provide us a better looking info for each round
	public static String formatInfo(String symbol, int population, int foodStock) {
	        
			//initializing a template 
			String patternLine = "%s || %-10d || %-10d ||";
			//initializing a string by using String.format 
	        String info = String.format(patternLine, symbol, population, foodStock);

	        //initializing a stringBuilder we are going to use later
	        StringBuilder formattedInfo = new StringBuilder();
	        // appending or adding the into to the stringBuilder
	        formattedInfo.append(info);

	        //Returns info of round in a better organized form
	        return formattedInfo.toString();
	    }
	
	// This function will get the results after calling tactics for each colony
	public int[] tacticResults(Colony[] players)
	{
		// going through each player
		for(int i = 0; i<players.length; i++)
		{
			//calling the selecting tactics method for each player
			// and storing it to the array of results 
			tacticResultsArr[i]=Tactic.selectTacticAndGetResult(players[i]);
		}
		
		//Returns the results
		return tacticResultsArr;
	}

	// This function will get the results after calling Factory for each colony
	public int[] factoryResults(Colony[] players)
	{
		// going through all the players
		for(int j=0; j<players.length; j++)
		{
			//Calling the factory select product for each player
			// and storing it to the array of results 
			factoryResultsArr[j]=Factory.selectProductsAndGetProducts(players[j]);
		}
		
		//Returns the results
		return factoryResultsArr;
	}
	
	// This function was for testing the program
	public void printTacticResults(int[] tactics)
	{
		// Prints the tactics results
		for(int result: tactics)
		{
			System.out.println(result);	
		}
	}

	// This function was for testing the program 
	public void printFactoryResults(int[] products)
	{
		// Prints the products results
		for(int result: products)
		{
			System.out.println(result);	
		}
	}

	// This function compares to integers
	public int compare(int first, int second)
	{
		// Comparing using Math.max function
		comparedResult = Math.max(first,second);
		// Returns compared result
		return comparedResult;
	}
	
	// This function is the most important as it makes the populations and food stock change
	public Colony[] warResult(int[] tacticResults, Colony[] players) {
	   
		//I used two for loop so we can get all the pairs
		// getting these pairs means every colony fights with every colony
		for (int i = 0; i < tacticResults.length; i++) {
	        for (int j = i + 1; j < tacticResults.length; j++) {
	            
	        	//Initializing local compared result and using compare function to compare
	        	int comparedResult = compare(tacticResults[i], tacticResults[j]);
	            //initializing local result which gets us the difference between the compared colonies
	        	int result = Math.abs(tacticResults[i] - tacticResults[j]);
	            //Initializing percentage which we use later in the function
	        	int percentage = result / 10;
	            //Initializing player pair so we can return two colonies in the same time
	        	PlayerPair modificationResult;
	        	
	        	// If the first colony's tactics give bigger integer 
	            if (comparedResult == tacticResults[i]) {
	            	//we set the first and second colony
	                modificationResult = changePopulationAndFood(players[i], players[j], percentage);
	                //Changing the values of the players as needed
	                players[i] = modificationResult.player1;
	                players[j] = modificationResult.player2;
	            } else {
	            	//Else it means the second colony's tactics gave a bigger integer
	            	//we set the first and second colony
	                modificationResult = changePopulationAndFood(players[j], players[i], percentage);
	                //Changing the values of the players as needed
	                players[j] = modificationResult.player1;
	                players[i] = modificationResult.player2;
	            }
	        }
	    }
		//Returns the players with their new populations and food stock after the war
	    return players;
	}
	
	// This function is used to calculate percentage in integer format
	public static int calculateDecimal(int total, int percentage) {
	    //Using Math.round to round the number that can be float formats or even doubles
		int decimal = Math.round((percentage / 100.0f) * total);
	    return decimal;
	}

	//This function is used to update the colonies after they fight
	public PlayerPair changePopulationAndFood(Colony player1, Colony player2, int percentage) {
	    // initializing the integers we need which are used later in the function
		int secondPopulation = player2.getPopulation();
	    int firstFood = player1.getFoodStock();
	    int secondFood = player2.getFoodStock();
	    
	    // initializing the percentages we are going to add or subtract from colonies
	    int populationPercentage = calculateDecimal(secondPopulation, percentage);
	    int foodStockPercentage = calculateDecimal(secondFood, percentage);

	    // subtracting the losser's population
	    secondPopulation = secondPopulation - populationPercentage;
	    // setting the new population 
	    player2.setPopulation(secondPopulation);
	    // subtracting the looser's food stock
	    secondFood = secondFood - foodStockPercentage;
	    // setting the new food stock
	    player2.setFoodStock(secondFood);
	    // adding to the food of the winner
	    firstFood = firstFood + foodStockPercentage;
	    // setting the new food stock
	    player1.setFoodStock(firstFood);

	    // returning the pair compared with updates 
	    return new PlayerPair(player1, player2);
	}
	
}
