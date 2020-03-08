package Company;
import Employees.Cashier;
import misc.MsgException;
import Employees.*;
/**
* This class represents a purchase made by a customer.
*/
public class Purchase {

	private static int ordersCount = 1000;
	protected int serialNumber;
	protected NormalEmployee e;
	protected int sumPurchase;
	protected boolean status;// True = Transaction complete
	                           //False = Transaction
								// Have been canceled by the cashier/Employee
	// Constructors
	public Purchase(int value, NormalEmployee e)
	{
		this.serialNumber = ordersCount++;
		this.status = true;
		this.sumPurchase = value;
	}

	// Getters And Setters
	public Employee getE() {
		return e;
	}

	public void setE(Cashier e) {
		this.e = e;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getSumPurchase() {
		return sumPurchase;
	}
	public void setSumPurchase(int sumPurchase) {
		this.sumPurchase = sumPurchase;
	}
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// Logical Deletion Of The Order
	public void cancelOrder() throws MsgException
	{
	}


}
