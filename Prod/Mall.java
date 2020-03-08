package Prod;
import java.util.*;

import Company.Store;

public class Mall {

	// Variables
	protected int mallId;
	protected String mallName;
	private static int idmallcnt = 1000;
	protected Vector<Store> storesArr;
	protected String adress;

	// Constructors
	public Mall(String mallName, Vector<Store> storesArr, String adress) {
		this.mallId = idmallcnt++;
		this.mallName=mallName;
		this.storesArr = storesArr;
		this.adress = adress;
		
	}
	public Mall() {
		this.mallId = idmallcnt++;
		this.mallName="";
		this.storesArr = new Vector<Store>() ;
		this.adress = "";
	}
	public Mall(String s, String adress) {
		this.mallId = idmallcnt++;
		this.mallName=s;
		this.storesArr = new Vector<Store>() ;
		this.adress = adress;
	}

	// Getters And Setters
	public int getMallId() {
		return mallId;
	}

	public void setMallId(int mallId) {
		this.mallId = mallId;
	}

	public Vector<Store> getStoresArr() {
		return storesArr;
	}

	public void setStoresArr(Vector<Store> storesArr) {
		this.storesArr = storesArr;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMallName() {
		return mallName;
	}
	public void setMallName(String mallName) {
		this.mallName = mallName;
	}
	// To String
	@Override
	public String toString() {
		return "Mall ID = " + mallId + "\nStores = " + printStoresInArr() + "Adress = " + adress;
	}
	
	public String printStoresInArr()
	{
		if(this.storesArr.size() > 0)
		{
			String temp = "";
			for(int i = 0; i < this.storesArr.size(); i++)
			{
				temp += this.storesArr.get(i).toString() + "\n";
			}
			return temp;
		}
		return "No Stores In This Mall";
	}
	
	public double getSumShopping() {
		double temp = 0;
		for(int i = 0; i<this.storesArr.size(); i++)
		{
			temp+= this.storesArr.get(i).getSumMoney();
		}
		return temp;
	}
	public boolean companyExistInMall(String company) {
		for(int i = 0; i<this.storesArr.size(); i++)
		{
			if(this.storesArr.get(i).getStoreCompany().getCompanyName().equals(company))
			{
				return true;
			}
		}
		return false;
	}
	public Store removeStore(int storeId, String networkName) {
		Store s = null;
		for(int i=0; i<this.storesArr.size(); i++)
		{
			if((this.storesArr.get(i).getStoreId() == storeId) && (this.storesArr.get(i).getStoreCompany().getCompanyName().equals(networkName)))
			{
				s = this.storesArr.get(i);
				this.storesArr.remove(i);
				return s;
			}
		}
		return s;
	}
	public void addStore(Store st) 
	{
		this.storesArr.add(st);
	}


}
