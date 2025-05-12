package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "/orderscreateorder",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Order createOrder(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateOrderCommand createOrderCommand
    ) throws Exception {
        System.out.println("##### /order/createOrder  called #####");
        Order order = new Order();
        order.createOrder(createOrderCommand);
        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/confirmorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order confirmOrder(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/confirmOrder  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.confirmOrder();

        orderRepository.save(order);
        return order;
    }
}
//>>> Clean Arch / Inbound Adaptor
