public class BurgerFactory {
    public Burger getBurger(String burger) {
        switch (burger.toLowerCase()) {
            case "cheeseburger":
                return new Cheeseburger();
            case "doublecheeseburger":
                return new DoubleCheeseburger();
            case "hamburger":
                return new Hamburger();
            default:
                return null;
        }
    }
}
