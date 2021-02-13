package solution;

import exceptions.NegativeIntegerException;

public class Task {

  /**
   * Determines whether the input is even or not.
   *
   * @param num a non-negative integer
   * @return true if <pre>num</pre> is even and false otherwise.
   */
  public static boolean isEven(int num) {
    if (num < 0) {
      throw new NegativeIntegerException();
    }
    return num % 2 == 0;
  }
}
