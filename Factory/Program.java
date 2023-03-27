import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        BurgerFactory factory = new BurgerFactory();

        Burger brgr = factory.getBurger("Cheeseburger");
        brgr.add();
        brgr = factory.getBurger("DoubleCheeseburger");
        brgr.add();

        List<Burger> order = new ArrayList<>();
        order.add(factory.getBurger("Hamburger"));
        order.add(factory.getBurger("Cheeseburger"));
        order.add(factory.getBurger("DoubleCheeseburger"));
        for (Burger t : order) {
            t.add();
        }
    }
}
