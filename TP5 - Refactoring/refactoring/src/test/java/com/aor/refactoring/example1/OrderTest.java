package com.aor.refactoring.example1;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class OrderTest
{

    private Order getSmallOrder()
    {
        Order order = new Order();
        OrderLine ol = new OrderLine(new Product("Lollipop", 5), 10);
        order.add(ol);

        return order;
    }

    private Order getLargeOrder()
    {
        Order order = new Order();

        OrderLine ol1 = new OrderLine(new Product("Playstation 4", 400), 2);
        OrderLine ol2 = new OrderLine(new Product("Red Dead Redemption 2", 50), 1);

        order.add(ol1);
        order.add(ol2);

        return order;
    }

    @Test
    public void isElegibleForFreeDelivery()
    {
        assertFalse(getSmallOrder().isElegibleForFreeDelivery());
        assertTrue(getLargeOrder().isElegibleForFreeDelivery());
    }

    @Test
    public void printOrder() {
        String printed = getLargeOrder().printOrder();
        assertEquals(
                "Playstation 4(x2): 800.0\n" +
                        "Red Dead Redemption 2(x1): 50.0\n" +
                        "Total: 850.0", printed);
    }
}