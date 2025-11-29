import ui.TelaMain;
import javax.swing.SwingUtilities;

public class main {
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> new TelaMain().setVisible(true));
}
}