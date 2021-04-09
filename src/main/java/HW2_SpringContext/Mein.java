package HW2_SpringContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.smartcardio.CardTerminal;

public class Mein {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MeinConfig.class);

        ProductService service = context.getBean("productService", ProductService.class);
        try {
            service.addToCartById(1);
            service.addToCartById(1);
            service.addToCartById(2);
            service.addToCartById(4);
            service.deleteFromCartById(2);
            service.deleteFromCartById(1);
            service.deleteFromCartById(5);
        }catch (Exception e){
            e.printStackTrace();
        }

        //проверка второго экземпляра корзины
        Cart testCart = context.getBean("cart",Cart.class);
        System.out.print("Тестовая корзина: ");
        testCart.print();

        context.close();
    }
}
