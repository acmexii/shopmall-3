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
// @RequestMapping(value="/orderItems")
@Transactional
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepository;

    @RequestMapping(
        value = "/orderItemscreateorderitem",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public OrderItem createOrderItem(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateOrderItemCommand createOrderItemCommand
    ) throws Exception {
        System.out.println("##### /orderItem/createOrderItem  called #####");
        OrderItem orderItem = new OrderItem();
        orderItem.createOrderItem(createOrderItemCommand);
        orderItemRepository.save(orderItem);
        return orderItem;
    }
}
//>>> Clean Arch / Inbound Adaptor
