package websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.*;

import libs.Lib_utils;
import variables.Tag;

public class Ws_config extends ServerEndpointConfig.Configurator{
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response){
		HttpSession session 	= (HttpSession) request.getHttpSession();
		String username 		= (String) session.getAttribute(Tag.username);
		
		sec.getUserProperties().put(Tag.username, username);
		sec.getUserProperties().put(Tag.path, Lib_utils.getPath(Tag.db_file));
	}
}
