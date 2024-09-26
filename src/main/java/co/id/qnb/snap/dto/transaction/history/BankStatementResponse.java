package co.id.qnb.snap.dto.transaction.history;
import java.util.List;

import co.id.qnb.snap.dto.BaseResponse;
import co.id.qnb.snap.dto.transaction.history.TransactionHistoryDetailResponse.AmountDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Bank Statement Response")
public class BankStatementResponse extends BaseResponse{

    @Schema(description = "Transaction identifier on service provider system. Must be filled upon successful transaction", maxLength = 64)
    private String referenceNo;

    @Schema(description = "Transaction identifier on service consumer system", maxLength = 64)
    private String partnerReferenceNo;

    @Schema(description = "Starting and ending balance before the first/last transaction")
    private List<BalanceDTO> balance;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BalanceDTO {
        @Schema(description = "Transaction Amount", requiredMode = Schema.RequiredMode.REQUIRED)
        private AmountDTO amount;

        @Schema(description = "Starting balance", requiredMode = Schema.RequiredMode.REQUIRED)
        private AmountDTO startingBalance;

        @Schema(description = "Ending balance", requiredMode = Schema.RequiredMode.REQUIRED)
        private AmountDTO endingBalance;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AmountDTO {
            @Schema(description = "Value of the transaction amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
            private String value;

            @Schema(description = "Currency (ISO4217)", requiredMode = Schema.RequiredMode.REQUIRED, example = "IDR", maxLength = 3)
            private String currency;

            @Schema(description = "Date and time in ISO-8601 format", requiredMode = Schema.RequiredMode.REQUIRED, example = "2020-12-18T16:03:45+07:00")
            private String dateTime;
        }
    }

    @Schema(description = "Total transaction amount with type = CREDIT")
    private DebitAndCreditEntries totalCreditEntries;

    @Schema(description = "Total transaction amount with type = DEBIT")
    private DebitAndCreditEntries totalDebitEntries;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DebitAndCreditEntries {
        @Schema(description = "Number of entries", requiredMode = Schema.RequiredMode.REQUIRED)
        private String numberOfEntries;

        @Schema(description = "Amount", requiredMode = Schema.RequiredMode.REQUIRED)
        private AmountDTO amount;
    }

    @Schema(description = "Indicates if there are more records available (Y/N)")
    private String hasMore;

    @Schema(description = "Last record datetime in ISO-8601 format")
    private String lastRecordDateTime;

    @Schema(description = "Detailed transaction data")
    private List<DetailDataDTO> detailData;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailDataDTO {
        @Schema(description = "Detail balance information", requiredMode = Schema.RequiredMode.REQUIRED)
        private DetailBalanceDTO detailBalance;

        @Schema(description = "Transaction amount", requiredMode = Schema.RequiredMode.REQUIRED)
        private AmountDTO amount;

        @Schema(description = "Origin amount", requiredMode = Schema.RequiredMode.REQUIRED)
        private AmountDTO originAmount;

        @Schema(description = "Timestamp of the transaction in ISO-8601 format", requiredMode = Schema.RequiredMode.REQUIRED)
        private String transactionDate;

        @Schema(description = "Transaction remark", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 256)
        private String remark;

        @Schema(description = "Internal transaction identifier from publisher perspective")
        private String transactionId;

        @Schema(description = "Transaction type (CREDIT/DEBIT)", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 6)
        private String type;

        @Schema(description = "Transaction detail indicator (SUCCESS/ERROR CORRECTION)", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 20)
        private String transactionDetailStatus;

        @Schema(description = "Additional information of detail transaction")
        private Object detailInfo;


        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class DetailBalanceDTO {
            @Schema(description = "Starting amount", requiredMode = Schema.RequiredMode.REQUIRED)
            private List<AmountDTO> startAmount;

            @Schema(description = "Ending amount", requiredMode = Schema.RequiredMode.REQUIRED)
            private List<AmountDTO> endAmount;
        }
    }
}

