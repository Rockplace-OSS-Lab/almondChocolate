package almond.util;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public final class JsonHelper {

	public static String convertMapToJson(Map<String, Object> map) {
		Gson gsonObj = new Gson();
		
		return gsonObj.toJson(map);
	}
	
	public static Map<String, Object> convertJsonToMap(String json) {
		Gson gsonObj = new Gson();
		Type type = new TypeToken<Map<String, Object>>(){}.getType();
		
		return gsonObj.fromJson(json, type);
	}
}
