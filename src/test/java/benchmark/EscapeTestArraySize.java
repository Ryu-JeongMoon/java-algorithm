package benchmark;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 3)
@Fork(2)
public class EscapeTestArraySize {

  private final Random random = new Random();

  @Benchmark
  public long arraySize63() {
    return add(new int[63]);
  }

  @Benchmark
  public long arraySize64() {
    return add(new int[64]);
  }

  @Benchmark
  public long arraySize65() {
    return add(new int[65]);
  }

  private int add(int[] array) {
    array[0] = random.nextInt();
    array[1] = random.nextInt();
    return array[0] + array[1];
  }
}

/*
# JMH version: 1.36
# VM version: JDK 11.0.14, OpenJDK 64-Bit Server VM, 11.0.14+9-jvmci-22.0-b05
# VM invoker: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-22.0.0.2/Contents/Home/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions -javaagent:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/lib/idea_rt.jar=61300:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: benchmark.EscapeTestArraySize.arraySize63

# Run progress: 0.00% complete, ETA 00:08:00
# Fork: 1 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 75200177.650 ops/s
# Warmup Iteration   2: 75476376.752 ops/s
# Warmup Iteration   3: 74457588.980 ops/s
Iteration   1: 76023689.645 ops/s
Iteration   2: 76011325.985 ops/s
Iteration   3: 76046968.325 ops/s
Iteration   4: 75968178.193 ops/s
Iteration   5: 76047826.622 ops/s

# Run progress: 16.67% complete, ETA 00:06:49
# Fork: 2 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 75627199.933 ops/s
# Warmup Iteration   2: 75889110.605 ops/s
# Warmup Iteration   3: 76064605.684 ops/s
Iteration   1: 76047509.028 ops/s
Iteration   2: 75996743.963 ops/s
Iteration   3: 75966602.812 ops/s
Iteration   4: 76064105.185 ops/s
Iteration   5: 76066856.830 ops/s


Result "benchmark.EscapeTestArraySize.arraySize63":
  76023980.659 ±(99.9%) 56134.027 ops/s [Average]
  (min, avg, max) = (75966602.812, 76023980.659, 76066856.830), stdev = 37129.183
  CI (99.9%): [75967846.632, 76080114.686] (assumes normal distribution)


# JMH version: 1.36
# VM version: JDK 11.0.14, OpenJDK 64-Bit Server VM, 11.0.14+9-jvmci-22.0-b05
# VM invoker: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-22.0.0.2/Contents/Home/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions -javaagent:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/lib/idea_rt.jar=61300:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: benchmark.EscapeTestArraySize.arraySize64

# Run progress: 33.33% complete, ETA 00:05:27
# Fork: 1 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 75777826.232 ops/s
# Warmup Iteration   2: 75809851.005 ops/s
# Warmup Iteration   3: 76027803.432 ops/s
Iteration   1: 75248165.245 ops/s
Iteration   2: 76017968.478 ops/s
Iteration   3: 76029076.770 ops/s
Iteration   4: 75628445.712 ops/s
Iteration   5: 75276323.921 ops/s

# Run progress: 50.00% complete, ETA 00:04:05
# Fork: 2 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 74905967.028 ops/s
# Warmup Iteration   2: 75374032.390 ops/s
# Warmup Iteration   3: 75816710.668 ops/s
Iteration   1: 75770738.012 ops/s
Iteration   2: 75563686.177 ops/s
Iteration   3: 75056733.655 ops/s
Iteration   4: 75499925.032 ops/s
Iteration   5: 75462573.992 ops/s


Result "benchmark.EscapeTestArraySize.arraySize64":
  75555363.699 ±(99.9%) 484096.872 ops/s [Average]
  (min, avg, max) = (75056733.655, 75555363.699, 76029076.770), stdev = 320200.107
  CI (99.9%): [75071266.828, 76039460.571] (assumes normal distribution)


# JMH version: 1.36
# VM version: JDK 11.0.14, OpenJDK 64-Bit Server VM, 11.0.14+9-jvmci-22.0-b05
# VM invoker: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-22.0.0.2/Contents/Home/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions -javaagent:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/lib/idea_rt.jar=61300:/Users/jm/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/223.8617.56/IntelliJ IDEA 2022.3 EAP.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: benchmark.EscapeTestArraySize.arraySize65

# Run progress: 66.67% complete, ETA 00:02:43
# Fork: 1 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 73556737.736 ops/s
# Warmup Iteration   2: 75165998.890 ops/s
# Warmup Iteration   3: 75681643.035 ops/s
Iteration   1: 75546729.628 ops/s
Iteration   2: 75952076.197 ops/s
Iteration   3: 75934042.069 ops/s
Iteration   4: 76016743.303 ops/s
Iteration   5: 76009480.684 ops/s

# Run progress: 83.33% complete, ETA 00:01:21
# Fork: 2 of 2
OpenJDK 64-Bit Server VM warning: -XX:ThreadPriorityPolicy=1 may require system level permission, e.g., being the root user. If the necessary permission is not possessed, changes to priority will be silently ignored.
# Warmup Iteration   1: 75154487.611 ops/s
# Warmup Iteration   2: 75554818.159 ops/s
# Warmup Iteration   3: 74582143.454 ops/s
Iteration   1: 74910697.400 ops/s
Iteration   2: 74999217.321 ops/s
Iteration   3: 74982101.921 ops/s
Iteration   4: 74989671.889 ops/s
Iteration   5: 74957198.733 ops/s


Result "benchmark.EscapeTestArraySize.arraySize65":
  75429795.915 ±(99.9%) 763218.353 ops/s [Average]
  (min, avg, max) = (74910697.400, 75429795.915, 76016743.303), stdev = 504821.685
  CI (99.9%): [74666577.562, 76193014.267] (assumes normal distribution)


# Run complete. Total time: 00:08:10

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                         Mode  Cnt         Score        Error  Units
EscapeTestArraySize.arraySize63  thrpt   10  76023980.659 ±  56134.027  ops/s
EscapeTestArraySize.arraySize64  thrpt   10  75555363.699 ± 484096.872  ops/s
EscapeTestArraySize.arraySize65  thrpt   10  75429795.915 ± 763218.353  ops/s
 */