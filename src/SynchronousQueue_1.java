import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * JAVA MULTITHREAD - SynchronousQueue
 * 
 * @author RinaldoDev
 */
public class SynchronousQueue_1 {

  private static final SynchronousQueue<String> FILA = 
      new SynchronousQueue<>();

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();

    Runnable r1 = () -> {
      put();
      System.out.println("Escreveu na fila!");
    };
    Runnable r2 = () -> {
      String msg = take();
      System.out.println("Pegou da fila! " + msg);
    };

    executor.execute(r1);
    executor.execute(r2);

    executor.shutdown();
  }

  private static String take() {
    try {
      return FILA.take();
//      return FILA.poll(timeout, unit);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
      return "Exceção!";
    }
  }

  private static void put() {
    try {
      FILA.put("Inscreva-se");
//      FILA.offer(e, timeout, unit);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
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