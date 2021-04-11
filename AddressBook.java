import java.util.*;

	
public class AddressBook
{
	public ArrayList<String> first_name = new ArrayList<String>();
	public ArrayList<String> last_Name = new ArrayList<String>();
	public ArrayList<String> address = new ArrayList<String>();
	public ArrayList<String> city = new ArrayList<String>();
	public ArrayList<String> state = new ArrayList<String>();
	public ArrayList<String> zip = new ArrayList<String>();
	public ArrayList<String> phone = new ArrayList<String>();
	public ArrayList<String> email = new ArrayList<String>();
	
	
	
	//UC1 Set detalis for new person
	public void setDetails()
	{
		Scanner sc = new Scanner(System.in);
	
		while(true)
		{
			System.out.println();
			System.out.println("Set details for New person"); 
			
			System.out.println("Enter the First Name: ");
			first_name.add(sc.nextLine());
			System.out.println("Enter the Last Name: ");
			last_Name.add(sc.nextLine());
			System.out.println("Enter the Address: ");
			address.add(sc.nextLine());
			System.out.println("Enter the Name of city: ");
			city.add(sc.nextLine());
			System.out.println("Enter the Name of state");
			state.add(sc.nextLine());
			System.out.println("Enter the Name of zip code ");
			zip.add(sc.nextLine());
			System.out.println("Enter the Phone Number: ");
			phone.add(sc.nextLine());
			System.out.println("Enter the Email address: ");
			email.add(sc.nextLine());
			
			System.out.println();
			System.out.println("Do yoy want to set another person details select y/n");
		
			String choose = sc.nextLine();
			if(choose.equalsIgnoreCase("y"))
			{
				continue;
			}
				
			else if(choose.equalsIgnoreCase("n"))
			{
				System.out.println("Thank you");
				break;
			}
			else
				System.out.println("Invalide input");
		}

	}	
	
	//UC2 Shows details of person who present in book
	public void showDetails()
	{
		Scanner shows = new Scanner(System.in);
		System.out.println();
		
		System.out.println("Enter the First name of person whose details want to show");
		String showName = shows.next();
		int position =first_name.indexOf(showName);
			
		if(first_name.contains(showName))
		{
			System.out.println(first_name.get(position));
			System.out.println(last_Name.get(position));
			System.out.println(address.get(position));
			System.out.println(city.get(position));
			System.out.println(state.get(position));
			System.out.println(zip.get(position));
			System.out.println(phone.get(position));
			System.out.println(email.get(position));
			
		}
		else
			System.out.println("Thie Person is not available in book ");
		
	
	}
	
	//UC3 Edit the details of persons using name of person
	public void editDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Do you want to edit details of person? select y/n");
		String check = sc.next();
			
		if(check.equalsIgnoreCase("y"))
		{
			while(true)
			{
				System.out.println("Enter the First name of person whose details want to edit");
				String editName = sc.next();
				int pos = first_name.indexOf(editName);
				
				if(first_name.contains(editName))
				{	
					System.out.println();
				
					System.out.println("Enter the First Name: ");
					first_name.set(pos,sc.nextLine());
					System.out.println("Enter the Last Name: ");
					last_Name.set(pos,sc.nextLine());
					System.out.println("Enter the Address: ");
					address.set(pos,sc.nextLine());
					System.out.println("Enter the Name of city: ");
					city.set(pos,sc.nextLine());
					System.out.println("Enter the Name of state");
					state.set(pos,sc.nextLine());
					System.out.println("Enter the Name of zip code ");
					zip.set(pos,sc.nextLine());
					System.out.println("Enter the Phone Number: ");
					phone.set(pos,sc.nextLine());
					System.out.println("Enter the Email address: ");
					email.set(pos,sc.nextLine());
					break;
				}
				else
					System.out.println("not any person of available of this name");
			}
		}
		else if(check.equalsIgnoreCase("n"))
		{
			System.out.println("you Selected 'NO'");
		}
		else
		{
			System.out.println("inavalid option choose correct ");
			editDetails();
		}
		System.out.println("Firs_name: " +first_name+ " \nlast_name: "+last_Name+ "\nAddress: "+address+ " \ncity: "+city+
				"\nstate: "+state+ "\nzipcode: "+zip+ "\nPhoneNumber: "+phone+ "\nEmail: " +email);
	
	
	}
	
	//UC4 delete the details of persons from address book
	public void deleteDetails()
	{
		Scanner delete = new Scanner(System.in);
		System.out.println("Do you want to delete the details ? select y/n ");
		String check = delete.next();
		
		if(check.equalsIgnoreCase("y"))
		{
			System.out.print("Enter the First name of person whose details want to delete ");
			String deleteName = delete.next();
			int pos = first_name.indexOf(deleteName);
			
			if(first_name.contains(deleteName))
			{
				first_name.remove(pos);
				last_Name.remove(pos);
				address.remove(pos);
				city.remove(pos);
				state.remove(pos);
				zip.remove(pos);
				phone.remove(pos);
				email.remove(pos);
			}
			
			System.out.println("Successfully delete details of " +deleteName);
			
		}
		else if (check.equalsIgnoreCase("n"))
			System.out.println("you Selected 'NO' ");
		else
			System.out.println("inavalid option");
			
	}
	
	
	public static void main(String[] args)
	{
		AddressBook book = new AddressBook();
		
	    Scanner user = new Scanner(System.in);
		System.out.println("choose the option from below");
		
		
		while(true)
		{
			System.out.println("1)Set details of new person\n2)Show details of person\n3)Delete details of person\n4)edit the details of person\n5)Exit"); 
			int select = user.nextInt();
			
			switch(select)
			{
				case 1:
					book.setDetails();
					break;
					
				case 2:
					book.showDetails();
					break;
				
				case 3:
					book.deleteDetails();
					break;
					
				case 4:
					book.editDetails();
					break;
					
				case 5:
					System.exit(0);
					break;
				default : 
					System.out.println("Invalid Input");
					
					
			}
		}
		
		
	}
}
