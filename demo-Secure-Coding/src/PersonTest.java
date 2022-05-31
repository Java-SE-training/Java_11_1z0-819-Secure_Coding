import org.junit.jupiter.api.Test;

import java.io.*;
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

  @Test
  void testEncapsulationSerialization() throws IOException, ClassNotFoundException {

    Person person = new Person("Dave", 23, new ArrayList<>());

    ByteArrayOutputStream boas = new ByteArrayOutputStream();
    try(ObjectOutputStream oos = new ObjectOutputStream(boas)){
      oos.writeObject(person);
    }
    byte[] bytes = boas.toByteArray();
    bytes[98] = 12; // sneaky ..., bytes array length must be between [155-159]

    for (int i = 0; i < 160; i++) {
      if(bytes[i] == 23)
      System.out.println(i);
    }

    try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes))){
      Person person2 = (Person) ois.readObject();
      System.out.println(person);
      System.out.println(person2);
    }
  }

}
