public class FizzBuzz {

  public String convert(int in){
    if (in % 3 == 0) {
      return "fizz";
    } else if (in % 5 == 0) {
      return "buzz";
    }
    return String.valueOf(in);
  }
}
