public class Onion extends SandwichDecorator {

    public Onion(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with onion";
    }

    @Override
    public int getCost() {
        return super.getCost() + 5;
    }
}