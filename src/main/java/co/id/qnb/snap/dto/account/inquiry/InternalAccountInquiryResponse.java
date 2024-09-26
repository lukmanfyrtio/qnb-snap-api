package co.id.qnb.snap.dto.account.inquiry;

import co.id.qnb.snap.dto.BaseResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "API Internal Account Inquiry Response")
public class InternalAccountInquiryResponse extends BaseResponse {

	@Schema(description = "Transaction identifier on service provider system", example = "2020102977770000000009")
	@Size(max = 64)
	private String referenceNo;

	@Schema(description = "Transaction identifier on service consumer system", example = "2020102900000000000001")
	@Size(max = 64)
	private String partnerReferenceNo;

	@Schema(description = "Beneficiary Account Name", required = true, example = "Yories Yolanda")
	@NotNull
	@Size(max = 100)
	private String beneficiaryAccountName;

	@Schema(description = "Beneficiary Account Number", required = true, example = "888801000157508")
	@NotNull
	@Size(max = 34)
	private String beneficiaryAccountNo;

	@Schema(description = "Beneficiary Account Status", example = "Rekening aktif")
	@Size(max = 16)
	private String beneficiaryAccountStatus;

	@Schema(description = "Beneficiary Account Type", example = "D")
	@Size(max = 1)
	private String beneficiaryAccountType;

	@Schema(description = "Currency Type", example = "IDR")
	@Size(max = 3)
	private String currency;

}