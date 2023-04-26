import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.max;

public class Program {
    public static void main(String[] args) {
        IDetail detail = new Motherboard("05015");
        Computer pc = new PC(detail, "John Stevens");

        pc.getDetail();
        pc.assemble();
        pc.printDetails();;


    }
}

interface IDetail {
    public String getDescription();
    public void get();
}


class VideoCard implements IDetail{
    private String description;

    public VideoCard(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void get() {
        System.out.println("Getting VideoCard");
    }
}

class Motherboard implements IDetail{
    private String description;

    public Motherboard(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void get() {
        System.out.println("Getting Motherboard");
    }
}

abstract class Computer {

    private IDetail detail;
    private String computerType;

    public Computer(IDetail detail, String computerType){
        this.detail = detail;
        this.computerType = computerType;
    }

    public abstract void assemble();
    public abstract void getDetail();

    public void printDetails(){
        System.out.println("Computer: "+computerType+", Detail:"+detail.getDescription());
    }
}

class PC extends Computer{

    private IDetail detail;
    private String computerType;
    public PC(IDetail detail, String computerType){
        super(detail, computerType);
        this.detail = detail;
        this.computerType = computerType;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling " + detail.getDescription() + " for " + computerType);
    }
    @Override
    public void getDetail() {
        detail.get();
        System.out.println("Getting "+detail.getDescription()+" for " + computerType);
    }

}
