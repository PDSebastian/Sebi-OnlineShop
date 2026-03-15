package ro.mycode.sebionlineshop.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ro.mycode.sebionlineshop.productCategories.model.ProductCategory;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;

import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank(message = "SKU-ul este obligatoriu")
    @Column(unique = true)
    private String sku;

    @NotBlank(message = "Numele produsului este obligatoriu")
    private String name;

    @NotNull(message = "Prețul este obligatoriu")
    private int price;

    @NotNull(message = "Greutatea este obligatorie")
    private int weight;

    @NotBlank(message = "Descrierea este obligatorie")
    private String description;

    @NotBlank(message = "Thumbnail-ul este obligatoriu")
    private String thumbnail;

    @NotBlank(message = "Imaginea este obligatorie")
    private String image;

//    @NotBlank(message = "Categoria este obligatorie")
    private String category;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOption> productOptions;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && weight == product.weight && Objects.equals(Id, product.Id) && Objects.equals(sku, product.sku) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(thumbnail, product.thumbnail) && Objects.equals(image, product.image) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, sku, name, price, weight, description, thumbnail, image, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

}
