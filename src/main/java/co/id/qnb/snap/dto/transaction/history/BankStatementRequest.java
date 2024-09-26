package co.id.qnb.snap.dto.transaction.history;

import java.time.OffsetDateTime;

import co.id.qnb.snap.dto.BaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Bank Statement Request")
public class BankStatementRequest extends BaseRequest{


    @Schema(description = "Card token for payment. Must be filled if accountNo is null", maxLength = 128)
    private String bankCardToken;

    @Schema(description = "Bank account number. Must be filled if bankCardToken is null", maxLength = 16)
    private String accountNo;

    @Schema(description = "Starting time range in ISO-8601 format", example = "2019-07-03T12:08:56-07:00")
    private OffsetDateTime fromDateTime;

    @Schema(description = "Ending time range in ISO-8601 format", example = "2019-07-03T12:08:56-07:00")
    private OffsetDateTime toDateTime;

}
