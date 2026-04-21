package ro.mycode.sebionlineshop.costumers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import ro.mycode.sebionlineshop.orders.model.Order;

import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="customers")


public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Email-ul este obligatoriu")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Parola este obligatorie")
    private String password;

    @NotBlank(message = "Numele complet este obligatoriu")
    @Column(name = "full_name")
    private String fullName;

    @NotBlank(message = "Adresa de facturare este obligatorie")
    @Column(name = "billing_address")
    private String billingAddress;

    @NotBlank(message = "Adresa de livrare este obligatorie")
    @Column(name = "default_shipping_address")
    private String defaultShippingAddress;

    @NotBlank(message = "Țara este obligatorie")
    private String country;

    @NotBlank(message = "Numărul de telefon este obligatoriu")
    private String phone;

    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Costumer costumer = (Costumer) o;
        return Objects.equals(id, costumer.id) && Objects.equals(email, costumer.email) && Objects.equals(password, costumer.password) && Objects.equals(fullName, costumer.fullName) && Objects.equals(billingAddress, costumer.billingAddress) && Objects.equals(defaultShippingAddress, costumer.defaultShippingAddress) && Objects.equals(country, costumer.country) && Objects.equals(phone, costumer.phone);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, fullName, billingAddress, defaultShippingAddress, country, phone);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", defaultShippingAddress='" + defaultShippingAddress + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
