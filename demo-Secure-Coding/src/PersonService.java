import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @PROJECT demo-Secure-Coding
 * @Author Elimane on 31/05/2022
 */
public class PersonService {

  private final Map<String, Person> people = new HashMap<>();


  public Person addPerson(String name, int age, Collection<String> shirts){
    return this.people.computeIfAbsent(name, (k) -> new Person(name, age, shirts));
  }

  public Person removePerson(String name){
    return this.people.remove(name);
  }

  public boolean mayPersonDrive(Person person){
      return this.people.get(person.getName()).getAge() >= 16;
  }

}
