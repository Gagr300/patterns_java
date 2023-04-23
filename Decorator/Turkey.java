public class Turkey extends SandwichDecorator {

    public Turkey(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with turkey";
    }

    @Override
    public int getCost() {
        return super.getCost() + 35;
    }
}