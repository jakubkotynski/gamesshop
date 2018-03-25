package games.shop.service.product;

import games.shop.entity.Product;
import games.shop.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCommandService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductCommandService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long createProduct(Product product){
        productRepository.save(product);

        return product.getId();
    }

    public void updateProduct(Product product){
        Product dbProduct = productRepository.findOne(product.getId());
        if(product.getId() == null){
            LOGGER.debug("Produkt nie widnieje w bazie danych");
        } else {
            dbProduct.setName(product.getName());
            dbProduct.setCategory(product.getCategory());
            dbProduct.setPrice(product.getPrice());
            dbProduct.setDescription(product.getDescription());
            dbProduct.setUnitsInStock(product.getUnitsInStock());
        }
    }

    public int productCount(){
        return productRepository.findAll().size();
    }

    public List<Product> showAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long id){
        productRepository.delete(id);
    }

    public Product findProductById(Long id){
        return productRepository.findOne(id);
    }

}
