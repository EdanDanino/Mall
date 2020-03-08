package Company;

import java.util.*;

import Employees.Employee;
import Employees.NormalEmployee;
import misc.MsgException;
/**
* This class represents a store. When a store is created,
* 
*/
public class Store
{

	// Variables
	private final static int NumOfOrder = 1000;
	protected int storeId;
	protected Company storeCompany;
	protected Vector<Employee> storeEmp;
	protected Vector<Purchase> storeOrd;
	protected double sumMoney;

	// Constructors
	public Store(Store s,int id)
	{
		this.storeId=id;
		this.storeCompany = s.storeCompany;
		this.storeEmp = new Vector<Employee>();
		this.storeOrd = new Vector<Purchase>();
		sumMoney = 0;
	}
	public Store(Company s,int id)
	{
		this.storeId=id;
		this.storeCompany = s;
		this.storeEmp = new Vector<Employee>();
		this.storeOrd = new Vector<Purchase>();
		sumMoney = 0;
	}


	public Store()
	{
		this.storeId= -1;
		this.storeCompany = null;
		this.storeEmp = new Vector<Employee>();
		this.storeOrd = new Vector<Purchase>();
		sumMoney = 0;
	}

	// Getters And Setters
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public Company getStoreCompany() {
		return storeCompany;
	}
	public void setStoreCompany(Company storeCompany) {
		this.storeCompany = storeCompany;
	}
	
	public void addSumMoney(double newOr)
	{
		this.sumMoney += newOr;
	}

	public double getSumMoney() {
		return sumMoney;
	}
	// Adding A New Purchases To The Store
	public void newPurchase(Purchase p)
	{
		storeOrd.add(p);
		this.sumMoney += p.getSumPurchase();
	}
	
	private int getWorkerIndexById(int workerId) {
		for (int i = 0; i < this.storeEmp.size(); i++) {
			if (this.storeEmp.get(i).getId() == workerId) {
				return i;
			}
		}
		return -1;
	}
	
	// Logical Deletion Of The Order By Purchase ID
	public void cancelPurchase(int deletedP, int workerId) throws MsgException
	{
		NormalEmployee e = (NormalEmployee) storeEmp.get(getWorkerIndexById(workerId));
		e.setSumCostumers(e.getSumCustomers() - 1);
		e.setSumMoney(e.getSumMoney() - this.storeOrd.get(deletedP - NumOfOrder).getSumPurchase());
	}

	// Returning The Number Of Purchases
	public int purchaseCount()
	{
		return this.storeOrd.size();
	}
	@Override
	public String toString() {
		return "Store ID = " + storeId + "\nStore Company=" + storeCompany.getCompanyName() + "\nSum Income Money = " + sumMoney;
	}

	// To String
	
}
