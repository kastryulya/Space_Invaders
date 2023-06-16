package Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player extends IconOnScreen {

  private final ArrayList<FireBallPlayer> fireBalls;

  public Player() {
    super();
    setImage(new ImageIcon(
        "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/player.png").getImage());

    setX(Options.PLAYER_START_X);
    setY(Options.PLAYER_START_Y);

    fireBalls = new ArrayList<>(20);
  }

  public void move() {
    if (getX() < 0) {
      setX(Options.screenWidth - Options.WIDTH_OF_PLAYER * 2);
    } else if (getX() > Options.screenWidth - Options.WIDTH_OF_PLAYER * 2) {
      setX(0);
    } else {
      setX(getX() + getDx());

      for (FireBallPlayer fireBall : fireBalls) {
        if (fireBall != null) {
          fireBall.move();
        }
      }
    }
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
      setDx(-8);
    }
    if (key == KeyEvent.VK_RIGHT) {
      setDx(8);
    }

    if (key == KeyEvent.VK_SPACE) {
      fireBalls.add(new FireBallPlayer((int) (getX() + Options.HEIGHT_OF_PLAYER * 0.35), getY()));
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

  public ArrayList<FireBallPlayer> getFireBalls() {
    return fireBalls;
  }
}
