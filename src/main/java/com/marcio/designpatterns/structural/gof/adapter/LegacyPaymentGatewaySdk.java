package com.marcio.designpatterns.structural.gof.adapter;

/**
 * Simula um SDK de terceiro (ex: gateway de pagamento legado) com uma
 * assinatura de método que NÃO combina com a interface que nosso sistema
 * usa internamente. Não temos controle sobre este código.
 */
public class LegacyPaymentGatewaySdk {

    public LegacyChargeResult doCharge(long amountInCents, String currencyCode) {
        System.out.printf("[SDK legado] cobrando %d centavos (%s)%n", amountInCents, currencyCode);
        return new LegacyChargeResult(true, "TXN-" + System.nanoTime());
    }

    public record LegacyChargeResult(boolean approved, String transactionId) {}
}
