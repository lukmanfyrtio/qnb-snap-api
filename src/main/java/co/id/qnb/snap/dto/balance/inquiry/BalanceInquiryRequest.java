package co.id.qnb.snap.dto.balance.inquiry;

import java.util.List;

import co.id.qnb.snap.dto.BaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request for Balance Inquiry")
public class BalanceInquiryRequest extends BaseRequest {

	@Schema(description = "Card token for payment. Must be filled if accountNo is null and Authorization-Customer is Null", example = "6d7963617264746f6b656e", maxLength = 128)
	@Size(max = 128)
	private String bankCardToken;

	@Schema(description = "Bank account number. Must be filled if bankCardToken is Null and Authorization-Customer is Null", example = "7382382957893840", maxLength = 16)
	@Size(max = 16)
	private String accountNo;

	@Schema(description = "Balance types. If this parameter doesn't exist, it means to inquiry all balance types on the account", example = "[\"Cash\", \"Coins\"]")
	private List<String> balanceTypes;

}
