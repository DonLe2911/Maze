package websocket;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class Ws_decoder implements Decoder.Text<Ws_object>{
	@Override
	public void destroy(){}

	@Override
	public void init(EndpointConfig arg0){}

	@Override
	public Ws_object decode(String content) throws DecodeException{     
		JsonObject object = Json.createReader(new StringReader(content)).readObject();
		return new Ws_object(object);	
	}
	
	public boolean willDecode(String object_string){
		boolean flag = true;
		try{Json.createReader(new StringReader(object_string)).readObject();}
		catch(Exception e){flag = false;}
		return flag;
	}
}
