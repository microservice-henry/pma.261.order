package store.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "order",
    url = "${ORDER_API_URL:http://order:8080}"
)
public interface OrderController {

    @PostMapping("/orders")
    public ResponseEntity<OrderOut> create(
        @RequestHeader("id-account") String idAccount,
        @RequestBody OrderIn in
    );

    @GetMapping("/orders")
    public ResponseEntity<List<OrderSummaryOut>> findAll(
        @RequestHeader("id-account") String idAccount
    );

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderOut> findById(
        @RequestHeader("id-account") String idAccount,
        @PathVariable String id,
        @RequestParam(required = false) String currency
    );

    @GetMapping("/orders/health-check")
    public ResponseEntity<Void> healthCheck();

}
