package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StockInsufficient extends AbstractEvent {

    private Long productId;
    private Integer requestedQuantity;
    private Integer availableStock;
    private StockStatus status;
    private Date detectedAt;

    public StockInsufficient(Stock aggregate) {
        super(aggregate);
    }

    public StockInsufficient() {
        super();
    }
}
//>>> DDD / Domain Event
