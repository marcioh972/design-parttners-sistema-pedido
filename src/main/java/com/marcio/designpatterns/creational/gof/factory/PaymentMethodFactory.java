package com.marcio.designpatterns.creational.gof.factory;

/**
 * FACTORY METHOD clássico (GoF).
 *
 * Centraliza o "new" das implementações de PaymentMethod. O código
 * cliente não conhece as classes concretas (CreditCardPayment, PixPayment...),
 * só o tipo (String/enum) e a interface de resultado. Isso isola a
 * criação de objetos da lógica de negócio.
 *
 * Trade-off: para adicionar um novo meio de pagamento é preciso editar
 * este switch -- compare com a versão Spring, que resolve isso via DI
 * e evita esse ponto único de modificação.
 */
public class PaymentMethodFactory {

    public static PaymentMethod create(String type) {
        return switch (type.toUpperCase()) {
            case "CARTAO" -> new CreditCardPayment();
            case "PIX" -> new PixPayment();
            case "BOLETO" -> new BoletoPayment();
            default -> throw new IllegalArgumentException("Meio de pagamento desconhecido: " + type);
        };
    }
}
