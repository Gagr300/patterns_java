
public class Program {
    public static void main(String[] args) {
        Sandwich Sandwich1 = new Cheese(new Hum(new Turkey(new SpicySandwich())));
        Sandwich Sandwich2 = new Onion(new Hum(new MushroomSandwich()));
        Sandwich Sandwich3 = new Cheese(new Hum(new BaseSandwich()));

        System.out.println(Sandwich1.getDescription() + '\t' + Sandwich1.getCost());
        System.out.println(Sandwich2.getDescription() + '\t' + Sandwich2.getCost());
        System.out.println(Sandwich3.getDescription() + '\t' + Sandwich3.getCost());
    }
}
