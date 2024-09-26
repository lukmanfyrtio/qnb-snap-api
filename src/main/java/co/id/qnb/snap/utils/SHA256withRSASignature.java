package co.id.qnb.snap.utils;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class SHA256withRSASignature {

	public static void main(String[] args) throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048); // Key size

		// Generate the key pair
//		KeyPair keyPair = keyPairGen.generateKeyPair();
//		PrivateKey privateKey = keyPair.getPrivate();
//		PublicKey publicKey = keyPair.getPublic();
		String privateKeyString = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDAZl3ZSQDsFr3x"
				+ "RHU9tQV9vPO2BPoY669WJbf/ZGmL9CHAIDd2789dPrwaOxRu7OAEuUVjzs4vx/Ey"
				+ "kX/B9gV7AGzTTKFCMx2Mek15U4H4nG40v9PhM46OWfxeSsNKxlh8r01TWLet9e+y"
				+ "/2vURQTBM8e1POMIyr0wzWmFLsDx6KF3vhBpgAEBiSOPlmp/nJ49nha3z5foUx5I"
				+ "Z+nwwSDGsMvB9v8Y9mgaLd/H2z0bXS6AaaDc91PKWPpTt5s8jKdcY4cUokBIMoLz"
				+ "eBqBSxchoYWBOvA6TxaPkRGhRJSgWWLnukQNedc1XFi+PUaJkqUXGiz08400BRzt"
				+ "ek/AjSTdAgMBAAECggEAHzAY03GVkC+pj5QQyzVuU/EOsnlBD0wZKoZHusMMpu6m"
				+ "j+3I/+MkwpE6Tag5Cjgkoi9kM6cg3jbzfsZ+JrNaNROfEGtyEniVuCFVMK8cOPAm"
				+ "ny9fSbihSasFkUVePd9EFcYW60VM1QqyVdo4oPqlKCpcG6FojhLLMz+A9OFcznmm"
				+ "jfZxiy6wCOklV9pn2tsAnJ7358CuL9ruHIhbScOXothuCAIkaxYznncHm0GWyUQ4"
				+ "qarH/pn31BcNTEnZ2yl+l0NPQj8n/gxAV2ZczKkT8XY6wBG9S3sOL3xRO5TYrk0w"
				+ "Yl6DM7pia2VgUtrsOgjbSnMmKOkQO8jmVr0lsNYzAwKBgQDwzrnEQ0BVYg63rpQt"
				+ "D/I1VEYURefOaMCBHe59IewnCxXJBbnAURLJFytPw8UeMLHQSRwH006+Ii0jXXfW"
				+ "ZXJSnoZlcY7nYJRChqnZ4p0yz29SjR0ZmWG5uGOFpIv4b8ryv9gcHGrDd5brQ5p+"
				+ "M+5gdbWdI+AuHU6N1gD34cXurwKBgQDMic9/6Git3JXNV2TUeSCb4wc+/yalncOa"
				+ "4Kb/bSfQKoZZm71TSEQK2y9uMC4e8brUCyVQnY7WjNXi9Esp3mhy9z4NFJndrVtG"
				+ "eEiBomfA6Kgmupuqt7cK9927BypeQWdY8s+lvKghAyQNplGYlhm8U9YeY2PzOEca"
				+ "3bNV6zDoMwKBgHS/5XTwHhrHZddMPu7yEj4k0600j0SVqO9wsZXdgn8TcsZ5jitd"
				+ "ozv3jboockNG3I7dQ0fP/RdVvois4lMB8EF6NjKssdogCwGOBH9szUY7J//gBsHI"
				+ "iYbfjPDYbDxRBxZWSNKoPGL0cikyJ48UYnhF2X2MTT5OWy2NGf8UaUBlAoGBALNg"
				+ "jLSNGviXAl1SLqBUFjAAO4OY+si2AiyapnpNvWPHV4nQlooqT1oB/aex41DKCGIb"
				+ "4D7B3tn0K0PdoOl4HrvsbuPD1GjftrOnm1btGfbJU2absxdWBNY+qJt0XkjJLRyJ"
				+ "3Wdpez1wZrb9zIN359wM3jRKUAamrV03XyaTm5GXAoGBAIZQAVGKlQF12RZmVABa"
				+ "7CzGXetgAhiBMO9EBYxI+eD29xxdlC9c7UDCjyEt3XdS/iNwE6tVRsx2yp529iHV"
				+ "QcNoPiN9K4WMTW72lPO2PLDBvjnXDgh3aKtcaCOv7W2U6ok8so0FjZvY2WTqp7D/" + "0X1IIlvPgnkpV8B8RKbBtGT8";
		privateKeyString = Base64.getEncoder().encodeToString(loadPrivateKeyFromString(privateKeyString).getEncoded());
//		String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
//		String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//		String publicKeyString="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwGZd2UkA7Ba98UR1PbUF"
//				+ "fbzztgT6GOuvViW3/2Rpi/QhwCA3du/PXT68GjsUbuzgBLlFY87OL8fxMpF/wfYF"
//				+ "ewBs00yhQjMdjHpNeVOB+JxuNL/T4TOOjln8XkrDSsZYfK9NU1i3rfXvsv9r1EUE"
//				+ "wTPHtTzjCMq9MM1phS7A8eihd74QaYABAYkjj5Zqf5yePZ4Wt8+X6FMeSGfp8MEg"
//				+ "xrDLwfb/GPZoGi3fx9s9G10ugGmg3PdTylj6U7ebPIynXGOHFKJASDKC83gagUsX"
//				+ "IaGFgTrwOk8Wj5ERoUSUoFli57pEDXnXNVxYvj1GiZKlFxos9PONNAUc7XpPwI0k"
//				+ "3QIDAQAB";
//		publicKeyString=Base64.getEncoder().encodeToString(loadPrivateKeyFromString(publicKeyString).getEncoded());
		System.out.println("Generated Private Key: " + privateKeyString);

		String clientId = "gljUAiK413a6UXY3fY1klKTAfi7J365u"; // Replace with actual client ID

		// Get the current timestamp
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		String now = ZonedDateTime.now().format(formatter);

		// Generate the string to sign
		String stringToSign = generateStringToSign(clientId, now);
		System.out.println("String to sign : " + stringToSign);
		// Generate the signature
		String xSignature = generateSignature(stringToSign, privateKeyString);
		System.out.println(xSignature);
		// Verify the signature
//		System.out.println(verifySignature(xSignature, stringToSign, publicKeyString));
	}

	public static PrivateKey loadPrivateKeyFromString(String keyString) throws Exception {
		// Remove the first and last lines (BEGIN/END PRIVATE KEY)
		keyString = keyString.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "")
				.replaceAll("\\s+", ""); // Remove any extra whitespace

		// Decode the Base64 encoded string
		byte[] keyBytes = Base64.getDecoder().decode(keyString);

		// Generate a private key from the byte array
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // Change "RSA" to your key algorithm
		return keyFactory.generatePrivate(keySpec);
	}

	public static String generateSignature(String stringToSign, String privateKeyStr) {
		try {
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
