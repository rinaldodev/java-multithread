/**
 * JAVA MULTITHREAD - Volatile e Yield
 * @author RinaldoDev
 */
public class Volatile {

  private static int numero = 0;
  private static boolean preparado = false;

  private static class MeuRunnable implements Runnable {
    @Override
    public void run() {
      while (!preparado) {
        Thread.yield();
      }

      System.out.println(numero);
    }
  }

  public static void main(String[] args) {
    Thread t0 = new Thread(new MeuRunnable());
    t0.start();
    numero = 42;
    preparado = true;
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