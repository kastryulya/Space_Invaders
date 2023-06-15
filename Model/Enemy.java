package Model;

import javax.swing.ImageIcon;

public class Enemy extends IconOnScreen{

  public Enemy(int x, int y) {
    super();
    setImage(new ImageIcon(
        "/Users/ulya/Desktop/Матмех/4 семестр/Space_Invaders/Images/enemy.png").getImage());
    setX(x);
    setY(y);
  }

  public void move(int dx) {
    setDx(dx);
    if (getX() < 0) {
      setX(Options.screenWidth - Options.WIDTH_OF_ENEMY * 2);
    } else if (getX() > Options.screenWidth - Options.WIDTH_OF_ENEMY * 2) {
      setX(0);
    } else {
      setX(getX() + getDx());
    }
  }
}
