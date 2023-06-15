package Model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

  private final Player player;
  private final List<Enemy> enemies;

  private final ArrayList<FireBallEnemy> fireBallEnemies;

  private int deadEnemies;

  private boolean gameIsOver;

  public GameModel() {
    player = new Player();
    enemies = new ArrayList<>();
    fireBallEnemies = new ArrayList<>(20);

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
      setGameIsOver(true);
    }
  }

  public boolean playerIsWinner() {
    return player.isAlive();
  }

  public Player getPlayer() {
    return player;
  }

  public List<Enemy> getEnemies() {
    return enemies;
  }

  public ArrayList<FireBallEnemy> getFireBallEnemies() {
    return fireBallEnemies;
  }

  public void updateStateEnemies() {
    for (int i = 0; i < Options.I_ENEMIES; i++) {
      for (int j = 0; j < Options.J_ENEMIES; j++) {
        Enemy enemy = enemies.get(i * Options.J_ENEMIES + j);

        if (enemy.isAlive() && enemy.getX() % 100 == 0
            && i * Options.J_ENEMIES + j + 1 > Options.J_ENEMIES * (
            Options.I_ENEMIES - 1)) {
          fireBallEnemies.add(new FireBallEnemy(enemy.getX(), enemy.getY()));
        }

        if (i % 2 == 0) {
          enemy.move(10);
        } else {
          enemy.move(-10);
        }
      }
    }

    for (FireBallEnemy fireBallEnemie : fireBallEnemies) {
      fireBallEnemie.move();
    }

    for (FireBallEnemy fireBallEnemie : fireBallEnemies) {
      if (objectIsDefeated(player.getX(), player.getY(), fireBallEnemie.getX(),
          fireBallEnemie.getY())) {
        player.die();
      }
    }

    ArrayList<FireBallPlayer> fireBalls = player.getFireBalls();

    for (FireBallPlayer fireBall : fireBalls) {
      for (Enemy enemy : enemies) {
        if (fireBall == null || !fireBall.isAlive()) {
          continue;
        }
        if (objectIsDefeated(enemy.getX(), enemy.getY(), fireBall.getX(), fireBall.getY())
            && enemy.isAlive()) {
          enemy.die();
          deadEnemies += 1;

          fireBall.die();
          fireBall = null;
        }
      }
    }
  }

  public boolean objectIsDefeated(int objectX, int objectY, int fireBallX, int fireBallY) {
    return Math.abs(objectY - fireBallY) < Options.WIDTH_OF_PLAYER * Options.COEF_DEFEAT
        && Math.abs(objectX - fireBallX) < Options.HEIGHT_OF_PLAYER * Options.COEF_DEFEAT;
  }

  public boolean isGameIsOver() {
    return gameIsOver;
  }

  public void setGameIsOver(boolean gameIsOver) {
    this.gameIsOver = gameIsOver;
  }
}
