import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JAVA MULTITHREAD - Sincronizar Coleções
 * 
 * @author RinaldoDev
 */
public class SincronizarColecoes {
  
  private static List<String> lista = new ArrayList<>();
  
  public static void main(String[] args) throws InterruptedException {
    lista = Collections.synchronizedList(lista);
    // Utilize a versão do synchronizedXXX de acordo com
    // seu tipo de coleção!
//    lista = Collections.synchronizedCollection(lista);
//    lista = Collections.synchronizedMap(lista);
//    lista = Collections.synchronizedSet(lista);
    
    MeuRunnable runnable = new MeuRunnable();
    Thread t0 = new Thread(runnable);
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t0.start();
    t1.start();
    t2.start();
    Thread.sleep(500);
    System.out.println(lista);
  }
  
  public static class MeuRunnable implements Runnable {
    @Override
    public void run() {
      lista.add("Inscreva-se no canal!");
      String name = Thread.currentThread().getName();
      System.out.println(name + " inseriu na lista!");
    }
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
//Facebook: rinaldo.dev
//