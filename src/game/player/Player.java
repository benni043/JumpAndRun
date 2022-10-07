package game.player;

public class Player {

    public final int PLAYER_WIDTH = 30;
    public final int PLAYER_HEIGHT = 30;

    public final int MOVING_SPEED = 4;
    public final int JUMP_HEIGHT = 12;

    private int x;
    private int y;
    private int verticalSpeed;
    private boolean onGround;
    private boolean doubleJumpActive;

    public Player() {
        this.x = 50;
        this.y = 570;
        this.verticalSpeed = 0;
        this.onGround = false;
        this.doubleJumpActive = true;
    }

    public void fall() {
        this.y += verticalSpeed;
        verticalSpeed += 1;
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

    public int getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(int verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public boolean isDoubleJumpActive() {
        return doubleJumpActive;
    }

    public void setDoubleJumpActive(boolean doubleJumpActive) {
        this.doubleJumpActive = doubleJumpActive;
    }
}
