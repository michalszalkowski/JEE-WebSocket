package btbw.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/message")
public class StringWebSocket {

	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException {

		System.out.println("Received: " + message);

		session.getBasicRemote().sendText("Michał Btbw");

		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			session.getBasicRemote().sendText("Michał Btbw " + i);
		}

		session.getBasicRemote().sendText("End");
	}

	@OnOpen
	public void onOpen() {
		System.out.println("Client connected");
	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}
}