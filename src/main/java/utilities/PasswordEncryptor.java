package utilities;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class PasswordEncryptor {

    private static final String ALGORITHM = "AES";
    private static final String SecretKey = "12345678ABCJ3458";

    // Make sure the key is 16 bytes (128-bit) long
    private static SecretKeySpec getKey(String secret) {
        return new SecretKeySpec(secret.getBytes(), ALGORITHM);
    }

    public static String encrypt(String plainText, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, getKey(secretKey));
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedText, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, getKey(secretKey));
        byte[] decoded = Base64.getDecoder().decode(encryptedText);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted);
    }

    public static void main(String[] args) throws Exception {

        String encryptedPassword = PasswordEncryptor.encrypt("Rahil@123",SecretKey);
        System.out.println(encryptedPassword); // Use this encrypted password in properties file

        String decryptedPassword = PasswordEncryptor.decrypt(encryptedPassword, SecretKey);
        System.out.println("!!Decrypted password is: "+decryptedPassword);
    }
}
