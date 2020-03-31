package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public void setProduct(Product product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public StringBuffer printOrderLine()
    {
        StringBuffer printBuffer = new StringBuffer();
        printBuffer.append(this.product.getName() + "(x" + this.quantity + "): " + this.getTotal() + "\n");
        return printBuffer;
    }

    public double getTotal() { return this.product.getPrice() * this.quantity; }
}
