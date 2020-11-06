import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JAVA MULTITHREAD - ReentrantLock
 * @author youtube.com/RinaldoDev
 */
public class ReentrantLock_1 {

  private static int i = -1;
  
  private static Lock lock = new ReentrantLock();
  
  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    
    Runnable r1 = () -> {
      lock.lock();
      String name = Thread.currentThread().getName();
      i++;
      System.out.println(name + ": " + i);
      lock.unlock();
    };
    
    for (int i = 0; i < 6; i++) {
      executor.execute(r1);
    }
    
    executor.shutdown();
  }
  
}
//
//picpay.me/RinaldoDev
//apoia.se/rinaldodev
//
//YouTube:  RinaldoDev
//Twitter:  @rinaldodev
//Blog:     rinaldo.dev
//LinkedIn: rinaldodev
//
