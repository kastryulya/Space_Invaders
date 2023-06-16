package Model;

import javax.swing.ImageIcon;

public class FireBallEnemy extends IconOnScreen {

  public FireBallEnemy(int x, int y) {
    super();
    setImage(new ImageIcon(
        "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/fireballEnemy.png").getImage());

    setX(x);
    setY(y);
  }

  public void move() {
    if (getY() < Options.screenHeight) {
      setY(getY() + 10);
    } else {
      die();
    }
  }
}
