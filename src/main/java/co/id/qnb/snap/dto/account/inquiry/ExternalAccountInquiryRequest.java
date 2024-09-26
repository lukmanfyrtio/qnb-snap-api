package co.id.qnb.snap.dto.account.inquiry;

import co.id.qnb.snap.dto.BaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
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
@Schema(description = "API External Account Inquiry Requset")
public class ExternalAccountInquiryRequest extends BaseRequest{

	@Schema(description = "Beneficiary Bank Code", requiredMode = RequiredMode.REQUIRED, example = "002")
	@NotNull
	@Size(max = 8)
	private String beneficiaryBankCode;

	@Schema(description = "Beneficiary Account Number", requiredMode = RequiredMode.REQUIRED, example = "888801000157508")
	@NotNull
	@Size(max = 34)
	private String beneficiaryAccountNo;

}
