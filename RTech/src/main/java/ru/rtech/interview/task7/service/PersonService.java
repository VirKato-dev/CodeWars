package ru.rtech.interview.task7.service;

import ru.rtech.interview.task7.domain.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonService {


    /**
     * Возвращает средний индекс массы тела всех лиц мужского пола старше 18 лет
     *
     * @return
     */
    public void getAdultMaleUsersAverageBMI() {
        double totalImt = 0.0;
        long countOfPerson = 0;
        double heightInMeters = 0d;
        double imt = 0d;
        List<Person> adultPersons = new ArrayList<>();
        try {
            Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:test", "admin", "qwerty$4");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM person WHERE sex = 'male' AND age > 18");
            while (rs.next()) {
                Person p = new Person();
                //Retrieve by column name
                p.setId(rs.getLong("id"));
                p.setSex(rs.getString("sex"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getLong("age"));
                p.setWeight(rs.getLong("weight"));
                p.setHeight(rs.getLong("height"));
                adultPersons.add(p);
            }

            for (Person p : adultPersons) {
                heightInMeters = p.getHeight() / 100d;
                imt = p.getWeight() / (Double) (heightInMeters * heightInMeters);
                totalImt += imt;
            }
            countOfPerson = adultPersons.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Average imt - " + totalImt / countOfPerson);
    }
}
