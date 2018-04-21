package com.mygdx.game.entities;

import com.mygdx.game.components.Graphics;
import com.mygdx.game.components.Motion;
import com.mygdx.game.components.Position;
import com.mygdx.game.world.TileMap;

public class Zombie extends Entity
{
    
    public Zombie(TileMap map)
    {
        manager = EntityManager.getInstance();
        ID = manager.createEntity();
        manager.addComponent(ID, new Position(8, 8));
        map.getTile(8,8).setEntityID(ID);
        manager.addComponent(ID, new Graphics("alien.png",1,1));
       // manager.addComponent(ID,new Motion(1,0));
    }
}