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
	private  int id;
	private String name;
	private int dNo;
	private String city;
	private String state;
	

	public  int getid() {
		return id;
	}
	public  void setid(int id) {
		this.id = id;
	}
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
}