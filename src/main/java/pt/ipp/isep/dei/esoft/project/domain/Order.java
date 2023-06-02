package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

public class Order {
    private static int orderIdCounter = 0;
    private int orderId;
    private double orderValue;
    private Date orderDate;
    Client client;

    public Order(double orderValue, Client client) {
        this.orderValue = orderValue;
        this.client = client;
        this.orderId = orderIdCounter++;
        orderDate = new Date();
    }

    public double getOrderValue() {
        return orderValue;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderValue=" + orderValue +
                ", orderDate=" + orderDate +
                ", clientEmail='" + client.toString() + '\'' +
                '}';
    }
}
