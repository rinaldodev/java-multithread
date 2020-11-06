import java.util.Optional;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JAVA MULTITHREAD - Produtor-Consumidor 
 * 3) Usando as ferramentas da linguagem.
 * 
 * @author RinaldoDev
 */
public class ProdutorConsumidor_3 {

  private static final BlockingQueue<Integer> FILA = 
      new LinkedBlockingDeque<>(5);

  public static void main(String[] args) {

    Runnable produtor = () -> {
//      simulaProcessamento();
      simulaProcessamentoLento();
      System.out.println("Produzindo");
      int numero = new Random().nextInt(10000);
      try {
        FILA.put(numero);
        System.out.println(numero);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
    };

    Runnable consumidor = () -> {
      simulaProcessamento();
//      simulaProcessamentoLento();
      System.out.println("Consumindo");
      try {
        Integer take = FILA.take();
        System.out.println(take);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
    };

    Janelas.monitore(() -> String.valueOf(FILA.size()));

    ScheduledExecutorService executor = 
        Executors.newScheduledThreadPool(2);
    executor.scheduleWithFixedDelay(produtor, 0, 10, TimeUnit.MILLISECONDS);
    executor.scheduleWithFixedDelay(consumidor, 0, 10, TimeUnit.MILLISECONDS);
  }

  private static final void simulaProcessamento() {
    int tempo = new Random().nextInt(40);
    try {
      Thread.sleep(tempo);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }
  
  private static final void simulaProcessamentoLento() {
    int tempo = new Random().nextInt(400);
    try {
      Thread.sleep(tempo);
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