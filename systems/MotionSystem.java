package com.mygdx.game.systems;

import com.mygdx.game.components.Motion;
import com.mygdx.game.components.Position;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.EntityManager;

import java.util.ArrayList;
import java.util.Set;

public class MotionSystem implements Systems
{
    private Set<Integer> movable;
    private EntityManager em;
    private ArrayList<Entity> entityList;

    public MotionSystem(ArrayList<Entity> list)
    {
        em = EntityManager.getInstance();
        movable = em.getAllEntitiesPossessingComponent(Motion.class);
        entityList = list;
    }

    public void update()
    {
        for (Integer i : movable)
        {
            em.getComponent(entityList.get(i).ID, Position.class).position.x += em.getComponent(entityList.get(i).ID, Motion.class).velocity.x;
            em.getComponent(entityList.get(i).ID, Position.class).position.y += em.getComponent(entityList.get(i).ID, Motion.class).velocity.y;
        }
    }
}