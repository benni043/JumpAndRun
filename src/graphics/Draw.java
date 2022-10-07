package graphics;

import game.map.Camera;
import game.player.movement.KeyListener;
import main.Main;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    private final int[][] platforms = {{0, 600, 600, 600}, {400, 500, 500, 500}, {200, 400, 300, 400}, {400, 200, 500, 200}, {300, 300, 400, 300}};

        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D graphics2D = (Graphics2D) graphics;

        //graphics2D.translate(-Camera.camX, -Camera.camY);

        //player
        graphics2D.setColor(Color.BLUE);
        graphics2D.drawRect(Main.getPlayer().getX(), Main.getPlayer().getY(), Main.getPlayer().PLAYER_WIDTH, Main.getPlayer().PLAYER_HEIGHT);
        graphics2D.fillRect(Main.getPlayer().getX(), Main.getPlayer().getY(), Main.getPlayer().PLAYER_WIDTH, Main.getPlayer().PLAYER_HEIGHT);

        //draw platforms
        graphics2D.setColor(Color.RED);

        for (int[] platform : platforms) {
            graphics2D.drawLine(platform[0], platform[1], platform[2], platform[3]);
        }

        Player player = Main.getPlayer();

        if(KeyListener.isAPressed()) player.setX(player.getX()-player.MOVING_SPEED);
        if(KeyListener.isDPressed()) player.setX(player.getX()+player.MOVING_SPEED);

        if (!player.isOnGround()) player.fall();

        playerTouchesGround();
    }

    public void playerTouchesGround() {
        Player player = Main.getPlayer();

        for (int[] platform : platforms) {
            if (player.getX() + player.PLAYER_WIDTH >= platform[0] && player.getX() <= platform[2] && player.getY() + player.PLAYER_HEIGHT >= platform[1]) {
                if (player.getY() + player.PLAYER_HEIGHT - player.getVerticalSpeed() <= platform[1]) {
                    player.setY(platform[1] - player.PLAYER_HEIGHT);
                    player.setVerticalSpeed(0);
                    player.setOnGround(true);
                    return;
                }
            }
        }
        player.setOnGround(false);
    }
}