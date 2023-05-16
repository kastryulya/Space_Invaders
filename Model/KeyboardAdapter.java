package Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardAdapter extends KeyAdapter {
  private final GameModel m_gameModel;

  public KeyboardAdapter(GameModel gameModel) {
    m_gameModel = gameModel;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    m_gameModel.getPlayer().keyPressed(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    m_gameModel.getPlayer().keyReleased(e);
  }
}
