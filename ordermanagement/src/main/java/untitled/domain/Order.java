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
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long userId;

    private OrderStatus orderStatus;

    private Date orderDate;

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrdermanagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void createOrder(CreateOrderCommand createOrderCommand) {
        //implement business logic here:

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void confirmOrder() {
        //implement business logic here:

        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
