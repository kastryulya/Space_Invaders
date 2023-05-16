package GUI;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SpaceInvaders extends JFrame {

  public static void main(String[] args) {
    try {
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame();

      frame.setContentPane(new GameVisualizer());
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    });
  }
}
