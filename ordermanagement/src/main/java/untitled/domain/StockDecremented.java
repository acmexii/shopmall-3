package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class StockDecremented extends AbstractEvent {

    private Long productId;
    private Integer quantityChanged;
    private Integer remainingStock;
    private Object status;
    private Date changedAt;
}
