package benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Threads(5)
@Warmup(iterations = 3)
@Fork(2)
public class ArrayListSize {

  private static final int CAPACITY = 1_000_000;

  @Benchmark
  public List<String> preAssigned() {
    ArrayList<String> list = new ArrayList<>(CAPACITY);
    for (int i = 0; i < CAPACITY; i++) {
      list.add("foo");
    }
    return list;
  }

  @Benchmark
  public List<String> resizing() {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < CAPACITY; i++) {
      list.add("bar");
    }
    return list;
  }
}

/*
# JMH version: 1.36
# VM version: JDK 11.0.14, OpenJDK 64-Bit Server VM, 11.0.14+9-jvmci-22.0-b05
# VM invoker: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-22.0.0.2/Contents/Home/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions -javaagent:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/lib/idea_rt.jar=59900:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 5 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: benchmark.ArrayListSize.preAssigned

# Run progress: 0.00% complete, ETA 00:05:20
# Fork: 1 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 412.786 ops/s
# Warmup Iteration   2: 572.600 ops/s
# Warmup Iteration   3: 581.084 ops/s
Iteration   1: 583.503 ops/s
Iteration   2: 581.855 ops/s
Iteration   3: 583.692 ops/s
Iteration   4: 582.453 ops/s
Iteration   5: 583.400 ops/s

# Run progress: 25.00% complete, ETA 00:04:06
# Fork: 2 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 411.179 ops/s
# Warmup Iteration   2: 570.916 ops/s
# Warmup Iteration   3: 579.578 ops/s
Iteration   1: 577.755 ops/s
Iteration   2: 579.574 ops/s
Iteration   3: 576.588 ops/s
Iteration   4: 577.809 ops/s
Iteration   5: 580.780 ops/s


Result "benchmark.ArrayListSize.preAssigned":
  580.741 ±(99.9%) 4.022 ops/s [Average]
  (min, avg, max) = (576.588, 580.741, 583.692), stdev = 2.660
  CI (99.9%): [576.719, 584.763] (assumes normal distribution)


# JMH version: 1.36
# VM version: JDK 11.0.14, OpenJDK 64-Bit Server VM, 11.0.14+9-jvmci-22.0-b05
# VM invoker: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-22.0.0.2/Contents/Home/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions -javaagent:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/lib/idea_rt.jar=59900:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 5 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: benchmark.ArrayListSize.resizing

# Run progress: 50.00% complete, ETA 00:02:43
# Fork: 1 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 190.298 ops/s
# Warmup Iteration   2: 266.963 ops/s
# Warmup Iteration   3: 273.128 ops/s
Iteration   1: 280.583 ops/s
Iteration   2: 272.929 ops/s
Iteration   3: 272.934 ops/s
Iteration   4: 281.225 ops/s
Iteration   5: 281.857 ops/s

# Run progress: 75.00% complete, ETA 00:01:21
# Fork: 2 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 205.201 ops/s
# Warmup Iteration   2: 279.323 ops/s
# Warmup Iteration   3: 282.381 ops/s
Iteration   1: 292.578 ops/s
Iteration   2: 281.063 ops/s
Iteration   3: 257.993 ops/s
Iteration   4: 289.581 ops/s
Iteration   5: 294.118 ops/s


Result "benchmark.ArrayListSize.resizing":
  280.486 ±(99.9%) 16.233 ops/s [Average]
  (min, avg, max) = (257.993, 280.486, 294.118), stdev = 10.737
  CI (99.9%): [264.253, 296.719] (assumes normal distribution)


# Run complete. Total time: 00:05:28

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                   Mode  Cnt    Score    Error  Units
ArrayListSize.preAssigned  thrpt   10  580.741 ±  4.022  ops/s
ArrayListSize.resizing     thrpt   10  280.486 ± 16.233  ops/s
 */