package co.id.qnb.snap.dto.balance.inquiry;

import java.util.List;

import lombok.Data;

@Data
public class BalanceInquiryRequest {
    private String partnerReferenceNo;
    private String bankCardToken;
    private String accountNo;
    private List<String> balanceTypes;
    private AdditionalInfo additionalInfo;

    @Data
    public static class AdditionalInfo {
        private String deviceId;
        private String channel;
    }
}
