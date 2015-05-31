package btbw.dto;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageDtoEncoder implements Encoder.Text<MessageDto> {

	@Override
	public String encode(MessageDto message) throws EncodeException {

		JsonObject jsonObject = Json.createObjectBuilder()
				.add("subject", message.getSubject())
				.add("content", message.getContent()).build();
		return jsonObject.toString();

	}

	@Override
	public void init(EndpointConfig ec) {
		System.out.println("MessageDtoEncoder - init method called");
	}

	@Override
	public void destroy() {
		System.out.println("MessageDtoEncoder - destroy method called");
	}

}
