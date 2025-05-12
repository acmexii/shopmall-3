package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderItemCreated extends AbstractEvent {

    private Long productId;
    private Integer quantity;
    private StockId stockId;

    public OrderItemCreated(OrderItem aggregate) {
        super(aggregate);
    }

    public OrderItemCreated() {
        super();
    }
}
//>>> DDD / Domain Event
