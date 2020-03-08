package Employees;
import misc.MsgException;
/**
* This class represents a cashier, which extends employee.
* A cashier has a vector containing the number of transactions performed by the cashier.
*/
public class Cashier extends NormalEmployee {
	// Variables
	public int NumOfTransactions;

	// Constructors
	public Cashier(String name,float id, double salary, double workPercentage, int storeid) throws MsgException {
		super(name,id, salary, workPercentage, storeid);

	}

	// Getters And Setters
	public int getNumOfTransactions() {
		return NumOfTransactions;
	}

	public void setNumOfTransactions(int numOfTransactions) {
		this.NumOfTransactions = numOfTransactions;
	}

	// Implements Of ISalary
	@Override
	public int calculateSalary(Employee e) {
		Cashier me = (Cashier) e;
		int calcSalary = (int) ((me.getSalary() + NumOfTransactions * workPercentage));
		return calcSalary;
	}

	// To String
	@Override
	public String toString() {
		return "Cashier [NumOfTransactions=" + NumOfTransactions + ", name=" + name + ", id=" + id + ", salary="
				+ salary + ", workPercentage=" + workPercentage + "]";
	}
}
