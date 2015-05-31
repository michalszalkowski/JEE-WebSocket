package btbw.socket;

import btbw.dto.Message;
import btbw.dto.MessageDecoder;
import btbw.dto.MessageEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(
		value = "/websocket/json",
		encoders = {MessageEncoder.class},
		decoders = {MessageDecoder.class}
)
public class JsonWebSocket {

	@OnMessage
	public void onMessage(Message message, Session session) throws IOException, InterruptedException, EncodeException {

		System.out.println("Received. Subject: " + message.getSubject() + " Received: " + message.getContent());

		session.getBasicRemote().sendObject(new Message("Michał", "Btbw"));

		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			session.getBasicRemote().sendObject(new Message("Michał", "Btbw " + i));
		}
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