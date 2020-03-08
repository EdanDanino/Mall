package Company;
import java.util.*;

import Employees.Employee;
import Employees.NormalEmployee;
import misc.MsgException;

/**
 * This class represents a company, a base for the company classes to come. A
 * company has a name, an array of employees and an array of stores.
 * 
 * @author ARIK
 */
abstract public class Company {
	// Variables
	protected String companyName;
	protected Vector<Employee> companyEmp;
	protected Vector<Store> companyStore;
	// protected TreeMap<Integer, TreeMap<Integer, Employee>> emp;
	
	
	// Constructors
	public Company(Company c) {
		this.companyName = c.companyName;
		this.companyEmp = new Vector<Employee>();
		this.companyStore = new Vector<Store>();
	}

	public Company(String name) {
		this.companyName = name;
		this.companyEmp = new Vector<Employee>();
		this.companyStore = new Vector<Store>();
	}

	// Getters And Setters
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Vector<Employee> getCompanyEmp() {
		return companyEmp;
	}

	public void setCompanyEmp(Vector<Employee> companyEmp) {
		this.companyEmp = companyEmp;
	}

	public Vector<Store> getCompanyStore() {
		return companyStore;
	}

	public void setCompanyStore(Vector<Store> companyStore) {
		this.companyStore = companyStore;
	}
	
	public String printAllEmployees()
	{
		if(this.companyEmp.size() > 0)
		{
			String temp = "";
			for(int i = 0; i<this.companyEmp.size(); i++)
			{
				temp += "\nID: " + (int)this.companyEmp.get(i).getId() + ", Name: " + this.companyEmp.get(i).getName() + ", Store ID: " + this.companyEmp.get(i).getStoreId();
			}
			return temp;
		}
		else
		{
			return "No Workers\n";
		}
		
	}
	
	public String printAllStores()
	{
		if(this.companyStore.size() > 0)
		{
			String temp = "";
			for(int i = 0; i<this.companyStore.size(); i++)
			{
				temp += "\nID: " + this.companyStore.get(i).getStoreId() + " Sum Money Income: " + this.companyStore.get(i).getSumMoney();
			}
			return temp;
		}	
		else
		{
			return "No Stores\n";
		}
	}

	// To String
	@Override
	public String toString() {
		return "Company Name = [" + companyName + "]\n Company Employee's =\n" + printAllEmployees() + " \nCompany Store = \n" + printAllStores();
	}

	public void addWorker(Employee w1, int storeId)
	{
		if (getStoreIndexById((int)w1.getStoreId()) != -1) {
			w1.setStoreId(storeId);
			this.companyEmp.add(w1);
			this.companyStore.get(getStoreIndexById(storeId)).storeEmp.add(w1);
			System.out.println("Worker Added Succsefully To Store: " + storeId);
		}
		else
		{
			System.out.println("Error Has Occurred On: Store ID Doesn't Exist!");
		}
	}

	public void removeWorker(int workerId) {
		int storeId = -1;
		if (getWorkerIndexById(workerId) != -1) {
			storeId = this.getCompanyEmp().get(getWorkerIndexById(workerId)).getStoreId();
			this.getCompanyEmp().remove(getWorkerIndexById(workerId));
			if (storeId != -1) {
				if (getStoreIndexById(storeId) != -1) {
					for (int j = 0; j < this.companyStore.get(getStoreIndexById(storeId)).storeEmp.size(); j++) {
						if (this.companyStore.get(getStoreIndexById(storeId)).storeEmp.get(j).getId() == workerId) {
							this.companyStore.get(getStoreIndexById(storeId)).storeEmp.remove(j);
							break;
						}
					}
				}
			}
		}

	}

	public double getSumShoppingAllCompany() {
		double temp = 0;
		for (int i = 0; i < this.companyStore.size(); i++) {
			temp += this.companyStore.get(i).getSumMoney();
		}
		return temp;
	}

	public double getSumSalariesAllNetwork() {
		double temp = 0;
		for (int i = 0; i < this.companyEmp.size(); i++) {
			temp += this.companyEmp.get(i).getSalary();
		}
		return temp;
	}

	public boolean storeIdExist(int storeId) {
		if (getStoreIndexById(storeId) != -1) {
			return true;
		}
		return false;
	}

	private boolean workerIdExist(int workerId) {
		if (getWorkerIndexById(workerId) != -1) {
			return true;
		}
		return false;
	}

	private int getStoreIndexById(int storeId) {
		for (int i = 0; i < this.companyStore.size(); i++) {
			if (this.companyStore.get(i).getStoreId() == storeId) {
				return i;
			}
		}
		return -1;
	}

	private int getWorkerIndexById(int workerId) {
		for (int i = 0; i < this.companyEmp.size(); i++) {
			if (this.companyEmp.get(i).getId() == workerId) {
				return i;
			}
		}
		return -1;
	}

	public double getSumSalariesStore(int storeId) {
		double temp = 0;
		if (getStoreIndexById(storeId) != -1) {
			for (int i = 0; i < this.companyStore.get(getStoreIndexById(storeId)).storeEmp.size(); i++) {
				temp += this.companyStore.get(getStoreIndexById(storeId)).storeEmp.get(i).getSalary();
			}
		}
		return temp;
	}

	public double getSumShoppingStore(int storeId) {
		if (getStoreIndexById(storeId) != -1)
			return this.companyStore.get(getStoreIndexById(storeId)).getSumMoney();
		else
			return 0;
	}

	public void shopping(int storeId, int value, int workerId) throws MsgException { 
		if((getStoreIndexById(storeId) != -1)&& (getWorkerIndexById(workerId) != -1))
		{
			NormalEmployee p = (NormalEmployee) this.companyEmp.get(getWorkerIndexById(workerId));
			Purchase pur = new Purchase(value, p);
			this.companyStore.get(getStoreIndexById(storeId)).newPurchase(pur);
			companyStore.get(getStoreIndexById(storeId)).addSumMoney(pur.getSumPurchase());
			System.out.println("The Order: " + pur.getSerialNumber() + " Was Completed By: " + p.getName() + ", Sum: " + value);
		}
		else
		{
			throw new MsgException("Error Was Occurred On: Menu 3 Command 3: Worker Doesn't Exist!");
		}
	}

	public void returningItem(int storeId, int orderid, int workerId) throws MsgException 
	{
		if(getStoreIndexById(storeId) != -1)
		{
			this.companyStore.get(getStoreIndexById(storeId)).cancelPurchase(orderid, workerId);
		}
	}

	public void shiftWorker(int workerId, int originalStoreId, int newStoreId) {
		if (getWorkerIndexById(workerId) != -1) {
			this.companyEmp.get(getWorkerIndexById(workerId)).setStoreId(newStoreId);
			Employee e = this.companyStore.get(getStoreIndexById(originalStoreId)).storeEmp
					.remove(getWorkerIndexById(workerId));
			this.companyStore.get(getStoreIndexById(newStoreId)).storeEmp.add(e);
		}
	}

	public String printStore(int storeId) {
		if (storeIdExist(storeId)) {
			return this.companyStore.get(getStoreIndexById(storeId)).toString();
		}
		return null;
	}

	public String printWorker(int workerId) {
		if (workerIdExist(workerId)) {
			return this.companyEmp.get(getWorkerIndexById(workerId)).toString();
		}
		return null;
	}

	public void addStore(Store st) {
		this.companyStore.add(st);
	}

}
