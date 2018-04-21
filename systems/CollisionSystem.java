package com.mygdx.game.systems;

import com.mygdx.game.components.Collision;
import com.mygdx.game.components.Motion;
import com.mygdx.game.components.Position;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.world.TileMap;

import java.util.ArrayList;
import java.util.Set;

public class CollisionSystem implements Systems {

    private Set<Integer> collider;
    private EntityManager em;
    private ArrayList<Entity> entityList;
    private TileMap map;

    public CollisionSystem(ArrayList<Entity> list,TileMap map){
        em = EntityManager.getInstance();
        collider = em.getAllEntitiesPossessingComponent(Collision.class);
        entityList = list;
        this.map=map;
    }

    public void update(){

        for (Integer i : collider){
            int x= (int) em.getComponent(entityList.get(i).ID,Position.class).position.x;
            int dx= (int) em.getComponent((entityList.get(i).ID), Motion.class).velocity.x;
            int y= (int) em.getComponent(entityList.get(i).ID,Position.class).position.y;
            int dy= (int) em.getComponent((entityList.get(i).ID),Motion.class).velocity.y;

            if(x+dx>=map.getWidth() || x+dx<0 || y+dy>=map.getHeight() || y+dy<0){
                em.getComponent((entityList.get(i).ID), Motion.class).velocity.x=0;
                em.getComponent((entityList.get(i).ID), Motion.class).velocity.y=0;
                return;
            }

            if(map.getTile(x+dx,y+dy).getEntityID()!=-1){
                em.getComponent((entityList.get(i).ID), Motion.class).velocity.x=0;
                em.getComponent((entityList.get(i).ID), Motion.class).velocity.y=0;
                return;
            }

            map.getTile(x,y).setEntityID(-1);
            map.getTile(x+dx,y+dy).setEntityID(entityList.get(i).ID);



        }
    }


}
