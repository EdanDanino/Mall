package Company;
import misc.MsgException;
/**
 * This class represents a book company.
 * A book company extends the company class, adding a variable containing the best book of the week.
 * @author ARIK
 *
 */
public class BookCompany extends Company
{
	// Variables
	private String bestBookPerWeek;

	// Constructors
	public BookCompany(Company c, String bestBookPerWeek)throws MsgException
	{
		super(c);
		if(bestBookPerWeek.length() > 30)
		{
			throw new MsgException("Book Name Over 30 Letters");
		}
		this.bestBookPerWeek = bestBookPerWeek;
	}
	public BookCompany(String name , String bestBookPerWeek )
	{
		super(name);
		this.bestBookPerWeek = bestBookPerWeek;
	}


	// Getters And Setters
	public String getBestBookPerWeek() {
		return bestBookPerWeek;
	}

	public void setBestBookPerWeek(String bestKoterForTheWeek) {
		this.bestBookPerWeek = bestKoterForTheWeek;
	}

	// To String
	@Override
	public String toString() {
		return "Company Name = " + companyName + "\nEmployees: " + printAllEmployees() + "\nStores: " + printAllStores() + "Best Book Per Week = " + bestBookPerWeek;
	}
}
