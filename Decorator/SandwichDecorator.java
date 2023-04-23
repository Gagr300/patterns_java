public abstract class SandwichDecorator implements Sandwich {
    protected final Sandwich sandwich;

    public SandwichDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription();
    }

    @Override
    public int getCost() {
        return sandwich.getCost();
    }
}
