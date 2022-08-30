import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    public static final int UNIT_SIZE = 20;
    public static final int NUM_OF_COLS = 20;
    public static final int NUM_OF_ROWS = 30;
    public static final int SCREEN_WIDTH = NUM_OF_COLS*UNIT_SIZE;
    public static final int SCREEN_HEIGHT = NUM_OF_ROWS*UNIT_SIZE;
    protected Shapes[] shapes;


    public GameScene(){
        this.shapes = new Shapes[10];
        this.shapes[0] = new Shapes(0, 0 , UNIT_SIZE, UNIT_SIZE, 3);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        gameLoop();
    }

    public void drawGrid(Graphics g){
        for (int x = 0; x<=SCREEN_WIDTH; x+=UNIT_SIZE){
            for (int y = 0; y<=SCREEN_HEIGHT; y+=UNIT_SIZE)
                g.drawLine(0 ,y, x, y);
        }
        for (int x = 0; x<=SCREEN_WIDTH; x+=UNIT_SIZE){
            for (int y = 0; y<=SCREEN_HEIGHT; y+=UNIT_SIZE)
                g.drawLine(x ,0, x, SCREEN_HEIGHT);
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        shapes[0].paint(g);
    }

    public void gameLoop(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    repaint();
                    shapes[0].move();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
