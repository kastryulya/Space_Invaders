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
}
