package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateOrderItemCommand {

    private Long productId;
    private Integer quantity;
    private StockId stockId;
}
