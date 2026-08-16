package com.marcio.designpatterns.behavioral.spring.template;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

/**
 * TEMPLATE METHOD "à la Spring".
 *
 * O padrão é IDÊNTICO ao clássico -- Template Method não muda de forma
 * com o Spring, porque já é 100% orientado a objetos, sem "novidade"
 * de container para oferecer aqui. A diferença aparece nas subclasses:
 * elas viram @Service, então o Spring decide QUAL implementação injetar
 * (ex: via @Qualifier ou perfil), em vez de você fazer "new" na mão.
 */
public abstract class OrderDeliveryProcessor {

    public final void process(Order order) {
        validate(order);
        order.setStatus(OrderStatus.VALIDADO);
        charge(order);
        order.setStatus(OrderStatus.PAGO);
        deliver(order);
        order.setStatus(OrderStatus.ENVIADO);
    }

    protected void validate(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalStateException("Pedido sem itens");
        }
    }

    protected void charge(Order order) {
        System.out.println("[Pagamento] cobrando pedido " + order.getId());
    }

    protected abstract void deliver(Order order);
}
