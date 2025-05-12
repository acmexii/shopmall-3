package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "stocks", path = "stocks")
public interface StockRepository
    extends PagingAndSortingRepository<Stock, Long> {
    @Query(
        value = "select stock " +
        "from Stock stock " +
        "where(:productId is null or stock.productId = :productId) and (:status is null or stock.status = :status) and (:page is null or stock.page = :page) and (:pageSize is null or stock.pageSize = :pageSize)"
    )
    List<Stock> stockStatusView(
        Long productId,
        StockStatus status,
        Integer page,
        Integer pageSize,
        Pageable pageable
    );

    @Query(
        value = "select stock " +
        "from Stock stock " +
        "where(:fromDate is null or stock.fromDate = :fromDate) and (:toDate is null or stock.toDate = :toDate) and (:page is null or stock.page = :page) and (:pageSize is null or stock.pageSize = :pageSize)"
    )
    List<Stock> stockChangeHistory(
        Date fromDate,
        Date toDate,
        Integer page,
        Integer pageSize,
        Pageable pageable
    );
}
