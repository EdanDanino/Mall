package Employees;
import misc.MsgException;
/**
* The class NormalEmployee extends the base abstract class employee,
* adding a vector calculating the sum of every purchase and saving it in a vector.
*/
public class NormalEmployee extends Employee {

	// Variables
	protected int sumCustomers;
	protected double sumMoney;

	// Constructors
	public NormalEmployee(String name,float id, double salary, double workPercentage, int storeid) throws MsgException {
		super(name,id, salary, workPercentage, storeid);
		this.sumCustomers = 0;
		this.sumMoney = 0;
	}

	// Getters And Setters
	public int getSumCustomers() {
		return sumCustomers;
	}

	public void setSumCostumers(int sumCustomers) {
		this.sumCustomers = sumCustomers;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	// To String
	@Override
	public String toString() {
		return "NormalEmployee [sumCustomers=" + sumCustomers + ", name=" + name + ", id=" + id + ", salary=" + salary
				+ ", workPercentage=" + workPercentage + "]";
	}

	/**
	* overrides the function "calculateSalary" from the implemented interface, calculating the salary of a normal worker,
	* combining all of the things needed.
	*/
	@Override
	public int calculateSalary(Employee e) {
		NormalEmployee me = (NormalEmployee) e;
		int calcSalary = (int) ((me.getSalary() + this.sumMoney + this.sumCustomers * workPercentage));
		return calcSalary;
	}

}
