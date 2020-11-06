import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * JAVA MULTITHREAD - Classes com operações atômicas
 * 
 * @author RinaldoDev
 */
public class ClassesAtomicas {
//  static AtomicLong i = new AtomicLong(-1);
//  static AtomicBoolean b = new AtomicBoolean(false);
  static AtomicReference<Object> r = new AtomicReference<>(new Object());

  public static void main(String[] args) {
    MeuRunnable runnable = new MeuRunnable();

    Thread t0 = new Thread(runnable);
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);

    t0.start();
    t1.start();
    t2.start();
  }

  public static class MeuRunnable implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
//        System.out.println(name + ":" + i.incrementAndGet());
//        System.out.println(name + ":" + b.compareAndExchange(false, true));
        System.out.println(name + ":" + r.getAndSet(new Object()));
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