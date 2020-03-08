package Company;
import misc.MsgException;
/**
 * This class represents a clothing company.
 * A clothing company extends the company class, adding a variable containing the clothes provider.
 * @author ARIK
 *
 */
public class ClothingCompany extends Company
{
	// Variables
	private String clothingProvider;

	// Constructors
	public ClothingCompany(Company s, String clothingProvider)throws MsgException
	{
		super(s);
		if(clothingProvider.length() > 20)
		{
			throw new MsgException("Company Name Over 20 Letters");
		}
		this.clothingProvider = clothingProvider;
	}

	public ClothingCompany(Company s)
	{
		super(s);
		this.clothingProvider = "";
	}
	public ClothingCompany(String name , String Provider )
	{
		super(name);
		this.clothingProvider =Provider;
	}

	// Getters And Setters
	public String getClothingProvider() {
		return clothingProvider;
	}
	public void setClothingProvider(String clothingProvaider) {
		this.clothingProvider = clothingProvaider;
	}

	// To String
	@Override
	public String toString() {
		return "Company Name = " + companyName + "\nEmployees: " + printAllEmployees() + "\nStores: " + printAllStores() + "\nClothing Provider = " + clothingProvider;
	}
}
