package ua.hrynko.projectcv.db.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orders_cars")
public class OrdersCars implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Cars car;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }


    @Override
    public String toString() {
        return "OrdersCars [orderId=" + order.getId() + ", carId=" + car.getId() + "]";

    }

}
