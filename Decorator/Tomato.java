public class Tomato extends SandwichDecorator {

    public Tomato(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with tomato";
    }

    @Override
    public int getCost() {
        return super.getCost() + 15;
    }
}