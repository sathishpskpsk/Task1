package task1;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public interface AddressInterface {
	public void jsonAdd(JSONObject jsonObject, int id);
	public void xmlAdd(Object addressInfo, int id);
	public void csvAdd(ArrayList array, int id);
}
