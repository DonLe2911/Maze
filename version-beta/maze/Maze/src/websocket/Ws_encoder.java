package websocket;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class Ws_encoder implements Encoder.Text<Ws_object>{
	@Override
	public void destroy() {}

	@Override
	public void init(EndpointConfig arg0) {}

	@Override
	public String encode(Ws_object object){
		return object.get_json().build().toString();
	}
}
