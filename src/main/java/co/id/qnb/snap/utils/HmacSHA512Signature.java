package co.id.qnb.snap.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA512Signature {

	public static String generateSignature(String clientSecret, String httpMethod, String endpointUrl,
			String accessToken, String requestBody, String timeStamp) throws Exception {

		// Step 1: Minify the RequestBody (optional: here it simply trims white spaces)
		String minifiedRequestBody = minifyRequestBody(requestBody);

		// Step 2: Hash the minified RequestBody using SHA-256 and convert to lowercase
		// hex
		String hashedRequestBody = sha256Hex(minifiedRequestBody).toLowerCase();

		// Step 3: Create stringToSign
		String stringToSign = httpMethod + ":" + endpointUrl + ":" + accessToken + ":" + hashedRequestBody + ":"
				+ timeStamp;

		// Step 4: Generate HMAC-SHA512 signature
		return hmacSha512(clientSecret, stringToSign);
	}

	// Function to minify the request body (in this case, trim extra spaces)
	private static String minifyRequestBody(String requestBody) {
		return requestBody.trim(); // Customize as needed
	}

	// Function to hash using SHA-256
	private static String sha256Hex(String data) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(hash);
	}

	// Function to generate HMAC-SHA512 signature
	private static String hmacSha512(String secret, String data) throws Exception {
		Mac sha512Hmac = Mac.getInstance("HmacSHA512");
		SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
		sha512Hmac.init(secretKeySpec);
		byte[] signedBytes = sha512Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(signedBytes);
	}

	// Helper function to convert bytes to hex string
	private static String bytesToHex(byte[] bytes) {
		try (Formatter formatter = new Formatter()) {
			for (byte b : bytes) {
				formatter.format("%02x", b);
			}
			return formatter.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		// Example values
		String clientSecret = "yourClientSecret";
		String httpMethod = "POST";
		String endpointUrl = "https://api.example.com/resource";
		String accessToken = "yourAccessToken";
		String requestBody = "{\"key\":\"value\"}";
		String timeStamp = "2024-09-25T10:24:30+07:00";

		// Generate signature
		String signature = generateSignature(clientSecret, httpMethod, endpointUrl, accessToken, requestBody,
				timeStamp);
		System.out.println("Generated Signature: " + signature);
	}

	public static boolean verifySignature(String receivedSignature, String clientSecret, String httpMethod,
			String endpointUrl, String accessToken, String requestBody, String timeStamp) throws Exception {
// Step 1: Recompute the signature using the same process
		String computedSignature = HmacSHA512Signature.generateSignature(clientSecret, httpMethod, endpointUrl,
				accessToken, requestBody, timeStamp);

// Step 2: Compare the received signature with the computed signature
		return receivedSignature.equals(computedSignature);
	}
}
