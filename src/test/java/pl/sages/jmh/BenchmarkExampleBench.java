package pl.sages.jmh;

import org.apache.commons.collections4.CollectionUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@State(Scope.Thread)
public class BenchmarkExampleBench {

    private static final int THREADS = 1;
    private static final Random RANDOM = new Random();

    private List<Integer> integers1 = new ArrayList<>();
    private List<Integer> integers2 = new ArrayList<>();

    @Setup(Level.Invocation)
    public void initialize() {
        integers1.clear();
        integers2.clear();
        IntStream.range(1, 1000).forEach(e -> integers1.add(RANDOM.nextInt(e)));
        IntStream.range(1, 1000).forEach(e -> integers2.add(RANDOM.nextInt(e)));
    }

    @Benchmark
    @Warmup(iterations = 5, time = 2)
    @Measurement(iterations = 5, time = 2)
    @Fork(value = 1)
    @Threads(THREADS)
    public void jdkIntersection(Blackhole bh) {
        List<Integer> copy = new ArrayList<>(integers1);
        copy.retainAll(integers2);
        bh.consume(copy);
    }

    @Benchmark
    @Warmup(iterations = 5, time = 2)
    @Measurement(iterations = 5, time = 2)
    @Fork(value = 1)
    @Threads(THREADS)
    public void apacheIntersection(Blackhole bh) {
        List<Integer> copy = new ArrayList<>(integers1);
        Collection<Integer> intersection = CollectionUtils.intersection(integers1, integers2);
        bh.consume(intersection);
        bh.consume(copy);
    }

    /**
     * Wykonaj tą metodą aby uruchomić testy
     */
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

}
