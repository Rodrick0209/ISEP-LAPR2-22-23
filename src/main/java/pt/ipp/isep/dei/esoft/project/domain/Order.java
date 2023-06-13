package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Order.
 */
public class Order implements Serializable {
    private static int orderIdCounter = 1;



    private final int orderId;
    private double orderValue;
    private Date orderDate;
    /**
     * The Client.
     */
    Client client;

    /**
     * Instantiates a new Order.
     *
     * @param orderValue the order value
     * @param client     the client
     */
    public Order(double orderValue, Client client) {
        this.orderValue = orderValue;
        this.client = client;
        this.orderDate = new Date();
        orderId = orderIdCounter++;
    }

    public Order(double orderValue, Date orderDate) {
        this.orderValue = orderValue;
        this.orderDate = orderDate;
        orderId = orderIdCounter++;
    }
    public Order(double orderValue, Date orderDate, Client client) {
        this.orderValue = orderValue;
        this.orderDate = orderDate;
        this.client = client;
       orderId = orderIdCounter++;
    }

    public Order(Client client,Date orderDate) {
        this.client = client;
        this.orderDate = orderDate;
        orderId = orderIdCounter++;
    }

    /**
     * Gets order value.
     *
     * @return the order value
     */
    public double getOrderValue() {
        return orderValue;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Sets order value.
     *
     * @param orderValue the order value
     */
    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    /**
     * Gets order date.
     *
     * @return the order date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets order date.
     *
     * @param orderDate the order date
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId = " + orderId +
                ", orderValue = " + orderValue+"$" +
                ", orderDate = " + orderDate +
                ", clientEmail = " + client.toString()+"}";
    }
}
