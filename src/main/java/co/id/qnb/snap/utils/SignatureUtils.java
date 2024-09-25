package co.id.qnb.snap.utils;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignatureUtils {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048); // Key size

		// Generate the key pair
		KeyPair keyPair = keyPairGen.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
		
		String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
		System.out.println("Generated Private Key: " + privateKeyString);
		
	    String clientId = "YourClientID"; // Replace with actual client ID
	    String privateKeyStr = privateKeyString; // Replace with actual private key in Base64 format
	    String timestamp = "2022-07-29T15:36:54+07:00"; // e.g., "2022-07-29T15:36:54+07:00"

	    // Generate the string to sign
	    String stringToSign = generateStringToSign(clientId, timestamp);

	    // Generate the signature
	    String xSignature = generateSignature(stringToSign, privateKeyStr);
	    
	    System.out.println(verifySignature(xSignature, stringToSign, Base64.getEncoder().encodeToString(publicKey.getEncoded())));
	}

	public String generatePrivateKeyString() {
		try {
			// Create a KeyPairGenerator for RSA
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(2048); // Key size

			// Generate the key pair
			KeyPair keyPair = keyPairGen.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();

			// Convert the private key to a Base64 encoded string
			return Base64.getEncoder().encodeToString(privateKey.getEncoded());
		} catch (Exception e) {
			e.printStackTrace(); // Handle exceptions as necessary
			return null;
		}
	}
	
	public static String generateSignature(String stringToSign, String privateKeyStr) {
	    try {
	        // Convert the private key string to a PrivateKey object
	        byte[] decodedKey = Base64.getDecoder().decode(privateKeyStr);
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

	        // Create a Signature object and initialize it with the private key
	        Signature signature = Signature.getInstance("SHA256withRSA");
	        signature.initSign(privateKey);

	        // Update the signature object with the original data
	        signature.update(stringToSign.getBytes());

	        // Generate the signature
	        byte[] signatureBytes = signature.sign();
	        
	        

	        // Return the signature as a Base64 encoded string
	        return Base64.getEncoder().encodeToString(signatureBytes);
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle exceptions as necessary
	        return null;
	    }
	}

	public static String generateStringToSign(String clientId, String timestamp) {
	    return clientId + "|" + timestamp;
	}

	public static boolean verifySignature(String xSignature, String stringToSign, String publicKeyStr) {
	    try {
	        // Convert the public key string to a PublicKey object
	        byte[] decodedKey = Base64.getDecoder().decode(publicKeyStr);
	        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        PublicKey publicKey = keyFactory.generatePublic(keySpec);

	        // Create a Signature object and initialize it with the public key
	        Signature signature = Signature.getInstance("SHA256withRSA");
	        signature.initVerify(publicKey);

	        // Update the signature object with the original data
	        signature.update(stringToSign.getBytes());

	        // Verify the signature
	        byte[] signatureBytes = Base64.getDecoder().decode(xSignature);
	        return signature.verify(signatureBytes);
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle exceptions as necessary
	        return false;
	    }
	}

}
