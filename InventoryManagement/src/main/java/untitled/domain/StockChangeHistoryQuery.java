package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class StockChangeHistoryQuery {

    private Date fromDate;
    private Date toDate;
    private Integer page;
    private Integer pageSize;
}
