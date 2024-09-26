package co.id.qnb.snap.dto;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Base Request containing common fields")
public class BaseRequest {
	@Schema(description = "Transaction identifier on service consumer system", example = "2020102900000000000001")
	@Size(max = 64)
	private String partnerReferenceNo;

	@Schema(description = "Additional information", example = "{\"deviceId\":\"12345679237\", \"channel\":\"mobilephone\"}")
	private Map<String, Object> additionalInfo;
}
