package btbw.socket;

import btbw.map.MessageMapDecoder;
import btbw.map.MessageMapEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(
		value = "/websocket/json/map",
		encoders = {MessageMapEncoder.class},
		decoders = {MessageMapDecoder.class}
)
public class JsonMapWebSocket {

	@OnMessage
	public void onMessage(Map message, Session session) throws IOException, InterruptedException, EncodeException {

		session.getBasicRemote().sendObject(getRow("Map: Michał", "Btbw"));

		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			session.getBasicRemote().sendObject(getRow("Map: Michał", "Btbw " + i));
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

	private Map<String, String> getRow(String key, String value) {
		HashMap<String, String> map = new HashMap<>();
		map.put(key, value);
		return map;
	}
}