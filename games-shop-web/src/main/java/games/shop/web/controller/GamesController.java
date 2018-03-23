package games.shop.web.controller;

import games.shop.entity.Product;
import games.shop.service.product.ProductCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GamesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final ProductCommandService productCommandService;

    @Autowired
    public GamesController(ProductCommandService productCommandService) {
        this.productCommandService = productCommandService;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model){
        LOGGER.debug("add product is executed!");
        Product product = new Product();
        model.addAttribute("product", product);
        return "productForm";
    }


    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productCommandService.createProduct(product);

        return "adminMain";
    }

    @RequestMapping(value = "/showProducts", method = RequestMethod.GET)
    public String showAllProducts(Model model){
        List<Product> products = productCommandService.showAllProducts();
        model.addAttribute("products", products);

        return "showProducts";
    }

}
