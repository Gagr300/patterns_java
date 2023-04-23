public class SpicySandwich implements Sandwich {
    @Override
    public String getDescription() {
        return "Spicy";
    }
    @Override
    public int getCost() {
        return 150;
    }
}