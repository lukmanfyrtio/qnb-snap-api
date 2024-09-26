package co.id.qnb.snap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.id.qnb.snap.dto.balance.inquiry.BalanceInquiryRequest;
import co.id.qnb.snap.dto.balance.inquiry.BalanceInquiryResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/balance-inquiry")
@Tag(name = "Informasi Saldo", description = "API Balance Inquiry (Informasi Saldo) diperlukan agar Konsumen, Non-PJP Pengguna Layanan, PJP AIS, maupun PJP PIAS dapat mengakses informasi saldo terkini dari rekening yang dimiliki secara real time, sesuai dengan layanan yang disediakan oleh PJP AIS.")
public class BalanceInquiryController {

	@PostMapping
	public ResponseEntity<BalanceInquiryResponse> inquireBalance(@RequestBody BalanceInquiryRequest request) {
		// Simulating the balance inquiry response
		BalanceInquiryResponse response = new BalanceInquiryResponse();
		response.setResponseCode("2001100");
		response.setResponseMessage("Request has been processed successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
