package ro.mycode.sebionlineshop.options.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele opțiunii este obligatorie")
    @Column(name = "option_name")
    private String optionName;


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
