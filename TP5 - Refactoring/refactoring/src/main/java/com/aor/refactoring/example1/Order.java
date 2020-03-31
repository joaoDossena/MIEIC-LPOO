package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(OrderLine ol) { this.lines.add(ol); }

    public double getTotal()
    {
        double total = 0;
        for(OrderLine line : this.lines)
            total += line.getTotal();

        return total;
    }

    public StringBuffer printOrderLines()
    {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : this.lines)
            printBuffer.append(line.printOrderLine());
        return printBuffer;
    }

    public boolean isElegibleForFreeDelivery() { return this.getTotal() > 100; }

    public String printOrder()
    {
        StringBuffer printBuffer = new StringBuffer();

        printBuffer.append(this.printOrderLines());
        printBuffer.append("Total: " + this.getTotal());

        return printBuffer.toString();
    }
}