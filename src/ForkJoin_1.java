import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * JAVA MULTITHREAD - Fork/Join - Recursive Action
 * @author RinaldoDev
 */
public class ForkJoin_1 {

  public static void main(String[] args) {
    final String msg = "Inscreva-se no canal RinaldoDev!";
    
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    
    ImpressaoDeStrings task = new ImpressaoDeStrings(msg);
    forkJoinPool.invoke(task);
  }
  
  public static class ImpressaoDeStrings extends RecursiveAction {

    private static final int LIMITE = 5;
    
    private String stringParaImprimir;
    
    public ImpressaoDeStrings(String msg) {
      this.stringParaImprimir = msg;
    }

    @Override
    protected void compute() {
      if (stringParaImprimir.length() < LIMITE) {
        System.out.println(stringParaImprimir);
      } else {
        int length = stringParaImprimir.length();
        int meioDaString = length / 2;
        
        String parte1 = stringParaImprimir.substring(0, meioDaString);
        String parte2 = stringParaImprimir.substring(meioDaString);
        
        ImpressaoDeStrings task1 = new ImpressaoDeStrings(parte1);
        ImpressaoDeStrings task2 = new ImpressaoDeStrings(parte2);
        
        ForkJoinTask.invokeAll(task1, task2);
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