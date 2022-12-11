package dao_.BadicDao_;

import com.google.gson.Gson;
import dao_.Domain.Person;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class test {
    public static void main(String[] args) {
        Person person = new Person(1, "datou");
        Gson gson = new Gson();
        String s = gson.toJson(person);
//        System.out.println(s);
        Person person1 = gson.fromJson(s, Person.class);
//        System.out.println(person1);

        LinkedHashMap<Integer, Person> integers = new LinkedHashMap<Integer, Person>();
        integers.put(1, new Person(1, "datou1"));
        integers.put(2, new Person(2, "wanggoui"));
        Gson gson1 = new Gson();
        String s1 = gson1.toJson(integers);
        System.out.println(s1);
        LinkedHashMap<Integer, Person> o = gson1.fromJson(s1, new PersonTypeToken().getType());
        System.out.println(o);

    }
}
interface A{

}

