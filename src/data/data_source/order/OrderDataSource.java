package data.data_source.order;

import data.models.Order;

public abstract class OrderDataSource {
    private Order order;
   public abstract void createOrder(Order order);
    public abstract Order getOrder();

}
