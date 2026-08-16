package com.marcio.designpatterns.structural.gof.decorator;

/** Decorator abstrato: guarda o objeto decorado e delega a ele. */
public abstract class PriceCalculatorDecorator implements PriceCalculator {
    protected final PriceCalculator wrapped;

    protected PriceCalculatorDecorator(PriceCalculator wrapped) {
        this.wrapped = wrapped;
    }
}
