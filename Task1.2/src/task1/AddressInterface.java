package task1;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public interface AddressInterface {
	
	public int add(JSONObject jsonObject, int id,Object addressInfo,ArrayList array);
	public JSONObject read(int sId);
}
