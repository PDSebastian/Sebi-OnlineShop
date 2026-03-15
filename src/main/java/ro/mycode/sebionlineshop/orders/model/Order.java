package ro.mycode.sebionlineshop.orders.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.mycode.sebionlineshop.costumers.model.Costumer;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Suma  este obligatorie")
    private Double amount;

    @NotBlank(message = "Adresa  este obligatorie")
    @Column(name = "shipping_address")
    private String shippingAddress;

    @NotBlank(message = "Adresa de facturare este obligatorie")
    @Column(name = "order_address")
    private String orderAddress;

    @NotBlank(message = "Email-ul pentru comandă este obligatoriu")
    @Column(name = "order_email")
    private String orderEmail;

    @NotNull(message = "Data comenzii este obligatorie")
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @NotBlank(message = "Statusul comenzii este obligatoriu")
    @Column(name = "order_status")
    private String orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="costumer_id")
    private Costumer costumer;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(amount, order.amount) && Objects.equals(shippingAddress, order.shippingAddress) && Objects.equals(orderAddress, order.orderAddress) && Objects.equals(orderEmail, order.orderEmail) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, shippingAddress, orderAddress, orderEmail, orderDate, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderEmail='" + orderEmail + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }



}
