package games.shop.entity;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Audited
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "LATEST_VERSION")
    private Long version;

    @NotEmpty
    @Column(name = "PRODUCT_NAME")
    private String name;

    @NotEmpty
    @Column(name = "DESCRIPTION")
    private String description;

    @NotEmpty
    @Column(name = "CATEGORY")
    private String category;

    @NotEmpty
    @Column(name = "PRICE")
    private BigDecimal price;

    @NotEmpty
    @Column(name = "UNITS_IN_STOCK")
    private int unitsInStock;

    public Product() {
    }

    public Product(String name, String description, String category, BigDecimal price, int unitsInStock) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.unitsInStock = unitsInStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
}
