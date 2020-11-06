/**
 * JAVA MULTITHREAD - Synchronized
 * 
 * @author RinaldoDev
 */
public class Synchronized_1 {

  static int i = -1;

  public static void main(String[] args) {
    MeuRunnable runnable = new MeuRunnable();

//    for (int i = 0; i < 5; i++) {
//      runnable.run();
//    }
    
    Thread t0 = new Thread(runnable);
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    Thread t3 = new Thread(runnable);
    Thread t4 = new Thread(runnable);

    t0.start();
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }

//  public static void imprime() {
//    synchronized (Synchronized_1.class) {
//      i++;
//      String name = Thread.currentThread().getName();
//      System.out.println(name + ":" + i);
//    }
//  }

  public static class MeuRunnable implements Runnable {
//    static Object lock1 = new Object();
//    static Object lock2 = new Object();
    @Override
    public synchronized void run() {
//    public void run() {
//      imprime();
//      synchronized (this) {
        i++;
        String name = Thread.currentThread().getName();
        System.out.println(name + ":" + i);
//      }
//      synchronized(lock1) {
//        i++;
//        String name = Thread.currentThread().getName();
//        System.out.println(name + ":" + i);
//      }
//      synchronized(lock2) {
//        i++;
//        String name = Thread.currentThread().getName();
//        System.out.println(name + ":" + i);
//      }
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