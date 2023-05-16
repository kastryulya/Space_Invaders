package Model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

  private final Player player;
  private final List<Enemy> enemies;

  private int deadEnemies;

  public GameModel() {
    player = new Player();
    enemies = new ArrayList<>();

    for (int i = 0; i < Options.I_ENEMIES; i++) {
      for (int j = 0; j < Options.J_ENEMIES; j++) {
        Enemy enemy = new Enemy(Options.ENEMY_START_X + Options.DJ_ENEMIES * j,
            Options.ENEMY_START_Y + Options.DI_ENEMIES * i);
        enemies.add(enemy);
      }
    }
    deadEnemies = 0;
  }

  public void action() {
    if (player.isAlive() && deadEnemies < Options.QUANTITY_ENEMIES) {
      player.move();
      updateStateEnemies();
    } else {
      gameIsOver();
    }
  }

  public void gameIsOver() {
    if (player.isAlive()) {
      System.out.println("You won)");
    } else {
      System.out.println("You lose(");
    }
  }

  public Player getPlayer() {
    return player;
  }

  public List<Enemy> getEnemies() {
    return enemies;
  }

  public void updateStateEnemies() {
    if (player.fireBallIsNull() || !player.getFireBall().isAlive()) {
      return;
    }

    FireBall tempFireBall = player.getFireBall();
    for (Enemy enemy : enemies) {
      if (enemyIsDefeated(enemy.getX(), enemy.getY(), tempFireBall.getX(), tempFireBall.getY())
          && enemy.isAlive()) {
        enemy.die();
        deadEnemies += 1;

        tempFireBall.die();
        player.delFireBall();
      }
    }
  }

  public boolean enemyIsDefeated(int enemyX, int enemyY, int fireBallX, int fireBallY) {
    return Math.abs(enemyY - fireBallY) < Options.WIDTH_OF_ENEMY * Options.COEF_DEFEAT
        && Math.abs(enemyX - fireBallX) < Options.HEIGHT_OF_ENEMY * Options.COEF_DEFEAT;
  }
}
