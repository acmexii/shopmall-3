package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class StockStatusViewQuery {

    private Long productId;
    private StockStatus status;
    private Integer page;
    private Integer pageSize;
}
