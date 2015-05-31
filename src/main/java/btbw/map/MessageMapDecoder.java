package btbw.map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.json.Json;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MessageMapDecoder implements Decoder.Text<Map> {

	@Override
	public Map decode(String json) throws DecodeException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<HashMap<String, String>>() {});
		} catch (Exception e) {
			System.out.print("Problem with Decoder: " + e.getMessage());
			return new HashMap();
		}
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
	public void init(EndpointConfig config) {
		System.out.println("MessageMapDecoder -init method called");
	}

	@Override
	public void destroy() {
		System.out.println("MessageMapDecoder - destroy method called");
	}
}
