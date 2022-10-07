package game.player.movement;

import main.Main;
import game.player.Player;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private static boolean isAPressed = false;
    private static boolean isDPressed = false;

    private static int jumpCount = 0;

    @Override
    public void keyTyped(KeyEvent e) {
        Player player = Main.getPlayer();

        if(e.getKeyChar() == 'a') {
            isAPressed = true;
        }
        if(e.getKeyChar() == 'd') {
            isDPressed = true;
        }
        if(e.getKeyChar() == ' ') {
            if(player.isOnGround()) player.setDoubleJumpActive(true);

            if(player.isDoubleJumpActive()) {
                player.setOnGround(false);
                player.setVerticalSpeed(-player.JUMP_HEIGHT);
                jumpCount++;

                if(jumpCount == 2) {
                    player.setDoubleJumpActive(false);
                    jumpCount = 0;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.getPlayer().setX(50);
            Main.getPlayer().setY(570);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            isAPressed = false;
        }
        if(e.getKeyChar() == 'd') {
            isDPressed = false;
        }
    }

    public static boolean isAPressed() {
        return isAPressed;
    }

    public static void setIsAPressed(boolean isAPressed) {
        KeyListener.isAPressed = isAPressed;
    }

    public static boolean isDPressed() {
        return isDPressed;
    }

    public static void setIsDPressed(boolean isDPressed) {
        KeyListener.isDPressed = isDPressed;
    }
}
