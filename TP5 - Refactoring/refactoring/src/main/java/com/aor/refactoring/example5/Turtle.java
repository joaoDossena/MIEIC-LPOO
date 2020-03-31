package com.aor.refactoring.example5;

public class Turtle
{
    private Position position;

    public Turtle(Position position) { this.position = position; }

    public Position getPosition() { return this.position; }

    public void execute(Command command) { command.execute(this.position); }
}
