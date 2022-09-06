import java.awt.*;

public class Shape extends Point {
    public static final int NUM_OF_BLOCKS = 4;
    protected int shapeId;
    protected Block[] blocks;

    public Shape(int x, int y, int shapeId){
        super(x, y);
        this.shapeId = shapeId;
        blocks = new Block[NUM_OF_BLOCKS];
    }

    public void paint(Graphics g){
        configShape();
        for (int i = 0; i < blocks.length; i++) {
            blocks[i].paint(g);
        }
    }

    public void configShape(){
        switch (shapeId){
            case 1:
                for (int i = 0, j = this.x; i< blocks.length; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                break;
            case 2:
                blocks[0] = new Block(this.x, this.y, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                for (int i = 1, j = this.x; i< blocks.length; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y+GameScene.UNIT_SIZE, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                break;
            case 3: {
                int i = 0, j = this.x;
                for (; i < blocks.length - 1; i++, j += GameScene.UNIT_SIZE) {
                    blocks[i] = new Block(j, this.y + GameScene.UNIT_SIZE, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                blocks[3] = new Block(j - GameScene.UNIT_SIZE, this.y, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
            }
            break;
            case 4:
                for (int i = 0, j = this.x; i< 2; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                for (int i = 2, j = this.x; i< blocks.length; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y+GameScene.UNIT_SIZE, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                break;
            case 5:
                for (int i = 0, j = this.x; i< 2; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y+GameScene.UNIT_SIZE, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                for (int i = 2, j = this.x+GameScene.UNIT_SIZE; i< blocks.length; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                break;
            case 6:
                for (int i = 0, j = this.x; i< blocks.length-1; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y+GameScene.UNIT_SIZE, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                blocks[blocks.length-1] = new Block(this.x + GameScene.UNIT_SIZE, this.y, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);

                break;
            case 7:
                for (int i = 0, j = this.x; i< 2; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                for (int i = 2, j = this.x+GameScene.UNIT_SIZE; i< blocks.length; i++, j+=GameScene.UNIT_SIZE){
                    blocks[i] = new Block(j, this.y+GameScene.UNIT_SIZE, GameScene.UNIT_SIZE, GameScene.UNIT_SIZE);
                }
                break;
        }
    }

    public void move(){
        this.y += GameScene.UNIT_SIZE;
    }

    public void moveRight(){
        this.x += GameScene.UNIT_SIZE;
    }

    public void moveLeft(){
        this.x -= GameScene.UNIT_SIZE;
    }


}
