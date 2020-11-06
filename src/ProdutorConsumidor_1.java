import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * JAVA MULTITHREAD - Produtor-Consumidor 
 * 1) Condição de corrida e Deadlock.
 * 
 * @author RinaldoDev
 */
public class ProdutorConsumidor_1 {

  private static final List<Integer> LISTA = new ArrayList<>(5);
  private static boolean produzindo = true;
  private static boolean consumindo = true;

  public static void main(String[] args) {

    Thread produtor = new Thread(() -> {
      while (true) {
        try {
          simulaProcessamento();
          if (produzindo) {
            System.out.println("Produzindo");
            int numero = new Random().nextInt(10000);
            LISTA.add(numero);
            if (LISTA.size() == 5) {
              System.out.println("Pausando produtor.");
              produzindo = false;
            }
            if (LISTA.size() == 1) {
              System.out.println("Iniciando consumidor.");
              consumindo = true;
            }
          } else {
            System.out.println("!!! Produtor dormindo!");
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    });

    Thread consumidor = new Thread(() -> {
      while (true) {
        try {
          simulaProcessamento();
          if (consumindo) {
            System.out.println("Consumindo");
            Optional<Integer> numero = LISTA.stream().findFirst();
            numero.ifPresent(n -> {
              LISTA.remove(n);
            });
            if (LISTA.size() == 0) {
              System.out.println("Pausando consumidor.");
              consumindo = false;
            }
            if (LISTA.size() == 4) {
              System.out.println("Iniciando produtor.");
              produzindo = true;
            }
          } else {
            System.out.println("??? Consumidor dormindo!");
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    });

    Janelas.monitore(() -> String.valueOf(LISTA.size()));

    produtor.start();
    consumidor.start();
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