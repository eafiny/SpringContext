package HW2_SpringContext;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
               new Product(0L, "OurProduct1", (int)(Math.random()*1000)),
               new Product(1L, "OurProduct2", (int)(Math.random()*1000)),
               new Product(2L, "OurProduct3", (int)(Math.random()*1000)),
               new Product(3L, "OurProduct4", (int)(Math.random()*1000)),
               new Product(4L, "OurProduct5", (int)(Math.random()*1000))

        ));
    }

    public List<Product> getProducts(){return products;}

    public Product getProductById(long id) {return products.get((int) id);}
}
