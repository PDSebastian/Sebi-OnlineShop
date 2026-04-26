package ro.mycode.sebionlineshop.orderDetails.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ro.mycode.sebionlineshop.orders.model.Order;
import ro.mycode.sebionlineshop.products.model.Product;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Suma totală este obligatorie")
    private Double amount;

    @NotBlank(message = "Adresa de livrare este obligatorie")
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
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;




    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(orderAddress, that.orderAddress) && Objects.equals(orderEmail, that.orderEmail) && Objects.equals(orderDate, that.orderDate) && Objects.equals(orderStatus, that.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, shippingAddress, orderAddress, orderEmail, orderDate, orderStatus);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
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
