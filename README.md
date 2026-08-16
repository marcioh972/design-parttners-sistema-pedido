# Design Patterns com Java — Dos Clássicos (GoF) ao Spring Framework

Projeto de estudo: um **Sistema de Pedidos** simples onde cada padrão GoF
aparece **duas vezes**, lado a lado:

- `*.gof.*`    → implementação clássica, em Java puro, sem o container.
- `*.spring.*` → a mesma intenção resolvida com os recursos do Spring
  (injeção de dependência, eventos, escopos de bean, `@Order`, etc).

A ideia não é "GoF errado, Spring certo" — é enxergar que o Spring não
elimina os padrões, ele **os implementa para você** por baixo de anotações.

## Requisitos

- Java 17+
- Maven 3.9+ (usa o `spring-boot-starter-parent`, então não precisa
  declarar versões de dependência manualmente)

## Rodando

```bash
mvn spring-boot:run
```

Depois, teste o fluxo completo (Builder → Chain of Responsibility →
Strategy → Facade → Observer) via:

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerId": "C1",
    "customerName": "Márcio",
    "customerEmail": "marcio@example.com",
    "vip": true,
    "items": [
      {"productId": "P1", "productName": "Teclado mecânico", "price": 350.00, "quantity": 1},
      {"productId": "P2", "productName": "Mouse", "price": 120.00, "quantity": 2}
    ]
  }'
```

> Nota: este projeto foi montado num sandbox sem acesso ao Maven Central,
> então as classes puras (pacotes `*.gof.*`) já foram compiladas e
> validadas com `javac` diretamente. As classes `*.spring.*` foram
> revisadas manualmente (imports, assinaturas, injeção) mas só serão
> compiladas de fato na primeira vez que você rodar `mvn spring-boot:run`
> na sua máquina — se aparecer algum erro de compilação, me mostre o
> stacktrace que eu ajusto.

## Mapa de padrões

| Categoria      | Padrão                     | GoF (Java puro)                                             | Spring way                                                        |
|----------------|-----------------------------|---------------------------------------------------------------|---------------------------------------------------------------------|
| Criacional     | Singleton                   | `creational/gof/singleton/OrderIdGenerator`                  | `creational/spring/singleton/SpringOrderIdGenerator` (bean padrão)  |
| Criacional     | Builder                     | `creational/gof/builder/OrderBuilder`                        | *(GoF já é a forma idiomática; ver nota no README do pacote)*       |
| Criacional     | Factory Method               | `creational/gof/factory/PaymentMethodFactory`                | `creational/spring/factory/PaymentStrategyFactory` (`Map<String,Bean>`) |
| Estrutural     | Adapter                     | `structural/gof/adapter/LegacyPaymentGatewayAdapter`          | `structural/spring/adapter/LegacyPaymentGatewayAdapterService`      |
| Estrutural     | Decorator                   | `structural/gof/decorator/*Decorator`                        | *(ver `README_DECORATOR.txt` — o equivalente é AOP/proxies: `@Transactional`, `@Cacheable`)* |
| Estrutural     | Facade                      | `structural/gof/facade/OrderFacade`                           | `structural/spring/facade/OrderCheckoutService` (camada `@Service`) |
| Comportamental | Strategy                    | `behavioral/gof/strategy/PricingContext`                      | `behavioral/spring/strategy/DiscountResolver` (`List<Bean>` + `@Order`) |
| Comportamental | Observer                    | `behavioral/gof/observer/ObservableOrder`                     | `behavioral/spring/observer/OrderStatusPublisher` (`ApplicationEvent` + `@EventListener`) |
| Comportamental | Template Method              | `behavioral/gof/template/OrderProcessor`                      | `behavioral/spring/template/OrderDeliveryProcessor` (mesma classe, subclasses viram `@Service`) |
| Comportamental | Chain of Responsibility      | `behavioral/gof/chain/OrderValidator`                         | `behavioral/spring/chain/OrderValidationChain` (`List<Bean>` ordenada) |
| Comportamental | Command                     | `behavioral/gof/command/OrderCommandInvoker`                   | *(comentário no próprio arquivo: equivalente seria `@EventListener` + `@Async`/fila)* |

