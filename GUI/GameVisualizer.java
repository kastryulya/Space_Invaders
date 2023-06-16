package GUI;

import Model.Enemy;
import Model.FireBallEnemy;
import Model.FireBallPlayer;
import Model.GameModel;
import Model.KeyboardAdapter;
import Model.Options;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
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

    if (gameModel.isGameIsOver()) {
      drawGameIsOver(g2d);
    }
  }

  private void drawPlayer(Graphics2D g) {
    g.drawImage(gameModel.getPlayer().getImage(), gameModel.getPlayer().getX(),
        gameModel.getPlayer().getY(), Options.WIDTH_OF_PLAYER,
        Options.HEIGHT_OF_PLAYER, this);

    ArrayList<FireBallPlayer> fireBalls = gameModel.getPlayer().getFireBalls();

    for (FireBallPlayer fireBall : fireBalls) {
      if (fireBall != null && fireBall.isAlive()) {
        g.drawImage(fireBall.getImage(),
            fireBall.getX(),
            fireBall.getY(),
            Options.WIDTH_OF_FIREBALL_PLAYER,
            Options.HEIGHT_OF_FIREBALL_PLAYER, this);
      }
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

    ArrayList<FireBallEnemy> fireBallEnemies = gameModel.getFireBallEnemies();

    for (int i = 0; i < fireBallEnemies.size(); i++) {
      if (fireBallEnemies.get(i) != null) {
        g.drawImage(fireBallEnemies.get(i).getImage(),
            fireBallEnemies.get(i).getX(),
            fireBallEnemies.get(i).getY(),
            Options.WIDTH_OF_FIREBALL_ENEMY,
            Options.HEIGHT_OF_FIREBALL_ENEMY, this);
      }
    }
  }

  private void drawGameIsOver(Graphics2D g) {
    if (gameModel.playerIsWinner()) {
      Image icon = new ImageIcon(
          "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/win.png").getImage();
      g.drawImage(icon,
          (int) (Options.screenWidth * 0.2), (int) (Options.screenHeight * 0.2),
          (int) (Options.screenWidth * 0.5), (int) (Options.screenHeight * 0.5),
          this);
    } else {
      Image icon = new ImageIcon(
          "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/youLose.png").getImage();
      g.drawImage(icon,
          (int) (Options.screenWidth * 0.2), (int) (Options.screenHeight * 0.2),
          (int) (Options.screenWidth * 0.5), (int) (Options.screenHeight * 0.5),
          this);
    }
  }
}
