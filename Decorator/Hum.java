public class Hum extends SandwichDecorator {

    public Hum(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with hum";
    }

    @Override
    public int getCost() {
        return super.getCost() + 25;
    }
}