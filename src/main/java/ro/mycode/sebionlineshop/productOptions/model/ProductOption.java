package ro.mycode.sebionlineshop.productOptions.model;

import jakarta.persistence.*;
import lombok.*;
import ro.mycode.sebionlineshop.options.model.Option;
import ro.mycode.sebionlineshop.products.model.Product;

import java.util.Objects;

@Entity
@Table(name = "product_options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private Option option;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductOption that = (ProductOption) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ProductOption{" +
                "id=" + id +
                '}';
    }
}
