package Company;
/**
 * This class represents a food company.
 * A food company extends the company class, adding a variable containing the number of supplyers.
 * @author ARIK
 *
 */
public class FoodCompany extends Company
{
	// Variables
	protected int numOfSupplyers;

	// Constructors
	public FoodCompany(Company s, int numOfSupplyers)
	{
		super(s);
		this.numOfSupplyers = numOfSupplyers;
	}
	public FoodCompany(Company s)
	{
		super(s);
		this.numOfSupplyers = 0;
	}
	public FoodCompany(String s, int numOfSupplyers)
	{
		super(s);
		this.numOfSupplyers = numOfSupplyers;
	}

	// Getters And Setters
	public int getNumOfSupplyers() {
		return numOfSupplyers;
	}
	public void setNumOfSupplyers(int numOfSupplyers) {
		this.numOfSupplyers = numOfSupplyers;
	}

	// To String
	@Override
	public String toString() {
		return "Company Name = " + companyName + "\nEmployees: " + printAllEmployees() + "\nStores: " + printAllStores() + "\nNumber Of Supplyers=" + numOfSupplyers;
	}
}
