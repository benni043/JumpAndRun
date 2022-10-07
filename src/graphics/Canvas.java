package graphics;

import game.player.movement.KeyListener;

import javax.swing.*;
import java.awt.*;

public class Canvas {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final int VIEWPORT_WIDTH = 1600;
    public static final int VIEWPORT_HEIGHT = 1200;

    Draw draw;
    public Canvas() {
        JFrame jFrame = new JFrame("Jump & Run");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.requestFocus();

        draw = new Draw();
        draw.setVisible(true);
        draw.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        jFrame.addKeyListener(new KeyListener());
        jFrame.add(draw);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public Draw getDraw() {
        return draw;
    }
}
