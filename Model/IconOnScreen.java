package Model;

import java.awt.Image;

public class IconOnScreen {

  private int x;
  private int y;
  private int dx;
  private boolean alive;
  private Image image;

  public IconOnScreen() {
    alive = true;
  }

  public int getDx() {
    return dx;
  }

  public void setDx(int dx) {
    this.dx = dx;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public boolean isAlive() {
    return alive;
  }

  public void die() {
    alive = false;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }
}
