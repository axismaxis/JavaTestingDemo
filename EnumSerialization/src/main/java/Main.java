import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        ObjectMapper mapper = new ObjectMapper();

        String jsonText = "";
        try{
            jsonText = mapper.writeValueAsString(person);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        Person person2 = new Person();

        try{
            person2 = mapper.readValue(jsonText, Person.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        System.out.println(person2);
        System.out.println(jsonText);
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
