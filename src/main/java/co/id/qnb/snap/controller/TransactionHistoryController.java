package co.id.qnb.snap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.id.qnb.snap.dto.transaction.history.BankStatementRequest;
import co.id.qnb.snap.dto.transaction.history.BankStatementResponse;
import co.id.qnb.snap.dto.transaction.history.TransactionHistoryDetailRequest;
import co.id.qnb.snap.dto.transaction.history.TransactionHistoryDetailResponse;
import co.id.qnb.snap.dto.transaction.history.TransactionHistoryListRequest;
import co.id.qnb.snap.dto.transaction.history.TransactionHistoryListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Riwayat Transaksi", description = "API Transaction History (Riwayat Transaksi) diperlukan agar Konsumen, Non-PJP Pengguna Layanan, atau PJP PIAS dapat mengakses informasi riwayat transaksi dari rekening yang dimiliki secara real time, sesuai dengan layanan yang disediakan oleh PJP AIS. Informasi riwayat transaksi berisi rincian mengenai transaksi kredit maupun debit, saldo rekening, dan beberapa informasi lainnya.")
public class TransactionHistoryController {

	@PostMapping(value = "/transaction-history-list")
	public ResponseEntity<TransactionHistoryListResponse> transactionHistoryList(
			@RequestBody TransactionHistoryListRequest request) {
		TransactionHistoryListResponse response = new TransactionHistoryListResponse();
		response.setResponseCode("2001100");
		response.setResponseMessage("Request has been processed successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/transaction-history-detail")
	public ResponseEntity<TransactionHistoryDetailResponse> transactionHistoryDetail(
			@RequestBody TransactionHistoryDetailRequest request) {
		TransactionHistoryDetailResponse response = new TransactionHistoryDetailResponse();
		response.setResponseCode("2001100");
		response.setResponseMessage("Request has been processed successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/bank-statement")
	public ResponseEntity<BankStatementResponse> bankStatement(@RequestBody BankStatementRequest request) {
		BankStatementResponse response = new BankStatementResponse();
		response.setResponseCode("2001100");
		response.setResponseMessage("Request has been processed successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
