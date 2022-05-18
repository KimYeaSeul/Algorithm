import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitTest {
  
  @Test
  public void test(){
    double expected = 1.0;
    double actual = 1.0;
    double delta = 2.0;
    assertEquals(expected, actual, delta);
  }
}