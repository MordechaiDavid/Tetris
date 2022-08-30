import java.awt.*;

public class Block extends Rectangle {
    public Block(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}
