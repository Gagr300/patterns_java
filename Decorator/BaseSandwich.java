
public class BaseSandwich implements Sandwich {
    @Override
    public String getDescription() {
        return "Regular";
    }
    @Override
    public int getCost() {
        return 100;
    }
}
