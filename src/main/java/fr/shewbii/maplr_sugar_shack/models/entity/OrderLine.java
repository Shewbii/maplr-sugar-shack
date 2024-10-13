package fr.shewbii.maplr_sugar_shack.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_lines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_lines_id_seq")
    @SequenceGenerator(name = "order_lines_id_seq", sequenceName = "order_lines_id_seq")
    private Integer id;

    private Integer quantity = 0;

    @ManyToOne
    private Product product;

    public OrderLine() {
    }

    public OrderLine(Integer id, Integer quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
