package HW2_SpringContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private Map<Product, Integer> cartProducts;
    private ProductRepository productRepository;

    @Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        cartProducts = new HashMap<>();
    }


    public void addInCartById(long id){
        boolean flag = false;
        for (Product p: cartProducts.keySet()){
            if (p.getId() == (int)id) {
                cartProducts.put(p, cartProducts.get(p) + 1);
                flag = true;
            }
        }
        if(!flag){
            cartProducts.put(productRepository.getProductById(id), 1);
        }
    }

    public boolean deleteProductById (long id){
        for (Product p: cartProducts.keySet()){
            if (p.getId() == (int)id) {
                cartProducts.remove(p);
                return true;
            }
        }
        return false;
    }

    public void print(){
        System.out.println("Товары в корзине:");
        if (cartProducts.isEmpty()) {
            System.out.println("Корзина пуста");
        }else {
            cartProducts.forEach((key, value) -> {
                System.out.println(key.toString() + " - " + value + "шт.");
            });
        }
    }
}
