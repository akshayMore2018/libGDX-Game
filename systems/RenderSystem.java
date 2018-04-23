package com.mygdx.game.systems;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.Settings;
import com.mygdx.game.components.Camera;
import com.mygdx.game.components.Graphics;
import com.mygdx.game.components.Position;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.world.TileMap;

import java.util.ArrayList;
import java.util.Set;

public class RenderSystem implements Systems
{
    private Set<Integer> renderable;
    private EntityManager em;
    private ArrayList<Entity> entityList;
    private TileMap map;
    public RenderSystem(ArrayList<Entity> list,TileMap map){
        em=EntityManager.getInstance();
        renderable=em.getAllEntitiesPossessingComponent(Graphics.class);
        entityList=list;
        this.map=map;
    }

    public void sketch(PolygonSpriteBatch batch)
    {
        float worldX= (float) em.getComponent(Camera.cameraOwner,Camera.class).worldStart.x;
        float worldY=(float) em.getComponent(Camera.cameraOwner,Camera.class).worldStart.y;

        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                batch.draw(map.tileImg, worldX+i * Settings.SCALED_TILE_SIZE, worldY+j * Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
            }
        }
        for (Integer i : renderable)
        {
            batch.draw(em.getComponent(entityList.get(i).ID, Graphics.class).img, worldX+(float) em.getComponent(entityList.get(i).ID, Position.class).position.x* Settings.SCALED_TILE_SIZE, worldY+(float) em.getComponent(entityList.get(i).ID, Position.class).position.y*Settings.SCALED_TILE_SIZE,em.getComponent(entityList.get(i).ID,Graphics.class).width*Settings.SCALED_TILE_SIZE,em.getComponent(entityList.get(i).ID,Graphics.class).height*Settings.SCALED_TILE_SIZE);
        }
    }
}
