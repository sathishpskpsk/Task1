package task1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressInfo {
	private static final JSONObject JSONObject = null;

	private String name;
	private int dNo;
	private String city;
	private String state;

	public AddressInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressInfo(int id, String name, int dNo, String city, String state) {
		super();
		this.name = name;
		this.dNo = dNo;
		this.city = city;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddressInfo [getName()=" + getName() + ", getdNo()=" + getdNo() + ", getCity()=" + getCity()
				+ ", getState()=" + getState() + "]";
	}

	static AddressInterface addressInterface = new Json();

	public static void main(String[] args) throws IOException, ParseException {
		AddressInterface addressInterface = new Json();
		Scanner scanner = new Scanner(System.in);

		boolean condition = true;
		ArrayList<AddressInfo> addressInfo = new ArrayList<>();
		ArrayList array = new ArrayList<>();

		// do {

		System.out.println("Enter Name:");
		String name = scanner.next();
		System.out.println("Door Number:");
		int dNo = scanner.nextInt();
		System.out.println("City:");
		String city = scanner.next();
		System.out.println("State:");
		String state = scanner.next();
		int id = 1;

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("dNO", dNo);
		jsonObject.put("city", city);
		jsonObject.put("state", state);
		
		addressInfo.add(new AddressInfo(id, name, dNo, city, state));

		array.add(name);
		array.add(dNo);
		array.add(city);
		array.add(state);
		

		System.out.println(addressInfo.toString());
		System.out.println("INFO done");
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
				System.out.println("          Process Terminated");
				System.out.println("*****************************************");
			}
				break;
			case 1: {
				addressInterface.jsonAdd(jsonObject, id);
			}
				break;
			case 2: {
				addressInterface.xmlAdd(addressInfo, id);
			}
				break;
			case 3: {
				addressInterface.csvAdd(array,id);
			}
				break;
			default:
				break;
			}
		} while (value);
	}
}