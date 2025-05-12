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
// @RequestMapping(value="/stocks")
@Transactional
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @RequestMapping(
        value = "/stocks/{id}/decreasestock",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Stock decreaseStock(
        @PathVariable(value = "id") Long id,
        @RequestBody DecreaseStockCommand decreaseStockCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /stock/decreaseStock  called #####");
        Optional<Stock> optionalStock = stockRepository.findById(id);

        optionalStock.orElseThrow(() -> new Exception("No Entity Found"));
        Stock stock = optionalStock.get();
        stock.decreaseStock(decreaseStockCommand);

        stockRepository.save(stock);
        return stock;
    }
}
//>>> Clean Arch / Inbound Adaptor
