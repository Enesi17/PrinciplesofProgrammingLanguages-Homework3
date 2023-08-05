package B201210590_EnesSmajli;

public class TEST {

	public static void main(String[] args) {
		
		// initializing this array to store the players 
		int[] players;
		// initializing this integer to store the number of players
		int playersCount = 0;
		
		// initializing this String to store the input
		String INPUT =" ";
		// Creating and object of class getInput to get input from the user
		getInput input = new getInput(INPUT);
		// Setting the input after getting it from the user
		input.setInput();
		//Storing the input to INPUT String
		INPUT = input.getStringInput();
		// Checking if the pattern of the input is correct
		while(!input.checkingStringPattern(INPUT))
		{
			// If the pattern is not correct we ask the user to re-write it
			// Also we give a message with an example to help them 
			System.out.println("Please rewrite the input string as this example: 12 45 899 54 1.");
			// Resets the input
			input.setInput();
			//Stores the new input to INPUT
			INPUT = input.getStringInput();
		}
		
		// Setting the plates that will play
		players = input.setPlayers(INPUT);
		// Setting the players number and storing it in the playersCount integer
		playersCount = players.length;
		//Starting the game 
		Game game = new Game();
		// Setting the players which mean creating colonies
		game.setPlayersCount(playersCount);
		// Calling the winner function which calls rounds until there is a winner
		game.winner(players);

	}

}
