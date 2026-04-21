package ro.mycode.sebionlineshop.options.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele opțiunii este obligatorie")
    @Column(name = "option_name")
    private String optionName;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOption> productOptions;



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(id, option.id) && Objects.equals(optionName, option.optionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, optionName);
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", optionName='" + optionName + '\'' +
                '}';
    }
}
