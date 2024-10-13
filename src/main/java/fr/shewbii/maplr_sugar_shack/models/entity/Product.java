package fr.shewbii.maplr_sugar_shack.models.entity;

import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String image;

    private Double price;

    private Integer stock;

    @Enumerated(EnumType.STRING)
    private SyrupTypeEnum type;

    public Product() {
    }

    public Product(Integer id, String name, String description, String image, Double price, Integer stock, SyrupTypeEnum type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public SyrupTypeEnum getType() {
        return type;
    }

    public void setType(SyrupTypeEnum type) {
        this.type = type;
    }
}
