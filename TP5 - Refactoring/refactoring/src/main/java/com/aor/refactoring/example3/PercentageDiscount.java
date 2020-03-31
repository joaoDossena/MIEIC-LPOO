package com.aor.refactoring.example3;

public class PercentageDiscount implements Discount
{
    private double percentage;

    public PercentageDiscount(double pctg) { this.percentage = pctg; }

    public double applyDiscount(double price) { return price - price * percentage; }
}