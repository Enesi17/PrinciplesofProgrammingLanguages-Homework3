package B201210590_EnesSmajli;

//This is the class of players of the game
public class Colony {
	
	//initializing the properties that each colony must have
	//initializing population
	private int population;
	//initializing food Stock
	private int foodStock;
	//initializing a symbol that will define the colony through the game
	private String symbol;
	
	//To create an object of this class the constructor gets an integers as parameter
	public Colony(int population)
	{
		//THe integer will be the population 
		this.population = population;
		//the food Stock is the square of the population at the start 
		this.foodStock = population*population;
	}
	
	//function to set population
	public void setPopulation(int newPopulation)
	{
		//Setting the parameter as the population
		this.population = newPopulation;
	}
	
	//Function to get population when needed
	public int getPopulation()
	{
		//Returns the population
		return population;
	}
	
	//Function to set food Stock
	public void setFoodStock(int newFoodStock)
	{
		//Setting the parameter as food stock
		this.foodStock = newFoodStock;
	}
	
	//Function to get food stock when needed
	public int getFoodStock()
	{
		//Returns the food stock
		return foodStock;
	}
	
	//Function to set symbol
	public void setSymbol(String symbol)
	{
		//Setting the parameter as symbol
		this.symbol=symbol;
	}
	
	//Function to get symbol when needed
	public String getSymbol()
	{
		//Returns the symbol
		return symbol;
	}
	
}
