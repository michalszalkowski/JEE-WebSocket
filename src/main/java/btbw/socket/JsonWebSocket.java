package btbw.socket;

import btbw.dto.MessageDto;
import btbw.dto.MessageDtoDecoder;
import btbw.dto.MessageDtoEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(
		value = "/websocket/json",
		encoders = {MessageDtoEncoder.class},
		decoders = {MessageDtoDecoder.class}
)
public class JsonWebSocket {

	@OnMessage
	public void onMessage(MessageDto message, Session session) throws IOException, InterruptedException, EncodeException {

		System.out.println("Received. Subject: " + message.getSubject() + " Received: " + message.getContent());

		session.getBasicRemote().sendObject(new MessageDto("Dto: Michał", "Btbw"));

		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			session.getBasicRemote().sendObject(new MessageDto("Dto: Michał", "Btbw " + i));
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