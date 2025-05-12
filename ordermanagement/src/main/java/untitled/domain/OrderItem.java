package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.OrdermanagementApplication;

@Entity
@Table(name = "OrderItem_table")
@Data
//<<< DDD / Aggregate Root
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;

    private Long productId;

    private Integer quantity;

    private StockId stockId;

    public static OrderItemRepository repository() {
        OrderItemRepository orderItemRepository = OrdermanagementApplication.applicationContext.getBean(
            OrderItemRepository.class
        );
        return orderItemRepository;
    }

    //<<< Clean Arch / Port Method
    public void createOrderItem(CreateOrderItemCommand createOrderItemCommand) {
        //implement business logic here:

        OrderItemCreated orderItemCreated = new OrderItemCreated(this);
        orderItemCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
