package com.marcio.designpatterns.structural.gof.facade;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;
import com.marcio.designpatterns.structural.gof.adapter.LegacyPaymentGatewayAdapter;
import com.marcio.designpatterns.structural.gof.adapter.LegacyPaymentGatewaySdk;

/**
 * FACADE clássico (GoF).
 *
 * Fechar um pedido envolve reservar estoque, cobrar pagamento, agendar
 * frete e notificar o cliente -- quatro subsistemas com suas próprias
 * regras. O Facade expõe UM método simples (checkout) e esconde toda
 * essa orquestração, para que o código cliente (ex: um controller)
 * não precise conhecer os quatro subsistemas nem a ordem correta de
 * chamá-los.
 */
public class OrderFacade {

    private final InventorySystem inventory = new InventorySystem();
    private final ShippingSystem shipping = new ShippingSystem();
    private final NotificationSystem notification = new NotificationSystem();
    private final LegacyPaymentGatewayAdapter paymentGateway =
            new LegacyPaymentGatewayAdapter(new LegacyPaymentGatewaySdk());

    public String checkout(Order order) {
        inventory.reserve(order);
        String transactionId = paymentGateway.charge(order.subtotal());
        order.setStatus(OrderStatus.PAGO);
        String trackingCode = shipping.schedule(order);
        order.setStatus(OrderStatus.ENVIADO);
        notification.notifyCustomer(order, "Pedido confirmado! Rastreio: " + trackingCode);
        return trackingCode;
    }
}
