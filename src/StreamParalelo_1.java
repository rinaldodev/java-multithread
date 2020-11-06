import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * JAVA MULTITHREAD - Streams Paralelos (simples)
 * 
 * @author RinaldoDev
 */
public class StreamParalelo_1 {

  public static void main(String[] args) {
    Instant inicio = Instant.now();
    Map<Double, Double> mapa = new ConcurrentHashMap<>();
    IntStream.range(1, 10000000)
        .parallel()
        .mapToDouble(numero -> Math.pow(numero, 5))
        .filter(numero -> numero % 2 == 0)
        .forEach(numero -> mapa.put(numero, Math.pow(numero, 5)));
    Instant fim = Instant.now();
    System.out.println(Duration.between(inicio, fim));
  }

  

}
// 
// picpay.me/RinaldoDev
// apoia.se/rinaldodev
//
// YouTube:  RinaldoDev
// Twitter:  @rinaldodev
// Blog:     rinaldo.dev
// LinkedIn: rinaldodev
//