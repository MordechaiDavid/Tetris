import java.awt.*;

public class Shapes extends Rectangle {
    public static final int NUM_OF_BLOCKS = 4;
    protected int shapeId;
    protected Block[] shape;

    public Shapes(int x, int y, int width, int height, int shapeId){
        super(x, y, width, height);
        this.shapeId = shapeId;
        shape = new Block[4];
    }

    public void paint(Graphics g){
        configShape();
        for (int i = 0; i < shape.length; i++) {
            shape[i].paint(g);
        }
    }

    public void configShape(){
        switch (shapeId){
            case 1:
                for (int i = 0, j = this.x; i< shape.length; i++, j+=this.width){
                    shape[i] = new Block(j, this.y, this.width, this.height);
                }
                break;
            case 2:
                shape[0] = new Block(this.x, this.y, this.width, this.height);
                for (int i = 1, j = this.x ; i<shape.length; i++, j+=this.width){
                    shape[i] = new Block(j, this.y+this.height, this.width, this.height);
                }
                break;
            case 3: {
                int i = 0, j = this.x;
                for (; i < shape.length - 1; i++, j += this.width) {
                    shape[i] = new Block(j, this.y + this.height, this.width, this.height);
                }
                shape[3] = new Block(j - this.width, this.y, this.width, this.height);
            }
            break;
            case 4:
                for (int i = 0, j = this.x; i< 2; i++, j+=this.width){
                    shape[i] = new Block(j, this.y, this.width, this.height);
                }
                for (int i = 2, j = this.x; i< shape.length; i++, j+=this.width){
                    shape[i] = new Block(j, this.y+this.height, this.width, this.height);
                }
                break;
            case 5:
                for (int i = 0, j = this.x; i< 2; i++, j+=this.width){
                    shape[i] = new Block(j, this.y+this.height, this.width, this.height);
                }
                for (int i = 2, j = this.x+this.width; i< shape.length; i++, j+=this.width){
                    shape[i] = new Block(j, this.y, this.width, this.height);
                }
                break;
            case 6:
                for (int i = 0, j = this.x; i< shape.length-1; i++, j+=this.width){
                    shape[i] = new Block(j, this.y+this.height, this.width, this.height);
                }
                shape[shape.length-1] = new Block(this.x + this.width, this.y, this.width, this.height);

                break;
            case 7:
                for (int i = 0, j = this.x; i< 2; i++, j+=this.width){
                    shape[i] = new Block(j, this.y, this.width, this.height);
                }
                for (int i = 2, j = this.x+this.width; i< shape.length; i++, j+=this.width){
                    shape[i] = new Block(j, this.y+this.height, this.width, this.height);
                }
                break;
        }
    }

    public void move(){
        this.y += this.height;
        System.out.println(y);
    }


}
