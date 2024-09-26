package co.id.qnb.snap.dto.transaction.history;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Transaction History Detail Request")
public class TransactionHistoryDetailRequest {

	@NotNull
	@Size(max = 64)
	@Schema(description = "Transaction identifier on service consumer system", requiredMode = Schema.RequiredMode.REQUIRED, example = "2020102900000000001")
	private String originalPartnerReferenceNo;

	@Schema(description = "Additional information", example = "{\"deviceId\":\"12345679237\", \"channel\":\"mobilephone\"}")
	private Map<String, Object> additionalInfo;

}
