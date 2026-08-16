package com.marcio.designpatterns.behavioral.gof.template;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

/**
 * TEMPLATE METHOD clássico (GoF).
 *
 * O ESQUELETO do processamento de um pedido é sempre o mesmo (validar,
 * cobrar, entregar, confirmar), mas o passo "entregar" muda conforme o
 * tipo de pedido (online -> transportadora; retirada -> notificar loja).
 * O método process() é 'final': as subclasses NÃO podem reordenar os
 * passos, só sobrescrever o(s) passo(s) variável(eis) (hook methods).
 */
public abstract class OrderProcessor {

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

    // Hook method: cada subclasse decide COMO entregar.
    protected abstract void deliver(Order order);
}
