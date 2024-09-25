package co.id.qnb.snap.dto.balance.inquiry;

import java.util.List;

import lombok.Data;

@Data
public class BalanceInquiryResponse {
	private String responseCode;
	private String responseMessage;
	private String accountNo;
	private String referenceNo;
	private List<AccountInfo> accountInfo;
	private AdditionalInfo additionalInfo;

	@Data
	public static class AccountInfo {
		private String balanceType;
		private Amount amount;
		private Amount availableBalance;
		private String status;
	}

	@Data
	public static class Amount {
		private String value;
		private String currency;

		public Amount(String value, String currency) {
			this.value = value;
			this.currency = currency;
		}
	}

	@Data
	public static class AdditionalInfo {
		private String deviceId;
		private String channel;
	}
}
