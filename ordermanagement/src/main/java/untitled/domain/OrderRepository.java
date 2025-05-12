package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository
    extends PagingAndSortingRepository<Order, Long> {
    @Query(
        value = "select order " +
        "from Order order " +
        "where(:userId is null or order.userId = :userId) and (:orderStatus is null or order.orderStatus = :orderStatus) and (:fromDate is null or order.fromDate = :fromDate) and (:toDate is null or order.toDate = :toDate) and (:page is null or order.page = :page) and (:pageSize is null or order.pageSize = :pageSize)"
    )
    List<Order> orderSummary(
        Long userId,
        OrderStatus orderStatus,
        Date fromDate,
        Date toDate,
        Integer page,
        Integer pageSize,
        Pageable pageable
    );
}
