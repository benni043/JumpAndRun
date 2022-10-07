package main;

import graphics.Canvas;
import game.player.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static Canvas canvas;
    private static Player player;

    public static void main(String[] args) {
        player = new Player();
        canvas = new Canvas();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                canvas.getDraw().repaint();
            }
        }, 0, 1000 / 25);

    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static Player getPlayer() {
        return player;
    }
}
