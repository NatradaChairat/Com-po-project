package camt.cbsd.lab05.entity.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shopkeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String shopkeeperId;
    String firstname;
    String lastname;
    String email;
}
