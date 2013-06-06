package cinema.util;

import java.security.MessageDigest;

public class MD5Digest {

	public static String digestPassword(String pass) {

		StringBuffer sb = null;
		try{
			
			String original = pass;
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(Integer.toHexString((int) (b & 0xff)));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}