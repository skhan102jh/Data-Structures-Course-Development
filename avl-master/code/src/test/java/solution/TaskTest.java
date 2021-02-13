package solution;

import exceptions.NegativeIntegerException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("CheckStyle")
public class TaskTest {

  // To switch between starter and solution
  static final boolean DEBUG = false;

  private boolean isEven(int num) {
    if (DEBUG) {
      return starter.Task.isEven(num); // uses sln.Task.isEven
    } else {
      return Task.isEven(num);
    }
  }

  @Test
  public void worksForEvenInput() {
    assertTrue(isEven(4));
  }

  @Test
  public void worksForOddInput() {
    assertFalse(isEven(5));
  }

  @Test
  public void worksForZero() {
    assertTrue(isEven(0));
  }

  @Test(expected = NegativeIntegerException.class)
  public void handlesInvalidInput() {
    isEven(-2);
  }
}