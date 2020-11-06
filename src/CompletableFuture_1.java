import java.util.concurrent.CompletableFuture;

/**
 * JAVA MULTITHREAD - CompletableFuture (simples)
 * 
 * @author RinaldoDev
 */
public class CompletableFuture_1 {

  public static void main(String[] args) {
    CompletableFuture<String> processe = processe();
    
    CompletableFuture<String> thenApply = 
        processe.thenApply(s -> s + " Curta o vídeo!");
    
    CompletableFuture<Void> thenAccept = 
        thenApply.thenAccept(s -> System.out.println(s));
    
    System.out.println("Apoie o canal pelo PicPay ou Apoia.SE!");
    
    sleep();
    sleep();
    sleep();
  }

  private static CompletableFuture<String> processe() {
    return CompletableFuture.supplyAsync(() -> {
      sleep();
      return "Inscreva-se no canal!";
    });
  }
  
  private static final void sleep() {
    try {
      Thread.sleep(2000);
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