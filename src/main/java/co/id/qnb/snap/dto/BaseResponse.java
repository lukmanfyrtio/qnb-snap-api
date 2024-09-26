package co.id.qnb.snap.dto;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Base Response containing common fields")
public class BaseResponse {

    @NotNull
    @Size(max = 7)
    @Schema(description = "Response code", requiredMode = Schema.RequiredMode.REQUIRED, example = "2001200")
    private String responseCode;

    @NotNull
    @Size(max = 150)
    @Schema(description = "Response message", requiredMode = Schema.RequiredMode.REQUIRED, example = "Request has been processed successfully")
    private String responseMessage;

    @Schema(description = "Additional information", 
            example = "{\"deviceId\":\"12345679237\", \"channel\":\"mobilephone\"}")
    private Map<String, Object> additionalInfo;
}
