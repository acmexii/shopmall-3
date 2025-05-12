package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DecreaseStockCommand {

    private Long productId;
    private Integer quantity;
}
