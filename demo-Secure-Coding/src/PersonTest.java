import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;


/**
 * @PROJECT demo-Secure-Coding
 * @Author Elimane on 31/05/2022
 */
class PersonTest {

  @Test
  void testImmutability(){

    Collection<String> shirts = new ArrayList<>();
    shirts.add("green");
    shirts.add("orange");
    shirts.add("blue");

    Person p = new Person("dave", 23, shirts);
    System.out.println(p);

    shirts.add("red");
    System.out.println(p);


  }

}
