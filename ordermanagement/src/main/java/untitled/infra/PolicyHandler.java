package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockDecremented'"
    )
    public void wheneverStockDecremented_OrderConfirmationPolicy(
        @Payload StockDecremented stockDecremented
    ) {
        StockDecremented event = stockDecremented;
        System.out.println(
            "\n\n##### listener OrderConfirmationPolicy : " +
            stockDecremented +
            "\n\n"
        );
        // Comments //
        //재고가 정상적으로 차감되었을 때에만 주문을 확정 처리하여 재고와 주문의 일관성을 보장합니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockInsufficient'"
    )
    public void wheneverStockInsufficient_OrderFailureOnStockInsufficiencyPolicy(
        @Payload StockInsufficient stockInsufficient
    ) {
        StockInsufficient event = stockInsufficient;
        System.out.println(
            "\n\n##### listener OrderFailureOnStockInsufficiencyPolicy : " +
            stockInsufficient +
            "\n\n"
        );
        // Comments //
        //재고가 부족할 경우 주문 상태를 FAILED로 변경하고 사용자에게 알림을 전송하기 위함

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
