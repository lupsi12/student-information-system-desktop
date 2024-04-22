import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Main {
	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }catch (InstantiationException ex){
            throw new RuntimeException(ex);
        }catch (IllegalAccessException ex){
            throw new RuntimeException(ex);
        }catch (UnsupportedLookAndFeelException ex){
            throw new RuntimeException(ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Basla basla = new Basla();
                basla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // * işaretine basıldığına programın arka planda durmasını sağlar
                basla.setVisible(true); // görünürlüğünü true yapar framenin
            }
        });
	}

}
