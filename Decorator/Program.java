import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Sandwich Sandwich1 = new Cheese(new Hum(new Turkey(new SpicySandwich())));
        Sandwich Sandwich2 = new Onion(new Hum(new MushroomSandwich()));
        Sandwich Sandwich3 = new Cheese(new Hum(new BaseSandwich()));

        System.out.println(Sandwich1.getDescription() + '\t' + Sandwich1.getCost());
        System.out.println(Sandwich2.getDescription() + '\t' + Sandwich2.getCost());
        System.out.println(Sandwich3.getDescription() + '\t' + Sandwich3.getCost());

        Sandwich Sandwich4;
        Scanner in = new Scanner(System.in);
        String sndwch;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Username\\Desktop\\test.txt"));
            sndwch = reader.readLine();
            switch (sndwch.toLowerCase()){
                case "regular":
                    Sandwich4 = new BaseSandwich();
                    break;
                case "mushroom":
                    Sandwich4 = new MushroomSandwich();
                    break;
                case "spicy":
                    Sandwich4 = new SpicySandwich();
                    break;
                default:
                    System.out.println("There is no such sandwich!");
            }
        }
        catch(IOException e1) {
            System.out.println("IOException");
            //e1.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Unexcepted Exception");
            //e.printStackTrace();
        }

    }
}
