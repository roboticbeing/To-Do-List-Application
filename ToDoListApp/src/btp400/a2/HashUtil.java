package btp400.a2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
 
public class HashUtil {
 
    // This hashes a string using SHA-512.
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        byte[] array = md.digest();
        StringBuilder sb = new StringBuilder(array.length * 2);
        for (byte a : array) {
            sb.append(Integer.toString((a & 0xff) + 0x100).substring(1));
        }
        return sb.toString();
    }
     
    // Creates a 32-byte random salt String.
    public static String getSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
     
    // Hashes a known salt with a known password.
    public static String getPasswordHash(String password, String salt) throws NoSuchAlgorithmException {
        return hashPassword(salt + password);
    }
}