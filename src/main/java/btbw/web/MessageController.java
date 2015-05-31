package btbw.web;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Stateless
@Path("/")
public class MessageController {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> test() {

		return new HashMap<String, String>() {{
			put("message", "ok");
		}};
	}
}
