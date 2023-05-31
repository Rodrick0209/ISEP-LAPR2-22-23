package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

public class Order {
    private static int orderIdCounter = 0;
    private int orderId;
    private double orderValue;
    private Date orderDate;

    public Order(double orderValue, Date orderDate) {
        this.orderValue = orderValue;
        this.orderDate = orderDate;
        this.orderId = orderIdCounter++;
        orderDate = new Date();
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }
}
