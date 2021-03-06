
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Geometry {

    private static Texture texture;
    private static Sprite sprite;

    static {
        texture=new Texture(Gdx.files.internal("pixel.png"));
        sprite=new Sprite(texture);
    }

    public static void drawLine(PolygonSpriteBatch batch,float X1,float Y1,float X2,float Y2,float scaleY){
        float length= (float) Math.sqrt(Math.pow(X2-X1,2)+Math.pow(Y2-Y1,2));
        float angleToRot= (float) (Math.atan2(Y2-Y1,X2-X1)*180/Math.PI);
        sprite.setOrigin(0,0);
        sprite.setPosition(X1,Y1);
        sprite.setRotation(angleToRot);
        if(length==0)
            length=scaleY;  //for drawing a point through dawLine, where in X2-X1 is 0.
        sprite.setScale(length,scaleY);
        sprite.draw(batch);

    }

    public static void drawGrid(PolygonSpriteBatch batch,float screenWidth,float screenHeight,float tileSize,float scaleY){
        for(int i = 0; i < screenWidth / tileSize; i++)
            drawLine(batch,i*tileSize,0,i*tileSize,screenHeight,scaleY);
        for(int j=0;j<screenHeight/tileSize;j++)
            drawLine(batch,0,j*tileSize,screenWidth,j*tileSize,scaleY);
    }


    public static void drawPolygon(PolygonSpriteBatch batch,Vector7[] vertices,float scaleY){
        for(int i=0;i<vertices.length-1;i++){
            drawLine(batch,(float)vertices[i].x,(float)vertices[i].y,(float)vertices[i+1].x,(float)vertices[i+1].y,scaleY);
        }
        drawLine(batch,(float)vertices[0].x,(float)vertices[0].y,(float)vertices[vertices.length-1].x,(float)vertices[vertices.length-1].y,scaleY);
    }



    /**
     * Bresenham's algorithm for drawing circle
     */
    public static void drawCircle(PolygonSpriteBatch batch,int centerX,int centerY,int radius,int scaleY){
        int x = 0, y = radius;
        int d = 3 - 2 * radius;
        while(y>=x){
            drawCircle(batch,centerX,centerY,x,y,scaleY);

        if(d<0){
            d = d + 4 * x + 6;
        }else{
            y--;
            d = d + 4 * (x - y) + 10;
        }

        x++;

        drawCircle(batch,centerX,centerY,x,y,scaleY);
        }
    }

    private static void drawPoint(PolygonSpriteBatch batch, int X1, int Y1, int scaleXY){
        sprite.setOrigin(0,0);
        sprite.setPosition(X1,Y1);
        sprite.setScale(scaleXY);
        sprite.draw(batch);
    }

    private static void drawCircle(PolygonSpriteBatch batch, int centerX, int centerY, int x, int y,int scaleXY) {

        drawPoint(batch,centerX + x, centerY + y, scaleXY);
        drawPoint(batch,centerX - x, centerY + y, scaleXY);
        drawPoint(batch,centerX + x, centerY - y, scaleXY);
        drawPoint(batch,centerX - x, centerY - y, scaleXY);

        drawPoint(batch,centerX + y, centerY + x, scaleXY);
        drawPoint(batch,centerX - y, centerY + x, scaleXY);
        drawPoint(batch,centerX + y, centerY - x, scaleXY);
        drawPoint(batch,centerX - y, centerY - x, scaleXY);

    }

}
