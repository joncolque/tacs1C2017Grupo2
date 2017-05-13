package util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PassEncoder {
	
	private static PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public static String encriptarPassword(String unaPass) {
		return encoder.encode(unaPass);
	}
}
