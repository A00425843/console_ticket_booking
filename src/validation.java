import java.util.Scanner;

public class validation {
	
	
	Scanner scn=new Scanner(System.in);
	public String check_String(String Name) 
	{
		boolean a=Name.matches("[a-zA-Z]+");
	    while(!a)
	    {
	    System.out.println("Name Entered is wrong...Enter Again");
	    Name = scn.nextLine();
	    a=Name.matches("[a-zA-Z]+");
	    }
		return Name;
	}

}
