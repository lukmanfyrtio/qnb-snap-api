package co.id.qnb.snap.dto.transaction.history;

import java.util.List;

import co.id.qnb.snap.dto.BaseResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Transaction History Detail Response")
public class TransactionHistoryDetailResponse extends BaseResponse{

	@Size(max = 64)
	@Schema(description = "Transaction identifier on service provider system. Must be filled upon successful transaction", example = "2020102977770000000009")
	private String referenceNo;

	@Size(max = 64)
	@Schema(description = "Transaction identifier on service consumer system", example = "2020102900000000000001")
	private String partnerReferenceNo;

	@Schema(description = "Amount details")
	private AmountDTO amount;

	@Schema(description = "Transaction cancelled time in ISO-8601 format")
	private String cancelledTime;

	@NotNull
	@Schema(description = "Transaction created time in ISO-8601 format", requiredMode = Schema.RequiredMode.REQUIRED, example = "2009-07-03T12:08:56-07:00")
	private String dateTime;

	@Schema(description = "Refund amount details")
	private AmountDTO refundAmount;

	@Size(max = 256)
	@Schema(description = "Transaction remark", example = "Payment to Warung Ikan Bakar")
	private String remark;

	@Schema(description = "Source of funds used for this transaction")
	private List<SourceOfFundsDTO> sourceOfFunds;

	@NotNull
	@Size(max = 32)
	@Schema(description = "Transaction status", requiredMode = Schema.RequiredMode.REQUIRED, example = "SUCCESS", allowableValues = {
			"INIT", "SUCCESS", "CLOSED", "CANCELLED" })
	private String status;

	@NotNull
	@Size(max = 32)
	@Schema(description = "Transaction type", requiredMode = Schema.RequiredMode.REQUIRED, example = "PAYMENT", allowableValues = {
			"PAYMENT", "REFUND", "TOP_UP", "SEND_MONEY", "RECEIVE_MONEY" })
	private String type;


	@Data
	@Schema(description = "Amount Details")
	class AmountDTO {

		@NotNull
		@Size(max = 16)
		@Schema(description = "Net amount of the transaction", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345678.00")
		private String value;

		@NotNull
		@Size(max = 3)
		@Schema(description = "Currency of the amount (ISO 4217)", requiredMode = Schema.RequiredMode.REQUIRED, example = "IDR")
		private String currency;
	}

	@Data
	@Schema(description = "Source of Funds")
	class SourceOfFundsDTO {

		@NotNull
		@Size(max = 32)
		@Schema(description = "Source of funds used for this transaction", requiredMode = Schema.RequiredMode.REQUIRED, example = "BALANCE")
		private String source;

		@Schema(description = "Amount details")
		private AmountDTO amount;
	}
}
