package com.mygdx.game.systems;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.Settings;
import com.mygdx.game.components.Graphics;
import com.mygdx.game.components.Position;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.EntityManager;

import java.util.ArrayList;
import java.util.Set;

public class RenderSystem implements Systems
{
    private Set<Integer> renderable;
    private EntityManager em;
    private ArrayList<Entity> entityList;
    public RenderSystem(ArrayList<Entity> list){
        em=EntityManager.getInstance();
        renderable=em.getAllEntitiesPossessingComponent(Graphics.class);
        entityList=list;

    }

    public void sketch(PolygonSpriteBatch batch)
    {
        for (Integer i : renderable)
        {
            batch.draw(em.getComponent(entityList.get(i).ID, Graphics.class).img, (float) em.getComponent(entityList.get(i).ID, Position.class).position.x* Settings.SCALED_TILE_SIZE, (float) em.getComponent(entityList.get(i).ID, Position.class).position.y*Settings.SCALED_TILE_SIZE,em.getComponent(entityList.get(i).ID,Graphics.class).width*Settings.SCALED_TILE_SIZE,em.getComponent(entityList.get(i).ID,Graphics.class).height*Settings.SCALED_TILE_SIZE);
        }
    }
}