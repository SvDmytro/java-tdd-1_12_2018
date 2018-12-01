public class FizzBuzz {

  final static String FIZZ = "fizz";
  final static String BUZZ = "buzz";

  public String convert(int in){
    if (in % 15 == 0){
      return FIZZ + BUZZ;
    }
    if (in % 3 == 0) {
      return FIZZ;
    } else if (in % 5 == 0) {
      return BUZZ;
    }
    return String.valueOf(in);
  }
}
