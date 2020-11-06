import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * JAVA MULTITHREAD - Executors - SingleThread
 * 
 * @author RinaldoDev
 */
public class Executors_SingleThread_Runnable {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = null;
    try {
      executor = Executors.newSingleThreadExecutor();
      
      executor.execute(new Tarefa());
      executor.execute(new Tarefa());
      executor.execute(new Tarefa());
      Future<?> future = executor.submit(new Tarefa());
      
      System.out.println(future.isDone());
      executor.shutdown();
      executor.awaitTermination(10, TimeUnit.SECONDS);
      System.out.println(future.isDone());
    } catch (Exception e) {
      throw e;
    } finally {
      if (executor != null) {
//        executor.shutdown();
        executor.shutdownNow();
      }
    }
  }
  
  public static class Tarefa implements Runnable {
    @Override
    public void run() {
      String name = Thread.currentThread().getName();
      System.out.println(name + ": Inscreva-se no canal!");
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
// Facebook: rinaldo.dev
//