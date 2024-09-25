package co.id.qnb.snap.controller;


import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/api/v1.0/balance-inquiry")
@Tag(name = "Balance Inquiry", description = "API Balance Inquiry (Informasi Saldo) diperlukan agar Konsumen, Non-PJP Pengguna Layanan, PJP AIS, maupun PJP PIAS dapat mengakses informasi saldo terkini dari rekening yang dimiliki secara real time, sesuai dengan layanan yang disediakan oleh PJP AIS.")
public class BalanceInquiryController {

    @PostMapping
    public ResponseEntity<BalanceInquiryResponse> inquireBalance(@RequestBody BalanceInquiryRequest request) {
        // Simulating the balance inquiry response
        BalanceInquiryResponse response = new BalanceInquiryResponse();
        response.setResponseCode("2001100");
        response.setResponseMessage("Request has been processed successfully");
        response.setAccountNo(request.getAccountNo());
        // Mock account information - in a real implementation, this would come from the service/database
        response.setAccountInfo(generateMockAccountInfo());
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    // This would be replaced by actual service logic
    private List<BalanceInquiryResponse.AccountInfo> generateMockAccountInfo() {
        List<BalanceInquiryResponse.AccountInfo> accountInfoList = new ArrayList<>();
        
        BalanceInquiryResponse.AccountInfo cashInfo = new BalanceInquiryResponse.AccountInfo();
        cashInfo.setBalanceType("Cash");
        cashInfo.setAmount(new BalanceInquiryResponse.Amount("200000.00", "IDR"));
        cashInfo.setAvailableBalance(new BalanceInquiryResponse.Amount("130000.00", "IDR"));
        accountInfoList.add(cashInfo);

        BalanceInquiryResponse.AccountInfo coinsInfo = new BalanceInquiryResponse.AccountInfo();
        coinsInfo.setBalanceType("Coins");
        coinsInfo.setAmount(new BalanceInquiryResponse.Amount("50000.00", "IDR"));
        coinsInfo.setAvailableBalance(new BalanceInquiryResponse.Amount("30000.00", "IDR"));
        accountInfoList.add(coinsInfo);
        
        return accountInfoList;
    }
}


