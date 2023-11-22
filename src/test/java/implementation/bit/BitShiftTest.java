package implementation.bit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * <u>why does java not have unsigned left shift operator?</u>
 *
 * <p>
 * In Java, all integer types, including byte, short, int, and long, are signed.
 * This means that they use a bit to represent the sign of the number (positive or negative) using two's complement representation.
 * In a signed left shift operation (<<), the sign bit is shifted along with the other bits.
 *
 * <p>
 * If Java were to introduce an unsigned left shift operator (<<<),
 * it would need to interpret the bits as an unsigned value, disregarding the sign bit.
 * However, since Java's primitive integer types are signed,
 * introducing an unsigned left shift operator would go against the language's design choice of treating these types as signed.
 */
class BitShiftTest {

  /**
   * <pre>{@code
   * Integer.toBinaryString(Integer.MAX_VALUE)
   * 01111111111111111111111111111111
   *
   * fill zero to blank
   * 111111111111111111111111111111[]
   *
   * after right shift
   * 11111111111111111111111111111110
   * }</pre>
   */
  @Test
  void signedShiftLeftIfPositive() {
    // given
    int toBeShifted = Integer.MAX_VALUE;

    // when
    toBeShifted <<= 1;

    // then
    assertThat(toBeShifted).isEqualTo(-2);
  }

  /**
   * <pre>{@code
   * Integer.toBinaryString(-1)
   * 11111111111111111111111111111111
   *
   * fill zero to blank
   * 111111111111111111111111111111[]
   *
   * after right shift
   * 11111111111111111111111111111110
   * }</pre>
   */
  @Test
  void signedShiftLeftIfNegative() {
    // given
    int toBeShifted = -2;

    // when
    toBeShifted <<= 1;

    // then
    assertThat(toBeShifted).isEqualTo(-4);
  }

  @Test
  void signedShiftRightIfPositive() {
    // given
    int positive = 0;

    // when
    positive >>= 1;

    // then
    assertThat(positive).isEqualTo(0);
  }

  /**
   * <pre>{@code
   * Integer.toBinaryString(-1)
   * 11111111111111111111111111111111
   *
   * fill zero to blank
   * []111111111111111111111111111111
   *
   * after right shift
   * 11111111111111111111111111111111
   * }</pre>
   */
  @Test
  void signedShiftRightIfNegative() {
    // given
    int negative = -1;

    // when
    negative >>= 1;

    // then
    assertThat(negative).isEqualTo(-1);
  }

  /**
   * <pre>{@code
   * Integer.toBinaryString(-2)
   * 11111111111111111111111111111110
   *
   * fill zero to blank
   * []111111111111111111111111111111
   *
   * after right shift
   * 01111111111111111111111111111111
   * }</pre>
   */
  @Test
  void unsignedShiftRight() {
    // given
    int toBeShifted = -1;

    // when
    toBeShifted >>>= 1;

    // then
    assertThat(toBeShifted).isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  void countBits() {
    // given, when
    int counted = countBits(7);

    // then
    assertThat(counted).isEqualTo(3);
  }

  private static int countBits(int x) {
    int sum = 0;
    while (x != 0) {
      sum += x & 1;
      x >>>= 1;
    }
    return sum;
  }
}
