package benchmark;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Threads(5)
@Fork(2)
public class LoopUnrollingCounter {

  private static final int MAX = 1_000_000;
  private static final long[] DATA = new long[MAX];

  @Setup
  public void createDate() {
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < MAX; i++) {
      DATA[i] = random.nextLong();
    }
  }

  @Benchmark
  public long intStride1() {
    long sum = 0;
    for (int i = 0; i < MAX; i++) {
      sum += DATA[i];
    }
    return sum;
  }

  @Benchmark
  public long longStride1() {
    long sum = 0;
    for (long i = 0; i < MAX; i++) {
      sum += DATA[(int) i];
    }
    return sum;
  }
}

/*
jdk8
Benchmark                          Mode  Cnt     Score     Error  Units
LoopUnrollingCounter.intStride1   thrpt   25  3013.608 ± 159.598  ops/s
LoopUnrollingCounter.longStride1  thrpt   25  1482.954 ± 120.510  ops/s

jdk11
Benchmark                          Mode  Cnt     Score     Error  Units
LoopUnrollingCounter.intStride1   thrpt   10  14158.090 ± 1832.970  ops/s
LoopUnrollingCounter.longStride1  thrpt   10   7008.386 ±  346.639  ops/s

jdk11 - graalvm
Benchmark                          Mode  Cnt     Score     Error  Units
LoopUnrollingCounter.intStride1   thrpt   10  14765.411 ± 593.933  ops/s
LoopUnrollingCounter.longStride1  thrpt   10   8033.640 ± 249.375  ops/s

jdk17
Benchmark                          Mode  Cnt      Score     Error  Units
LoopUnrollingCounter.intStride1   thrpt   10  14376.659 ± 974.476  ops/s
LoopUnrollingCounter.longStride1  thrpt   10   9698.815 ± 292.565  ops/s

# JMH version: 1.23
# VM version: JDK 1.8.0_352, OpenJDK 64-Bit Server VM, 25.352-b08
# VM invoker: /Library/Java/JavaVirtualMachines/azul-1.8.0_352/Contents/Home/jre/bin/java
# VM options: -javaagent:IntelliJ IDEA 2022.3 EAP.app
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.rsupport.rv5x.core.jmh.LoopUnrollingCounter.intStride1
# Benchmark: com.rsupport.rv5x.core.jmh.LoopUnrollingCounter.longStride1

# Run complete. Total time: 00:16:53
Benchmark                          Mode  Cnt     Score     Error  Units
LoopUnrollingCounter.intStride1   thrpt   25  3013.608 ± 159.598  ops/s
LoopUnrollingCounter.longStride1  thrpt   25  1482.954 ± 120.510  ops/s

# JMH version: 1.36
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/bin/java
# VM options: -javaagent:IntelliJ IDEA 2022.3 EAP.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 5 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: benchmark.LoopUnrollingCounter.intStride1

# Run progress: 0.00% complete, ETA 00:05:20
# Fork: 1 of 2
# Warmup Iteration   1: 14919.086 ops/s
# Warmup Iteration   2: 15194.015 ops/s
# Warmup Iteration   3: 15200.396 ops/s
Iteration   1: 15152.412 ops/s
Iteration   2: 14942.119 ops/s
Iteration   3: 10950.561 ops/s
Iteration   4: 14293.217 ops/s
Iteration   5: 13954.018 ops/s

# Run progress: 25.00% complete, ETA 00:04:11
# Fork: 2 of 2
# Warmup Iteration   1: 13940.454 ops/s
# Warmup Iteration   2: 14957.865 ops/s
# Warmup Iteration   3: 14865.815 ops/s
Iteration   1: 13997.803 ops/s
Iteration   2: 14752.423 ops/s
Iteration   3: 14849.889 ops/s
Iteration   4: 14763.045 ops/s
Iteration   5: 13925.412 ops/s


Result "benchmark.LoopUnrollingCounter.intStride1":
  14158.090 ±(99.9%) 1832.970 ops/s [Average]
  (min, avg, max) = (10950.561, 14158.090, 15152.412), stdev = 1212.396
  CI (99.9%): [12325.120, 15991.060] (assumes normal distribution)


# JMH version: 1.36
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/bin/java
# VM options: -javaagent:IntelliJ IDEA 2022.3 EAP.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 5 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: benchmark.LoopUnrollingCounter.longStride1

# Run progress: 50.00% complete, ETA 00:02:49
# Fork: 1 of 2
# Warmup Iteration   1: 7550.278 ops/s
# Warmup Iteration   2: 7510.725 ops/s
# Warmup Iteration   3: 7083.338 ops/s
Iteration   1: 7175.461 ops/s
Iteration   2: 6405.642 ops/s
Iteration   3: 7012.505 ops/s
Iteration   4: 7080.895 ops/s
Iteration   5: 7103.842 ops/s

# Run progress: 75.00% complete, ETA 00:01:24
# Fork: 2 of 2
# Warmup Iteration   1: 7227.358 ops/s
# Warmup Iteration   2: 7452.473 ops/s
# Warmup Iteration   3: 7084.868 ops/s
Iteration   1: 7087.504 ops/s
Iteration   2: 7127.775 ops/s
Iteration   3: 7119.848 ops/s
Iteration   4: 7114.641 ops/s
Iteration   5: 6855.752 ops/s


Result "benchmark.LoopUnrollingCounter.longStride1":
  7008.386 ±(99.9%) 346.639 ops/s [Average]
  (min, avg, max) = (6405.642, 7008.386, 7175.461), stdev = 229.280
  CI (99.9%): [6661.747, 7355.026] (assumes normal distribution)


# Run complete. Total time: 00:05:36

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                          Mode  Cnt      Score      Error  Units
LoopUnrollingCounter.intStride1   thrpt   10  14158.090 ± 1832.970  ops/s
LoopUnrollingCounter.longStride1  thrpt   10   7008.386 ±  346.639  ops/s
 */