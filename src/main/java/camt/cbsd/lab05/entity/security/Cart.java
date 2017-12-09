package camt.cbsd.lab05.entity.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String cardId;

    LocalDateTime dateTime;

    @ManyToOne
    Customer customer;

    @ManyToMany(mappedBy = "carts")
    List<Product> products;
}
