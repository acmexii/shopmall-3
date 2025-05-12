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
    StockRepository stockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_StockDecrementPolicy(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener StockDecrementPolicy : " + orderPlaced + "\n\n"
        );
        // Comments //
        //주문이 생성되면 각 주문 상품의 재고를 자동으로 차감하여 재고 부족 여부를 신속히 확인합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
