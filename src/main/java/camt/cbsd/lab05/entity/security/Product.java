package camt.cbsd.lab05.entity.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String productId;
    String name;
    String image;
    double price;
    int stock;
    int selected;
    String description;

    @ManyToMany
    List<Cart> carts;
}
