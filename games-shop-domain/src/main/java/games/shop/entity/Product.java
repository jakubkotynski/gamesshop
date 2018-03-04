package games.shop.entity;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private Long version;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
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
