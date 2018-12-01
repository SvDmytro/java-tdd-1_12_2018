import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

  private FizzBuzz fizzBuzz;

  @Before
  public void setUp() {
    fizzBuzz = new FizzBuzz();
  }

  @Test
  public void ifInputIsOneShouldReturnOne() {
    String result = fizzBuzz.convert(1);

    assertEquals("not return 1", "1", result);
  }

  @Test
  public void ifInputIs3ShouldReturnFizz() {
    String result = fizzBuzz.convert(3);

    assertEquals("not return fizz", "fizz", result);
  }

  @Test
  public void ifInputIs5ShouldReturnBuzz() {
    String result = fizzBuzz.convert(5);

    assertEquals("not return buzz", "buzz", result);
  }

  @Test
  public void ifInputIs15ShouldReturnFizzBuzz() {
    String result = fizzBuzz.convert(15);

    assertEquals("not return fizzbuzz", "fizzbuzz", result);
  }

}
