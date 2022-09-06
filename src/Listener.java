import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    protected Shape shape;

    public Listener(Shape shape){
        this.shape = shape;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            shape.moveRight();
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            shape.moveLeft();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
