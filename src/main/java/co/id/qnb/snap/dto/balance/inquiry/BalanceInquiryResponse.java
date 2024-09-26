package co.id.qnb.snap.dto.balance.inquiry;

import java.math.BigDecimal;
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
@Schema(description = "Balance Inquiry Response")
public class BalanceInquiryResponse extends BaseResponse{

    @Size(max = 64)
    @Schema(description = "Reference number", example = "2020102977770000000009")
    private String referenceNo;

    @Size(max = 64)
    @Schema(description = "Partner reference number", example = "2020102900000000000001")
    private String partnerReferenceNo;

    @Size(max = 32)
    @Schema(description = "Registered account number", example = "115471119")
    private String accountNo;

    @Size(max = 140)
    @Schema(description = "Customer account name", example = "JONOMADE")
    private String name;

    @Schema(description = "List of account information")
    private List<AccountInfoDTO> accountInfo;

}

@Data
@Schema(description = "Account Information")
class AccountInfoDTO {

    @Size(max = 70)
    @Schema(description = "Balance type", example = "Cash")
    private String balanceType;

    @Schema(description = "Amount details")
    private AmountDTO amount;

    @Schema(description = "Float amount details")
    private AmountDTO floatAmount;

    @Schema(description = "Hold amount details")
    private AmountDTO holdAmount;

    @Schema(description = "Available balance details")
    private AmountDTO availableBalance;

    @Schema(description = "Ledger balance details")
    private AmountDTO ledgerBalance;

    @Schema(description = "Current multilateral limit")
    private AmountDTO currentMultilateralLimit;

    @Size(max = 4)
    @Schema(description = "Registration status code", example = "0001")
    private String registrationStatusCode;

    @Size(max = 4)
    @Schema(description = "Account status", example = "0001", allowableValues = {"1", "2", "4", "6", "7", "9"})
    private String status;
}

@Data
@Schema(description = "Amount Details")
class AmountDTO {

    @NotNull
    @Schema(description = "Value of the amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "200000.00")
    private BigDecimal value;

    @NotNull
    @Size(max = 3)
    @Schema(description = "Currency of the amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "IDR")
    private String currency;
}
