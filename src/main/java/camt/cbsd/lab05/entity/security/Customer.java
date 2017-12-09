package camt.cbsd.lab05.entity.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String customerId;
    String username;
    String phonenumber;
    String email;

    @OneToMany(mappedBy = "customer")
    List<Cart> carts;

}
