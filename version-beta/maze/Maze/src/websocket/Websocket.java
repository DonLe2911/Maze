package websocket;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import models.Model_storeRecord;
import variables.Tag;
import variables.Ws;

@ServerEndpoint(value="/Websocket", configurator=Ws_config.class, encoders={Ws_encoder.class}, decoders={Ws_decoder.class})
public class Websocket{
	@OnOpen
	public void handleOpen(EndpointConfig config, Session session){
		System.out.println("connected");
	}
	@OnMessage
	public void handleMessage(Ws_object object, Session session) throws IOException, EncodeException{
		System.out.println("message received");
		try {
			int id = Integer.parseInt(object.get(Tag.code).toString());
			switch(id) {
			case Ws.time_send_code:
				Model_storeRecord record = new Model_storeRecord(object, session);
				record.run();
				break;
			}
		} catch(Exception e) {
			object.set(Tag.code, Tag.failure);
			session.getBasicRemote().sendObject(object);
		}
	} 
	@OnError
	public void handleError(Session session, Throwable t) throws Exception{
		t.printStackTrace();
		Ws_object object = new Ws_object();
		object.set(Tag.code, Tag.failure);
		session.getBasicRemote().sendObject(object);
	}
	@OnClose
	public void handleClose(Session session){
		System.out.println("SOCKET CLOSED!");
	}
}