package co.id.qnb.snap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.id.qnb.snap.dto.account.inquiry.ExternalAccountInquiryRequest;
import co.id.qnb.snap.dto.account.inquiry.ExternalAccountInquiryResponse;
import co.id.qnb.snap.dto.account.inquiry.InternalAccountInquiryRequest;
import co.id.qnb.snap.dto.account.inquiry.InternalAccountInquiryResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "API Account Inquiry", description = "API Account Inquiry ini digunakan untuk pemindah bukuan dana yang bersumber dari PJP PIAS melalui layanan transfer kredit di Bank PJP AIS menggunakan API transfer intrabank/interbank")
public class AccountInquiryController {

	
	@PostMapping(value = "/account-inquiry-internal")
	public ResponseEntity<InternalAccountInquiryResponse> accountInquiryInternal(
			@RequestBody InternalAccountInquiryRequest request) {
		InternalAccountInquiryResponse response = new InternalAccountInquiryResponse();
		response.setResponseCode("2001100");
		response.setResponseMessage("Request has been processed successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/account-inquiry-external")
	public ResponseEntity<ExternalAccountInquiryResponse> accountInquiryExternal(
			@RequestBody ExternalAccountInquiryRequest request) {
		ExternalAccountInquiryResponse response = new ExternalAccountInquiryResponse();
		response.setResponseCode("2001100");
		response.setResponseMessage("Request has been processed successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
