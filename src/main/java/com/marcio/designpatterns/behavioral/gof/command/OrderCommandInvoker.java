package com.marcio.designpatterns.behavioral.gof.command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * COMMAND clássico (GoF).
 *
 * Cada ação sobre um pedido (confirmar, cancelar...) vira um OBJETO que
 * sabe se executar E se desfazer. O Invoker não conhece a lógica de
 * negócio de cada comando, só guarda um histórico (pilha) e sabe chamar
 * execute()/undo() -- útil para implementar "desfazer última ação",
 * filas de tarefas, ou log de auditoria de operações.
 *
 * Nota sobre a versão "Spring way": o padrão em si não muda -- Command
 * já é puramente OO. O que o Spring adiciona de idiomático aqui é
 * publicar cada execute() como um evento de domínio (mesma ideia do
 * Observer/@EventListener já implementado) e, se precisar reprocessar
 * comandos de forma assíncrona, usar @Async ou uma fila (RabbitMQ/Kafka)
 * em vez de uma Deque em memória.
 */
public class OrderCommandInvoker {

    private final Deque<OrderCommand> history = new ArrayDeque<>();

    public void execute(OrderCommand command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (history.isEmpty()) {
            System.out.println("[Comando] nada para desfazer");
            return;
        }
        history.pop().undo();
    }
}
