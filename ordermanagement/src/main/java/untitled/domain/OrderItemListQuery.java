package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OrderItemListQuery {

    private Long productId;
    private Integer page;
    private Integer pageSize;
}
