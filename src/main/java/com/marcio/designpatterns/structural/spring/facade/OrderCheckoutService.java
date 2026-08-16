package com.marcio.designpatterns.structural.spring.facade;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;
import com.marcio.designpatterns.structural.spring.adapter.PaymentGatewayPort;
import org.springframework.stereotype.Service;

/**
 * FACADE "à la Spring".
 *
 * Esta é a essência da camada de @Service no Spring: uma classe fina que
 * orquestra vários outros beans (InventoryService, ShippingService,
 * PaymentGatewayPort...) por trás de um único método de negócio.
 *
 * A diferença para o Facade GoF não está na intenção (esconder
 * complexidade de subsistemas), mas em COMO os subsistemas chegam até
 * aqui: em vez de "new InventorySystem()" dentro da própria fachada,
 * eles são injetados pelo container via construtor -- o que torna esta
 * classe trivial de testar com mocks.
 */
@Service
public class OrderCheckoutService {

    private final InventoryService inventory;
    private final ShippingService shipping;
    private final NotificationService notification;
    private final PaymentGatewayPort paymentGateway;

    public OrderCheckoutService(InventoryService inventory,
                                 ShippingService shipping,
                                 NotificationService notification,
                                 PaymentGatewayPort paymentGateway) {
        this.inventory = inventory;
        this.shipping = shipping;
        this.notification = notification;
        this.paymentGateway = paymentGateway;
    }

    public String checkout(Order order) {
        inventory.reserve(order);
        paymentGateway.charge(order.subtotal());
        order.setStatus(OrderStatus.PAGO);
        String trackingCode = shipping.schedule(order);
        order.setStatus(OrderStatus.ENVIADO);
        notification.notifyCustomer(order, "Pedido confirmado! Rastreio: " + trackingCode);
        return trackingCode;
    }
}
