package rocketpowers.productstore.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Products")
public class ProductModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="code")
    private int code;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;


}
