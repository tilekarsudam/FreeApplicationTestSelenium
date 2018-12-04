package temp.PwdEncrypt;

//URL: https://www.youtube.com/watch?v=OPuFZHC0dJg 
// Encoded Value for  'Luthan Franchies' = 'THV0aGFuIEZyYW5jaGllcw=='
// base64 URL for Encode/Decode: https://www.base64decode.org/ 

import java.util.Base64;

import org.openqa.selenium.WebDriver;

public class PwdEncryptionMethod {

	WebDriver driver;

	public PwdEncryptionMethod(WebDriver driver) {
		this.driver = driver;
	}

	public PwdEncryptionMethod() {
		// TODO Auto-generated constructor stub
	}

	// using Base64 from Util.Java i.e. inBuild Java
	public String EncodeBase64Java(String Password) {
		byte[] endPwd = Base64.getEncoder().encode(Password.getBytes());
		System.out.println("Endoced : " + Password + " is : now " + new String(endPwd));
		return new String(endPwd);
	}

	public String DecodeBase64Java(String EncryptedPass) {
		byte[] decodePwd = Base64.getDecoder().decode(EncryptedPass);
		System.out.println("Decoded : " + EncryptedPass + " is : " + new String(decodePwd));
		return new String(decodePwd);

	}

}
