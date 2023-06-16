package Model;

import javax.swing.ImageIcon;

public class FireBallPlayer extends IconOnScreen {

  public FireBallPlayer(int x, int y) {
    super();
    setImage(new ImageIcon(
        "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/fireball.png").getImage());

    setX(x);
    setY(y);
  }

  public void move() {
    if (getY() > 0) {
      setY(getY() - 20);
    } else {
      die();
    }
  }
}
