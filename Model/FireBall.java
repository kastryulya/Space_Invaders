package Model;

import javax.swing.ImageIcon;

public class FireBall extends IconOnScreen {

  public FireBall(int x, int y) {
    super();
    setImage(new ImageIcon(
        "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/fireball.png").getImage());

    setX(x);
    setY(y);
  }

  public void move() {
    if (getY() > 0) {
      setY(getY() - 5);
    } else {
      die();
    }
  }
}
