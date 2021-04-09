package HW2_SpringContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ProductService {
    private ProductRepository productRepository;
    private Cart cart;

    @Autowired
    public ProductService(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public void addToCartById(long id){
        cart.addInCartById(id);
        cart.print();
    }

    public void deleteFromCartById(long id){
        if (!cart.deleteProductById(id)){
            throw  new NoSuchElementException("Товара с id " + id + " нет в корзине.");
        } else cart.print();
    }
}
