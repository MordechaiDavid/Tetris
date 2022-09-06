import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameScene extends JPanel {
    public static final int UNIT_SIZE = 20;
    public static final int NUM_OF_COLS = 20;
    public static final int NUM_OF_ROWS = 30;
    public static final int SCREEN_WIDTH = NUM_OF_COLS*UNIT_SIZE;
    public static final int SCREEN_HEIGHT = NUM_OF_ROWS*UNIT_SIZE;
    public static final int MAX_UNITS = (NUM_OF_COLS*NUM_OF_ROWS);
    protected Shape[] shapes;
    protected int currentShape;
    protected Random random;
    protected Listener listener;


    public GameScene(){
        this.random = new Random();
        this.currentShape = -1;
        this.shapes = new Shape[MAX_UNITS/4]; // divide by 4 because of the size of shapes.
        newShape();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        gameLoop();
    }

    public void newShape(){
        this.currentShape++;
        int randomShape = random.nextInt(7)+1;
        this.shapes[currentShape] = new Shape(0, 0, randomShape);
        // add listener when the shape created
        listener = new Listener(shapes[currentShape]);
        this.addKeyListener(listener);
        this.setFocusable(true);
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

    public void checkArrived(){
        for (int i = 0; i < 4; i++) {
           Block currentBlock =  shapes[currentShape].blocks[i];
           if (currentBlock!=null){
               if (currentBlock.y+UNIT_SIZE >= SCREEN_HEIGHT) {
                   this.removeKeyListener(listener);
                   newShape();
               }
           }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        for (int i = 0; i <= currentShape; i++) {
            shapes[i].paint(g);
        }
    }

    public void gameLoop(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    checkArrived();
                    repaint();
                    shapes[currentShape].move();
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
