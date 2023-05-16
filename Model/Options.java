package Model;

import java.awt.Toolkit;

public interface Options {
  int PLAYER_START_X = 550;
  int PLAYER_START_Y = 650;

  int ENEMY_START_X = 350;
  int ENEMY_START_Y = 100;

  int WIDTH_OF_ENEMY = 40;
  int HEIGHT_OF_ENEMY = 40;

  int WIDTH_OF_PLAYER = 50;
  int HEIGHT_OF_PLAYER = 50;

  int WIDTH_OF_FIREBALL = 15;
  int HEIGHT_OF_FIREBALL = 15;

  double COEF_DEFEAT = 0.7;
  int I_ENEMIES = 4;
  int J_ENEMIES = 6;

  int DI_ENEMIES = 70;
  int DJ_ENEMIES = 90;

  int QUANTITY_ENEMIES = I_ENEMIES * J_ENEMIES;
  int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
  int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
}
