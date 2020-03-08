package Employees;
import java.util.*;

import misc.MsgException;
/**
* This class extends the abstract employee class,
* adding the same vector seen in NormalEmployee and a vector containing all of the canceled orders.
*/
public class AdvancedEmployee extends NormalEmployee {

	// Variables
	protected Vector<Integer> sumCustomers = new Vector<Integer>();
	protected Vector<Integer> cancelCustomers = new Vector<Integer>();

	// Constructors
	public AdvancedEmployee(String name,float id, double salary, double workPercentage, int storeid) throws MsgException {
		super(name,id, salary, workPercentage, storeid);
	}

	public void setSumCostumers(Vector<Integer> sumCostumers) {
		this.sumCustomers = sumCostumers;
	}

	public Vector<Integer> getCancelCustomers() {
		return cancelCustomers;
	}

	public void setCancelCustomers(Vector<Integer> cancelCustomers) {
		this.cancelCustomers = cancelCustomers;
	}

	// To String
	@Override
	public String toString() {
		return "AdvancedEmployee [sumCustomers=" + sumCustomers + ", cancelCustomers=" + cancelCustomers + ", name="
				+ name + ", id=" + id + ", salary=" + salary + ", workPercentage=" + workPercentage + "]";
	}

	// The Sum Of The Employee's Selling
	private int sumSellings() {
		int sum = 0;
		for (int i = 0; i < sumCustomers.size(); i++) {
			sum += sumCustomers.get(i);
		}
		return sum;
	}

	// Implements Of ISalary
	@Override
	public int calculateSalary(Employee e) {
		AdvancedEmployee me = (AdvancedEmployee) e;
		int calcSalary = (int) ((me.getSalary() + sumSellings() + sumCustomers.size() * workPercentage) * 1.5);
		return calcSalary;
	}

}
