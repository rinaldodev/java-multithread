import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * JAVA MULTITHREAD - Semaphore
 * 2) Try-Acquire
 * 
 * @author RinaldoDev
 */
public class Semaphore_2 {

  private static final Semaphore SEMAFORO = new Semaphore(100);
  
  private static final AtomicInteger QTD = new AtomicInteger(0);
  
  public static void main(String[] args) {
    ScheduledExecutorService executor = 
        Executors.newScheduledThreadPool(501);

    Runnable r1 = () -> {
      String name = Thread.currentThread().getName();
      int usuario = new Random().nextInt(10000);
      
      boolean conseguiu = false;
      QTD.incrementAndGet();
      while (!conseguiu) {
        conseguiu = tryAcquire();
      }
      QTD.decrementAndGet();
      
      System.out.println("Usuário " + usuario
          + " se inscreveu no canal usando a thread " + name + "\n");
      sleep();
      SEMAFORO.release();
    };
    
    Janelas.Mensagem janela = Janelas.criaJanela("QTD");
    Runnable r2 = () -> {
      int qtd = QTD.get();
      janela.setText(qtd + " usuários esperando para increver-se no canal!");
    };
    
    for (int i = 0; i < 500; i++) {
      executor.execute(r1);
    }
    executor.scheduleWithFixedDelay(r2, 0, 100, TimeUnit.MILLISECONDS);
  }

  private static void sleep() {
    // espera de 1 a 6 segundos
    try {
      int tempoEspera = new Random().nextInt(6);
      tempoEspera++;
      Thread.sleep(1000 * tempoEspera);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }

  private static boolean tryAcquire() {
    try {
      return SEMAFORO.tryAcquire(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
      return false;
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