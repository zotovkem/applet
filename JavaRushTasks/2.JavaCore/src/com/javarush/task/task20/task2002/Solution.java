package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
            User user1 = new User();
            user1.setFirstName("Joni");
            user1.setLastName("Zotov");
            user1.setBirthDate(new Date(86,7,31));
            user1.setCountry(User.Country.RUSSIA);
            user1.setMale(true);
            User user2 = new User();
            user2.setFirstName("An");
            user2.setLastName("Zotova");
            user2.setBirthDate(new Date(85,8,4));
            user2.setCountry(User.Country.UKRAINE);
            user2.setMale(false);

//            javaRush.users.add(user1);
//            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (loadedObject.equals(javaRush))
                System.out.println("равны");
            else
                System.out.println("не равны");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(this.hashCode());
            writer.println(this.users.size() > 0 ? "usersIsEmpty=true" : "usersIsEmpty=false");
            if (this.users.size() > 0) {
                for (User user :
                        this.users) {
                    if (user != null) {
                        writer.println(user.getBirthDate().getTime() + ";" + user.getCountry() + ";" + user.getFirstName() + ";" +
                                user.getLastName() + ";" + (user.isMale() ? "true" : "false"));
                    }
                }
                writer.println("endUsers");
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.ready()) {
                reader.readLine();
                if (reader.readLine().equals("usersIsEmpty=true")) {
                    String str;
                    while (!(str = reader.readLine()).equals("endUsers")) {
                        User user = new User();
                        String arrStr[] = str.split(";");
                        user.setBirthDate(new Date(Integer.parseInt(arrStr[0])));
                        user.setCountry(User.Country.valueOf(arrStr[1]));
                        user.setFirstName(arrStr[2]);
                        user.setLastName(arrStr[3]);
                        user.setMale(Boolean.parseBoolean(arrStr[4]));
                        this.users.add(user);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
