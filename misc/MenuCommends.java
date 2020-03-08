package misc;


import java.util.Vector;

import Company.*;
import Employees.*;
import Prod.Mall;
public class MenuCommends {
	public static Vector<Company> companys = new Vector<Company>();
	public static Vector<Mall> malls = new Vector<Mall>();
	
	
	private static boolean NetworkNameExist(String name)
	{
		for (int i = 0; i < companys.size(); i++) 
		{
			if (name.equals(companys.get(i).getCompanyName()))
				return true;
		}
		return false;
	}
	private static boolean MallNameExist(String name)
	{
		for (int i = 0; i < malls.size(); i++) 
		{
			if (name.equals(malls.get(i).getMallName()))
				return true;
		}
		return false;
	}
	
	private static Company getNetworkByName(String name) throws MsgException
	{
		for (int i = 0; i < companys.size(); i++) 
		{
			if (name.equals(companys.get(i).getCompanyName()))
				return companys.get(i);
		}
		throw new MsgException("NetWork Name Dosnt exsist");
	}
	
	private static Mall getMallByName(String name) throws MsgException
	{
		for (int i = 0; i < malls.size(); i++) 
		{
			if (name.equals(malls.get(i).getMallName()))
				return malls.get(i);
		}
		throw new MsgException("mall Name Dosnt exsist");
	}
	
	
	// Menu 1:
	
	// Menu 1 Command 1 addChain
	public static void addClothingNetwork(String name, String importerName) throws MsgException
	{
		if (NetworkNameExist(name))
			throw new MsgException("Clothing Networks's name Exist");
		Company n1 = new ClothingCompany(name, importerName);
		companys.add(n1);
		System.out.println("Clothing Network: " + name + " Added Succssfully");
	}
	public static void addBooksNetwork(String name, String bookTitle)throws MsgException
	{
		if (NetworkNameExist(name))
			throw new MsgException("Books Networks's name Exist");
		Company n1 = new BookCompany(name, bookTitle);
		companys.add(n1);
		System.out.println("Books Network: " + name + " Added Succssfully");
		
	}
	public static void addFastFoodNetwork(String name,  int suppliersQuantity, float businessMealPrice, float studentDiscounts) throws MsgException
	{
		if (NetworkNameExist(name))
			throw new MsgException("Fast food Networks's name Exist");
		Company n1 = new FastFoodCompany(name, suppliersQuantity, businessMealPrice, studentDiscounts);
		companys.add(n1);
		System.out.println("Fast Food Network: " + name + " Added Succssfully");
	}
	public static void addFoodNetwork(String name,  int suppliersQuantity) throws MsgException
	{
		if (NetworkNameExist(name))
			throw new MsgException("Food Networks's name Exist");
		Company n1 = new FoodCompany(name, suppliersQuantity);
		companys.add(n1);
		System.out.println("Food Network: " + name + " Added Succssfully");
	}
	
	// Menu 1 Command 2 addEmployee
	public static void addEmployee(String workerName, int workerId, int workerType, double workerJobPercentage ,int workerBaseSalary, String networkName, int storeId) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		Employee w1;
		switch(workerType)
		{
		case 1:
			w1 = new ManagerEmployee(workerName, workerId, workerBaseSalary, workerJobPercentage, workerType, storeId);
		break;
		case 2:
			w1 = new AdvancedEmployee(workerName, workerId,  workerBaseSalary, workerJobPercentage, storeId);
		break;
		case 3:
			w1 = new NormalEmployee(workerName, workerId, workerJobPercentage, workerBaseSalary, storeId);
		break;
		case 4:
			w1 = new Cashier(workerName, workerId, workerJobPercentage, workerBaseSalary, storeId);
		break;
		default:
			throw new MsgException("The Worker Type Dosent exsist");
		}
		n1.addWorker(w1, storeId);
	}
	
	// Menu 1 Command 3 removeEmployee
	public static void removeEmployee(int workerId, String networkName) throws  MsgException
	{	
		Company n1 = getNetworkByName(networkName);
		n1.removeWorker(workerId);
		System.out.println("Worker: " + workerId + " Deletion Succsesfully From Network: " + networkName);
	}
	
	// Menu 1 Command 4 getSumShopping
	
	public static double getSumShoppingNetwork(String networkName) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		return n1.getSumShoppingAllCompany();
	}
	
	// Menu 1 Command 5 getSumSalaries
	
	public static double getSumSalariesAllNetwork(String networkName) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		return n1.getSumSalariesAllNetwork();
	}
	
	// Menu 1 Command 6 print 
	
	public static String printNetwork(String networkName) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		return n1.toString();
	}
	
	// Menu 2:
	
	// Menu 2 Command 1 addCenter
	public static void addCenter(String name, int id, String adress) throws MsgException
	{
		if (MallNameExist(name))
			throw new MsgException("Name Dosent exsist");
		Mall m1 = new Mall(name, adress);
		malls.add(m1);
		System.out.println("Added Mall Successfully Name: " + name + " On " + adress);
	}
	
	//Menu 2 Command 2 addStore
	public static void addStore(int storeId, String networkName, String mallName) throws MsgException
	{
		Mall m1 = getMallByName(mallName);
		Company n1 = getNetworkByName(networkName);
		if (n1.storeIdExist(storeId))
			throw new MsgException("Store Id allready Exist");
		else
		{
			Store st = new Store(n1,storeId);
			n1.addStore(st);
			m1.addStore(st);
			System.out.println("Added Store Successfully ID: " + storeId + ", By Company: " + networkName);
		}
		
	}
	
	//Menu 2 Command 3 getSumShopping
	public static double getSumShoppingMall(String mallName) throws MsgException
	{
		Mall m1 = getMallByName(mallName);
		return m1.getSumShopping();
	}
	
	//Menu 2 Command 4 shiftStore
	public static void shiftStore(String company, int storeId, String originalMallName, String newMallName) throws MsgException
	{
		Mall originalMall = getMallByName(originalMallName);
		Mall newMall = getMallByName(newMallName);
		if ((!originalMall.companyExistInMall(company)) && (!newMall.companyExistInMall(company)))
			throw new MsgException("network's name both malls");
		Store st = originalMall.removeStore(storeId,company);
		newMall.addStore(st);
	}
	
	//Menu 2 Command 5 print 
	public static String printMall(String mallName) throws MsgException
	{
		Mall m1 = getMallByName(mallName);
		return m1.toString();
	}
	
	//Menu 3:
	
	//Menu 3 Command 1 getSumSalaries 
	public static double getSumSalariesStore(int storeId, String networkName) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		return n1.getSumSalariesStore(storeId);
	}
	
	//Menu 3 Command 2 getSumShopping
	public static double getSumShoppingStore(int storeId, String networkName) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		return n1.getSumShoppingStore(storeId);
		
	}
	
	//Menu 3 Command 3 shopping
	public static void shopping(int storeId, String networkName, int value, int workerId) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		n1.shopping(storeId, value, workerId);
		
	}
	
	//Menu 3 Command 4 returningItem
	public static void returningItem(int storeId, String networkName, int orderid, int workerId) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		n1.returningItem(storeId, orderid, workerId);
		System.out.println("The Item Was Returned!");
	}
	
	//Menu 3 Command 5 shiftEmployee
	public static void shiftEmployee(int workerId, String networkName, int originalStoreId, int newStoreId) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		n1.shiftWorker(workerId, originalStoreId, newStoreId);
		System.out.println("The Employee: " + workerId + " Was Shifted From Store: " + originalStoreId + " To Store: " + newStoreId);
	}
	
	//Menu 3 Command 6 print
	public static String printStore(int storeId, String networkName) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		return n1.printStore(storeId);
	}
	
	//Menu 3 Command 7 printEmployee
	public static String printEmployee(int workerId, String networkName) throws MsgException
	{
		Company n1 = getNetworkByName(networkName);
		return n1.printWorker(workerId);
	}
	
}
