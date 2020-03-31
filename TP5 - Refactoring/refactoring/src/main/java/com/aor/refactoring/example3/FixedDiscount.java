package com.aor.refactoring.example3;

public class FixedDiscount implements Discount
{
    private double fixed;

    public FixedDiscount(double fx) { this.fixed = fx; }

    public double applyDiscount(double price)
    {
        if(price < fixed) return 0;
        return price - fixed;
    }
}