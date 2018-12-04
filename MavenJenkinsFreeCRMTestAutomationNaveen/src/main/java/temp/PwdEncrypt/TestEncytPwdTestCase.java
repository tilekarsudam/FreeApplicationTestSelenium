package temp.PwdEncrypt;

import java.util.Base64;

import org.openqa.selenium.WebDriver;

public class TestEncytPwdTestCase {
	public static void main(String args[]) {

		String New = "Luthan Franchies";
		String EncryptedPass = "THV0aGFuIEZyYW5jaGll";
		
		
		
		
		
		
		 
		
		
		
		
		
		
		
		
		
		
		

		PwdEncryptionMethod pp = new PwdEncryptionMethod();
		pp.EncodeBase64Java(New);
		System.out.println("Driver Return value is: ");

//		byte[] endPwd = Base64.getEncoder().encode(Password.getBytes());
//		System.out.println("Encoded :" + Password + " is :" + new String(endPwd));
//
//		byte[] decodePwd = Base64.getDecoder().decode(EncryptedPass.getBytes());
//		System.out.println("Decoded :" + EncryptedPass + " is : " + new String(decodePwd));
	}

}
