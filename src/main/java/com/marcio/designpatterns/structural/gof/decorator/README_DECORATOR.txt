DECORATOR (GoF) -- por que não tem um par "Spring way" separado?

O Decorator empilha comportamento em TEMPO DE EXECUÇÃO, compondo objetos
manualmente:

    PriceCalculator calc = new TaxDecorator(
                                new VipDiscountDecorator(
                                    new BasePriceCalculator()));
    calc.calculate(order);

O Spring já resolve o MESMO problema (adicionar comportamento transversal
sem alterar a classe original) de duas formas idiomáticas:

  1) Composição de beans no @Configuration, se a decoração é fixa:
         @Bean
         PriceCalculator priceCalculator(BasePriceCalculator base) {
             return new TaxDecorator(new VipDiscountDecorator(base));
         }

  2) AOP (@Aspect / proxies dinâmicos), quando a decoração é transversal
     a muitas classes (log, cache, transação, segurança). Na prática,
     @Transactional, @Cacheable e @Async SÃO decorators implementados
     via proxy -- o Spring gera em runtime um objeto que "embrulha" o
     seu bean real e adiciona comportamento antes/depois da chamada,
     exatamente como TaxDecorator embrulha o BasePriceCalculator aqui.

Ou seja: você já usa Decorator todo dia no Spring, só que via anotação
em vez de escrever a classe wrapper à mão.
