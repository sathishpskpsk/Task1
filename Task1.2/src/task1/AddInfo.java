package task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class AddInfo extends AddressInfo {
	
	
	static AddressInterface addressInterface = new JsonAdd();
	static AddressInterface addressInterface1 = new XmlAdd();
	static AddressInterface addressInterface2 = new CsvAdd();
	public static void main(String[] args) throws IOException, ParseException {
		Scanner scanner = new Scanner(System.in);

		boolean condition = true;
		ArrayList<AddressInfo> addressInfo = new ArrayList<>();
		ArrayList array = new ArrayList<>();

		System.out.println("Enter Name:");
		String name = scanner.next();
		System.out.println("Door Number:");
		int dNo = scanner.nextInt();
		System.out.println("City:");
		String city = scanner.next();
		System.out.println("State:");
		String state = scanner.next();
		int id=1;

		JSONObject jsonObject = new JSONObject();//JSON Object
		jsonObject.put("name", name);
		jsonObject.put("dNO", dNo);
		jsonObject.put("city", city);
		jsonObject.put("state", state);
		
		addressInfo.add(new AddressInfo(id, name, dNo, city, state));//List of Object

		array.add(name);//Arraylist
		array.add(dNo);
		array.add(city);
		array.add(state);
		
		select(addressInfo, array, jsonObject, id);
	}

	private static void select(Object addressInfo, ArrayList array, JSONObject jsonObject, int id) {
		Scanner scanner = new Scanner(System.in);
		boolean value = true;
		do {
			System.out.println("1.JSON File");
			System.out.println("2.XML File");
			System.out.println("3.CSV File");
			System.out.println("0.Exit");
			System.out.println("Select what type of file you want:");
			int s = scanner.nextInt();
			switch (s) {
			case 0: {
				value = false;
				System.out.println("*****************************************");
				System.out.println("          ADD Process Terminated");
				System.out.println("*****************************************");
			}
				break;
			case 1: {
				int a=addressInterface.add(jsonObject, id,addressInfo,array);
				System.err.println("\n   Your ID is: "+a);
			}
				break;
			case 2: {
				addressInterface1.add(jsonObject, id,addressInfo,array);
			}
				break;
			case 3: {
				addressInterface2.add(jsonObject, id,addressInfo,array);
			}
				break;
			default:
				break;
			}
		} while (value);
		
		System.out.println("READ DATA  \n ENter ID:");
		int sId=scanner.nextInt();
		JSONObject jsonObject2 = addressInterface.read(sId);
		System.out.println("Your Info "+jsonObject2); 
		 
		
	}

}
