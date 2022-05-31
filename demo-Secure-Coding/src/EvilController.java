import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * @PROJECT demo-Secure-Coding
 * @Author Elimane on 29/05/2022
 */
public class EvilController {
  public Person updateAgeMaliciously(Person p){
    // This will fail because we applied
    // Security best practices on "Person" class
    return new Person("evil", 12, new ArrayList<>());
  }

  private static class BadPerson extends Person{

    public BadPerson(String name, int age) {
      super(name, age, new ArrayList<>());
    }

    @Override
    public boolean mayDriveACar() {
      return new SecureRandom().nextBoolean();
    }
  }

}
