import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * JAVA MULTITHREAD - Executors - MultiThread
 * 
 * @author RinaldoDev
 */
public class Executors_MultiThread {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = null;
    try {
//      executor = Executors.newFixedThreadPool(3);
      executor = Executors.newCachedThreadPool();
      
      List<Tarefa> lista = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        lista.add(new Tarefa());
      }
      
//      String string = executor.invokeAny(lista);
//      System.out.println(string);
      
      List<Future<String>> list = executor.invokeAll(lista);
      
      for (Future<String> future : list) {
        System.out.println(future.get());
      }
//      Future<String> f1 = executor.submit(new Tarefa());
//      System.out.println(f1.get());
//      Future<String> f2 = executor.submit(new Tarefa());
//      Future<String> f3 = executor.submit(new Tarefa());
//      System.out.println(f2.get());
//      System.out.println(f3.get());
      executor.shutdown();
    } catch (Exception e) {
      throw e;
    } finally {
      if (executor != null) {
        executor.shutdownNow();
      }
    }
  }

  public static class Tarefa implements Callable<String> {
    @Override
    public String call() throws Exception {
      String name = Thread.currentThread().getName();
      int nextInt = new Random().nextInt(1000);
      return name + ": Inscreva-se no canal! " + nextInt;
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