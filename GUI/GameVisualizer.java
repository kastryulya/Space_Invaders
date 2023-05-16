package GUI;

import Model.Enemy;
import Model.GameModel;
import Model.KeyboardAdapter;
import Model.Options;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class GameVisualizer extends JPanel {

  private final GameModel gameModel = new GameModel();

  public GameVisualizer() {
    setBackground(Color.black);
    addKeyListener(new KeyboardAdapter(gameModel));
    setFocusable(true);

    Timer timer = new Timer("events generator", true);
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        onRedrawEvent();
      }
    }, 0, 30);
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        gameModel.action();
      }
    }, 0, 30);
  }

  protected void onRedrawEvent() {
    EventQueue.invokeLater(this::repaint);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    drawPlayer(g2d);
    drawEnemies(g2d);
  }

  private void drawPlayer(Graphics2D g) {
    g.drawImage(gameModel.getPlayer().getImage(), gameModel.getPlayer().getX(),
        gameModel.getPlayer().getY(), Options.WIDTH_OF_PLAYER,
        Options.HEIGHT_OF_PLAYER, this);

    if (!gameModel.getPlayer().fireBallIsNull() && gameModel.getPlayer().getFireBall()
        .isAlive()) {
      g.drawImage(gameModel.getPlayer().getFireBall().getImage(),
          gameModel.getPlayer().getFireBall().getX(),
          gameModel.getPlayer().getFireBall().getY(),
          Options.WIDTH_OF_FIREBALL,
          Options.HEIGHT_OF_FIREBALL, this);
    }
  }

  private void drawEnemies(Graphics2D g) {
    List<Enemy> enemies = gameModel.getEnemies();

    for (Enemy enemy : enemies) {
      if (enemy.isAlive()) {
        g.drawImage(enemy.getImage(), enemy.getX(),
            enemy.getY(), Options.WIDTH_OF_ENEMY,
            Options.HEIGHT_OF_ENEMY, this);
      }
    }
  }
}
