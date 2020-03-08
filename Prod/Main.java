package Prod;
import java.util.*;

import misc.MsgException;
import misc.UsedCommends;
public class Main {

	public static void main(String[] args) throws MsgException,NumberFormatException {
			int menuIndex = 1;
			String command;
			Scanner reader = new Scanner(System.in);
			boolean flag = true;
			UsedCommends.addData();
			System.out.println("Welcome To Arik Mall!");
			while (flag)
			{
				System.out.println("You are in Menu " + menuIndex);
				System.out.println("Please enter your Command:");
				command = reader.nextLine();
				String[] commandInfo = command.split(" ",2);
				if (menuIndex == 1)
				{
					if (commandInfo.length == 1)
					{
						switch (commandInfo[0])
						{
						case "7":
						{
							menuIndex = 2;
							break;
						}
						case "8":
						{
							menuIndex = 3;
							break;
						}
						case "9":
						{
							flag = false;
							reader.close();
							break;
						}
						default:
							System.out.println(new MsgException("cant find command in menu 1"));
						}
					}
					else
					{
						try
						{
							UsedCommends.menu1Commands(command);
						}
						catch(NumberFormatException e)
						{
							System.out.println("String need to be number at "+ e.getMessage());
						}
						catch (MsgException e)
						{
							System.out.println(e.getMessage());
						}
					}
				}
				else if (menuIndex == 2)
				{
					if (commandInfo.length == 1)
					{
						switch (commandInfo[0])
						{
						case "6":
						{
							menuIndex = 1;
							break;
						}
						case "7":
						{
							menuIndex = 3;
							break;
						}
						case "8":
						{
							flag = false;
							break;
						}
						default:
							System.out.println(new MsgException(" cant find command in menu 2"));
						}
					}
					else
					{
						try
						{
							UsedCommends.menu2Commands(command);
						}
						catch(NumberFormatException e)
						{
							System.out.println("String need to be number at "+ e.getMessage());
						}
						catch (MsgException e)
						{
							System.out.println(e.getMessage());
						}
						
					}
				}
				else // menu 3
				{
					if (commandInfo.length == 1)
					{
						switch (commandInfo[0])
						{
						case "8":
						{
							menuIndex = 1;
							break;
						}
						case "9":
						{
							menuIndex = 2;
							break;
						}
						case "10":
						{
							flag = false;
							break;
						}
						default:
							System.out.println(new MsgException("cant find command in menu 3"));
						}
					}
					else
					{
						try
						{
							UsedCommends.menu3Commands(command);
						}
						catch(NumberFormatException e)
						{
							System.out.println("String need to be number at "+ e.getMessage());
						}
						catch (MsgException e)
						{
							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
	}
