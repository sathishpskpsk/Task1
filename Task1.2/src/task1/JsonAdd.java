package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonAdd implements AddressInterface {
	public int add(JSONObject jsonObject, int id, Object addressInfo, ArrayList array) {
		File file = new File("Address.json");
		JSONParser jsonParser = new JSONParser();
		JSONArray jarray = new JSONArray();
		try {
			if (file.exists()) {
				Reader fileReader = new FileReader(file);
				Object object = jsonParser.parse(fileReader);
				jarray.addAll((Collection) object);
				for (int i = 0; i < jarray.size(); i++) {
					id = id + 1;
				}
				jsonObject.put("ID", id);
				jarray.add(jsonObject);
				String string = jarray.toJSONString();// JSONArray into string
				Writer writer = new FileWriter(file);
				writer.write(string);
				writer.close();
				System.out.println("*****************************************");
				System.out.println("  Json file Uploaded successfully !!!");
				System.out.println("*****************************************");
				return id;
			} else {
				jsonObject.put("ID", id);
				FileWriter fw = new FileWriter(file);
				jarray.add(jsonObject);
				String str = jarray.toJSONString();
				fw.write(str);
				fw.close();
				System.out.println("*****************************************");
				System.out.println("  Json file created successfully !!!");
				System.out.println("*****************************************");
				return id;
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return 0;
	};

	public JSONObject read(int sId) {
		File file = new File("Address.json");
		try {
			Reader fileReader = new FileReader(file);
			JSONParser jsonParser = new JSONParser();
			Object object = jsonParser.parse(fileReader);
			ArrayList jarray = new ArrayList<>();
			jarray.addAll((Collection) object);

			

			for (int i = 0; i < jarray.size(); i++) {
				JSONObject one = (JSONObject) jarray.get(i);
				Long long1 = (Long) one.get("ID");
				if (long1 == sId) {
					return one;
				} 	
			}
			// jarray.forEach( emp -> parseEmployeeObject( (JSONObject) emp , sId) );
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	
	
	// private void parseEmployeeObject(JSONObject emp, int sId) {
	// long empID = (long) emp.get("ID");
	// if(empID==sId) {
	// System.out.println("ID ==> "+emp.get("ID"));
	// System.out.println("Name ==> "+emp.get("name"));
	// System.out.println("DoorNo ==> "+emp.get("dNO"));
	// System.out.println("City ==> "+emp.get("city"));
	// System.out.println("State ==> "+emp.get("state"));
	// }
	// }
}
