package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.InventoryManagementApplication;

@Entity
@Table(name = "Stock_table")
@Data
//<<< DDD / Aggregate Root
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockId;

    private Product product;

    private Integer quantity;

    private StockStatus status;

    public static StockRepository repository() {
        StockRepository stockRepository = InventoryManagementApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    //<<< Clean Arch / Port Method
    public void decreaseStock(DecreaseStockCommand decreaseStockCommand) {
        //implement business logic here:

        StockDecremented stockDecremented = new StockDecremented(this);
        stockDecremented.publishAfterCommit();
        StockInsufficient stockInsufficient = new StockInsufficient(this);
        stockInsufficient.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
