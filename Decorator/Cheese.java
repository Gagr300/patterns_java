public class Cheese extends SandwichDecorator {

    public Cheese(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with cheese";
    }

    @Override
    public int getCost() {
        return super.getCost() + 15;
    }
}