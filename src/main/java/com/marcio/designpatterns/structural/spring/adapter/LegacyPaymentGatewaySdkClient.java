package com.marcio.designpatterns.structural.spring.adapter;

import org.springframework.stereotype.Component;

/** Mesmo SDK de terceiro, agora registrado como bean para poder ser injetado. */
@Component
public class LegacyPaymentGatewaySdkClient {

    public LegacyChargeResult doCharge(long amountInCents, String currencyCode) {
        System.out.printf("[SDK legado] cobrando %d centavos (%s)%n", amountInCents, currencyCode);
        return new LegacyChargeResult(true, "TXN-" + System.nanoTime());
    }

    public record LegacyChargeResult(boolean approved, String transactionId) {}
}
