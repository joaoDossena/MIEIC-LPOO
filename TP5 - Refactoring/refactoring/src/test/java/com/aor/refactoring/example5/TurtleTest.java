package com.aor.refactoring.example5;

import org.junit.Test;

import static org.junit.Assert.*;
import org.mockito.Mockito;

public class TurtleTest
{

    @Test
    public void testRotateLeft()
    {
        Turtle turtle = new Turtle(new Position(5, 5, 'N'));
        Command rotateLeft = new RotateLeft();
        turtle.execute(rotateLeft); assertEquals('W', turtle.getPosition().getDirection());
        turtle.execute(rotateLeft); assertEquals('S', turtle.getPosition().getDirection());
        turtle.execute(rotateLeft); assertEquals('E', turtle.getPosition().getDirection());
        turtle.execute(rotateLeft); assertEquals('N', turtle.getPosition().getDirection());
        assertEquals(5, turtle.getPosition().getX());
        assertEquals(5, turtle.getPosition().getY());
    }

    @Test
    public void testRotateRight()
    {
        Turtle turtle = new Turtle(new Position(5, 5, 'N'));
        Command rotateRight = new RotateRight();
        turtle.execute(rotateRight); assertEquals('E', turtle.getPosition().getDirection());
        turtle.execute(rotateRight); assertEquals('S', turtle.getPosition().getDirection());
        turtle.execute(rotateRight); assertEquals('W', turtle.getPosition().getDirection());
        turtle.execute(rotateRight); assertEquals('N', turtle.getPosition().getDirection());
        assertEquals(5, turtle.getPosition().getX());
        assertEquals(5, turtle.getPosition().getY());
    }

    @Test
    public void testForward()
    {
        Turtle turtleN = new Turtle(new Position(5, 5, 'N'));
        Command moveForward = new MoveForward();

        turtleN.execute(moveForward);
        assertEquals(4, turtleN.getPosition().getX());
        assertEquals(5, turtleN.getPosition().getY());

        Turtle turtleW = new Turtle(new Position(5, 5, 'W'));

        turtleW.execute(moveForward);
        assertEquals(5, turtleW.getPosition().getX());
        assertEquals(4, turtleW.getPosition().getY());

        Turtle turtleS = new Turtle(new Position(5, 5, 'S'));

        turtleS.execute(moveForward);
        assertEquals(6, turtleS.getPosition().getX());
        assertEquals(5, turtleS.getPosition().getY());

        Turtle turtleE = new Turtle(new Position(5, 5, 'E'));

        turtleE.execute(moveForward);
        assertEquals(5, turtleE.getPosition().getX());
        assertEquals(6, turtleE.getPosition().getY());
    }

}