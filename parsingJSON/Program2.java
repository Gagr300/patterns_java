import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.core.JsonParser;
import static java.lang.Math.max;

/*
На основе списка Подстригающихся в парикмахерской, считанной из файла, создать списки:

клиентов с датой рождения в следующем месяце (от текущей даты запуска приложения)
клиентов с датой рождения через две недели от текущей даты запуска приложения
клиентов с максимальным количеством посещений парикмахерской
клиентов с конкретным именем
 */

public class Program2 {
    public static void main(String[] args) throws IOException {

        List<HaircutMan> clients = new ArrayList<>();
        TreeMap<Date, List<Service>> hm0 = new TreeMap<>();
        List<Service> ls = new ArrayList<>(Arrays.asList(new Service("mask",500,"clay"), new Service("haircut",1000)));
        hm0.put( new GregorianCalendar(2019, Calendar.MARCH, 20, 15,10).getTime(), ls);
        clients.add(new HaircutMan("01","Denis",
                "Kochetkov", "Alexeevich",
                new GregorianCalendar(1997, Calendar.FEBRUARY, 11).getTime(), hm0));

        TreeMap<Date, List<Service>> hm1 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList(new Service("mask",500,"clay"), new Service("haircut",1500)));
        hm1.put( new GregorianCalendar(2023, Calendar.FEBRUARY, 1,12,0).getTime(), ls);
        ls = new ArrayList<>(Arrays.asList(new Service("mask",700,"black"), new Service("haircut",2000)));
        hm1.put( new GregorianCalendar(2023, Calendar.MARCH, 1,12,0).getTime(), ls);
        List<Service> ls1 = new ArrayList<>(Arrays.asList(new Service("mask",500,"clay"), new Service("haircut",1000)));
        clients.add(new HaircutMan("02","Danil",
                "Grishin", "Alexandrovich",
                new GregorianCalendar(2001, Calendar.JANUARY, 17).getTime(), hm1));

        TreeMap<Date, List<Service>> hm2 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList(new Service("styling",1000,"wask"), new Service("haircut",2000)));
        hm2.put(new GregorianCalendar(2023, Calendar.MARCH, 2, 15, 0).getTime(), ls);
        clients.add(new HaircutMan("03","Leonid",
                "Andreev", "Maksimovich",
                new GregorianCalendar(2001, Calendar.JULY, 5).getTime(), hm2));


        TreeMap<Date, List<Service>> hm3 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList(new Service("eyebrows",1000,"styling"), new Service("haircut",1500)));
        hm3.put( new GregorianCalendar(2023, Calendar.NOVEMBER, 10,10,30).getTime(), ls);
        clients.add(new HaircutMan("04","Igor",
                "Granat", "Olegovich",
                new GregorianCalendar(2001, Calendar.AUGUST, 2).getTime(), hm3));

        TreeMap<Date, List<Service>> hm4 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList( new Service("haircut",2000)));
        hm4.put( new GregorianCalendar(2023, Calendar.DECEMBER, 27,17,30).getTime(), ls);
        clients.add(new HaircutMan("05","Alexandr",
                "Trusov", "Pavlovich",
                new GregorianCalendar(2001, Calendar.OCTOBER, 8).getTime(), hm4));

        TreeMap<Date, List<Service>> hm5 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList( new Service("haircut",2000)));
        hm5.put( new GregorianCalendar(2022, Calendar.SEPTEMBER, 7, 75,10).getTime(), ls);
        clients.add(new HaircutMan("06","Kirill", "Alexeev", "Alexeevna",
                new GregorianCalendar(1987, Calendar.MAY, 13).getTime(), hm5));

        TreeMap<Date, List<Service>> hm6 = new TreeMap<>();

        ls = new ArrayList<>(Arrays.asList(new Service("mask",500,"clay"), new Service("haircut",2500)));
        hm6.put( new GregorianCalendar(2023, Calendar.FEBRUARY, 1,12,0).getTime(), ls);

        ls = new ArrayList<>(Arrays.asList(new Service("mask",500,"clay"), new Service("haircut",2500)));
        hm6.put( new GregorianCalendar(2023, Calendar.MARCH, 1,12,0).getTime(), ls);
        clients.add(new HaircutMan("07","Roman",
                "Golybev", "Viktorovich",
                new GregorianCalendar(1995, Calendar.JANUARY, 17).getTime(), hm6));

        TreeMap<Date, List<Service>> hm7 = new TreeMap<>();

        ls = new ArrayList<>(Arrays.asList( new Service("haircut",2500)));
        hm7.put( new GregorianCalendar(2023, Calendar.MARCH, 1,15,0).getTime(), ls);
        clients.add(new HaircutMan("08","Denis",
                "Golybev", "Viktorovich",
                new GregorianCalendar(1994, Calendar.JUNE, 14).getTime(), hm7));


        TreeMap<Date, List<Service>> hm8 = new TreeMap<>();

        ls = new ArrayList<>(Arrays.asList(new Service("styling",1000,"wask"), new Service("haircut",2500), new Service("coloring",3000, "blue iroiro")));
        hm8.put( new GregorianCalendar(2023, Calendar.MARCH, 1,16,0).getTime(), ls);
        clients.add(new HaircutMan("09","Artem",
                "Kuznetsov", "Olegonvich",
                new GregorianCalendar(1996, Calendar.MAY, 30).getTime(), hm8));

        TreeMap<Date, List<Service>> hm9 = new TreeMap<>();

        ls = new ArrayList<>(Arrays.asList(new Service("styling",1000,"wask"), new Service("haircut",2500)));
        hm9.put( new GregorianCalendar(2023, Calendar.MARCH, 1,10,0).getTime(), ls);
        clients.add(new HaircutMan("10","Ilya",
                "Frolov", "Danilovich",
                new GregorianCalendar(1998, Calendar.MAY, 25).getTime(), hm9));

        TreeMap<Date, List<Service>> hm10 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList(new Service("haircut",2500)));
        hm10.put( new GregorianCalendar(2023, Calendar.DECEMBER, 1,16,0).getTime(), ls);
        clients.add(new HaircutMan("09","Ivan",
                "Sidorov", "Vladimirovich",
                new GregorianCalendar(1999, Calendar.NOVEMBER, 30).getTime(), hm10));

        TreeMap<Date, List<Service>> hm11 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList(new Service("haircut",2500)));
        hm11.put( new GregorianCalendar(2023, Calendar.NOVEMBER, 1,10,0).getTime(), ls);
        clients.add(new HaircutMan("10","Matvey",
                "Rumyantsev", "Evgenievich",
                new GregorianCalendar(2000, Calendar.JUNE, 7).getTime(), hm11));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("clients.json"), clients);

        String result = objectMapper.writeValueAsString(clients);
        //System.out.println(result);

        byte[] jsonData = Files.readAllBytes(Paths.get("clients.json"));
        ObjectMapper mapperBack = new ObjectMapper();
        HaircutMan[] resultBack = mapperBack.readValue(jsonData, HaircutMan[].class);
        /*
        for (HaircutMan client :resultBack)
            System.out.println(client);
        */
        List<HaircutMan> ClBDayInNextMonth = new ArrayList<>();
        List<HaircutMan> ClBDayInTwoWeeks = new ArrayList<>();
        List<HaircutMan> ClMaxVisits = new ArrayList<>();
        List<HaircutMan> ClWithName = new ArrayList<>();

        Calendar calendarNext = Calendar.getInstance();
        calendarNext.add(Calendar.MONTH, 1);
        Date curDate = new Date();

        int maxVisits = 0;
        for (HaircutMan client :resultBack)
            maxVisits = max(maxVisits,client.getVisitServices().size());
        
        int finalMaxVisits = maxVisits;
        ClMaxVisits =  clients.stream()
                .filter(c -> c.getVisitServices().size() == finalMaxVisits)
                .collect(Collectors.toList());
        
        ClBDayInNextMonth =  clients.stream()
                .filter(c -> c.getBirthday().getMonth() == calendarNext.getTime().getMonth())
                .collect(Collectors.toList());
        
        ClWithName =  clients.stream()
                .filter(c -> c.getName().equals("Ilya"))
                .collect(Collectors.toList());
        
         ClBDayInTwoWeeks =  clients.stream()
                .filter(c -> check(curDate, c.getBirthday()))
                .collect(Collectors.toList());
        
        System.out.println("\nClients that have birthday in next month");
        for (HaircutMan client :ClBDayInNextMonth)
            System.out.println(client);

        System.out.println("\nClients that have birthday after two weeks");
        for (HaircutMan client :ClBDayInTwoWeeks)
            System.out.println(client);

        System.out.println("\nClients that have max number of visits");
        for (HaircutMan client :ClMaxVisits)
            System.out.println(client);

        System.out.println("\nClients that have name \"Ilya\"");
        for (HaircutMan client :ClWithName)
            System.out.println(client);

    }
    
     static public Boolean check (Date d1, Date d2){
        d1.setYear(d2.getYear());
        long diffInMillies =  d2.getTime() - d1.getTime();

        return ((int) (diffInMillies / (24 * 60 * 60 * 1000)) == 14 );
    }
}


