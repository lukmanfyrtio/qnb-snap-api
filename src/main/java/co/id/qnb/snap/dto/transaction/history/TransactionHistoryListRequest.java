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
@Schema(description = "Transaction History List Request")
public class TransactionHistoryListRequest extends BaseRequest{


	@Schema(description = "Starting time range in ISO-8601 format", example = "2019-07-03T12:08:56-07:00")
	private OffsetDateTime fromDateTime;

	@Schema(description = "Ending time range in ISO-8601 format", example = "2019-07-03T12:08:56-07:00")
	private OffsetDateTime toDateTime;

	@Schema(description = "Maximum number of transactions returned in one pagination", example = "10", defaultValue = "10")
	private Integer pageSize;

	@Schema(description = "Current page number", example = "0", defaultValue = "0")
	private Integer pageNumber;

}
