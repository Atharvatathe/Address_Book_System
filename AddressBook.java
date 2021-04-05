import java.util.*;

public class AddressBook
{
	public String name, address, city;
	public String state_zip,phone,email;
	
	
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
		System.out.println("Enter the Name of state and zip code ");
		person.state_zip = sc.nextLine();
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
		System.out.print("\nstate and Zip code: "+person.state_zip+ "\nPhone no.: "+person.phone+ "\nEmail: "+person.email);
		System.out.println();
	}

	public static void main(String[] args)
	{
		AddressBook atharva = new AddressBook();
		AddressBook ram = new AddressBook();
		
		atharva.setDetails(atharva);
		ram.setDetails(ram);
		
		atharva.showDetails(atharva);
		ram.showDetails(ram);
	}
}
