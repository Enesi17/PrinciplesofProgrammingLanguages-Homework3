package B201210590_EnesSmajli;

import java.util.ArrayList;
import java.util.List;

//This class will be used to start the game
public class Game {

	// Initializing the players counter so we can store the number of players
	private int playersCount;
	// Initializing an array of colonies where we are going to store players
	private Colony[] colonies= new Colony[playersCount+1];
	// Initializing the colony we will use to store the winner of the game
	Colony winner;
	
	//The constructor will only tell that the game is starting
	public Game()
	{
		//Writing a message to the user
		System.out.println("The game is starting ...\n");
	}
	
	//This function will return us the winner
	public Colony winner(int[] players)
	{
		 // Initializing the local array of players
		 Colony[] colonies = new Colony[players.length];
		 //Starting a round by creating an object of round
		    Round r1 = new Round();
		 //Entering the players   
		    r1.enterPlayers(players);
		 //Getting the players to store them into colonies array
		    colonies = r1.getPlayers();
		 // Calling rounds until the last colony is left
		    do {
		    	// Starting rounds 
		        round(players, r1);
		        // Removing the losers and storing colonies that are left to the colonies array
		        colonies = removeLosers(colonies);
		    } while (colonies.length != 1);
		    // If we have only one colony left we store it to the winner colony
		    if (colonies.length == 1) {
		        //Storing the last colony left to the winner
		    	winner = colonies[0];
		    }
		    
		    // Printing out to the console the winner
		    System.out.println("\nAnd the winneerrrrr issss... \n");
		    System.out.println("Symbol||Population||Food Stock||");
		    System.out.println(Round.formatInfo(winner.getSymbol(), winner.getPopulation(), winner.getFoodStock()));
		    System.out.println("================================");
			
		    //Also the function will return the winner
		    return winner;
	}
	
	//This function does all the things that should be done in a round
	public void round(int[] players, Round r1)
	{
		//Gets the players and stores them to the colonies array
		this.colonies = r1.getPlayers();
		System.out.println("\n");
		//Calling tactics and getting the results
		int[] tacticResults = r1.tacticResults(colonies);
		//Calling factory and getting the products
		r1.factoryResults(colonies);
		//Starting the war with the tactics's results we got
		r1.warResult(tacticResults, colonies);
		//updating the colonies array by getting the players after the war but now without info
		this.colonies = r1.getPlayersWithoutInfo();
	}
	
	// Setting players counter if it is needed
	public void setPlayersCount(int playersCount)
	{
		// Setting the parameter as playersCount
		this.playersCount = playersCount;
	}
	
	// This function gets us playersCount
	public int getPlayersCount()
	{
		//Returns players counter
		return playersCount;
	}
	
	//This function removes the colonies that loose the game
	private Colony[] removeLosers(Colony[] colonies) {
	    // initializing a list with the colonies we have
		List<Colony> remainingColonies = new ArrayList<>();
	    
		// For each colony we check if they are 0 in population or food stock
	    for (Colony colony : colonies) {
	        if (colony.getPopulation() > 0 && colony.getFoodStock() > 0) {
	        	// if they are not we add them to the list of colonies
	            remainingColonies.add(colony);
	        }
	    }
	    //Returning the colonies without the losers
	    return remainingColonies.toArray(new Colony[0]);
	}

}
