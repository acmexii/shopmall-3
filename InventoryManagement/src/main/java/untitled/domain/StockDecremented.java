package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StockDecremented extends AbstractEvent {

    private Long productId;
    private Integer quantityChanged;
    private Integer remainingStock;
    private StockStatus status;
    private Date changedAt;

    public StockDecremented(Stock aggregate) {
        super(aggregate);
    }

    public StockDecremented() {
        super();
    }
}
//>>> DDD / Domain Event
