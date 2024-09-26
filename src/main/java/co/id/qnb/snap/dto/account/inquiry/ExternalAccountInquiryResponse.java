package co.id.qnb.snap.dto.account.inquiry;

import co.id.qnb.snap.dto.BaseResponse;
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
@Schema(description = "API External Account Inquiry Response")
public class ExternalAccountInquiryResponse extends BaseResponse{


    @Schema(description = "Transaction identifier on service provider system", example = "2020102977770000000009")
    @Size(max = 64)
    private String referenceNo;

    @Schema(description = "Transaction identifier on service consumer system", example = "2020102900000000000001")
    @Size(max = 64)
    private String partnerReferenceNo;

    @Schema(description = "Beneficiary Account Name", requiredMode = RequiredMode.REQUIRED, example = "Yories Yolanda")
    @NotNull
    @Size(max = 100)
    private String beneficiaryAccountName;

    @Schema(description = "Beneficiary Account Number", requiredMode = RequiredMode.REQUIRED, example = "888801000157508")
    @NotNull
    @Size(max = 34)
    private String beneficiaryAccountNo;

    @Schema(description = "Beneficiary Bank Code", example = "002")
    @Size(max = 8)
    private String beneficiaryBankCode;

    @Schema(description = "Beneficiary Bank Name", example = "Bank BRI")
    @Size(max = 50)
    private String beneficiaryBankName;

    @Schema(description = "Currency Type", example = "IDR")
    @Size(max = 3)
    private String currency;


    // Getters and Setters
}