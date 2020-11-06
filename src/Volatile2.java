import java.lang.Thread.State;

/**
 * JAVA MULTITHREAD - Volatile e Yield - Exemplo reproduzível
 * @author RinaldoDev
 */
public class Volatile2 {

  private static volatile int numero = 0;
  private static volatile boolean preparado = false;
//  private static int numero = 0;
//  private static boolean preparado = false;

  private static class MeuRunnable implements Runnable {

    @Override
    public void run() {
      while (!preparado) {
        Thread.yield();
      }

      if (numero != 42) {
//        System.out.println(numero);
        throw new IllegalStateException("Inscreva-se no canal!");
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    while (true) {
      Thread t0 = new Thread(new MeuRunnable());
      t0.start();
      Thread t1 = new Thread(new MeuRunnable());
      t1.start();
      Thread t2 = new Thread(new MeuRunnable());
      t2.start();
      
      numero = 42;
      preparado = true;
      
      while (
          t0.getState() != State.TERMINATED
          || t1.getState() != State.TERMINATED
          || t2.getState() != State.TERMINATED
          ) {
        // espera
      }
      
      numero = 0;
      preparado = false;
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