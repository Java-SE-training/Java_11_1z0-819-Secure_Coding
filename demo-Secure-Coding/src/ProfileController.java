/**
 * @PROJECT demo-Secure-Coding
 * @Author Elimane on 29/05/2022
 */
//INVARIANTS: statements that must always be true in our code
public class ProfileController {
  public Person updateProfile(Person p, int age){
    if(age >= 13){
      if(age <= 120){
        p.setAge(age);
        return p;
      }
    }
    throw new IllegalArgumentException("Age must be under 121 and over 12");
  }
}
