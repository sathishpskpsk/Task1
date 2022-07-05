package task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class CsvAdd implements AddressInterface {
	public void add(JSONObject jsonObject, int id, Object addressInfo, ArrayList array) {
		
		try {
			File file = new File("Address.csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fw);
			
			if (file.exists()) {
				Scanner scanner = new Scanner(file);
				scanner.useDelimiter(",");
				ArrayList arrayList = new ArrayList<>();
				while (scanner.hasNext()) {
					arrayList.add(scanner.next());
				}
				
				for (int i = 0; i < arrayList.size(); i++) {
					bufferedWriter.write(arrayList.get(i) + ",");
				}
				bufferedWriter.newLine();
				for (int i = 0; i < array.size(); i++) {
					bufferedWriter.write(array.get(i)+ ",");
				}
				System.out.println("*****************************************");
				System.out.println("  CSV file Uploaded successfully !!!");
				System.out.println("*****************************************");
			} else {
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
				
				System.out.println("*****************************************");
				System.out.println("  CSV file created successfully !!!");
				System.out.println("*****************************************");
			}
			bufferedWriter.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JSONObject read(int sId) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
