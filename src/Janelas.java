import java.awt.Font;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Janelas {

  public static synchronized Mensagem criaJanela(String textoInicial) {
    JFrame jFrame = new JFrame(textoInicial); 
    Mensagem jLabel = new Mensagem(); 
    jLabel.setText("<html><body>" + textoInicial + "</body></html>"); 
    jLabel.setFont(new Font("Serif", Font.PLAIN, 72));
    JPanel jPanel = new JPanel(); 
    jPanel.add(jLabel); 
    jFrame.add(jPanel); 
    jFrame.setSize(800, 600);
    jFrame.setLocation(1000, 200);
    jFrame.setVisible(true);
    return jLabel;
  }
  
  public static final void monitore(Supplier<String> supplier) {
    Janelas.Mensagem msg = Janelas.criaJanela("Contador");
    Runnable monitor = () -> {
      msg.setText(supplier.get());
    };
    ScheduledExecutorService executor = 
        Executors.newScheduledThreadPool(1);
    executor.scheduleWithFixedDelay(monitor, 0, 50, TimeUnit.MILLISECONDS);

  }
  
  public static class Mensagem extends JLabel {
    private static final long serialVersionUID = 1L;
    @Override
    public void setText(String text) {
      super.setText("<html><body><p style=\"width:400px\">" + text + "</p></body></html>");
    }
  }
  
  
}
