package Model;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends IconOnScreen {

  private FireBall fireBall;

  public Player() {
    super();
    setImage(new ImageIcon(
        "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/player.png").getImage());

    setX(Options.PLAYER_START_X);
    setY(Options.PLAYER_START_Y);
  }

  public void move() {
    if (getX() < 0) {
      setX(Options.screenWidth - Options.WIDTH_OF_PLAYER * 2);
    } else if (getX() > Options.screenWidth - Options.WIDTH_OF_PLAYER * 2) {
      setX(0);
    } else {
      setX(getX() + getDx());
      if (fireBall != null) {
        fireBall.move();
        if (!fireBall.isAlive()) {
          fireBall = null;
        }
      }
    }
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
      setDx(-5);
    }
    if (key == KeyEvent.VK_RIGHT) {
      setDx(5);
    }

    if (key == KeyEvent.VK_SPACE) {
      if (fireBallIsNull()) {
        fireBall = new FireBall((int) (getX() + Options.HEIGHT_OF_PLAYER * 0.35), getY());
      }
    }
  }

  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
      setDx(0);
    }

    if (key == KeyEvent.VK_RIGHT) {
      setDx(0);
    }
  }

  public FireBall getFireBall() {
    return fireBall;
  }

  public void delFireBall() {
    fireBall = null;
  }

  public boolean fireBallIsNull() {
    return fireBall == null;
  }
}
