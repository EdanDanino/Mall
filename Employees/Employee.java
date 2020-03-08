package Employees;
import misc.ISalary;
import misc.MsgException;

/**
* This class represents an abstract Employee class, a base for employee classes to come.
* A basic employee has a name, an id, work Percentage and salary - given by the implemenation of ISalary.
* 
*
* @author ARIK
*/
abstract public class Employee implements ISalary {

	// Variables
	public String name;
	protected float id;
	protected double salary;
	protected double workPercentage;
	protected int storeId;

	// Constructors
	public Employee(String name,float id, double salary, double workPercentage, int storeId) throws MsgException {
		this.name = name;
		if(id<0)
		{
			throw new MsgException("Id Below 0! Is not compatable");
		}
		this.id = id;
		this.storeId = storeId;
		this.salary = salary;
		this.workPercentage = workPercentage;
	}

	public Employee(Employee e, int storeId)  throws MsgException {
		this.name = e.getName();
		if(e.getId()<0)
		{
			throw new MsgException("Id Below 0! Is not compatable");
		}
		this.id = e.getId();
		this.storeId = storeId;
		this.salary = e.getSalary();
		this.workPercentage = e.getworkPercentage();
	}

	public Employee() {
		this.name = "";
		this.id =-1;
		this.storeId = -1;
		this.salary = 0;
		this.workPercentage= 0.0;
	}

	// Getters And Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public float getId() {
		return id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setId(float id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getworkPercentage() {
		return workPercentage;
	}

	public void setWorkPrecentage(double workPercentage) {
		this.workPercentage = workPercentage;
	}

	// To String
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + ", workPercentage=" + workPercentage
				+ "]";
	}

}
