package Company;
/**
 * This class represents a fast food company.
 * A food company extends the food company class (which extends the company class), adding variables containing the cost of a meal and students sale.
 * @author ARIK
 *
 */
public class FastFoodCompany extends FoodCompany
{
	// Variables
	private float costOfMeal;
	private float studentsSale;

	// Constructors
	public FastFoodCompany(Company s, int numOfSupplyers, float costOfMeal, float studentsSale)
	{
		super(s, numOfSupplyers);
		this.costOfMeal = costOfMeal;
		this.studentsSale = studentsSale;
	}
	public FastFoodCompany(String s, int numOfSupplyers, float costOfMeal, float studentsSale)
	{
		super(s, numOfSupplyers);
		this.costOfMeal = costOfMeal;
		this.studentsSale = studentsSale;
	}
	

	// Getters And Setters
	public float getCostOfMeal() {
		return costOfMeal;
	}
	public void setCostOfMeal(float costOfMeal) {
		this.costOfMeal = costOfMeal;
	}
	public float getStudentsSale() {
		return studentsSale;
	}
	public void setStudentsSale(float studentsSale) {
		this.studentsSale = studentsSale;
	}
	@Override
	public String toString() {
		return "Company Name=" + companyName + "\nEmployees: " + printAllEmployees() + "\nStores: " + printAllStores() +"\nCost Of Meal = " + costOfMeal + "\n Students Sale = " + studentsSale + "\n Number Of Supplyers = " + numOfSupplyers;
	}

}
