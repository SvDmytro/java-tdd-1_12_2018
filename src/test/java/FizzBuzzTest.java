import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

  @Test
  public void ifInputIsOneShouldReturnOne() {
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.convert(1);

    assertEquals("not return 1", "1", result);
  }
}
