package B201210590_EnesSmajli;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//This class was formed to make the process of getting the input easier 
public class getInput {

	//This string will be used later to store the input we get from the user
	private String input;
	
	//The constructor of this class will get a string as parameter every time
	//we create any object from this class and will store it to the input above
	public getInput(String input)
	{
		//the method we use to set private variables
		this.input = input;
	}
	
	//because we have String input as private we need a method to set it 
	public void setInput()
	{
		// Creates and object from class Scanner	
		Scanner getInput = new Scanner(System.in);
		//Asks the use to write the input as it is required
		System.out.println("Write the string of integers that will play the game:");
		//gets the next line and store it in String input of this class
		this.input = getInput.nextLine();
	}
	
	//Because we have String input as private we need a method to get it
	public String getStringInput()
	{
		//Simply returns the input
		return input;
	}
	
	//This function checks the pattern of the input
	public boolean checkingStringPattern(String input)
	{
		//First check if the input is null
		if(input == null || input.isEmpty())
		{
			//Ask from them to rewrite it
			System.out.println("Please enter the string input...");
			//call setInput() to be able to set it because it was left empty
			setInput();
		}
		
		//Creating the pattern we need for the program
		Pattern pattern = Pattern.compile("^[0-9 ]+$");
		//Creating a matcher to the pattern we just created 
		Matcher clear = pattern.matcher(input);
		
		//Checking if there were matches found
		if(clear.find())
		{
			//Returns true if the pattern of the input is correct 
			return true;
		}else {
			//Returns false if the pattern of the input is incorrect
			return false;
		}
		
	}

	//This function is used to read each integer in the string
	public int[] setPlayers(String numbersString) {
        //Initializing a string array by splitting the input where white-spaces are found
		String[] numberStrings = numbersString.split(" ");
        //Initializing a integer array to store the numbers we get from input
		int[] numbers = new int[numberStrings.length];
		
		//Using a loop to turn strings into integers
        for (int i = 0; i < numberStrings.length; i++) {
        	//Storing the integers so we can use it later
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }
        //returns the numbers array which will turn into the players later in the program
        return numbers;
    }


}
