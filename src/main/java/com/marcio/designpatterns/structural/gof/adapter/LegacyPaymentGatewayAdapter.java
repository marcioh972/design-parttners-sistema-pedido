package com.marcio.designpatterns.structural.gof.adapter;

import java.math.BigDecimal;

/**
 * ADAPTER clássico (GoF).
 *
 * Traduz a interface do LegacyPaymentGatewaySdk (que não podemos alterar)
 * para a interface PaymentGateway que o resto da aplicação conhece.
 * Sem o adapter, teríamos que espalhar conversões de BigDecimal->centavos
 * e de LegacyChargeResult->String por todo o código cliente.
 */
public class LegacyPaymentGatewayAdapter implements PaymentGateway {

    private final LegacyPaymentGatewaySdk legacySdk;

    public LegacyPaymentGatewayAdapter(LegacyPaymentGatewaySdk legacySdk) {
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
