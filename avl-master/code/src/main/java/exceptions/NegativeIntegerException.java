package exceptions;


/**
 * NegativeIntegerException.
 *
 * <p>Methods expecting non-negative integer argument throw this exception
 * they receive a negative integer value.</p>
 */
public class NegativeIntegerException extends RuntimeException {
  /**
   * Constructs a new NegativeIntegerException.
   */
  public NegativeIntegerException() {
  }

  /**
   * Constructs a new NegativeIntegerException with the specified detail message.
   *
   * @param message the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   */
  public NegativeIntegerException(String message) {
    super(message);
  }
}
