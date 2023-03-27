public class Program {
    public static void main(String[] args) {
        BurgerFactory factory = new BurgerFactory();
 
        Burger brgr = factory.getBurger("Cheeseburger");
        brgr.perform();
        brgr = factory.getBurger("DoubleCheeseburger");
        brgr.perform();
      
       List<Burger> order = new ArrayList<>();
       order.add(factory.getBurger("Hamburger"));
    }
}
