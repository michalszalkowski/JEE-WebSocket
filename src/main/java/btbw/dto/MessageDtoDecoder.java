package btbw.dto;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;

public class MessageDtoDecoder implements Decoder.Text<MessageDto> {

	@Override
	public MessageDto decode(String jsonMessage) throws DecodeException {

		JsonObject jsonObject = Json
				.createReader(new StringReader(jsonMessage)).readObject();
		MessageDto message = new MessageDto();
		message.setSubject(jsonObject.getString("subject"));
		message.setContent(jsonObject.getString("content"));
		return message;

	}

	@Override
	public boolean willDecode(String jsonMessage) {
		try {
			Json.createReader(new StringReader(jsonMessage)).readObject();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void init(EndpointConfig ec) {
		System.out.println("MessageDtoDecoder -init method called");
	}

	@Override
	public void destroy() {
		System.out.println("MessageDtoDecoder - destroy method called");
	}

}
