package com.marcio.designpatterns.behavioral.gof.command;

public interface OrderCommand {
    void execute();
    void undo();
}
