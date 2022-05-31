import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * @PROJECT demo-Secure-Coding
 * @Author Elimane on 29/05/2022
 */
@Setter
@Getter
@ToString
public class Person {
 //--------------------------------------------------------------------------------------------
 //To make sure that there is no malicious characters in the name
  //private static final Pattern BLOCKLIST = Pattern.compile("<>\\(\\)\\[\\]\\\\/\\s\\$");
  private static final Pattern ALLOWLIST = Pattern.compile("[A-Za-z'\\-]+");
//--------------------------------------------------------------------------------------------


  private  String name;
  private  int age;
  //Making immutable collection
  private final Collection<String> shirts;

  public Person(String name, int age, Collection<String> shirts) {
    //The constructor is a good place to enforce invariants
    //In that case "age" is an invariant
    if(age < 13){
      throw new IllegalArgumentException("Invalid age");
    }
    if(age > 120){
      throw new IllegalArgumentException("Invalid age");
    }
    if(!(age >= 13 && age <= 120)){
      throw new IllegalArgumentException("Invalid age");
    }
    if(!ALLOWLIST.matcher(name).matches()){
      throw new IllegalArgumentException("Invalid name");
    }

    this.name = name;
    this.age = age;

    //Making "shirts" collection immutable(Cannot be modified after "Person" instantiation)
    this.shirts = new ArrayList<>(shirts);

    //Making "shirts" collection mutable(Can be modified after "Person" instantiation)
    //this.shirts = shirts;
  }
  public boolean mayDriveACar(){
    return this.age >= 16;
  }
  Integer getShirtCount(){
    return shirts.size();
  }
  Iterator<String> getShirts(){
    return shirts.iterator();
  }

  Collection<String> getShirtCollection(){
    return Collections.unmodifiableCollection(this.shirts);
  }

}
