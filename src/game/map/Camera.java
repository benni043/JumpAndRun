package game.map;

import graphics.Canvas;
import main.Main;

public class Camera {

    public static int offsetMaxX = Canvas.WIDTH - Canvas.VIEWPORT_WIDTH;
    public static int offsetMaxY = Canvas.HEIGHT - Canvas.VIEWPORT_HEIGHT;
    public static int offsetMinX = 0;
    public static int offsetMinY = 0;

    public static int camX = Main.getPlayer().PLAYER_WIDTH - Canvas.VIEWPORT_WIDTH / 2;
    public static int camY = Main.getPlayer().PLAYER_HEIGHT - Canvas.VIEWPORT_HEIGHT / 2;

    public static void camera() {
        if(camX > offsetMaxX) {
            camX = offsetMaxX;
        } else if(camX < offsetMinX) {
            camX = offsetMinX;
        }
        if(camY > offsetMaxY) {
            camY = offsetMaxY;
        } else if(camY < offsetMinY) {
            camY = offsetMinY;
        }

    }

}
