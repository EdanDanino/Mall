package misc;
public class UsedCommends {
	
	public static void menu1Commands(String command) throws MsgException, NumberFormatException
	{
		String[] commandInfo = command.split(" ");
		if (commandInfo.length > 1)
		{

				switch (commandInfo[0])
				{
				case "1":
				{
					switch(commandInfo[1])
					{

					case "1":
					{
						if(commandInfo.length == 4)
						{
							MenuCommends.addClothingNetwork(commandInfo[2], commandInfo[3]);
							return;
						}
						throw new MsgException("Error Was Occurred On: Menu 1 Command 1 type 1");

					}
					case "2":
					{
						if (commandInfo.length == 4)
						{
							try 
							{
								MenuCommends.addFoodNetwork(commandInfo[2],Integer.parseInt(commandInfo[3]));
								return;
							}
							catch (NumberFormatException e)
							{
								throw new NumberFormatException("Error Was Occurred On: Menu 1 Command 1 Type 2");
							}
						}
						throw new MsgException("Error Was Occurred On: Menu 1 Command 1 Type 2");
					}
					case "3":
					{
						if (commandInfo.length == 6)
						{
							try
							{
								MenuCommends.addFastFoodNetwork(commandInfo[2],Integer.parseInt(commandInfo[3]),Integer.parseInt(commandInfo[4]),Integer.parseInt(commandInfo[5]));
								return;
							}
							catch (NumberFormatException e)
							{
								throw new NumberFormatException("Error Was Occurred On: menu 1 command 1 type 3");
							}
							
						}
						throw new MsgException(" menu 1 command 1 type 3");
					}
					case "4":
					{
						if (commandInfo.length == 4)
						{
							MenuCommends.addBooksNetwork(commandInfo[2],commandInfo[3]);
							return;
						}
						throw new MsgException("Error Was Occurred On: menu 1 command 1 type 4");
					}
					default:
						throw new MsgException("Error Was Occurred On: menu 1 command 1 no type");
					}
					

				}
				case "2":
				{
					if (commandInfo.length == 8)
					{
						if (commandInfo[3].length() == 1) // check type char is one letter
						{
							try 
							{
								MenuCommends.addEmployee(commandInfo[1], Integer.parseInt(commandInfo[2]), Integer.parseInt(commandInfo[3]), Double.parseDouble(commandInfo[4]), Integer.parseInt(commandInfo[5]), commandInfo[6], Integer.parseInt(commandInfo[7]));
								return;
							}
							catch (NumberFormatException e)
							{
								throw new NumberFormatException("Error Was Occurred On: menu 1 command 2");
							}
						}
					}
					throw new MsgException("Error Was Occurred On: menu 1 command 2");
				}
				case "3":
				{
					if (commandInfo.length == 3)
					{		
						try
						{
							MenuCommends.removeEmployee(Integer.parseInt(commandInfo[1]), commandInfo[2]);
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException("Error Was Occurred On: menu 1 command 3");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 1 command 3");
				}
				case "4":
				{
					if(commandInfo.length == 2)
					{
						System.out.println("Sum shoppings: " + MenuCommends.getSumShoppingNetwork(commandInfo[1]));
						return;
					}
					throw new MsgException("Error Was Occurred On: menu 1 command 4");
				}
				case "5":
				{
					if(commandInfo.length == 2)
					{
						System.out.println("Sum Salaries: "+ MenuCommends.getSumSalariesAllNetwork(commandInfo[1]));
						return;
					}
					throw new MsgException("Error Was Occurred On: menu 1 command 5");
				}
				case "6":
				{
					if(commandInfo.length == 2)
					{
						System.out.println(MenuCommends.printNetwork(commandInfo[1]));
						return;
					}
					throw new MsgException("Error Was Occurred On: menu 1 command 7");
				}
				default:
					throw new MsgException("Error Was Occurred On: menu 1 command 7 cant find command in menu 1");
				}
		}
		else
			throw new MsgException(" Not good");
	}
	public static void menu2Commands(String command) throws MsgException, NumberFormatException
	{
		String[] commandInfo = command.split(" ");
		if (commandInfo.length > 1)
		{

				switch (commandInfo[0])
				{
				case "1":
				{
					if (commandInfo.length == 4)
					{
						try 
						{
							MenuCommends.addCenter(commandInfo[1], Integer.parseInt(commandInfo[2]), commandInfo[3]);
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 2 command 1");
						}
					}
					throw new MsgException("Error Was Occurred On: Menu 2 Command 1");
				}
				case "2":
				{
					if (commandInfo.length == 4)
					{
						try 
						{
							MenuCommends.addStore(Integer.parseInt(commandInfo[1]),commandInfo[2] ,commandInfo[3]);
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 2 command 2");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 2 command 2");
				}
				case "3":
				{
					if (commandInfo.length == 2)
					{						
						System.out.println("Sum shoppings in mall: " + MenuCommends.getSumShoppingMall(commandInfo[1]));
						return;
					}
					throw new MsgException("Error Was Occurred On: menu 2 command 3");
				}
				case "4":
				{
					if(commandInfo.length == 5)
					{
						try 
						{
							MenuCommends.shiftStore(commandInfo[1], Integer.parseInt(commandInfo[2]), commandInfo[3], commandInfo[4]);
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 2 command 4");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 2 command 4");
				}
				case "5":
				{
					if(commandInfo.length == 2)
					{
						System.out.println(MenuCommends.printMall(commandInfo[1]));
						return;
					}
					throw new MsgException("Error Was Occurred On: menu 1 command 5");
				}
				default:
					throw new MsgException("Error Was Occurred On: menu 1 command 5: cant find command in menu 2");
				}
		}
		else
			throw new MsgException(" Not good");

		
	}
	public static void menu3Commands(String command) throws MsgException, NumberFormatException
	{
		String[] commandInfo = command.split(" ");
		if (commandInfo.length > 1)
		{

				switch (commandInfo[0])
				{
				case "1":
				{
					if (commandInfo.length == 3)
					{
						try 
						{
							System.out.println("Sum salaries in store: " + MenuCommends.getSumSalariesStore(Integer.parseInt(commandInfo[1]),commandInfo[2]));
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 3 command 1");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 3 command 1");
				}
				case "2":
				{
					if (commandInfo.length == 3)
					{
						try 
						{
							System.out.println("Sum shoppings in store: " + MenuCommends.getSumShoppingStore(Integer.parseInt(commandInfo[1]),commandInfo[2]));
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 3 command 2");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 3 command 2");
				}
				case "3":
				{
					if (commandInfo.length == 5)
					{						
						try 
						{
							MenuCommends.shopping(Integer.parseInt(commandInfo[1]), commandInfo[2], Integer.parseInt(commandInfo[3]), Integer.parseInt(commandInfo[4]));
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 3 command 3");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 3 command 3");
				}
				case "4":
				{
					if (commandInfo.length == 5)
					{						
						try 
						{
							MenuCommends.returningItem(Integer.parseInt(commandInfo[1]), commandInfo[2], Integer.parseInt(commandInfo[3]), Integer.parseInt(commandInfo[4]));
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 3 command 4");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 3 command 4");
				}
				case "5":
				{
					if (commandInfo.length == 5)
					{						
						try 
						{
							MenuCommends.shiftEmployee(Integer.parseInt(commandInfo[1]), commandInfo[2], Integer.parseInt(commandInfo[3]), Integer.parseInt(commandInfo[4]));
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 3 command 5");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 3 command 5");
				}
				case "6":
				{
					if (commandInfo.length == 3)
					{
						try 
						{
							System.out.println(MenuCommends.printStore(Integer.parseInt(commandInfo[1]),commandInfo[2]));
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 3 command 6");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 3 command 6");
				}
				case "7":
				{
					if (commandInfo.length == 3)
					{
						try 
						{
							System.out.println(MenuCommends.printEmployee(Integer.parseInt(commandInfo[1]),commandInfo[2]));
							return;
						}
						catch (NumberFormatException e)
						{
							throw new NumberFormatException(new NumberFormatException().getMessage() + ": menu 3 command 7");
						}
					}
					throw new MsgException("Error Was Occurred On: menu 3 command 7");
				}
				default:
					throw new MsgException(" cant find command in menu 3");
				}
		}
		else
			throw new MsgException(": Not good");
	}

	public static void addData() throws MsgException, NumberFormatException
	{
		//adding malls
		// MenuCommends.addCenter("Hilel", 212, "Yakinton");
		// MenuCommends.addCenter("Hasharon", 432, "Yoseftal");
		//adding Company
		// MenuCommends.addClothingNetwork("macMoris", "MrLog");
		//adding stores
		// MenuCommends.addStore(81, "macMoris", "Hilel");
		//MenuCommends.addStore(82, "macMoris", "Hilel");
		//1 3 macMoris 2 40 25
		// MenuCommends.addEmployee("moshe", 555, 1, 75, 2000, "macMoris", 81);
		//2 David 556 1 75 2000 macMoris 81
		//2 Idan 557 1 75 2000 macMoris 81
		//2 Tal 558 1 75 2000 macMoris 81
		
	}
		
}