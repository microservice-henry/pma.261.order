package store.order;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record OrderItemOut(

    String id,
    ProductRefOut product,
    Integer quantity,
    BigDecimal total

) {

}
