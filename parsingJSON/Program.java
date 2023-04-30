import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.fasterxml.jackson.core.JsonParser;
public class Program {
    public static void main(String[] args) throws IOException {

        List<HaircutMan> clients = new ArrayList<>();
        TreeMap<Date, List<String>> hm0 = new TreeMap<>();
        hm0.put( new GregorianCalendar(2019, Calendar.MARCH, 20, 15,10).getTime(),
                Arrays.asList("bob","paint","washing"));
        clients.add(new HaircutMan("01","Vikrotiya", "Tihomirova", "Alexeevna",
                new GregorianCalendar(1999, Calendar.FEBRUARY, 11).getTime(), hm0));

        TreeMap<Date, List<String>> hm1 = new TreeMap<>();
        hm1.put( new GregorianCalendar(2023, Calendar.FEBRUARY, 1,12,0).getTime(),
                Arrays.asList("hairtips","paint","washing"));
        hm1.put( new GregorianCalendar(2023, Calendar.MARCH, 1,12,0).getTime(),
                Arrays.asList("hairtips","paint","washing"));
        clients.add(new HaircutMan("02","Karina", "Samoilova", "Alexandrovna",
                new GregorianCalendar(2001, Calendar.JANUARY, 17).getTime(), hm1));

        TreeMap<Date, List<String>> hm2 = new TreeMap<>();
        hm2.put( new GregorianCalendar(2023, Calendar.MARCH, 2,15,0).getTime(),
                Arrays.asList("hairtips","washing"));
        clients.add(new HaircutMan("03","Tatyana", "Petrova", "Pavlovna",
                new GregorianCalendar(2001, Calendar.JULY, 5).getTime(), hm2));


        TreeMap<Date, List<String>> hm3 = new TreeMap<>();
        hm3.put( new GregorianCalendar(2023, Calendar.NOVEMBER, 10,10,30).getTime(),
                Arrays.asList("hairtips","washing"));
        clients.add(new HaircutMan("04","Kseniya", "Granat", "Olegonva",
                new GregorianCalendar(2001, Calendar.AUGUST, 2).getTime(), hm3));

        TreeMap<Date, List<String>> hm4 = new TreeMap<>();
        hm4.put( new GregorianCalendar(2023, Calendar.DECEMBER, 27,17,30).getTime(),
                Arrays.asList("hairtips","washing"));
        clients.add(new HaircutMan("05","Polina", "Trusova", "Pavlovna",
                new GregorianCalendar(2001, Calendar.OCTOBER, 8).getTime(), hm4));

        TreeMap<Date, List<String>> hm5 = new TreeMap<>();
        hm5.put( new GregorianCalendar(2022, Calendar.SEPTEMBER, 7, 75,10).getTime(),
                Arrays.asList("bob","paint","washing"));
        clients.add(new HaircutMan("06","Anna", "Alexeeva", "Alexeevna",
                new GregorianCalendar(1987, Calendar.NOVEMBER, 13).getTime(), hm5));

        TreeMap<Date, List<String>> hm6 = new TreeMap<>();
        hm6.put( new GregorianCalendar(2023, Calendar.FEBRUARY, 1,12,0).getTime(),
                Arrays.asList("hairtips","washing"));
        hm6.put( new GregorianCalendar(2023, Calendar.MARCH, 1,12,0).getTime(),
                Arrays.asList("hairtips"));
        clients.add(new HaircutMan("07","Ekaterina", "Golybeva", "Viktorovna",
                new GregorianCalendar(2001, Calendar.JANUARY, 17).getTime(), hm6));

        TreeMap<Date, List<String>> hm7 = new TreeMap<>();
        hm7.put( new GregorianCalendar(2023, Calendar.MARCH, 1,15,0).getTime(),
                Arrays.asList("hairtips","washing"));
        clients.add(new HaircutMan("08","Alina", "Golybeva", "Viktorovna",
                new GregorianCalendar(2000, Calendar.JUNE, 14).getTime(), hm7));


        TreeMap<Date, List<String>> hm8 = new TreeMap<>();
        hm8.put( new GregorianCalendar(2023, Calendar.MARCH, 1,16,0).getTime(),
                Arrays.asList("hairtips","washing"));
        clients.add(new HaircutMan("09","Alena", "Granat", "Olegonva",
                new GregorianCalendar(2001, Calendar.MARCH, 5).getTime(), hm8));

        TreeMap<Date, List<String>> hm9 = new TreeMap<>();
        hm9.put( new GregorianCalendar(2023, Calendar.MARCH, 1,10,0).getTime(),
                Arrays.asList("hairtips"));
        clients.add(new HaircutMan("10","Olesya", "Trusova", "Pavlovna",
                new GregorianCalendar(2001, Calendar.MAY, 25).getTime(), hm9));

        TreeMap<Date, List<String>> hm10 = new TreeMap<>();
        hm10.put( new GregorianCalendar(2023, Calendar.DECEMBER, 1,16,0).getTime(),
                Arrays.asList("hairtips","washing"));
        clients.add(new HaircutMan("09","Alena", "Granat", "Olegonva",
                new GregorianCalendar(2001, Calendar.NOVEMBER, 30).getTime(), hm10));

        TreeMap<Date, List<String>> hm11 = new TreeMap<>();
        hm11.put( new GregorianCalendar(2023, Calendar.NOVEMBER, 1,10,0).getTime(),
                Arrays.asList("hairtips"));
        clients.add(new HaircutMan("10","Olesya", "Trusova", "Pavlovna",
                new GregorianCalendar(2001, Calendar.OCTOBER, 7).getTime(), hm11));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("clients.json"), clients);

        String result = objectMapper.writeValueAsString(clients);
        System.out.println(result);

        byte[] jsonData = Files.readAllBytes(Paths.get("clients.json"));
        ObjectMapper mapperBack = new ObjectMapper();
        HaircutMan[] resultBack = mapperBack.readValue(jsonData, HaircutMan[].class);
        for (HaircutMan client :resultBack)
            System.out.println(client);
    }


}
