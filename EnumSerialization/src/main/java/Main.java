import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class Main {
    static class Person{
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        public String name;
        public int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> hello = Arrays.asList(new Person("John", 21), new Person("Poep", 25));
        System.out.println(hello);
        Person pers = hello.get(0);
        pers.name = "IChangedLulz";
        System.out.println(hello);


//        Person person = new Person();
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        String jsonText = "";
//        try{
//            jsonText = mapper.writeValueAsString(person);
//        } catch (JsonProcessingException e){
//            e.printStackTrace();
//        }
//
//        Person person2 = new Person();
//
//        try{
//            person2 = mapper.readValue(jsonText, Person.class);
//        } catch (JsonProcessingException e){
//            e.printStackTrace();
//        }
//
//        System.out.println(person2);
//        System.out.println(jsonText);
    }
}

class Person{
    public Description description;
    public String name;

    public Person(){
        this.description = Description.PERMANENT;
        this.name = "Timon";
    }
}
