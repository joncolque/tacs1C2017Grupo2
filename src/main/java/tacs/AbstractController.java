package tacs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractController extends Connection {

	protected final String BASE_URL = "https://api.themoviedb.org/3/";
	protected final String API_KEY = "api_key=3eb489d424860bc6870dc6776d05f6b9";
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected RestTemplate api = new RestTemplate();
	
}
