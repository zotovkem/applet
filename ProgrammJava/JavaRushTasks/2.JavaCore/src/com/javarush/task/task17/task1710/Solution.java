package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Person person = null;
        SimpleDateFormat readDateFormater = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        SimpleDateFormat writeDateFormater = new SimpleDateFormat("dd/MM/yyyy");

            String operationParam = args[0];
            Integer idPerson = null;
            String namePerson = "";
            Sex sexPerson = Sex.MALE;
            Date birthDayPerson = null;
        try {
            if (operationParam.equals("-c")) {
                namePerson = args[1];
                sexPerson = args[2].equals("м") ? Sex.MALE : Sex.FEMALE;
                birthDayPerson = writeDateFormater.parse(args[3]);
            }
            else
                idPerson = Integer.parseInt(args[1]);
                if (operationParam.equals("-u")) {
                    namePerson = args[2];
                    sexPerson = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                    birthDayPerson = writeDateFormater.parse(args[4]);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (operationParam.equals("-i")) {
            person = allPeople.get(idPerson);
            System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + readDateFormater.format(person.getBirthDay()));
        } else if (operationParam.equals("-c")) {
            person = (sexPerson.equals(Sex.MALE) ? Person.createMale(namePerson, birthDayPerson) : Person.createFemale(namePerson, birthDayPerson));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if (operationParam.equals("-d")) {
            person = Person.createFemale(null, null);
            person.setSex(null);
            allPeople.set(idPerson, person);
        } else if (operationParam.equals("-u")) {
            person = allPeople.get(idPerson);
            person.setName(namePerson);
            person.setSex(sexPerson);
            person.setBirthDay(birthDayPerson);
            allPeople.set(idPerson, person);
        }
    }
}
