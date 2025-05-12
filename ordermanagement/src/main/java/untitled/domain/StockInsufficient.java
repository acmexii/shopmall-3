package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class StockInsufficient extends AbstractEvent {

    private Long productId;
    private Integer requestedQuantity;
    private Integer availableStock;
    private Object status;
    private Date detectedAt;
}
