package websocket;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Ws_object{
	private JsonObject object;
	private JsonObjectBuilder object2;
	public Ws_object(){
		this.object2	= Json.createObjectBuilder();
	}
	public Ws_object(JsonObject object){
		this.object 	= object;
		this.object2	= Json.createObjectBuilder();
	}
	public Object get(String tag){
		return object.get(tag);
	}
	public JsonObjectBuilder get_json(){
		return object2;
	}
	
	public void set(String tag, int value){
		object2.add(tag, value);
	}
	public void set(String tag, boolean value){
		object2.add(tag, value);
	}
	public void set(String tag, String value){
		object2.add(tag, value);
	}
	public void set(String tag, JsonArray value){
		object2.add(tag, value);
	}
	public void set(String tag, double value) {
		object2.add(tag, value);
	}
}
