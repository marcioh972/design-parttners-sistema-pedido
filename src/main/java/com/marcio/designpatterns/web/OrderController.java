package com.marcio.designpatterns.web;

import com.marcio.designpatterns.creational.spring.singleton.SpringOrderIdGenerator;
import com.marcio.designpatterns.domain.Address;
import com.marcio.designpatterns.domain.Customer;
import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderItem;
import com.marcio.designpatterns.domain.Product;
import com.marcio.designpatterns.behavioral.spring.chain.OrderValidationChain;
import com.marcio.designpatterns.behavioral.spring.observer.OrderStatusPublisher;
import com.marcio.designpatterns.behavioral.spring.strategy.DiscountResolver;
import com.marcio.designpatterns.structural.spring.facade.OrderCheckoutService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Ponto de entrada HTTP que amarra as versões "Spring way" dos padrões:
 *
 *   1. Builder (gof, reaproveitado)  -> monta o Order
 *   2. Chain of Responsibility       -> valida o pedido
 *   3. Strategy                      -> calcula desconto
 *   4. Facade                        -> orquestra checkout (estoque, pagamento, frete)
 *   5. Observer                      -> notifica mudança de status
 *
 * Cada dependência chega pronta via injeção de construtor -- exatamente
 * a engrenagem que os padrões acima automatizam por trás dos panos.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final SpringOrderIdGenerator idGenerator;
    private final OrderValidationChain validationChain;
    private final DiscountResolver discountResolver;
    private final OrderCheckoutService checkoutService;
    private final OrderStatusPublisher statusPublisher;

    public OrderController(SpringOrderIdGenerator idGenerator,
                            OrderValidationChain validationChain,
                            DiscountResolver discountResolver,
                            OrderCheckoutService checkoutService,
                            OrderStatusPublisher statusPublisher) {
        this.idGenerator = idGenerator;
        this.validationChain = validationChain;
        this.discountResolver = discountResolver;
        this.checkoutService = checkoutService;
        this.statusPublisher = statusPublisher;
    }

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody CreateOrderRequest request) {
        // Endereço fixo apenas para fins de demonstração da cadeia de validação.
        Address placeholderAddress = new Address("Rua Exemplo, 123", "Maceió", "AL", "57000-000");
        Customer customer = new Customer(
                request.customerId(), request.customerName(), request.customerEmail(),
                request.vip(), placeholderAddress);

        List<OrderItem> items = request.items().stream()
                .map(i -> new OrderItem(new Product(i.productId(), i.productName(), i.price()), i.quantity()))
                .toList();

        Order order = new Order(idGenerator.nextId(), customer, items);

        validationChain.validate(order);

        BigDecimal finalPrice = discountResolver.calculateFinalPrice(order);
        String trackingCode = checkoutService.checkout(order);
        statusPublisher.changeStatus(order, order.getStatus());

        return Map.of(
                "pedido", order.getId(),
                "cliente", customer.name(),
                "subtotal", order.subtotal(),
                "precoComDesconto", finalPrice,
                "status", order.getStatus(),
                "codigoRastreio", trackingCode
        );
    }
}
