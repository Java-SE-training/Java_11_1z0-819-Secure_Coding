import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;


/**
 * @PROJECT demo-Secure-Coding
 * @Author Elimane on 31/05/2022
 */
class PersonTest {

  @Test
  void testImmutability() throws CloneNotSupportedException {

    Collection<String> shirts = new ArrayList<>();
    shirts.add("green");
    shirts.add("orange");
    shirts.add("blue");

    Person p = new Person("dave", 23, shirts);
    Person p2 = p.clone();
    System.out.println(p2);

    //"addShirt" is making p variant by modifying it
    p.addShirt("red");
    System.out.println(p);

    // p2 is invariant
    System.out.println(p2);


  }

}
