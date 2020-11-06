import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * JAVA MULTITHREAD - Fork/Join - Recursive Task
 * @author RinaldoDev
 */
public class ForkJoin_2 {

  public static void main(String[] args) {
    final String msg = "Inscreva-se no canal RinaldoDev!";
    
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    
    ImpressaoDeStrings task = new ImpressaoDeStrings(msg);
    Integer tamanhoDaString = forkJoinPool.invoke(task);
    System.out.println(tamanhoDaString);
  }
  
  public static class ImpressaoDeStrings extends RecursiveTask<Integer> {

    private static final int LIMITE = 10;
    
    private String stringParaImprimir;
    
    public ImpressaoDeStrings(String msg) {
      this.stringParaImprimir = msg;
    }

    @Override
    protected Integer compute() {
      if (stringParaImprimir.length() < LIMITE) {
        System.out.println(stringParaImprimir);
        System.out.println(stringParaImprimir.length());
        return stringParaImprimir.length();
      } else {
        int length = stringParaImprimir.length();
        int meioDaString = length / 2;
        
        String parte1 = stringParaImprimir.substring(0, meioDaString);
        String parte2 = stringParaImprimir.substring(meioDaString);
        
        ImpressaoDeStrings task1 = new ImpressaoDeStrings(parte1);
        ImpressaoDeStrings task2 = new ImpressaoDeStrings(parte2);

        ForkJoinTask<Integer> retornoTask1 = task1.fork();
        ForkJoinTask<Integer> retornoTask2 = task2.fork();
        
        Integer resultado1 = retornoTask1.join();
        Integer resultado2 = retornoTask2.join();
        
        return resultado1 + resultado2;
      }
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