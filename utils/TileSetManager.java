
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class TileSetManager {

    private Texture tileSheet;
    private TextureRegion regions[][];
    private HashMap<String,TextureRegion> tileBuffer;
    private int tileWidth,tileHeight;
    private int height,width;
    public TileSetManager(String path,int tileWidth,int tileHeight){
        tileBuffer=new HashMap<String, TextureRegion>();

        tileSheet=new Texture(Gdx.files.internal(path));

        this.height=tileSheet.getHeight();
        this.width=tileSheet.getWidth();

        this.tileHeight=tileHeight;
        this.tileWidth=tileWidth;

        int xTiles=width/tileWidth;
        int yTiles=height/tileHeight;

        regions=new TextureRegion[xTiles][yTiles];

        regions=TextureRegion.split(tileSheet,tileWidth,tileHeight);
        int counter=0;


        for(int y=0;y<yTiles;y++){
            for(int x=0;x<xTiles;x++){
                tileBuffer.put(""+counter++,regions[y][x]);
            }
        }
    }


    public TextureRegion getTile(String ID) {
        return tileBuffer.get(ID);
    }
}
