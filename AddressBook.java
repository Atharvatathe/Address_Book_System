import java.util.*;

public class AddressBook
{
	public String name, address, city;
	public String state,zip,phone,email;
	
	
	public void setDetails(AddressBook person)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter Details of New person");
		System.out.println("Enter the Name: ");
		person.name = sc.nextLine();
		System.out.println("Enter the Address: ");
		person.address = sc.nextLine();
		System.out.println("Enter the Name of city: ");
		person.city = sc.nextLine();
		System.out.println("Enter the Name of state");
		person.state = sc.nextLine();
		System.out.println("Enter the Name of zip code ");
		person.zip = sc.nextLine();
		System.out.println("Enter the Phone Number: ");
		person.phone = sc.nextLine();
		System.out.println("Enter the Email address: ");
		person.email = sc.nextLine();
	}	
	
	public void showDetails(AddressBook person)
	{
		System.out.println();
		System.out.println("Details of " + person.name + " person");
		System.out.print("Name: "+person.name+ "\nAddress: "+person.address+ "\nCity: "+person.city);
		System.out.print("\nstate: "+person.state+ "\nzip code: "+zip+ "\nPhone no.: "+person.phone+ "\nEmail: "+person.email);
		System.out.println();
	}
	
	public void editDetails(String[] args,AddressBook person)
	{
		person.name = args[0];
		person.address = args[1];
		person.city = args[2];
		person.state= args[3];
		person.zip = args[4];
		person.phone = args[5];
		person.email = args[6];
	}
	
	
	
	
	public static void main(String[] args)
	{
		AddressBook atharva = new AddressBook();
		AddressBook ram = new AddressBook();
		
		atharva.setDetails(atharva);
		ram.setDetails(ram);
		
		atharva.showDetails(atharva);
		ram.showDetails(ram);
		
		atharva.editDetails(args,atharva);
		atharva.showDetails(atharva);
	}
}
