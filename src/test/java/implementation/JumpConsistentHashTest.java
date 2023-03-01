package implementation;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:serafin.sedano@gmail.com">Serafin Sedano</a>
 */
class JumpConsistentHashTest {

  @Test
  public void hashInRange() {
    int bucket = JumpConsistentHash.jumpConsistentHash(ThreadLocalRandom.current().nextLong(), 10);

    assertThat(
      "Expected bucket in range [0, 10) but was " + bucket,
      bucket > -1 && bucket < 10);
  }

  @Test
  public void negativeBucketsEqualsMinusOne() {
    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> JumpConsistentHash.jumpConsistentHash(1L, -1));
  }

  @Test
  public void hashInRangeForObject() {
    int bucket = JumpConsistentHash.jumpConsistentHash(new Object(), 10);

    assertThat(
      "Expected bucket in range [0, 10) but was " + bucket,
      bucket > -1 && bucket < 10
    );
  }

  @Test
  public void negativeBucketsEqualsMinusOnForObject() {
    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> JumpConsistentHash.jumpConsistentHash(new Object(), -1));
  }

  @Test
  public void assignsToSameBucket() {
    int bucket1 = JumpConsistentHash.jumpConsistentHash(1L, 10);
    int bucket2 = JumpConsistentHash.jumpConsistentHash(1L, 11);

    assertEquals(bucket1, bucket2);
  }

  @Test
  public void assignsObjectToSameBucket() {
    int bucket1 = JumpConsistentHash.jumpConsistentHash("object", 117);
    int bucket2 = JumpConsistentHash.jumpConsistentHash("object", 118);

    assertEquals(bucket1, bucket2);
  }

  /**
   * Paper states a standar error of 0.00000000764 and (0.99999998, 1.00000002) 99% confidence interval.
   */
  @Test
  public void keyDistribution() {
    Map<Integer, Integer> sizes = new TreeMap<>();

    ThreadLocalRandom r = ThreadLocalRandom.current();
    int keys = 100_000;
    int buckets = 10;

    for (int i = 0; i < keys; i++) {
      int b = JumpConsistentHash.jumpConsistentHash(r.nextInt(keys), buckets);
      sizes.compute(b, (k, v) -> v == null ? 0 : v + 1);
    }
    assertEquals(buckets, sizes.size());
    IntSummaryStatistics stats = sizes.values().stream()
      .mapToInt(i -> i)
      .summaryStatistics();

    double percent99 = (double) keys / (double) buckets * 0.01d;

    assertThat(
      "Expected over 99% avg (" + percent99 + ") but was " + stats.getAverage(),
      stats.getAverage() > percent99
    );
  }
}