package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public volatile static  List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Person person = null;
        SimpleDateFormat readDateFormater = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        SimpleDateFormat writeDateFormater = new SimpleDateFormat("dd/MM/yyyy");

        char operationParam = args[0].charAt(args[0].length()-1);
        Integer idPerson = null;
        String namePerson = "";
        Sex sexPerson = Sex.MALE;
        Date birthDayPerson = null;
        try {
            for (int i = 1; i < args.length; ) {
                if (operationParam != 'c') {
                    idPerson = Integer.parseInt(args[i++]);
                }

                if (operationParam == 'c' || operationParam == 'u') {
                    namePerson = args[i++];
                    sexPerson = args[i++].equals("м") ? Sex.MALE : Sex.FEMALE;
                    birthDayPerson = writeDateFormater.parse(args[i++]);
                }

                switch (args[0]) {
                    case "-c": synchronized (allPeople){
                        person = (sexPerson.equals(Sex.MALE) ? Person.createMale(namePerson, birthDayPerson) : Person.createFemale(namePerson, birthDayPerson));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                        break;
                    }
                    case "-u": synchronized (allPeople){
                        person = allPeople.get(idPerson);
                        person.setName(namePerson);
                        person.setSex(sexPerson);
                        person.setBirthDay(birthDayPerson);
                        allPeople.set(idPerson, person);
                        break;
                    }
                    case "-i": synchronized (allPeople){
                        person = allPeople.get(idPerson);
                        System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + readDateFormater.format(person.getBirthDay()));
                        break;
                    }
                    case "-d": synchronized (allPeople){
                        person = Person.createFemale(null, null);
                        person.setSex(null);
                        allPeople.set(idPerson, person);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
