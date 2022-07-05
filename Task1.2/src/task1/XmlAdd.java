package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.xml.bind.JAXB;
import org.json.simple.JSONObject;

public class XmlAdd implements AddressInterface {

	public void add(JSONObject jsonObject, int id, Object addressInfo, ArrayList array) {
		ArrayList<String> st = (ArrayList<String>) addressInfo;
		String xmlString = "";
		File file = new File("Address.xml");
		StringWriter sw = new StringWriter();
		try {
			
			FileWriter fw = new FileWriter(file);
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
				String string = sw.toString();
				fw.write(string);
				
				System.out.println("*****************************************");
				System.out.println("  XML file Uploaded successfully !!!");
				System.out.println("*****************************************");
			} else {
				
				for (int i = 0; i < st.size(); i++) {
					Object object = (Object) st.get(i);
					JAXB.marshal(object, sw);
				}
				xmlString = sw.toString();
				fw.write(xmlString);
				
				System.out.println("*****************************************");
				System.out.println("  XML file created successfully !!!");
				System.out.println("*****************************************");
			}
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
