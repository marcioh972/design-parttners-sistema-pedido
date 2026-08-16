package com.marcio.designpatterns.structural.spring.adapter;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * ADAPTER "à la Spring".
 *
 * Mesma tradução de interface do exemplo GoF, mas o SDK legado chega
 * por injeção de dependência em vez de ser instanciado manualmente
 * (new LegacyPaymentGatewaySdk(...)). Isso facilita muito os testes:
 * em um teste unitário, basta injetar um mock do SDK legado.
 *
 * Esse é o padrão "porta e adaptador" (arquitetura hexagonal) que o
 * Spring favorece naturalmente: PaymentGatewayPort é a "porta" que o
 * domínio conhece; esta classe é o "adaptador" para o mundo externo.
 */
@Service
public class LegacyPaymentGatewayAdapterService implements PaymentGatewayPort {

    private final LegacyPaymentGatewaySdkClient legacySdk;

    public LegacyPaymentGatewayAdapterService(LegacyPaymentGatewaySdkClient legacySdk) {
        this.legacySdk = legacySdk;
    }

    @Override
    public String charge(BigDecimal amountInReais) {
        long cents = amountInReais.movePointRight(2).longValueExact();
        var result = legacySdk.doCharge(cents, "BRL");
        if (!result.approved()) {
            throw new IllegalStateException("Pagamento recusado pelo gateway legado");
        }
        return result.transactionId();
    }
}
