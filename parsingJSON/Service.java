import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public class Service{
    private String name;
    private String description;
    private int cost;
    public Service (){ }
    public Service (String name, int cost){
        this.name = name;
        this.cost = cost;
    }
    public Service (String name, int cost, String description){
        this.name = name;
        this.cost = cost;
        this.description=description;
    }
    public String getName(){return name;}

    public int getCost(){return cost;}

    public void setCost(int cost){this.cost = cost;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

}
