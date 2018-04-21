package com.mygdx.game.entities;

import com.mygdx.game.components.Collision;
import com.mygdx.game.components.Graphics;
import com.mygdx.game.components.Motion;
import com.mygdx.game.components.Position;
import com.mygdx.game.components.UserInput;
import com.mygdx.game.world.TileMap;

public class Player extends Entity
{

    public Player(TileMap map)
    {
        manager = EntityManager.getInstance();
        ID = manager.createEntity();
        manager.addComponent(ID, new Position(0, 0));
        map.getTile(0,0).setEntityID(ID);
        manager.addComponent(ID, new Graphics("player.png",1,1));
        manager.addComponent(ID,new Motion(0,0));
        manager.addComponent(ID,new UserInput(this));
        manager.addComponent(ID,new Collision());
    }

}