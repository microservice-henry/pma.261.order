package store.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderOut(

    String id,
    LocalDateTime date,
    String currency,
    List<OrderItemOut> items,
    BigDecimal total

) {

}
