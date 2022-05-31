import java.util.ArrayList;

/**
 * @PROJECT demo-Secure-Coding
 * @Author Elimane on 29/05/2022
 */
public class RegistrationController {
  public Person createPerson(String name, int age){

    if(age > 12 && age < 121){
      return new Person(name, age, new ArrayList<>());
    }
    throw new IllegalArgumentException("Age must be between 13 and 120");
  }
}
