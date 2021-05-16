import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.chrono.JapaneseChronology;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.*;

public class AddressBook extends Contact{

	static HashMap<Contact,String> personsInCity = new HashMap<Contact,String>();
	static  ArrayList<String> list;

	public static String CSV_CONTACT_FILE_PATH = "D:\\Intellij project\\AddressBook\\src\\main\\resources\\Contact.csv";
	public static String JSON_USER_FILE_PATH = "D:\\Intellij project\\AddressBook\\src\\main\\resources\\User.json";

	// Add Multiple Address Books

	public static void setMultipleBook() throws IOException {
		Scanner user = new Scanner(System.in);
		System.out.println("List of Address Books: ");
		for(Map.Entry m :multipleBooks.entrySet()){
			System.out.println(m.getKey());
		}
		while(true){
			System.out.println("Enter key of AddressBook which you have to access ");
			String key = user.nextLine();
			if(multipleBooks.containsKey(key)){
				chooseOption(multipleBooks.get(key));
				break;
			}
			else
				System.out.println("Invalid Key Enter Correct key");
		}
	}


	//Choose Differnt option for fill Details
	public static void chooseOption(AddressBook book) throws IOException {
		Scanner user = new Scanner(System.in);
		System.out.println("choose the option from below");


		while(true)
		{
			System.out.println();
			System.out.println("1)Set details of new person\n2)Show details of person\n3)Delete details of person\n" +
					"4)edit the details of person\n5)Goto other AddressBook\n6)Search person in city\n" +
					"7)Search person in state\n8)Count the person by city\n9)Sort person by name\n10)Sort By City\n" +
					"11)Sort by state\n12)Sort by zip\n13)WriteToFile\n14)readFromFile\n15)WriteOrReadCsvFile\n" +
					"16)WriteORReadJsonFile\n17)Exit");
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
					setMultipleBook();
					break;

				case 6:
					searchPersonIncity();
					break;

				case 7:
					searchPersonInState();
					break;

				case 8:
					countPersonsByCity();
					break;

				case 9:
					sortByName();
					break;

				case 10:
					sortPersonsByCity();
					break;

				case 11:
					sortPersonsByState();
					break;

				case 12:
					sortPersonsByZipCode();
					break;
				case 13:
					try {
						writeToFile();
					}catch (IOException e){
						e.printStackTrace();
					}
					break;
				case 14:
					try {
						readFromFile();
					}catch (IOException e){
						e.printStackTrace();
					}
					break;

				case 15:
					try {
						writeOrReadCSVFile();
					} catch (CsvDataTypeMismatchException e) {
						e.printStackTrace();
					} catch (CsvRequiredFieldEmptyException e) {
						e.printStackTrace();
					}
					break;

				case 16:
					writeOrReadJsonFile();
					break;

					case 17:
					System.exit(0);
					break;

				default :
					System.out.println("Invalid Input");


			}
		}

	}



	//Set detalis for new person
	public void setDetails()
	{
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println();
			System.out.println("Set details for New person");

			System.out.println("Enter the First Name: ");
			String firstName = sc.nextLine();
			boolean check = checkIsDuplicate(firstName);
			if(check == false)
				first_name.add(firstName);
			else{
				System.out.println("person is already exist");
				break;
			}
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

	//Shows details of person who present in book
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

	//Edit the details of persons using name of person
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

	//delete the details of persons from address book
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

	public static boolean checkIsDuplicate(String personName){
		if(first_name.contains(personName))
			return true;
		else
			return false;

	}
	public static void searchPersonIncity(){
		Scanner userInput=new Scanner(System.in);
		System.out.print("Enter city name :");
		int flag=0;
		String cityName=userInput.nextLine();
		for(Map.Entry m : multipleBooks.entrySet()){
			AddressBook addressbook=(AddressBook) m.getValue();
			for(String city : addressbook.city) {
				if(city.equalsIgnoreCase(cityName)) {
					flag=1;
					System.out.println(first_name);
				}
			}
		}
		if(flag==0)
			System.out.println("This City does not exists!");
	}

	public static void searchPersonInState(){
		Scanner user = new Scanner(System.in);
		System.out.print("Enter State name :");
		int flag=0;
		String stateName=user.nextLine();
		for(Map.Entry m : multipleBooks.entrySet()){
			AddressBook addressbook=(AddressBook) m.getValue();
			for(String state : addressbook.state) {
				if(state.equalsIgnoreCase(stateName)) {
					flag=1;
					System.out.println(first_name);
				}
			}
		}
		if(flag==0)
			System.out.println("This state does not exists!");
	}


	public static void countPersonsByCity(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the city name ");
		String cityName= sc.nextLine();
		List<Contact>personsInCity=getPersonsByCity(cityName);
		if(personsInCity.isEmpty())
			System.out.println("City "+cityName+" Does Not Exists !");
		else
			System.out.println("Total No. Of Persons Found In "+cityName.toUpperCase()+" Are :"+personsInCity.stream().count());
	}


	public static List<Contact> getPersonsByCity(String cityName) {
		List<Contact> list = personsInCity.entrySet()
				.stream()
				.filter(city->city.getValue().equalsIgnoreCase(cityName))
				.map(personInCity->personInCity.getKey())
				.collect(Collectors.toList());
		return list;
	}


	public static void sortByName(){
		List<String> name = first_name.stream().sorted().
				collect(Collectors.toList());
		System.out.println("Sorted list by name");
		name.forEach(System.out::println);

	}

	public static void sortPersonsByCity() {
		List<String> cityName = city.stream().sorted().
				collect(Collectors.toList());
		System.out.println("Sorted list by city");
		cityName.forEach(System.out::println);

	}



	public static void sortPersonsByState() {
		List<String> stateName = state.stream().sorted().
				collect(Collectors.toList());
		System.out.println("Sorted list by state");
		stateName.forEach(System.out::println);

	}

	public static void sortPersonsByZipCode() {
		List<String> zipcode = zip.stream().sorted().
				collect(Collectors.toList());
		System.out.println("Sorted list by zipcode");
		zipcode.forEach(System.out::println);
	}

	public static void writeToFile() throws IOException {
		try {
			FileOutputStream fileData = new FileOutputStream("D:/Intellij project/AddressBook/src/main/resources/Adderess.txt");
			ObjectOutputStream writeStream = new ObjectOutputStream(fileData);
			writeStream.writeObject(first_name);
			writeStream.writeObject(last_Name);
			writeStream.flush();
			writeStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFromFile()throws IOException {
		try {
			FileInputStream file = new FileInputStream("D:/Intellij project/AddressBook/src/main/resources/Adderess.txt");
			ObjectInputStream readStream = new ObjectInputStream(file);
			ArrayList<Contact> co = (ArrayList<Contact>) readStream.readObject();
			readStream.close();
			System.out.println(co.toString());

		}catch(FileNotFoundException e) {
			System.out.println("File Not Found!");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void writeOrReadCSVFile() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		Scanner select = new Scanner(System.in);
		System.out.println("Select 'W' to Write in to Csv file and 'R' for Read the file ");
		while (true) {
			String check = select.nextLine();
			if (check.equalsIgnoreCase("w")) {
				try (CSVWriter write = new CSVWriter(new FileWriter(CSV_CONTACT_FILE_PATH))) {
					List<String[]> csvdata = new ArrayList<String[]>();

					String[] header = "first_name,last_Name,address,city,state,zip,phone,email".split(",");
					String[] profile = "Atharva,Tathe,abc,pandharpur,Maharashtra,123,111111,atharva.com".split(",");

					csvdata.add(header);
					csvdata.add(profile);
					write.writeAll(csvdata);

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			} else if (check.equalsIgnoreCase("R")) {
				try (Reader reader = Files.newBufferedReader(Paths.get(CSV_CONTACT_FILE_PATH));
					 CSVReader csvreader = new CSVReader(reader);
				) {
					String[] nextLine;
					while((nextLine= csvreader.readNext())!=null){
						for (String tocken : nextLine)
							System.out.println(tocken);
						System.out.println("\n");
					}
				} catch (CsvException e) {
					e.printStackTrace();
				}
				break;
			}else
				System.out.println("Select valid option");

		}
	}

	public static void writeOrReadJsonFile() throws IOException {
		Scanner select = new Scanner(System.in);
		System.out.println("Select 'W' to Write in to Csv file and 'R' for Read the file ");
		while (true) {
			String check = select.nextLine();
			if (check.equalsIgnoreCase("w")) {
				try {
					Gson gson = new Gson();
					FileWriter fileWriter = new FileWriter(JSON_USER_FILE_PATH);
					gson.toJson(Contact.first_name, fileWriter);
					gson.toJson(Contact.last_Name, fileWriter);
					gson.toJson(Contact.address, fileWriter);
					gson.toJson(Contact.city, fileWriter);
					gson.toJson(Contact.state, fileWriter);
					gson.toJson(Contact.zip, fileWriter);
					gson.toJson(Contact.phone, fileWriter);
					gson.toJson(Contact.email, fileWriter);
					fileWriter.close();
				}catch (IOException e){
					e.printStackTrace();
				}
				break;

			} else if (check.equalsIgnoreCase("R")) {
				try{
					Gson gson = new Gson();
					Reader reader = new FileReader(JSON_USER_FILE_PATH);
					Contact.first_name = gson.fromJson(reader, (Type) Contact.class);
					System.out.println(first_name);
					reader.close();
				}catch (IOException e){
					e.printStackTrace();
				}
				break;

			} else
				System.out.println("Select valid option");

		}
	}

	public static void main(String[] args) throws IOException {

		AddressBook AddressBook1 = new AddressBook();
		AddressBook AddressBook2 = new AddressBook();

		multipleBooks.put("AddressBook1",AddressBook1);
		multipleBooks.put("AddressBook2",AddressBook2);

		setMultipleBook();

	}



}
