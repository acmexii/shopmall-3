package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "orderItems",
    path = "orderItems"
)
public interface OrderItemRepository
    extends PagingAndSortingRepository<OrderItem, Long> {
    @Query(
        value = "select orderItem " +
        "from OrderItem orderItem " +
        "where(:productId is null or orderItem.productId = :productId) and (:page is null or orderItem.page = :page) and (:pageSize is null or orderItem.pageSize = :pageSize)"
    )
    List<OrderItem> orderItemList(
        Long productId,
        Integer page,
        Integer pageSize,
        Pageable pageable
    );
}
