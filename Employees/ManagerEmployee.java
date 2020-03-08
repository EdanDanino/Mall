package Employees;
import misc.MsgException;

/**
* This class extends the abstract class employee,
* adding a variable containing the permission level of the manager.
*/
public class ManagerEmployee extends NormalEmployee {

	// Variables
	protected int permissionLvl;

	// Constructors
	public ManagerEmployee(String name,float id, double salary, double workPercentage, int intoPremissionLvl, int storeid) throws MsgException {
		super(name,id, salary, workPercentage, storeid);
		if (intoPremissionLvl <= 0 || intoPremissionLvl >= 4) {
			throw new MsgException("Error: Permission lvl Is supposed to be between 1 to 3 ! ");
		} else
			this.permissionLvl = intoPremissionLvl;
	}

	public ManagerEmployee(ManagerEmployee me) throws MsgException {
		super(me.getName(),me.getId(), me.getSalary(), me.getworkPercentage(), me.getStoreId());
		if (me.getPermissionLvl() < 1 || this.getPermissionLvl() > 3) {
			throw new MsgException("Permission lvl Is supposed to be between 1 to 3 ! ");
		}
		this.permissionLvl = me.getPermissionLvl();
	}

	

	// Getters And Setters
	public int getPermissionLvl() {
		return permissionLvl;
	}

	public void setPermissionLvl(int permissionLvl) {
		this.permissionLvl = permissionLvl;
	}

	// To String
	@Override
	public String toString() {
		return "ManagerEmployee [permissionLvl=" + permissionLvl + ", name=" + name + ", id=" + id + ", salary="
				+ salary + ", workPercentage=" + workPercentage + "]";
	}

	// Implements Of ISalary
	@Override
	public int calculateSalary(Employee e) {
		ManagerEmployee me = (ManagerEmployee) e;
		int calcSalary = (int) (me.getSalary() * me.getworkPercentage() * permissionLvl);
		return calcSalary;
	}

}
