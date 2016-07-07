package Tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_pack {
	
	public static String MD5_security(String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7',    
		        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		byte[] plain_text = plaintext.getBytes();
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		 mdInst.update(plain_text);
         byte[] md = mdInst.digest();
         //十六进制转换
         int j = md.length;
         char str[] = new char[j * 2];
         int k = 0;
         for (int i = 0; i < j; i++) {
             byte byte0 = md[i];
             str[k++] = hexChar[byte0 >>> 4 & 0xf];
             str[k++] = hexChar[byte0 & 0xf];
         }
         return new String(str);
	}
}
