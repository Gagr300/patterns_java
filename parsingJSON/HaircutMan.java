import com.fasterxml.jackson.annotation.JsonCreator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.*;
import java.util.stream.Stream;

public class HaircutMan
{
    private String ID;
    private String name, surname, patronymic;
    private Date birthday;
    private TreeMap<Date, List<Service>> visitServices;

    public HaircutMan(){}
    public HaircutMan (String ID, String name, String surname, String patronymic,
                       Date birthday, TreeMap<Date, List<Service>> visitServices){
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.visitServices = visitServices;
    }
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public Date getBirthday(){
        return birthday;
    }
    public TreeMap getVisitServices(){
        return visitServices;
    }

    public void setID(String ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public void addVisit(Date date,List<Service> services){
        visitServices.put(date, services);
    }

    public String toString() {
        return "HaircutMan{" +
                "id='" + ID + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic=" + patronymic + '\'' +
                ", birthday=" + birthday + '\'' +
                ", visitServices=" + visitServices.keySet() + '\'' +
                '}';
    }
}
