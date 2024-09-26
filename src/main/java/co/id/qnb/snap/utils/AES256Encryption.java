package co.id.qnb.snap.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Encryption {

	// AES Encryption Method
	public static String encrypt(String data, String clientSecret) throws Exception {
		// Step 1: Generate 256-bit AES key from the clientSecret
		SecretKeySpec secretKey = generateKey(clientSecret);

		// Step 2: Generate a random IV (Initialization Vector)
		byte[] iv = new byte[16];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

		// Step 3: Initialize Cipher for AES encryption in CBC mode with PKCS5 padding
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

		// Step 4: Encrypt the data
		byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

		// Step 5: Combine IV and encrypted data into one array
		byte[] encryptedDataWithIv = new byte[iv.length + encryptedBytes.length];
		System.arraycopy(iv, 0, encryptedDataWithIv, 0, iv.length);
		System.arraycopy(encryptedBytes, 0, encryptedDataWithIv, iv.length, encryptedBytes.length);

		// Step 6: Return the Base64-encoded encrypted string
		return Base64.getEncoder().encodeToString(encryptedDataWithIv);
	}

	// AES Decryption Method
	public static String decrypt(String encryptedData, String clientSecret) throws Exception {
		// Step 1: Decode Base64-encoded encrypted data
		byte[] encryptedDataWithIv = Base64.getDecoder().decode(encryptedData);

		// Step 2: Extract the IV from the encrypted data
		byte[] iv = new byte[16];
		byte[] encryptedBytes = new byte[encryptedDataWithIv.length - 16];
		System.arraycopy(encryptedDataWithIv, 0, iv, 0, iv.length);
		System.arraycopy(encryptedDataWithIv, iv.length, encryptedBytes, 0, encryptedBytes.length);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

		// Step 3: Generate the AES key from the clientSecret
		SecretKeySpec secretKey = generateKey(clientSecret);

		// Step 4: Initialize Cipher for AES decryption in CBC mode with PKCS5 padding
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

		// Step 5: Decrypt the data
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

		// Step 6: Return the decrypted string
		return new String(decryptedBytes, StandardCharsets.UTF_8);
	}

	// Generate a 256-bit AES key from the clientSecret using SHA-256
	private static SecretKeySpec generateKey(String clientSecret) throws Exception {
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		byte[] key = sha.digest(clientSecret.getBytes(StandardCharsets.UTF_8));
		return new SecretKeySpec(key, "AES");
	}

	public static void main(String[] args) throws Exception {
		// Example usage
		String clientSecret = "yourClientSecret";
		String data = "Sensitive data to encrypt";

		// Encrypt the data
		String encryptedData = encrypt(data, clientSecret);
		System.out.println("Encrypted Data: " + encryptedData);

		// Decrypt the data
		String decryptedData = decrypt(encryptedData, clientSecret);
		System.out.println("Decrypted Data: " + decryptedData);
	}
}
