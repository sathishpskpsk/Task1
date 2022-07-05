package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.xml.bind.JAXB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json implements AddressInterface {

	@Override
	public void jsonAdd(JSONObject jsonObject, int id) {
		File file = new File("Address.json");
		JSONParser jsonParser = new JSONParser();
		JSONArray array = new JSONArray();
		try {
			if (file.exists()) {
				Reader fileReader = new FileReader(file);
				Object object = jsonParser.parse(fileReader);
				array.addAll((Collection) object);
				for (int i = 0; i < array.size(); i++) {
					id = id + 1;
				}
				jsonObject.put("ID", id);
				array.add(jsonObject);
				String string = array.toJSONString();// JSONArray into string
				Writer writer = new FileWriter(file);
				writer.write(string);
				writer.close();
				System.out.println("*****************************************");
				System.out.println("  Json file Uploaded successfully !!!");
				System.out.println("*****************************************");

			} else {
				jsonObject.put("ID", id);
				FileWriter fw = new FileWriter(file);
				array.add(jsonObject);
				String str = array.toJSONString();
				fw.write(str);
				fw.close();
				System.out.println("*****************************************");
				System.out.println("  Json file created successfully !!!");
				System.out.println("*****************************************");
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public void xmlAdd(Object addressInfo, int id) {

		ArrayList<String> st = (ArrayList<String>) addressInfo;
		String xmlString = "";
		File file = new File("Address.xml");
		StringWriter sw = new StringWriter();
		try {
			if (file.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line.trim());
				}
				for (int i = 0; i < st.size(); i++) {
					Object object = (Object) st.get(i);
					JAXB.marshal(object, sw);
				}
				sw.append(sb);
				System.out.println(sw.toString());
				Writer writer = new FileWriter(file);
				String string = sw.toString();
				writer.write(string);
				writer.close();
				System.out.println("*****************************************");
				System.out.println("  XML file Uploaded successfully !!!");
				System.out.println("*****************************************");
			} else {
				FileWriter fw = new FileWriter(file);
				for (int i = 0; i < st.size(); i++) {
					Object object = (Object) st.get(i);

					System.out.println(object.toString());
					JAXB.marshal(object, sw);
				}
				xmlString = sw.toString();
				fw.write(xmlString);
				fw.close();
				System.out.println("*****************************************");
				System.out.println("  XML file created successfully !!!");
				System.out.println("*****************************************");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void csvAdd(ArrayList array, int id) {

		try {
			File file = new File("Address.csv");
			if (file.exists()) {
				Scanner scanner = new Scanner(file);
				scanner.useDelimiter(",");
				ArrayList arrayList = new ArrayList<>();
				ArrayList numbers=new  ArrayList<>();
				
				while (scanner.hasNext()) {
					arrayList.add(scanner.next());
				}
				
				System.out.println(arrayList);
				FileWriter fw = new FileWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(fw);
				for (int i = 0; i < arrayList.size(); i++) {
					bufferedWriter.write(arrayList.get(i) + ",");
				}
				bufferedWriter.newLine();
				for (int i = 0; i < array.size(); i++) {
					bufferedWriter.write(array.get(i)+ ",");
				}
			// arrayList.add(array);
				// System.out.println("ARRAY " + arrayList);
				// for (int i = 0; i < arrayList.size(); i++) {
				// bufferedWriter.write(arrayList.get(i++) + "," + arrayList.get(i++) + "," +
				// arrayList.get(i++) + ","
				// + arrayList.get(i++));
				//
				// bufferedWriter.write(arrayList.get(i++) + "," + arrayList.get(i++) + "," +
				// arrayList.get(i++) + ","
				// + arrayList.get(i++));
				// bufferedWriter.newLine();
				// bufferedWriter.write(arrayList.get(i++) + "," + arrayList.get(i++) + "," +
				// arrayList.get(i++) + ","
				// + arrayList.get(i));
				// bufferedWriter.newLine();
				//
				// }
				bufferedWriter.close();
				System.out.println("*****************************************");
				System.out.println("  CSV file Uploaded successfully !!!");
				System.out.println("*****************************************");
			} else {
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				ArrayList arrayHead = new ArrayList<>();
				arrayHead.add("Name");
				arrayHead.add("DoorNo");
				arrayHead.add("City");
				arrayHead.add("State");
				for (int i = 0; i < arrayHead.size(); i++) {
					bufferedWriter.write(arrayHead.get(i) + ",");
				}
				bufferedWriter.newLine();
				for (int i = 0; i < array.size(); i++) {
					bufferedWriter.write(array.get(i) + ",");
				}
				// for (int i = 0; i < array.size(); i++) {
				// bufferedWriter
				// .write(array.get(i++) + "," + array.get(i++) + "," + array.get(i++) + "," +
				// array.get(i++));
				//
				// }
				bufferedWriter.close();
				fileWriter.close();
				System.out.println("*****************************************");
				System.out.println("  CSV file created successfully !!!");
				System.out.println("*****************************************");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
